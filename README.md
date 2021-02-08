# treinamento-sigs
## Instale o GIT

## Instale o Docker
https://docs.docker.com/docker-for-windows/install/

## Faça o checkout da pasta do treinamento para seu desktop
git@github.com:viniciustrindade/treinamento-sigs.git

##  Execute um container docker com o banco de dados mysql
docker-compose up

## Verifique se esta conectando
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

## Extraia o eclipse IDE nessa pasta do projeto como "eclipse"
https://www.eclipse.org/downloads/

## Baixa e descopacte na pasta do projeto como "tomcat5.5"
https://archive.apache.org/dist/tomcat/tomcat-5/v5.5.26/bin/apache-tomcat-5.5.26.zip

