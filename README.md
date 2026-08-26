# 🎂 Age Calculator

A clean, full-stack **Age Calculator** built with **Java, Spring Boot, PostgreSQL (Supabase), and JavaScript**.

Enter a name and date of birth, and the application calculates the person's current age and stores the calculation in the database.

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Supabase-blue?logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Ready-blue?logo=docker)
![License](https://img.shields.io/badge/License-MIT-green)

## ✨ Features

- 🎯 Calculate age from Date of Birth
- 👤 Capture user's name
- 📅 Accurate age calculation using Java `LocalDate` and `Period`
- 💾 Store calculation records in PostgreSQL
- ⚡ REST API powered by Spring Boot
- 🌐 Simple and responsive frontend
- 🔐 Database credentials managed through environment variables
- 🐳 Docker-ready backend
- ☁️ Ready for cloud deployment

---

## 🏗️ Architecture

```text
                  ┌─────────────────────┐
                  │      Frontend       │
                  │  HTML / CSS / JS    │
                  └──────────┬──────────┘
                             │
                             │ HTTP POST
                             ▼
                  ┌─────────────────────┐
                  │     Spring Boot     │
                  │      REST API       │
                  └──────────┬──────────┘
                             │
                             │ JPA / Hibernate
                             ▼
                  ┌─────────────────────┐
                  │      Supabase       │
                  │     PostgreSQL      │
                  └─────────────────────┘
````

---

## 🛠️ Tech Stack

| Layer             | Technology                  |
| ----------------- | --------------------------- |
| Frontend          | HTML, CSS, JavaScript       |
| Backend           | Java                        |
| Framework         | Spring Boot                 |
| API               | REST                        |
| ORM               | Spring Data JPA / Hibernate |
| Database          | PostgreSQL                  |
| Database Platform | Supabase                    |
| Build Tool        | Maven                       |
| Containerization  | Docker                      |
| Version Control   | Git / GitHub                |
| Deployment        | Render                      |

---

## 📁 Project Structure

```text
age_calculator_java/
│
├── backend/
│   ├── Dockerfile
│   ├── pom.xml
│   │
│   └── src/
│       └── main/
│           ├── java/
│           │   └── ...
│           │
│           └── resources/
│               └── application.properties
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
│
└── README.md
```

---

## 🔄 How It Works

### 1. User enters information

The frontend collects:

```text
Name
Date of Birth
```

### 2. Frontend sends request

The application sends a `POST` request to:

```http
POST /api/calculate-age
```

Example request:

```json
{
  "name": "John Doe",
  "dob": "2000-05-15"
}
```

### 3. Spring Boot calculates the age

The backend uses Java's date/time API:

```java
LocalDate
Period
```

to calculate the person's current age.

### 4. Data is stored

The backend stores:

```text
Name
Date of Birth
Calculated Age
```

in PostgreSQL.

### 5. Result is returned

The API responds with:

```json
{
  "age": 26
}
```

---

## 🗄️ Database

The application uses a PostgreSQL table:

```text
user_age_records
```

### Schema

| Column           | Type    | Description    |
| ---------------- | ------- | -------------- |
| `id`             | BIGINT  | Primary key    |
| `name`           | VARCHAR | User's name    |
| `dob`            | DATE    | Date of birth  |
| `calculated_age` | INTEGER | Calculated age |

Supabase is used as the managed PostgreSQL database.

---

## 🚀 Running Locally

### Prerequisites

Make sure you have:

* Java 17+
* Maven
* Git
* PostgreSQL / Supabase account

---

### 1. Clone the repository

```bash
git clone https://github.com/atrimabhatta/age_calculator_java.git
```

```bash
cd age_calculator_java
```

---

### 2. Configure the backend

```bash
cd backend
```

Create/configure:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.application.name=age-calculator

server.port=${PORT:8080}

spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.open-in-view=false
```

---

### 3. Set environment variables

```bash
export DATABASE_URL="jdbc:postgresql://YOUR_SUPABASE_HOST:5432/postgres"
export DATABASE_USERNAME="postgres"
export DATABASE_PASSWORD="YOUR_PASSWORD"
```

Never commit database credentials to GitHub.

---

### 4. Start the backend

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

---

## 🔌 API

### Calculate Age

```http
POST /api/calculate-age
```

### Request

```json
{
  "name": "John Doe",
  "dob": "2000-05-15"
}
```

### Response

```json
{
  "age": 26
}
```

---

## 🐳 Docker

The backend includes a Dockerfile for cloud deployment.

Build the image:

```bash
docker build -t age-calculator ./backend
```

Run:

```bash
docker run -p 8080:8080 age-calculator
```

The application will be available at:

```text
http://localhost:8080
```

Docker can also be built remotely by deployment platforms such as Render, so Docker Desktop is not required on the deployment machine.

---

## ☁️ Deployment

The application is designed for deployment using:

```text
GitHub
   ↓
Render
   ↓
Docker
   ↓
Spring Boot
   ↓
Supabase PostgreSQL
```

### Backend

Render builds the application using:

```text
backend/Dockerfile
```

### Database

Supabase provides the PostgreSQL database.

### Frontend

The frontend can be deployed separately as a static site.

---

## 🔐 Environment Variables

The following variables are required:

```text
DATABASE_URL
DATABASE_USERNAME
DATABASE_PASSWORD
```

Example:

```text
DATABASE_URL=jdbc:postgresql://your-host:5432/postgres
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=********
```

⚠️ **Never expose your database password in source code or commit it to GitHub.**

---

## 📸 Application Flow

```text
┌───────────────────────────────────────┐
│           AGE CALCULATOR              │
│                                       │
│  Name:       [ John Doe           ]   │
│                                       │
│  Date of Birth: [ 15/05/2000       ] │
│                                       │
│          [ Calculate Age ]             │
│                                       │
│          🎉 Age: 26                   │
└───────────────────────────────────────┘
```

---

## 📌 Future Improvements

Potential improvements include:

* 📋 Display calculation history
* 🔍 Search previous records
* ✏️ Edit/delete records
* 📊 Admin dashboard
* 🔐 User authentication
* 🌍 Multi-language support
* 📱 Improved mobile experience
* 🧪 Automated unit and integration tests
* 📈 Analytics dashboard
* 🎨 UI themes and customization

---

## 🎯 Project Goal

The project demonstrates a complete full-stack workflow:

```text
User Input
    ↓
Frontend
    ↓
REST API
    ↓
Java / Spring Boot
    ↓
Age Calculation
    ↓
JPA / Hibernate
    ↓
PostgreSQL
    ↓
Supabase
```

It is intentionally simple while demonstrating the core concepts of building, connecting, and deploying a modern full-stack application.

---
## Output
<img width="2880" height="1800" alt="image" src="https://github.com/user-attachments/assets/de94eb02-5c07-4ca7-881d-778d72e560ae" />

## 👨‍💻 Author

**Atrima Bhattacharyya**

Built with Java ☕ + Spring Boot 🚀 + PostgreSQL 🐘

---

## ⭐ Support

If you find this project useful, consider giving the repository a ⭐ on GitHub.

````

