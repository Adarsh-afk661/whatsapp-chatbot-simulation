# 📱 WhatsApp Chatbot Backend Simulation

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green?style=for-the-badge&logo=spring-boot)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)
![REST API](https://img.shields.io/badge/API-REST-blue?style=for-the-badge)

**A simple backend simulation of a WhatsApp chatbot using Java & Spring Boot**

</div>

---

## 📋 Table of Contents

- [🚀 Project Objective](#-project-objective)
- [✨ Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [📂 Project Structure](#-project-structure)
- [🔌 API Details](#-api-details)
- [🧪 Testing](#-testing)
- [⚙️ Running the Project](#️-running-the-project)
- [📮 Postman Testing](#-postman-testing)
- [📝 Logging](#-logging)
- [⚠️ Validation Notes](#️-validation--behavior-notes)
- [📦 Submission](#-submission-artifacts)
- [🔮 Future Improvements](#-future-improvements)
- [👨‍💻 Author](#-author)

---

## 🚀 Project Objective

This project simulates a **WhatsApp chatbot backend** by exposing a webhook endpoint that:

- Accepts incoming messages in JSON format  
- Returns predefined chatbot responses  
- Logs all incoming messages  

---

## ✨ Features

- 📌 `POST /webhook` REST endpoint  
- 📥 Accepts JSON requests  
- 🤖 Returns predefined chatbot responses  
- ❓ Handles unknown messages  
- 📝 Logs incoming messages  
- 🧪 Includes basic testing  

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Maven**
- **REST API**

---

## 📂 Project Structure

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

---

---

## 🔌 API Details

### 📍 Endpoint

- **Method:** POST  
- **URL:** `/webhook`

---

### 📥 Request Body

```json
{
  "message": "Hi"
}": "Hi"
}
### Response 

{
  "reply": "Hello"
}
