#language: pt
#Author: Daniel Simi�o
#encoding: iso-8859-1
#Version: v1.0
@teste
Funcionalidade: realizar gerenciamento cadastral de funcionarios 
	#Objetivo dos testes:
	# 1 - Garantir o resultado esperado das funcionalidades de gerenciamento de funcion�rio do sistema bem como suas exce��es	
  
  #Pr�-requisitos: 
  # 1 - Disponivel planilha excel contendo inform��es do funcionario a ser incluso no sistema src/Massa
	# 2 - Login e Senha contendo perfil validos para acesso a area de gerenciamento de funcionarios
	# 3 - Todas a��es (inclusao, altera��o e exclus�o) devem ser validadas e tratadas suas exce��es
	# 4 - Tempo de resposta das a��es no sistema (incluir, consultar, alterar e excluir) n�o dever� ser maior que 1 minuto
	
  Contexto: 
    Dado que tenha acessado o sistema
    E que tenha realizado login com as credencias
    |login|senha|
    |xxxxx|xxxxx|
    
  @ID01
  Cenario: Realizar Inclusao de funcionario no sistema        
  Quando realizar inclus�o de funcionario na tela de  gerenciamento de funcionarios do sistema
  |nome|endere�o|cidade|idade|quantidade de filhos|CPF|
  |    |        |      |     |                    |   |
  Entao a pagina de inclusao retorna matricula gerada com sucesso 
  
  @ID02
  Cenario: Realizar Altera��o de funcionario no sistema        
  Quando realizar pesquisa de funcionario na tela de gerenciamento de funcionarios do sistema
  |matricula|
  |    			|
  E realizar a acao de Alteracao Cadastral para o funcionario
  |nome|endere�o|cidade|idade|quantidade de filhos|CPF|
  |    |        |      |     |                    |   |
  Entao a pagina de Alteracao Cadastral retorna alteracao realizada com sucesso

  @ID03
  Cenario: Realizar Exclus�o de funcionario no sistema        
  Quando realizar pesquisa de funcionario na tela de gerenciamento de funcionarios do sistema
  |matricula|
  |    			|
  E realizar a acao de Exclusao para o funcionario
  E realizar pesquisa de funcionario na tela de gerenciamento de funcionarios do sistema
  |matricula|
  |    			|
  Entao a pagina de gerenciamento de funcionarios nao retorna um funcionario no sistema
  
  