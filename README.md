# Clean Architecture Example

This project demonstrates the principles of **Clean Architecture** using **Kotlin**.
The goal is to create a modular, testable, and maintainable software structure where business logic is independent of frameworks and external systems.

## What is Clean Architecture?

**Clean Architecture** separates concerns into concentric layers and enforces **inward-pointing dependencies**:

* The **Domain layer** contains pure business rules and is completely framework-agnostic.
* The **Application layer** orchestrates use cases and defines ports (interfaces) needed by the use cases.
* The **Interface layer** provides **adapters** (incoming and outgoing) that implement those ports — e.g., web controllers, presenters, persistence repositories.

Outer layers depend on inner layers, never the other way around. Interfaces (ports) are defined in the inner layers; implementations (adapters) live in the Interface layer.

![Clean Architecture Overview](https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg)  
*Source: [The Clean Code Blog](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)*


## Benefits

* **High Testability:** Business logic can be tested without involving databases, frameworks, or network layers.
* **Framework Independence:** You can replace frameworks, databases, or delivery mechanisms with minimal effort.
* **Maintainability:** Changes in one layer have minimal impact on others.
* **Clear Dependency Direction:** All dependencies flow from the outside inward, never the other way around.

## Purpose

This repository serves as a **reference implementation and learning resource** for applying Clean Architecture in Kotlin.
It can be used as a **template for new projects** or as a **guide** to understanding modular architecture in practice.

## Technologies

* **Language:** Kotlin
* **Build Tool:** Gradle (Kotlin DSL)
* **Architecture Pattern:** Clean Architecture
* **Goal:** A modular, testable, and maintainable codebase

## Further Reading

* [Clean Architecture — Robert C. Martin (Uncle Bob)](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
* [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
* [Gradle Kotlin DSL Reference](https://docs.gradle.org/current/userguide/kotlin_dsl.html)