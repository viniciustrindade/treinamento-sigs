# treinamento-sigs
## Instale o GIT

## Faça o checkout da pasta do treinamento para seu desktop
git@github.com:viniciustrindade/treinamento-sigs.git
ou baixe https://github.com/viniciustrindade/treinamento-sigs/archive/refs/heads/main.zip

## Utilize o mysql de treinamento ou instale o docker
### Os acessos do Mysql de treinamento sera passado na apresentação.
### Instale o Docker
https://docs.docker.com/docker-for-windows/install/

###  Execute um container docker com o banco de dados mysql
docker-compose up

### Verifique se esta conectando
http://localhost:8080/?server=db&username=root

##  Instale o dbeaver 
https://dbeaver.io/download/

## Com DBEAVER Crie uma conexao mysql para o container mysql e verifique se esta conectando ao banco
HOST: localhost
USERNAME: root
SENHA: 12345
DATABASE: mysql
PORT: 3306

## Instale o oracle jdk-7u80-windows-x64.exe (precisa de cadastro no site da oracle)
https://www.oracle.com/br/java/technologies/javase/javase7-archive-downloads.html
 ou
https://nuvem.ufba.br/s/3MHgeaCqXQHLfS9 (windows)
https://nuvem.ufba.br/s/JBAoZkA5mW04EMo (linux)

## Extraia o eclipse IDE nessa pasta do projeto como "eclipse"
https://www.eclipse.org/downloads/

## Baixa e descompacte na pasta do projeto como "tomcat5.5"
https://archive.apache.org/dist/tomcat/tomcat-5/v5.5.26/bin/apache-tomcat-5.5.26.zip


## Baixa e descompacte na pasta do projeto como "mysql-connector-java"
## Baixa o jdbc
https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.49.zip
