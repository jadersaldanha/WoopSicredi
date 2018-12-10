# WoopSicredi

Ol�!

Bem-vindo(a) ao projeto de automa��o escrito na linguagem Java para a Simula��o de Investimento
na Poupan�a do Sicredi! \o/

Chegou a hora de poupar! Mas quanto? Em quanto tempo? Como posso saber?

Nosso associado gostaria de simular o investimento na poupan�a para descobrir qual o valor ideal e quanto ele vai poupar no prazo que escolher.

Vamos construir um simulador de investimentos?

Hist�ria
Com o prop�sito de Simular um Investimento na Poupan�a
como um Associado,
eu gostaria de preencher o formul�rio de simula��o
e ver a tabela de resultado com M�s e Valor.

Crit�rio de aceita��o:

O associado preencher todos os campos corretamente e visualizar o formul�rio de simula��o
O associado preencher o Valor inferior a �20.00� e receber a mensagem de orienta��o �Valor m�nimo de 20.00�.
Url: https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/

API:
A API do Simulador de Investimento est� dispon�vel em:

Get:
Url: http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador

Response:
{
"id": 1,
"meses": ["112", "124", "136", "148"],
"valor": ["2.802", "3.174", "3.564", "3.971"]
}

## Solu��o Proposta

Esse projeto de automa��o foi idealizado com o foco em diversas possibilidades para casos de teste, considerando a UI e a API. Contempla a gera��o de relat�rios de evid�ncia de intera��o e preenchimento de dados com elementos da interface, al�m o teste de API que verifica o status do servi�o e a resposta do Get. 

## Arquitetura do projeto
- Sicredi.com.br
	- /src/main/java
		- api
		- appObjects
		- tasks
		- testCases
		- regressionTestSuite
		- verificationPoints
	- /src/main/resources
		- datapools
		- support
		- config.properties
	- Reports
		- screenshots
		
## Onde:
- appObjects representa o pacote com as classes que identificam elementos da interface web do portal. tasks: tarefas que atuam nos elementos da interface identificados. testCases pacote que define as classes principais dos casos de teste automatizados de UI. RegressiontestSuite conjunto que chama as classes de caso de teste que desejar. verificaitonPoints onde est�o as classes para valida��o de dados e/ou elementos de interface, etc. Na pasta datapools est�o os arquivos necess�rios para a utiliza��o da massa de dados para testes automatizados, � poss�vel adicionar quantas linhas e dados quanto forem necess�rio. Para isso, basta escrever os dados de usu�rio em cada linha utilizando o separador ";". Support est�o as classes de suporte para o projeto, considerando o relat�rio de evid�ncias, datapool, gera��o de datas (alguns c�digos foram retirados de livros e material livre da internet). config.propeties armazena dados de ambiente, seja de homologa��o ou produ��o, respostas de api e o que for necess�rio n�o ficar evidente em hard code. Na pasta reports ser�o armazenados screenshots e relatorios de evid�ncia tanto para UI quanto para servi�o. O arquivo "SimularInvestimentoPoupancaRegressionTestSuite.jar" � o execut�vel dos casos de teste.  

## EXECU��O

Para executar o projeto � muito f�cil \o/ basta seguir os passos, dependendo do que preferir.

Por linha de comando:
- Clonar o reposit�rio: git clone https://github.com/jadersaldanha/WoopSicredi;
- Na pasta do projeto: java -jar SimularInvestimentoPoupancaRegressionTestSuite.jar.

Por linha de comando com gradle: 
- Clonar o reposit�rio: git clone https://github.com/jadersaldanha/WoopSicredi;
- Navegar at� a pasta do projeto cd WoopSicredi;
- gradle test ou ./gradlew test;

Por UI:
- Fazer o download do projeto Sicredi.com.br e descompactar onde desejares;
- Na pasta do projeto Sicredi.com.br clicar duas vezes no arquivo "SimularInvestimentoPoupancaRegressionTestSuite.jar";
- Aguarde a execu��o dos testes \o/;
- Verifique a execu��o dos testes nas pastas "reports" e "screenshots".

Ah! pode ser que voc� n�o consiga executar os testes ou aconte�a nada, nesse caso baixe o java!
https://www.java.com/pt_BR/download/
