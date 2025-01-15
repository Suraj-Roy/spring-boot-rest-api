# API - Application Programming Interface
# ======================================

# Overview
-----------

API is a software intermediary that allows two applications to communicate with each other. It is a set of defined rules that enables applications to talk to each other. API is a contract between the client and the server, providing a set of endpoints that can be used to interact with the server.

# What is a REST API?
--------------------

REST (Representational State of Resource) is an architectural style for designing networked applications. It is based on the HTTP protocol and uses HTTP methods to manipulate resources. REST is a stateless protocol, meaning that each request contains all the information necessary to complete the request.

# REST API vs SOAP API
----------------------

### SOAP (Simple Object Access Protocol)

SOAP is a protocol for exchanging structured information in the implementation of web services. It is a stateful protocol, meaning that the server maintains information about the client between requests. SOAP is more complex and verbose than REST, making it less popular for web services.

### Why SOAP is not used in a professional way:

*   **Complexity**: SOAP is more complex than REST, making it harder to implement and maintain.
*   **Verbosity**: SOAP requires more bandwidth and processing power than REST, making it less efficient.
*   **Statefulness**: SOAP's statefulness makes it less scalable and more prone to errors than REST.
*   **Limited support**: SOAP has limited support for HTTP methods and headers, making it less flexible than REST.

# Advantages of REST API in Spring Boot
--------------------------------------

*   **Simplicity**: REST is simpler to implement and maintain than SOAP.
*   **Flexibility**: REST supports a wide range of HTTP methods and headers, making it more flexible than SOAP.
*   **Scalability**: REST's statelessness makes it more scalable than SOAP.
*   **Wide support**: REST has wide support in Spring Boot and other frameworks, making it a popular choice for web services.

# Commonly used HTTP status codes
---------------------------------

*   **200 OK**: Request was successful.
*   **201 Created**: Resource was created.
*   **400 Bad Request**: Request was invalid.
*   **401 Unauthorized**: User is not authenticated.
*   **403 Forbidden**: User does not have permission.
*   **404 Not Found**: Resource was not found.
*   **500 Internal Server Error**: Server encountered an error.

