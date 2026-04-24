<div align="center">

<img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"/>
<img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/>
<img src="https://img.shields.io/badge/REST_API-005571?style=for-the-badge&logo=fastapi&logoColor=white"/>
<img src="https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge"/>

# 🤖 WhatsApp Chatbot — Backend Simulation

> A clean, production-structured Spring Boot REST API that simulates a WhatsApp chatbot webhook — built to demonstrate layered architecture, request validation, and automated testing.

</div>

---

## 📖 Overview

This project simulates the **server-side webhook** of a WhatsApp chatbot. When a user sends a message via WhatsApp Business API, WhatsApp forwards it to your webhook as a `POST` request. This application replicates that flow locally — receiving JSON payloads, processing them through a dedicated service layer, and returning appropriate replies.

Rather than hardcoding logic in the controller, the project follows a **Controller → Service → DTO** separation, making it easy to extend with a database, NLP engine, or real WhatsApp Business API in the future.

---

## 🏗️ Architecture

```
HTTP Client (Postman / WhatsApp)
        │
        ▼
┌──────────────────────┐
│  WebhookController   │  ← Receives POST /webhook, delegates to service
└──────────┬───────────┘
           │
           ▼
┌──────────────────────┐
│   ChatbotService     │  ← Business logic: message matching, logging
└──────────┬───────────┘
           │
           ▼
┌──────────────────────┐
│  MessageRequest /    │  ← DTOs for clean request-response contracts
│  MessageResponse     │
└──────────────────────┘
```

---

## 🗂️ Project Structure

```
src/
├── main/
│   ├── java/com/example/chatbot/
│   │   ├── ChatbotApplication.java          # Spring Boot entry point
│   │   ├── controller/
│   │   │   └── WebhookController.java       # POST /webhook endpoint
│   │   ├── dto/
│   │   │   ├── MessageRequest.java          # Incoming message model
│   │   │   └── MessageResponse.java         # Outgoing reply model
│   │   └── service/
│   │       └── ChatbotService.java          # Reply logic + console logging
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/example/chatbot/service/
        └── ChatbotServiceTest.java          # Unit tests for service layer
```

---

## ⚙️ Prerequisites

Ensure the following are installed on your machine:

| Requirement | Version | Check Command |
|-------------|---------|---------------|
| JDK | 17+ | `java -version` |
| Maven | 3.8+ | `mvn -version` |

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/whatsapp-chatbot-simulation.git
cd whatsapp-chatbot-simulation
```

### 2. Build the project

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn spring-boot:run
```

The server starts at: **`http://localhost:8080`**

> **Port conflict?** Run on a different port:
> ```bash
> mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
> ```

---

## 📡 API Reference

### `POST /webhook`

Accepts an incoming message and returns a chatbot reply.

**Request**

```http
POST /webhook
Content-Type: application/json
```

```json
{
  "message": "Hi"
}
```

**Response**

```json
{
  "reply": "Hello"
}
```

### Response Behavior

| Input Message | Response | Notes |
|---------------|----------|-------|
| `Hi` | `Hello` | Case-insensitive |
| `Bye` | `Goodbye` | Case-insensitive |
| *(blank / empty)* | `400 Bad Request` | Validation enforced |
| *(anything else)* | `I don't understand` | Default fallback |

> **Note:** Input is trimmed and matched case-insensitively — `" HI "`, `"hi"`, and `"Hi"` all return `Hello`.

---

## 🧪 Testing

### Run unit tests

```bash
mvn test
```

The `ChatbotServiceTest` covers:
- Correct reply for `Hi`
- Correct reply for `Bye`
- Default reply for unrecognized input
- Case-insensitivity behavior

### Manual testing with cURL

```bash
# Test Hi
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "Hi"}'

# Test Bye
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "Bye"}'

# Test unknown input
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "What is the weather?"}'
```

---

## 📋 Console Logging

Every request is logged automatically to stdout:

```
2024-01-15 10:23:01 INFO  ChatbotService - Incoming message received: Hi
2024-01-15 10:23:45 INFO  ChatbotService - Incoming message received: Bye
2024-01-15 10:24:10 INFO  ChatbotService - Incoming message received: What is the weather?
```

---

## 🔭 Roadmap

Planned improvements for future iterations:

- [ ] **WhatsApp Business API integration** — connect to real Meta webhook
- [ ] **Persistent chat history** — store conversations in PostgreSQL / MySQL
- [ ] **Dynamic reply rules** — load responses from DB or YAML config instead of hardcoding
- [ ] **NLP intent matching** — replace exact-match with keyword/intent detection
- [ ] **Dockerization** — `Dockerfile` + `docker-compose.yml` for one-command setup
- [ ] **Cloud deployment** — deploy on Render, Railway, or AWS EC2
- [ ] **Rate limiting** — prevent webhook flooding with Spring Rate Limiter

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature`
5. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

<div align="center">

**Built with ❤️ by [Adarsh Srivastava](https://github.com/your-username)**

*Internship Assignment — REST API Development with Java & Spring Boot*

</div>
