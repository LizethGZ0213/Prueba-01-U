${artifactId}
##Instrucciones de consumo
-Para consumir el endpoint de validar dispositivo bloqueado se
 requiere que el API de validacion de Trusteer funcione correctamente.
## Description
Este microservicio tiene 2 APIs que se encargan de validar lo siguiente:

1.Hacer el pre-enrolamiento:


2.Finaliza el registro de pre-enrolamiento:



### Versioning
${version}
#### Important changes
- **Class name refactor**

#### Last modification date:
04/09/2023 by developer

#### 1.consumer a apis, valida para poder hacer el enrolamiento
### Endpoint
> /api/public/v1/channel/authentication/phone/enrollment/validate POST

### Request data
En el body del request se debe de incluir el json resultado del analisis que realiza.

URL :

http://msach-o-security-phone-enrollment-bex-seguridad-stg.obe8.bancoppel-dev.openshiftapps.com/api/public/v1/channel/authentication/phone/enrollment/validate

> Test data : 
``` json
{
    "customer": {
        "id": "Tndsihg7gtlPiFERapsL/Or/JmRqvCkIZawrWzUU13PnECt1xdVLUnpEncTdQ1WGwNLp/q+mfbuyyYMUE0r46u4re1+BNfLwz6ZjRIXzqXTJes/OW3wbLiEFfQ/yZmB1vHlGifn8xYrL6fkMqi3VO7cOTRR4gHele1VuapUANvtBnuxpANvQVBkz13g6KC+eC9xCofBy6bk1KSUASunNWUlR3/9qtXhXyp5vhYofl7MN8j8UeNrqwLpZGlD1jMuJgRSmaCiy8yv/cDysdaDqKIkdi0Vcvp3wCJABWfY4DriPrRm12FCAy26Ka0PsQF1oPBfv6X2UYhzVYG+3Xu0CeQ==",
        "cellphone": "UQVhpXvXDPXoufw+s/K1MACs9c1FaVtP5FR6CsIt5T/r0EdkC5SLNK4vxFyAyLdafiaZzakHkEgifqb56vPnRkHLKB+h4LYr7Pj6VmPqjZ3d9zAXRZYc0rPZUtjg2VvtqPunOE1Dbjcq/TAkENpW0EZEWAPcyg+EaxsTYHTtrgan2ZTGJEVNs++AdO8a4G+4X2vi+w81OrXgB+ReregEAGLJotDaHPaZA0CvIXaaGh9Leeu6dvL/pZbBVp22R9XjlxLfZ81NC+SF5DQGpXcvc2QtYJRXdrCn9z8xc7rluFC1E18xPKZ2NtyF1PWaSECc+qS8wSAq/ssPZsivXUQ8sw==",
        "birthDate": "GeeCkL8XxmXpjR03Tbql2hMiIGqSRzkZMk9v3R187sjs3Z/xoJMV+Tc4I7g8+tlUwTtoD5JzuXu7m291WmyU3JpY0FAaXTvOki8HZapq+boQJmKfQSeNGT9rrhXFTEnooneAUnxOx1CQxO1q9VX0M3fjRhHbfFD4Fz4b5KLsUj9Z0o3nAQaGXbO+PZQvsW0DnWBQh+s7spBBvorrklYdd26Fi4VvweMmWsqgcb85LRCD1hW7l3Oj5rlxygzTzxMka6I4PS8C/aTQFi/rfRHWnPGuzOzFsUIpxWPFOnjREGPTPiovf2OPVGoSrhRTsRgYGEIhgTj8CVxwsA+g/JGsyQ=="
    },
    "termStatus": {
        "acept": true,
        "version": "1.0"
    }
}

```

 - El servicio es invocable desde el paquete  **${package}** en el metodo:
```java
  codigo

```
#### 2. valida si el cliente ya esta dado de alta, finaliza registro y regresa un token de sesion.
### Endpoint
> /api/public/v1/channel/authentication/phone/enrollment/confirm POST

### Request data
Recibe una contraseña, confirmacion de la misma.

URL : 
http://localhost:8080/api/public/v1/channel/authentication/phone/enrollment/confirm POST
- Objeto json encriptado
```json
{
    "password": "SF/9/SNfeWqculUpiMauPcvKMJruKwx7qECpt/e61Dh1f49MrdMkxTRDRQgOnwwpWNFX0FOWA/Y283eBp9pWy/0EqdToS1KSkXDXl7VAs67hn0lgsZZ0/54jluHrlhfC+SIxrL2FjzThaEvIw0CsFkMfo7ixzoOKIGiRJeHtgW4B9WCUwZRk381CiEiR/jfNDFNUaPmg+I+ykEhe5dal6uoGgn3SmI+zqXOfHVDZj9I4KoQI9zKebcLpkiQ5g90mI745694otz4zromEPnMuAgNZPKZ8Xej+JF7Rs2UumZBHV8lpvESDLDjphjENWavG3vUNViDLQNqvb9thwfASiQ==",
    "passwordConfirm": "SF/9/SNfeWqculUpiMauPcvKMJruKwx7qECpt/e61Dh1f49MrdMkxTRDRQgOnwwpWNFX0FOWA/Y283eBp9pWy/0EqdToS1KSkXDXl7VAs67hn0lgsZZ0/54jluHrlhfC+SIxrL2FjzThaEvIw0CsFkMfo7ixzoOKIGiRJeHtgW4B9WCUwZRk381CiEiR/jfNDFNUaPmg+I+ykEhe5dal6uoGgn3SmI+zqXOfHVDZj9I4KoQI9zKebcLpkiQ5g90mI745694otz4zromEPnMuAgNZPKZ8Xej+JF7Rs2UumZBHV8lpvESDLDjphjENWavG3vUNViDLQNqvb9thwfASiQ=="
}
```
 - La clase que realiza el cambio de password se encuentra en el paquete: **com.bancoppel.customer.phone.enrollment** en el metodo:
```java
  public SessionOpen createCustomerConfirm(PasswordBexRequest passwordRequest,
      HeadersModel headers) {
	  }	  
```


## Built With
* Maven
* Spring
* SpringBoot
* Lombok
* informix
* Redis


### Prerequisites
Se necesita tener instalado:
		
 - Java 17  		
 - Maven 		
 - lombok
 - informix
 - Redis

### Running JUnit tests

 - Desde pring Tools Suite click derecho sobre el proyecto  > Run As >
   JUnit Test. 
 
 mvn clean package site sonar:sonar -Pdevelopment_reporting 

 Esto ejecuta todas las pruebas unitarias del proyectos y genera los reportes en el site y el sonar.

#### site

Se divide en dos partes:

 1. Informacion del proyecto.

	- Proporciona una descripción general de los diversos documentos y enlaces que forman parte de la información general de este proyecto.
	
2. Reportes de proyecto
	
	- Brindan un panoramageneral de varios reportes que son generados automaticamente por Maven.
	
EL site es generado  dentro de la ca: target > site > index.html
	

	$ mvn clean install site


#### Sonar
Sonar es una plataforma de código abierto utilizada por los equipos de desarrollo para gestionar la calidad del código fuente.

mvn clean package site sonar:sonar -Pdevelopment_reporting

En las últimas líneas de la salida de consola hay un enlace, cópielo y péguelo en cualquier navegador web para ver el informe.
