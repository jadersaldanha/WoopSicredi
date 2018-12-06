# WoopSicredi

#Olá!

Bem-vindo(a) ao projeto de automação escrito na linguagem Java para a Simulação de Investimento
na Poupança do Sicredi! \o/

#Chegou a hora de poupar! Mas quanto? Em quanto tempo? Como posso saber?

Nosso associado gostaria de simular o investimento na poupança para descobrir qual o valor ideal e quanto ele vai poupar no prazo que escolher.

#Vamos construir um simulador de investimentos?

#História
Com o propósito de Simular um Investimento na Poupança#
como um Associado,
eu gostaria de preencher o formulário de simulação
e ver a tabela de resultado com Mês e Valor.

#Critério de aceitação:

O associado preencher todos os campos corretamente e visualizar o formulário de simulação
O associado preencher o Valor inferior a “20.00” e receber a mensagem de orientação “Valor mínimo de 20.00”.
Url: https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/

#API:
A API do Simulador de Investimento está disponível em:

#Get:
Url: http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador

#Response:
{
"id": 1,
"meses": ["112", "124", "136", "148"],
"valor": ["2.802", "3.174", "3.564", "3.971"]
}

Esse projeto de automação foi idealizado com o foco em diversas possibilidades para casos de teste, considerando a UI e a API. Contempla a geração de relatórios de evidência de interação e preenchimento de dados com elementos da interface, além o teste de API que verifica o status do serviço e a resposta do Get. 

#Organiza-se da seguinte forma:
- Sicredi.com.br
	- /src/main/java
		- api
		- appObjects
		- tasks
		- testCases
		- regressiontestSuite
		- verificationPoints
	- /src/main/resources
		- datapools
		- support
		- config.properties
	- Reports
		- screenshots
		
#Onde: 
- appObjects representa o pacote com as classes que identificam elementos da interface web do portal. tasks: tarefas que atuam nos elementos da interface identificados. testCases pacote que define as classes principais dos casos de teste automatizados de UI. RegressiontestSuite conjunto que chama as classes de caso de teste que desejar. verificaitonPoints onde estão as classes para validação de dados e/ou elementos de interface, etc. Na pasta datapools estão os arquivos necessários para a utilização da massa de dados para testes automatizados, é possível adicionar quantas linhas e dados quanto forem necessário. Para isso, basta escrever os dados de usuário em cada linha utilizando o separador ";". Support estão as classes de suporte para o projeto, considerando o relatório de evidências, datapool, geração de datas (alguns códigos foram retirados de livros e material livre da internet). config.propeties armazena dados de ambiente, seja de homologação ou produção, respostas de api e o que for necessário não ficar evidente em hard code. Na pasta reports serão armazenados screenshots e relatorios de evidência tanto para UI quanto para serviço. O arquivo "SimularInvestimentoPoupancaRegressionTestSuite.jar" é o executável dos casos de teste.  

#Para executar o projeto é muito fácil \o/ basta seguir os passos:
- Fazer o download do projeto Sicredi.com.br;
- Na pasta do projeto Sicredi.com.br clicar duas vezes no arquivo "SimularInvestimentoPoupancaRegressionTestSuite.jar";
- Aguarde a execução dos testes \o/;
- Verifique a execução dos testes nas pastas "reports" e "screenshots".

#Ah! pode ser que você não consiga executar os testes ou aconteça nada, nesse caso baixe o java!
https://www.java.com/pt_BR/download/
