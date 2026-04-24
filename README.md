# WhatsApp Chatbot Backend Simulation

A simple backend simulation of a WhatsApp chatbot built with Java and Spring Boot. This project was created as part of an internship assignment to demonstrate REST API development, JSON request handling, predefined chatbot responses, and message logging.

## Project Objective

The application simulates a WhatsApp chatbot backend by exposing a webhook endpoint that accepts incoming messages in JSON format and returns predefined responses.

Required behavior:

- `Hi` returns `Hello`
- `Bye` returns `Goodbye`
- Any other message returns `I don't understand`
- All incoming messages are logged in the console

## Tech Stack

- Java 17
- Spring Boot 3
- Maven
- REST API

## Features

- `POST /webhook` REST endpoint
- Accepts JSON requests simulating WhatsApp messages
- Returns chatbot-style predefined replies
- Handles unknown messages with a default response
- Logs every incoming message
- Includes a basic service-layer test

## Project Structure

```text
src
|-- main
|   |-- java
|   |   `-- com/example/chatbot
|   |       |-- ChatbotApplication.java
|   |       |-- controller/WebhookController.java
|   |       |-- dto/MessageRequest.java
|   |       |-- dto/MessageResponse.java
|   |       `-- service/ChatbotService.java
|   `-- resources
|       `-- application.properties
`-- test
    `-- java/com/example/chatbot/service/ChatbotServiceTest.java
API Details
Endpoint
Method: POST
URL: /webhook
Request Body
{
  "message": "Hi"
}
Success Response
{
  "reply": "Hello"
}
Supported Message Responses
Incoming Message	Reply
Hi	Hello
Bye	Goodbye
Any other message	I don't understand
How to Run the Project Locally
Prerequisites
Java 17 installed
Maven installed
Run on Default Port
mvn spring-boot:run
Application URL:

http://localhost:8080
Run on Another Port
If port 8080 is already in use, run:

mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
Application URL:

http://localhost:8081
How to Test Using Postman
Request Configuration
Method: POST
URL: http://localhost:8080/webhook
If using another port: http://localhost:8081/webhook
Header: Content-Type: application/json
Body type: raw + JSON
Test Case 1
Request:

{
  "message": "Hi"
}
Response:

{
  "reply": "Hello"
}
Test Case 2
Request:

{
  "message": "Bye"
}
Response:

{
  "reply": "Goodbye"
}
Test Case 3
Request:

{
  "message": "How are you?"
}
Response:

{
  "reply": "I don't understand"
}
Logging
Every incoming message is logged in the application console.

Example:

Incoming message received: Hi
Incoming message received: Bye
Incoming message received: How are you?
Validation and Behavior Notes
Blank messages are rejected by request validation
Message matching is case-insensitive
Leading and trailing spaces are ignored before reply generation
Running Tests
mvn test
Submission Artifacts
This repository is intended to be submitted with:

Source code
GitHub repository link
Screenshots of local execution
Demo video of the working API
Suggested Screenshots
Spring Boot application running in terminal
Postman request and response for Hi
Postman request and response for Bye
Postman request and response for an unknown message
Terminal logs showing incoming messages
Future Improvement Ideas
Real WhatsApp Business API integration
Database storage for chat history
More dynamic reply rules
Docker support for deployment
Cloud deployment on Render or another free platform
Author

Adarsh Srivastava
iski redme file banaoo
