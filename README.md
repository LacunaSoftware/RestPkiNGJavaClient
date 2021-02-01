# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import com.lacunasoftware.*;
import com.lacunasoftware.auth.*;
import com.lacunasoftware.restpki.*;
import io.swagger.client.api.DocumentsApi;

import java.io.File;
import java.util.*;

public class DocumentsApiExample {

    public static void main(String[] args) {
        
        DocumentsApi apiInstance = new DocumentsApi();
        UUID id = new UUID(); // UUID | 
        try {
            DocumentModel result = apiInstance.apiDocumentsIdGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DocumentsApi#apiDocumentsIdGet");
            e.printStackTrace();
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to */*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DocumentsApi* | [**apiDocumentsIdGet**](docs/DocumentsApi.md#apiDocumentsIdGet) | **GET** /api/documents/{id} | Retrieves a document&#x27;s details
*SignatureSessionsApi* | [**apiSignatureSessionsIdGet**](docs/SignatureSessionsApi.md#apiSignatureSessionsIdGet) | **GET** /api/signature-sessions/{id} | Retrieves a signature session&#x27;s details
*SignatureSessionsApi* | [**apiSignatureSessionsIdWhenCompletedGet**](docs/SignatureSessionsApi.md#apiSignatureSessionsIdWhenCompletedGet) | **GET** /api/signature-sessions/{id}/when-completed | Waits for the completion of a signature session
*SignatureSessionsApi* | [**apiSignatureSessionsPost**](docs/SignatureSessionsApi.md#apiSignatureSessionsPost) | **POST** /api/signature-sessions | Creates a signature session

## Documentation for Models

 - [CreateSignatureSessionRequest](docs/CreateSignatureSessionRequest.md)
 - [CreateSignatureSessionResponse](docs/CreateSignatureSessionResponse.md)
 - [DocumentFileModel](docs/DocumentFileModel.md)
 - [DocumentModel](docs/DocumentModel.md)
 - [DocumentStatus](docs/DocumentStatus.md)
 - [ErrorModelV2](docs/ErrorModelV2.md)
 - [SessionCompletionStatus](docs/SessionCompletionStatus.md)
 - [SignatureSessionModel](docs/SignatureSessionModel.md)
 - [SignatureSessionStatus](docs/SignatureSessionStatus.md)
 - [SignatureTypes](docs/SignatureTypes.md)
 - [ValidationItemModel](docs/ValidationItemModel.md)
 - [ValidationItemTypes](docs/ValidationItemTypes.md)
 - [ValidationResultsModel](docs/ValidationResultsModel.md)
 - [WebhookEventModel](docs/WebhookEventModel.md)
 - [WebhookEventTypes](docs/WebhookEventTypes.md)

## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


