LINK DO DEPLOY
https://app-240903194908.azurewebsites.net/brinquedos
    Sistema de Gerenciamento de Brinquedos
   O Sistema de Gerenciamento de Brinquedos é uma aplicação desenvolvida para uma empresa de brinquedos voltada para crianças até 12 anos. O objetivo do sistema é permitir o cadastro, consulta, atualização e exclusão de brinquedos através de uma interface web,     utilizando o framework Spring Boot e o banco de dados Oracle.

    
    
        RM 98660 - Leonardo Valentim de Souza
        RM 97714 - João Victor Leite Firmino
        RM 99618 - Gustavo dos Santos Correa
        RM 551201 - Lucas Cazzaro
        RM 99219 - Ronaldo Riyudi Noda
        
    

    Configuração do Spring Initializr
    Configuração utilizada para iniciar o projeto no Spring Initializr:


    Dependências
    
        Spring Web
        Spring Data JPA
        Oracle Driver
        Spring Boot DevTools
    

    Banco de Dados
    <p>O sistema utiliza o banco de dados Oracle para armazenar informações sobre os brinquedos. A configuração de acesso ao banco é feita através do arquivo <code>application.properties</code>.</p>

    PAGINA INICIAL
![image](https://github.com/user-attachments/assets/833ec396-ca51-4076-97c1-20b33794eaca)


    
    Cadastra um novo brinquedo no sistema.
    Exemplo de requisição:
    
![image](https://github.com/user-attachments/assets/1a6009ed-3431-47f1-a018-4eb2c1140549)

   
        verifique que foi adicionado
![image](https://github.com/user-attachments/assets/8592a668-f9c7-46bc-86f4-0302e0a37998)

       Detalhes do produto
![image](https://github.com/user-attachments/assets/ec087036-63b2-4cf9-a92c-8d50f26f7931)

    Atualiza as informações de um brinquedo existente
![image](https://github.com/user-attachments/assets/e4056a4f-d460-4d88-b1c9-68d01584b349)

![image](https://github.com/user-attachments/assets/84903b0c-6f02-42bd-b1d0-8ede6cc4c958)


    DELETE /brinquedos/excluir/{id}
    exclui um brinquedo do sistema pelo seu ID


    Execução do Projeto
  
        Clone o repositório do projeto.</li>
        Importe o projeto em sua IDE preferida (IntelliJ, Eclipse ou NetBeans).
        Atualize as dependências Maven, se necessário.
        Configure o banco de dados Oracle conforme as instruções.
        Execute o projeto.
        Utilize os endpoints listados acima para interagir com a API via Postman.
![image](https://github.com/user-attachments/assets/ff194965-b035-47e1-b68a-12aa6345f3da)

