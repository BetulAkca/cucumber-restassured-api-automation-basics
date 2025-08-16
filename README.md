# Cucumber-RestAssured-API-Automation-Basics

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8.8-red)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/TestNG-7.8.0-brightgreen)](https://testng.org/)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.3.0-orange)](https://rest-assured.io/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.12.0-lightgrey)](https://cucumber.io/)
[![Gson](https://img.shields.io/badge/Gson-2.10.1-yellow)](https://github.com/google/gson)

## Project Overview
This project is designed as an **introductory API automation framework**. It uses **Cucumber** and **RestAssured** to implement basic GET, POST, PUT, PATCH, and DELETE request tests.

The project focuses on **DevEx API** and **PetStore API**, including validations for status codes, content types, and response body content.

This repository is a foundation for building a more **advanced API automation framework**, demonstrating reusable methods, POJO deserialization, and test best practices.

---

## Technologies Used
- **Java 17**
- **Maven** (dependency management)
- **TestNG** (test runner)
- **RestAssured** (API testing library)
- **Cucumber** (BDD framework)
- **Gson** (POJO serialization / deserialization)

---

## Test Scenarios
- **GET Request Tests:** Verify status codes, content types, and response body validation.
- **POST Request Tests:** Add new users and profiles, validate request payloads.
- **PUT / PATCH Request Tests:** Update existing user or profile information.
- **DELETE Request Tests:** Delete users or specific data entries.
- **POJO & Gson Usage:** Deserialize JSON responses to Java objects for easy handling and validation.

---

## Usage
1. Clone the repository:
```bash
git clone https://github.com/your-username/cucumber-restassured-api-automation-basics.git
