##Projeto de Estudo Integração Spring - DynamoDb
Artigo base do estudo: https://medium.com/@kaikeventura/api-rest-com-spring-boot-e-aws-dynamodb-5e79ecb80b62

###Ferramentas:

* Java (JDK 8+): https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
* Spring Boot: https://start.spring.io/
* Docker: https://docs.docker.com/
* Imagem docker AWS Localstack (DynamoDB): https://github.com/localstack/localstack
* AWS CLI: https://aws.amazon.com/pt/cli/
* Postman: https://www.postman.com/


Necessario configurar o ambiente local com o AWS CLI e subir a imagem localstack no Docker.

~~~
Configuração Aws
Key ID: 123
Access Key: 123
Region: us-east-1
Format: text
~~~~

Você pode utilizar também variáveis de ambiente.


##Rodando o LocalStack

`localstack start`

É preciso gerar o banco de dados utilizando o arquivo costumer_table.json que está na raíz do projeto

`aws dynamodb create-table --cli-input-json file://costumer_table.json --endpoint-url=http://localhost:4566`

Para validar se a tabela foi criada é só utilizar o comando abaixo no terminal:

`aws dynamodb list-tables --endpoint-url=http://localhost:4566`
