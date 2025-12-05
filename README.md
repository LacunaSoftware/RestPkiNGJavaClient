REST PKI Core client package for Java
====================================
**Standard version for Java 8 and greater**

This package contains classes that encapsulate the calls to the REST PKI Core API.

The **Rest PKI Core Client package** is distributed on [Maven](https://mvnrepository.com/artifact/com.lacunasoftware.restpki/restpkicore-client).

The recommended way to install it is with Gradle:
    
    repositories {
            mavenCentral()
        }
    
    dependencies {
        compile("com.lacunasoftware.restpki:restpkicore-client:1.2.0")
        ...
    }
        
Or with Maven:
         
    <dependency>
      <groupId>com.lacunasoftware.restpki</groupId>
      <artifactId>restpkicore-client</artifactId>
      <version>1.2.0</version>
      <type>pom</type>
    </dependency>
