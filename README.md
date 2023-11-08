#bancoppel-api-archetype-java-17 - Java 17
Proyecto de tipo arquetipo para generar proyectos con un estandar de arquitectura
y tecnologia base para el proyecto de **_BAN-COPPEL_** 

##Pre-requisitos

Para el uso de este arquetipo se necesita tener instalado:
```
 * Java 17 
 * Maven >= 3.8
```
##Uso y configuracion de arquetipo
Inicialmente se tiene que ejecutar el comando de maven en terminal o IDE en la carpeta raiz 
del arquetipo. 

```
  >$ mvn clean install
```
Al finalizar el comando se genera un documento llamado _archetype-catalog.xml_ en la carpeta **".m2/repository"**.

#####Generar un nuevo proyecto ***Linea de comando***

Para generar un nuevo proyecto de nuestro arquetipo se tiene que ejecutar el siguiente comando en una ubicacion diferente al arquetipo:

```
  >$ mvn archetype:generate -B -DarchetypeGroupId=com.bancoppel -DarchetypeArtifactId=bancoppel-api-archetype-java-17 -DarchetypeVersion=4.0.0 -DgroupId=com.bancoppel.test -DartifactId=test-service -Dversion=1.0.0 -Dpackage=com.bancoppel.test
```

###Estructura del comando
#####**FAVOR DE VALIDAR LA VERSION DEL ARQUETIPO**
```
-DarchetypeGroupId=com.bancoppel -DarchetypeArtifactId=bancoppel-api-archetype-domain-java8 -DarchetypeVersion=3.0.0
```
#####Este parametro hace referencia al grupo que pertenece el proyecto, 
#####es un identificador para agrupar las dependencias dentro del repositorio local.
```
-DgroupId=com.bancoppel.test
```
#####Este parametro hace referencia al nombre de nuestro proyecto asi como el identificador raiz de la dependencia.
```
-DartifactId=test-service
```
#####Este parametro hace referencia a la version del proyecto en caso de no tenero toma el valor por default **1.0-SNAPSHOT**
```
-Dversion=1.0.0-ALPHA
```
#####Este parametro indica la estructura de paquetes de nuestras clases en el proyecto.
```
-Dpackage=com.bancoppel.test
```

#####Al finalizar el comando, se creara el proyecto en la raiz de donde se haya ejecutado el comando.
Antes
```
$pwd
/home/proyectos
$ll
drwxrwxr-x  4 user user 4096 ago 14 16:42 ./
drwxr-xr-x 39 user user 4096 oct 15 19:20 ../
```
Despues
```
$pwd
/home/proyectos
$ll
drwxrwxr-x  4 user user 4096 ago 14 16:42 ./
drwxr-xr-x 39 user user 4096 oct 15 19:20 ../
drwxrwxr-x 60 user user 4096 oct 15 16:09 ProyectoNuevo/
```

###Tecnologias del proyecto generado

```
 * Java 17
 * Maven 
 * Maven archetype 
 * Spring-boot 
 * Spring-cloud
 * Lombok
 * jkube
```

##Uso y configuracion de proyecto generado

Una vez generado el proyecto, vemos que tiene la siguiente estructura

Esta carpeta contiene la los archivos de perfilamiento para trabajar en los diferentes ambientes, 
en este caso solo contiene el ambiente de desarrollo.

```
    config/
        application-dev.properties
```

Esta carpeta debera de contener una coleccion de tipo json para poder hacer una prueba del API que desarrollaremos.

```
    request/
        Carpeta Vacia
```

Esta carpeta es los recursos del proyecto. 

```
    src/
        main
```

Esta carpeta contiene archivos de configuracion para la integracion con Openshift,


######configMap.yml
Este archivo tiene los datos del proyecto, junto con las propiedades que necesita el proyecto para funcionar.

######deployment.yml
Este archivo tiene la informacion necesaria para generar una nueva instancia y su configuracion en kubernetes.

######svc.yml
Este archivo contiene la configuracion para el numero de instancias y puertos.

```
            jkube
                configMap.yml
                deployment.yml
                svc.yml
```

Esta carpeta contiene todos los paquetes y clases de nuestro proyecto.
El documento _application.properties_ contiene por default el perfil de desarrollo. 
**spring.profiles.active=dev** para manejar el perfil default de spring eliminar esta linea.

```
            java 
                com
                    bancoppel
                        nuevo
                            api
                                ArchetypeController.java
                            business
                                ArchetypeBusiness.java
                            component
                                ErrorResolver.java
                                CustomFeignDecoder
                            config
                                ApplicationConfig.java
                                RedisConfig.java
                                InterceptorConfig.java
                                SwaggerConfig.java
                                WebMvcConfig.java
                            constant
                                ApiDocumentationConstants
                                ApiValues.java
                                Constants.java
                                ConstantsApi.java
                                ErrorResolverConstants.java
                                FeignConstants
                                JpaConstants.java
                                LogConstants.java
                                RedisConstants
                                SpecialCharacterConstants.java
                                SwaggerConstants
                            entity
                                informix
                                    ProductDetail
                                redis
                                    ProductCache
                            exceptions
                                custom
                                    BadRequestException.java
                                    DatabaseTimeoutException
                                    DownstreamException
                                    ForbiddenException.java
                                    InvalidOptionException.java
                                    NoDataFoundException.java
                                    StoreProcedureException
                                    TimeoutException.java
                                    UnauthorizedException.java
                                ErrorResponse.java
                                ErrorType.java
                            interceptor
                                ApiInterceptor.java
                            model
                                client
                                    ExampleClient
                                ProductInfoData.java
                                ProductProcessResponse.java
                            repository
                                informix
                                    ProductRepository
                                redis
                                    ProducCacheRepository
                            service
                                ArchetypeService.java
                            util
                                Util.java
                            MainApplication.java
            resource
                application.properties
```

Esta carpeta contiene todas las clases de prueba (UnitTest) de nuestro proyecto.

```
        test
            java
                com
                    bancoppel
                         nuevo
                            api
                                ArchetypeControllerTest.java
                            business
                                ArchetypeBusinessTest.java
                            component
                                ErrorResolverTest.java
                                CustomFeignDecoderTest
                            config
                                ApplicationConfigTest.java
                                InterceptorConfigTest.java
                                RedisConfigTest
                                SwaggerConfigTest.java
                                WebMvcConfigTest.java
                            interceptor
                                ApiInterceptorTest.java
                            mapper
                                ExceptionMapper.java
                                HeadersMapper.java
                            repository
                                ProductRepositoryTest.java
                            util
                                UtilTest.java
```

Estos documentos son necesarios para el uso de maven. 
El archivo readme contiene la informacion para poder generar las peticiones que contiene el proyecto base.

```
    findbugsfilter.xml
    pom.xml
    README.md
```