#

<h1 align="center">
   <a href="">Score Credit</a>
</h1>
<p align="center">An example of a credit score evaluator for loan approval, built in Java and Spring Boot.</p>


### About
Score Credit is an application designed to assess and return a score based on the characteristics of the applicant (CPF).


### Features
*   [x]   Persist ScoreCredit
*   [X]   GenerateScoreCredit
*   [X]   Find User


### Getting started

 #### Start

To get for development, we need to clone the project repo using some terminal like git bash and then use the following code:

-   `cd path of your preference`
-   `git clone https://github.com/mauriciorepo/challengescorecredit`
-   `cd scorecredit`
-   `cd criticaldata`

#### Requirements
*   [JDK 17: Required to run a java project](https://www.oracle.com/br/java/technologies/downloads/#java17)

*   [Maven 3.6.3: Required at least to do a build Java project](https://maven.apache.org/download.cgi)

After that, you can import project to Eclipse, Intellij or Vscode
*   [Eclipse: for development the project](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen3a)
*   [Intellij for development the project](https://www.jetbrains.com/)
*   [Vscode for development the project](https://code.visualstudio.com/)

### Tecnologies

The following tools were used on construction project:

*   [Java 17](https://www.java.com/pt-BR/download/manual.jsp)
*   [Spring](https://spring.io/)
*   [Spring Boot](https://spring.io/projects/spring-boot)
*   [Lombok](https://projectlombok.org/)
*   [JUnit 5](https://junit.org/junit5/)
*   [Keycloak](https://www.keycloak.org/)
*   [Oauth2.0](https://oauth.net/2/)
*   [Kafka](https://developer.confluent.io/quickstart/kafka-on-confluent-cloud/)
*   [Mongodb](https://www.mongodb.com/pt-br)
*   [Postgres](https://www.postgresql.org/)
*   [Docker](https://www.docker.com/)
*   [Docker Compose](https://docs.docker.com/compose/install/)


### StartUp

Once you have imported the Score Credit and Critical Data projects,  
 you can set up the environment. Open a terminal of your choice,  
  navigate to the project's root folder (challengescorecredit), and run the following commands:

 ```
  sudo docker-compose up -d
  ```
This command will start the databases (Base_a and Base_b), our authorization server (Keycloak), and Kafka for messaging.

You can check the status of the services with the following command:
```
  sudo docker-compose ps 
  ```

### Now we are going to configure authorization server keycloak, access this url

```
 http://localhost:8099
 ```
### Go to the clients menu and click on import client as in the image below

![keycloakclient](keycloakclient.png)

#### Copy the configuration below

          ```
            {
              "clientId": "critical-data",
              "name": "",
              "description": "",
              "rootUrl": "",
              "adminUrl": "",
              "baseUrl": "",
              "surrogateAuthRequired": false,
              "enabled": true,
              "alwaysDisplayInConsole": false,
              "clientAuthenticatorType": "client-secret",
              "secret": "pDFjMXQtRkswjTWFxVGZCZeJoWZYUOge",
              "redirectUris": [
                "/*"
              ],
              "webOrigins": [
                "/*"
              ],
              "notBefore": 0,
              "bearerOnly": false,
              "consentRequired": false,
              "standardFlowEnabled": true,
              "implicitFlowEnabled": false,
              "directAccessGrantsEnabled": true,
              "serviceAccountsEnabled": true,
              "authorizationServicesEnabled": true,
              "publicClient": false,
              "frontchannelLogout": true,
              "protocol": "openid-connect",
              "attributes": {
                "oidc.ciba.grant.enabled": "false",
                "oauth2.device.authorization.grant.enabled": "false",
                "client.secret.creation.time": "1696787427",
                "backchannel.logout.session.required": "true",
                "backchannel.logout.revoke.offline.tokens": "false"
              },
              "authenticationFlowBindingOverrides": {},
              "fullScopeAllowed": true,
              "nodeReRegistrationTimeout": -1,
              "protocolMappers": [
                {
                  "name": "Client ID",
                  "protocol": "openid-connect",
                  "protocolMapper": "oidc-usersessionmodel-note-mapper",
                  "consentRequired": false,
                  "config": {
                    "user.session.note": "client_id",
                    "userinfo.token.claim": "true",
                    "id.token.claim": "true",
                    "access.token.claim": "true",
                    "claim.name": "client_id",
                    "jsonType.label": "String"
                  }
                },
                {
                  "name": "Client Host",
                  "protocol": "openid-connect",
                  "protocolMapper": "oidc-usersessionmodel-note-mapper",
                  "consentRequired": false,
                  "config": {
                    "user.session.note": "clientHost",
                    "userinfo.token.claim": "true",
                    "id.token.claim": "true",
                    "access.token.claim": "true",
                    "claim.name": "clientHost",
                    "jsonType.label": "String"
                  }
                },
                {
                  "name": "Client IP Address",
                  "protocol": "openid-connect",
                  "protocolMapper": "oidc-usersessionmodel-note-mapper",
                  "consentRequired": false,
                  "config": {
                    "user.session.note": "clientAddress",
                    "userinfo.token.claim": "true",
                    "id.token.claim": "true",
                    "access.token.claim": "true",
                    "claim.name": "clientAddress",
                    "jsonType.label": "String"
                  }
                }
              ],
              "defaultClientScopes": [
                "web-origins",
                "acr",
                "roles",
                "profile",
                "email"
              ],
              "optionalClientScopes": [
                "address",
                "phone",
                "offline_access",
                "microprofile-jwt"
              ],
              "access": {
                "view": true,
                "configure": true,
                "manage": true
              }
            }
            ```

#### Paste the config in the field as shown in the image below, save the configs like the image.
![importclient](importclient.png)


### After saving, you can see the "critical data" client in the clients menu.

![ClientCriticalData](ClientCriticalData.png)


### Once the client is created, access Critical Data and copy the client secret.

![ClientSecret](ClientSecret.png)

### With the client secret in hand, you can generate a token using the endpoint:
```
http://localhost:8099/realms/master/protocol/openid-connect/token
```

### You can use Postman to obtain a token as shown in the image below:

![token](token.png)

### With the token, access the root of the "critical-data" project, go to src/main/resources/application.yml, locate the property below, and after the "Bearer" value, add a space and paste the token:

```
user:
  access:
    token: Bearer 
   ```
##### We can now upload the "Critical-Data" service in your preferred editor.
##### Using a postman, we can query the service, don't forget to exchange the token for the token you generated above:

```
curl --location 'localhost:8084/api/v1/users/98765432101/find' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI3eHk4SHQ0elBIdHlhN21Id0RIbmk3SlM3bVNJT0NBWWM0cXJaX3FxaTFzIn0.eyJleHAiOjE2OTY4MDY0MzEsImlhdCI6MTY5Njc5OTIzMSwianRpIjoiOTZmYTA1ZDktYjM1YS00MTBmLThkMTgtMWJjMmFjOTljZjE4IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDk5L3JlYWxtcy9tYXN0ZXIiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiYTAyNjRlMjMtNmNmMy00ZWJhLTliOWQtZmJjZDQxMWZkYjFlIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiY3JpdGljYWwtZGF0YSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbWFzdGVyIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImNyaXRpY2FsLWRhdGEiOnsicm9sZXMiOlsidW1hX3Byb3RlY3Rpb24iXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SG9zdCI6IjE3Mi4yNS4wLjEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtY3JpdGljYWwtZGF0YSIsImNsaWVudEFkZHJlc3MiOiIxNzIuMjUuMC4xIiwiY2xpZW50X2lkIjoiY3JpdGljYWwtZGF0YSJ9.W70-YV2AFwr9ook4QOByVwBscjYdRsI3p_TVDZTw4OCPQ9nsi9BkbuTHGyE9AtOfmd8JaQ9C-89D1PR-BTcs-hHtOvA2Arg-N6hmCDEHVZfaFrpUDIswn-IWwsw4uouoj9WicPnCaJC82nbQyVxzoDep8u-1Y8XaQYDZ66l55Q88OjfUAZgMSjvTKPiQcbK1ZjFAjXreF2-MRqq0ydLDsD7fVVlm1uKoNlBRN7-l_I8s3mlTd9e7ygxKAnINs5WT3MZCKj8A0Jtu2EO4yuWqhYych2iYWGyRxLh91LkhHjLc_nbrcKEpf3x0PO6ZZ3ZusXvUramCOzxj8f7qFX4hQw' \
--header 'Cookie: JSESSIONID=56C6D218A296334E61A9966A3F8D5749'
```
#### You will see this output:
* **Success Response:**

    * **Code:** 200 <br />
      **Content:**
      ```
        {
        "id": 2,
        "cpf": "98765432101",
        "name": "marcos ",
        "address": "rua tal 432",
        "list": [
            {
                "id": 2,
                "debtDueDate": "2023-10-04T18:02:31.089",
                "originalValue": 234.00,
                "currentBalance": 300.00,
                "typeOfDebt": "Emprestimo",
                "debtStatus": "ativo"
            }
          ]
               }  
      ```
## Starting Score Credit
###  Let's now up the Score Credit service, we can use this maven command:

```
mvn spring-boot:run
```
### Once started, we will insert a collection into mongdb using this curl
```
curl --location 'http://localhost:8085/api/v1/scores' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=56C6D218A296334E61A9966A3F8D5749' \
--data '{
   "address": "456 Elm Street",
   "source_of_income": "Business",
   "cpf": "98765432101",
   "assets": [
      {
         "description": "Motorcycle",
         "type": "Vehicle",
         "value": 8000.00,
         "purchase_date": "2021-03-10T00:00:00Z"
      },
      {
         "description": "Apartment",
         "type": "Real Estate",
         "value": 500000.00,
         "purchase_date":"2021-03-10T00:00:00Z"
      }
   ]
}
'
```
### You can highlight the collection in mongo express by accessing the url:
```
http://localhost:8067/
```
### Using bread crumb from the image it is possible to reach the same screen:

![mongoexpress](mongoexpress.png)

## Generating a credit score
##### In these resources it is possible to have a client's score point using the cpf, the service accesses base_a to calculate the factors together with the data from base_b:

```
        curl --location 'localhost:8085/api/v1/scores?cpf=98765432101' \
        --header 'Content-Type: application/json' \
        --header 'Cookie: JSESSIONID=56C6D218A296334E61A9966A3F8D5749' \
        --data ''
```

## Extracting data from Base_B

### For extraction we use two possible approaches, first by sending a message to a topic called "tp-score-data-lake" which can be consumed by anyone who subscribes to the topic.
### Accessing the url
```
http://localhost:9021/
```
#### Go to the menu, click on topics and select the topic tp-score-data-lake you will see the message from the insert made previously in base_b

![score-data-lake](score-data-lake.png)

## Solving the design challenge
### This design completely solves all the solutions required in the challenge
![challengescore.drawio (1).png](challengescore.drawio%20%281%29.png)