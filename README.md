# REST-Service

[![Language](https://shield.lylium.fr:/github/languages/top/KontainPluton/REST-Service?color=007396&logo=java&logoColor=white&labelColor=bd7509&style=for-the-badge)](https://openjdk.java.net/)
![Maven](https://shield.lylium.fr/badge/Use-Maven-C71A36?logo=Apache-Maven&logoColor=white&style=for-the-badge)
![Tomcat Version](https://shield.lylium.fr/badge/Use-Tomcat_9.0-F8DC75?logo=Apache-Tomcat&logoColor=white&style=for-the-badge)
[![Api provided](https://shield.lylium.fr/badge/API%20provided-REST-18b98d?logo=rest&logoColor=white&style=for-the-badge)](https://github.com/KontainPluton/REST-Service/tree/main/doc/documentation-swagger-html)

![IMT](https://shield.lylium.fr/badge/Made%20at-IMT%20Mines%20Al%C3%A8s-00bcd7?logo=mines&logoColor=white&style=for-the-badge&labelColor=black)
![Contributor](https://shield.lylium.fr:/github/contributors/KontainPluton/REST-Service?style=for-the-badge)
![GitHub last commit](https://shield.lylium.fr:/github/last-commit/KontainPluton/REST-Service?style=for-the-badge)

*[Test project for a course at IMT]*

## Information

**Java** service with **Maven** and **Tomcat 9.0**.
This service uses Jersey and implements a test Rest API to query flights, airlines and seats. The service is connected with a gRPC API to a service allowing to book hotels.

## Setup

### With Docker ![Docker](https://shield.lylium.fr/badge/-Docker-2496ED?logo=docker&logoColor=white&style=f&style=flat-square)

**TODO : ECRIRE LA PROCEDURE**

---

### Without Docker

#### **Requirements :**

- Have Java 1.8 (jdk) installed (https://openjdk.java.net/install/)
- Have Apache Maven installed (https://maven.apache.org/download.cgi)
- Have Apache Tomcat 9.0 installed (doesn't work with Tomcat 10.x) (https://tomcat.apache.org/download-90.cgi)
- Have Keycloak server installed (***localhost:8080***) (https://www.keycloak.org/downloads) (we will configure the realm and the clients in this part)

#### **Configure Keycloak server :**

*(In this part, this guide can be usefull : https://www.katacoda.com/keycloak/courses/keycloak/configure-keycloak)*

Once the server is installed (and configured on port 8080 (localhost)), you must add an admin user to keycloak. This user will be used to connect to the global server configuration page. 

Move to the /bin folder of your keycloak installation (example: `cd keycloak-16.1.0/bin`) and type : 
*(here, login=admin and password=admin)*

Linux : 
```
./add-user-keycloak.sh -r master -u admin -p admin
```
Windows :
```
./add-user-keycloak.bat -r master -u admin -p admin
```

Once done you can start your server, run : 

Linux : 
```
./standalone.sh
```
Windows : 
```
./standalone.bat
```

Open your browser and go to : localhost:8080, and click on "Administrative Console". The login and password are those defined previously for the admin user.

---

Then you can follow the guide (https://www.katacoda.com/keycloak/courses/keycloak/configure-keycloak).
- Create a new realm : `BookMe`
- Create a client : `service-rest`
  - Access Type : `bearer-only`
  - Admin URL : `http://localhost:8090/java-restserver/api/securised/`
- Create a client : `js-client`
  - Access Type : `public`
  - Admin URL : `http://localhost:8090/java-restserver/JS-Client/`
  - Root URL : `http://localhost:8090/java-restserver/JS-Client/`
  - Valid Redirect URIs : `http://localhost:8090/*`
- Create a role : `user`
- Create a user : `test` (password: test) (non-temporary password)
- Assign the role `user` to the `test` user
