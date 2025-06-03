

**Privacy-Preserving AI Chatbot Using Local Language Models**

A self-hosted AI chatbot that runs completely on your local machine using Large Language Models (LLMs). Built with Spring Boot and Thymeleaf, and powered by Ollama and LLaMA3, this chatbot protects your privacy while offering accurate, fast, and offline AI interactions.



---

**Motivation**

Current AI tools like ChatGPT process data on cloud servers, raising privacy concerns and needing constant internet access.

Problem:

* Risk of privacy breaches (GDPR/HIPAA).
* High dependency on cloud and internet.
* Expensive infrastructure requirements.

Solution:

* Local LLMs (Ollama + LLaMA3).
* Your data stays on your device.
* Works offline and is cost-efficient.

---

**System Design**

This project follows a 3-tier architecture:

1. Presentation Layer:

   * Thymeleaf frontend
   * Spring Security login

2. Application Layer:

   * Spring Boot REST API
   * Session-based access (no JWT)

3. Model Layer:

   * Ollama backend with LLaMA3-8B (4-bit quantized)



---

**Data Flow**

User → Thymeleaf UI → Spring Boot API → Ollama (LLaMA3) → Response

All processing is done locally, ensuring privacy.



---

**Results**

* Speed: Similar to loading a webpage
* Privacy: 100% local, no cloud processing
* System Requirements: Runs on regular computers
* Accuracy: Correct approximately 8 out of 10 times

\[Insert image: images/slide8-results.png]

---

**Tech Stack**

* Java (Spring Boot)
* Thymeleaf (UI)
* Ollama (LLM runtime)
* LLaMA3-8B (quantized)
* Spring Security

---

**How to Run**

1. Install Ollama and pull the model:
   ollama run llama3

2. Clone the repository:
   git clone [https://github.com/your-username/local-ai-chatbot.git](https://github.com/your-username/local-ai-chatbot.git)
   cd local-ai-chatbot

3. Run the Spring Boot app:
   ./mvnw spring-boot\:run

4. Open in your browser:
   [http://localhost:8080](http://localhost:8080)

---

