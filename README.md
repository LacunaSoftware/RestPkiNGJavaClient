REST PKI Core client package for Java
====================================
**Standard version for Java 8 and greater**

This package contains classes that encapsulate the calls to the REST PKI Core API.

The **Rest PKI Core Client package** is distributed by [Bintray](https://bintray.com/lacunasoftware/maven/restpki-core-client).

The recommended way to install it is with Gradle:
    
    repositories {
            mavenCentral()
            maven {
                url  "http://dl.bintray.com/lacunasoftware/maven"
            }
        }
    
    dependencies {
        compile("com.lacunasoftware.restpki:restpki-core-client:2.0.1")
        ...
    }
        
Or with Maven:
         
    <dependency>
      <groupId>com.lacunasoftware.restpki</groupId>
      <artifactId>restpki-core-client</artifactId>
      <version>2.0.1</version>
      <type>pom</type>
    </dependency>
