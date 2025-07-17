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

## Usar o parametro allowPublicKeyRetrievals

jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false


## Como isntalar o wsl no windows 10 (pre-requisito para instalar o docker)

To install WSL 2 on Windows 10 using PowerShell, follow these steps:

1. **Open PowerShell as Administrator**
   - Press `Win + X`, then select "Windows PowerShell (Admin)".

2. **Enable the WSL Feature**
   ```powershell
   dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
   ```

3. **Enable the Virtual Machine Platform Feature**
   ```powershell
   dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
   ```

4. **Restart Your Computer**
   - You must restart to complete the installation.

5. **Set WSL 2 as the Default Version**
   ```powershell
   wsl --set-default-version 2
   ```

6. **Install a Linux Distribution**
   - You can install Ubuntu (or another distribution) from the Microsoft Store, or via PowerShell:
   ```powershell
   wsl --install -d Ubuntu
   ```
   - Or, open the Microsoft Store, search for "Ubuntu", and click "Install".

7. **(Optional) Update the WSL Kernel**
   - If prompted, download and install the latest WSL2 kernel update from:
     [https://aka.ms/wsl2kernel](https://aka.ms/wsl2kernel)

---

**Summary of PowerShell Commands:**
```powershell
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
wsl --set-default-version 2
wsl --install -d Ubuntu
```


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
