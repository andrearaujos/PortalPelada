# PortalPelada
Postegres: 9.5.25 
JDK - Java SE Development Kit 8u281
Apache TomCat: apache-tomcat-10.0.2
Maven: apache-maven-3.6.3-bin.zip
Eclipse: Version: 2020-12 (4.18.0) Build id: 20201210-1552

Postgres: Instalar a versão informada acima, disponível em:
https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
Seguir o passo a passo do instalador.

JDK: Instalar a versão informada acima, disponível em:
Seguir o passo a passo do instalador.

Apache TomCat: Instalar a versão informada acima, disponível em:
https://tomcat.apache.org/download-10.cgi
Descompactar a pasta no c:

Maven: Instalar a versão informada acima, disponível em:
https://maven.apache.org/download.cgi
Descompactar a pasta no c:

Eclipse: Instalar a versão informada acima, disponível em:
https://www.eclipse.org/downloads/
Seguir o passo a passo do instalador.


Clonar o projeto através do github
No ecplise: 
Adicionar um novo o servidor de apache tomcat. Selecionar a versão 10 do apache tomcat no eclipse;
Abrir o projeto clonado a partir do local onde foi armazenado;

No pgAdminIII criar o banco usando aos scripts disponibilizados na pasta scripts_bd dentro do projeto.

No Eclipse em src/main/resources
Alterar o arquivo hibernate.cfg.xml colocando a senha do Postegres
