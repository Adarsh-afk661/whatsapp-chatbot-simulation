# 💬 WhatsApp Chatbot Backend Simulation

A lightweight backend simulation of a WhatsApp chatbot built with **Java 17** and **Spring Boot 3**. Created as part of an internship assignment to demonstrate REST API development, JSON request handling, predefined chatbot responses, and message logging.

---

## 📌 Project Objective

The application simulates a WhatsApp chatbot backend by exposing a webhook endpoint that accepts incoming messages in JSON format and returns predefined responses.

| Incoming Message | Reply |
|-----------------|-------|
| `Hi` | `Hello` |
| `Bye` | `Goodbye` |
| Any other message | `I don't understand` |

> All incoming messages are logged in the console.

---

## 🛠️ Tech Stack

| Technology | Version |
|------------|---------|
| Java | 17 |
| Spring Boot | 3.x |
| Build Tool | Maven |
| API Type | REST |

---

## ✨ Features

- `POST /webhook` REST endpoint
- Accepts JSON requests simulating WhatsApp messages
- Returns chatbot-style predefined replies
- Handles unknown messages with a default response
- Logs every incoming message to the console
- Includes a basic service-layer unit test
- Case-insensitive message matching
- Trims leading/trailing whitespace before processing
- Rejects blank messages via request validation

---

## 📁 Project Structure

```
src
├── main
│   ├── java
│   │   └── com/example/chatbot
│   │       ├── ChatbotApplication.java
│   │       ├── controller/
│   │       │   └── WebhookController.java
│   │       ├── dto/
│   │       │   ├── MessageRequest.java
│   │       │   └── MessageResponse.java
│   │       └── service/
│   │           └── ChatbotService.java
│   └── resources
│       └── application.properties
└── test
    └── java/com/example/chatbot/service/
        └── ChatbotServiceTest.java
```

---

## 🔌 API Details

### Endpoint

| Property | Value |
|----------|-------|
| Method | `POST` |
| URL | `/webhook` |
| Content-Type | `application/json` |

### Request Body

```json
{
  "message": "Hi"
}
```

### Success Response

```json
{
  "reply": "Hello"
}
```

---

## 🚀 How to Run the Project Locally

### Prerequisites

- Java 17 installed
- Maven installed

### Run on Default Port (8080)

```bash
mvn spring-boot:run
```

Access at: `http://localhost:8080`

### Run on a Custom Port (e.g., 8081)

```bash
mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
```

Access at: `http://localhost:8081`

---

## 🧪 How to Test Using Postman

**Request Configuration:**
- Method: `POST`
- URL: `http://localhost:8080/webhook`
- Header: `Content-Type: application/json`
- Body: `raw` → `JSON`

### Test Case 1 — `Hi`

**Request:**
```json
{ "message": "Hi" }
```
**Response:**
```json
{ "reply": "Hello" }
```

### Test Case 2 — `Bye`

**Request:**
```json
{ "message": "Bye" }
```
**Response:**
```json
{ "reply": "Goodbye" }
```

### Test Case 3 — Unknown Message

**Request:**
```json
{ "message": "How are you?" }
```
**Response:**
```json
{ "reply": "I don't understand" }
```

---

## 📋 Logging

Every incoming message is automatically logged to the application console.

**Example output:**
```
Incoming message received: Hi
Incoming message received: Bye
Incoming message received: How are you?
```

---

## ✅ Validation & Behavior Notes

- **Blank messages** are rejected by request validation
- **Message matching** is case-insensitive (`hi`, `HI`, `Hi` all return `Hello`)
- **Whitespace** is trimmed before reply generation

---

## 🧾 Running Tests

```bash
mvn test
```

---

## 📦 Submission Artifacts

This repository is submitted with:

- [x] Source code
- [x] GitHub repository link
- [x] Screenshots of local execution
- [x] Demo video of the working API

### Suggested Screenshots

1. Spring Boot application running in terminal
2. Postman — `Hi` request and response
3. Postman — `Bye` request and response
4. Postman — unknown message request and response
5. Terminal logs showing incoming messages

---

## 🔮 Future Improvement Ideas

- Real WhatsApp Business API integration
- Database storage for chat history
- More dynamic and configurable reply rules
- Docker support for containerized deployment
- Cloud deployment on Render or another free platform

---

## 👨‍💻 Author

**Adarsh Srivastava**

---

> *Built as an internship assignment to demonstrate REST API development with Java & Spring Boot.*
