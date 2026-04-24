# WhatsApp Chatbot Backend Simulation

This project is a simple WhatsApp chatbot backend simulation built using Java and Spring Boot for the internship assignment.

## Features

- Exposes a `POST /webhook` REST API endpoint
- Accepts JSON input simulating WhatsApp messages
- Returns predefined replies:
  - `Hi` -> `Hello`
  - `Bye` -> `Goodbye`
- Returns a default reply for unknown messages
- Logs all incoming messages in the console

## Tech Stack

- Java 17
- Spring Boot 3
- Maven

## Project Structure

```text
src/main/java/com/example/chatbot
|-- ChatbotApplication.java
|-- controller/WebhookController.java
|-- dto/MessageRequest.java
|-- dto/MessageResponse.java
|-- service/ChatbotService.java
```

## How to Run Locally

1. Make sure Java 17 and Maven are installed.
2. Open the project in terminal.
3. Run:

```bash
mvn spring-boot:run
```

4. The application will start on:

```text
http://localhost:8080
```

## API Endpoint

### `POST /webhook`

Request body:

```json
{
  "message": "Hi"
}
```

Response:

```json
{
  "reply": "Hello"
}
```

## Sample Test Cases

### Case 1

Request:

```json
{
  "message": "Hi"
}
```

Response:

```json
{
  "reply": "Hello"
}
```

### Case 2

Request:

```json
{
  "message": "Bye"
}
```

Response:

```json
{
  "reply": "Goodbye"
}
```

### Case 3

Request:

```json
{
  "message": "How are you?"
}
```

Response:

```json
{
  "reply": "I don't understand"
}
```

## Postman Testing

- Method: `POST`
- URL: `http://localhost:8080/webhook`
- Header: `Content-Type: application/json`
- Body: raw JSON

## Logging

Every incoming message is logged in the application console using Spring Boot logging.

Example log:

```text
Incoming message received: Hi
```
