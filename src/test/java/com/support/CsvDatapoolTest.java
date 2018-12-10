package com.support;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.Status;

public class CsvDatapoolTest implements IDatapoolTest {
	
	private Map<String, Integer> fieldLabels;
	private List<List<String>> dados;
	private int pointer;
	
	public CsvDatapoolTest(String filePath) {
		this.fieldLabels = new HashMap<String, Integer>();
		this.dados = new ArrayList<List<String>>();
		
		openFile(filePath);
		reset();
	}
	
	public boolean hasNext() {
		return this.pointer < dados.size();
	}

	public boolean isEmpty() {
		return dados.isEmpty();
	}

	public void reset() {
		this.pointer = 0;
	}

	public int getSize() {
		return dados.size();
	}

	public IDatapool next() throws DatapoolExceptionTest {
		if(!this.hasNext()) {
			throw new DatapoolExceptionTest("Não há mais registros neste datapool. Utilize o método reset() para reiniciar o loop.");
		}
		
		this.pointer++;
		return (IDatapool) this;
	}

	public IDatapool nextTo(int line) throws DatapoolExceptionTest {
		if(line >= this.getSize()) {
			throw new DatapoolExceptionTest("Há apenas " + this.getSize() + " registros neste datapool.");
		}
		
		this.pointer = line;
		return (IDatapool) this;
	}

	public IDatapool nextRandom() throws DatapoolExceptionTest {
		//this.pointer = ProviderUtils.getInt(this.getSize());
		return (IDatapool) this;
	}

	public String getValue(String field) throws DatapoolExceptionTest {
		if(!this.fieldLabels.containsKey(field)) {
			throw new DatapoolExceptionTest("O campo \"" + field + "\" não existe no datapool.");
		}
		
		int fieldIndex = this.fieldLabels.get(field);
		return this.getValue(fieldIndex);
	}
	
	public String getValue(int fieldIndex) throws DatapoolExceptionTest {
		return this.dados.get(this.pointer).get(fieldIndex);
	}

	private void openFile(String filePath) {
		try(FileReader arq = new FileReader(filePath); BufferedReader reader = new BufferedReader(arq)) {
	      String line = getFieldLabels(reader);	      
	      line = getDataRows(reader, line);
	    } catch (FileNotFoundException ex) {
	    	ReportTest.log(Status.WARNING, "Arquivo de datapool não encontrado: " + ex.getMessage());
	    } catch (IOException ex) {
	    	ReportTest.log(Status.WARNING, "Erro na abertura do arquivo de datapool: " + ex.getMessage());
	    }
	}

	private String getDataRows(BufferedReader reader, String line) throws IOException {
		while(line != null) {
			List<String> fields = new ArrayList<String>();
			for(String field : line.split(";")) {
				fields.add(field);
			}
			dados.add(fields);
			line = reader.readLine(); 
		}
		return line;
	}

	private String getFieldLabels(BufferedReader reader) throws IOException {
	    int index = 0;
	    String line = reader.readLine(); 
	    for(String fieldLabel : line.split(";")) {
	    	fieldLabels.put(fieldLabel, index++);
	    }
	    line = reader.readLine();
		return line;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("[ ");
		for(String field : this.fieldLabels.keySet()) {
			buffer.append(field.toUpperCase());
			buffer.append(": ");
			buffer.append(this.dados.get(this.pointer).get(this.fieldLabels.get(field)));
			buffer.append("; ");
		}
		buffer.append("]");
		
		return buffer.toString();
	}
}