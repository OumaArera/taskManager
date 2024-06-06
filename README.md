# Task Management App

## Overview

The Task Management App is a simple command-line application that allows users to manage tasks. Users can view tasks, add new tasks, mark tasks as complete, delete tasks, and view tasks by category or priority. This app is written in Java and includes unit tests to ensure its functionality.

## Features

- View all tasks
- Add a new task
- Mark a task as complete
- Delete a task
- View tasks by category
- View tasks by priority
- Exit the application

## Project Structure

```
taskManager/
│
├── docker-compose.test.yml
├── docker-compose.yml
├── Dockerfile
├── hamcrest-core-1.3.jar
├── junit-4.13.2.jar
├── LICENSE
├── pom.xml
├── README.md
├── TaskManagementApp.java
├── TaskManager.java
├── Tasks.java
├── TaskManagementApp.class
├── TaskManager.class
└── Tasks.class

```

## Prerequisites

- Java Development Kit (JDK) 11 or later
- Docker (optional, for running the app and tests in a container)

## Getting Started

### Running the Application

#### Using Java

1. **Compile the source files:**

    ```bash
    javac TaskManagementApp.java Tasks.java TaskManager.java
    ```

2. **Run the application:**

    ```bash
    java TaskManagementApp
    ```

#### Using Docker

1. **Build and Run the Docker image:**

    ```bash
    docker-compose up -d --build
    ```
2. **Attach Docker CLI**
 
    ```
    docker attach <container_id>
    ```

### Running the Tests

#### Using Java

1. **Compile the application and test files:**

    ```bash
    javac TaskManagerTest.java
    ```

2. **Run the tests:**

    ```bash
    java TaskManagerTest
    ```

#### Using Docker

1. **Build the Docker image for tests:**

    ```bash
    docker-compose -f docker-compose.test.yml up --build
    ```

## Classes

### Tasks

Represents a task with properties such as id, description, category, priority, and completion status.

### TaskManager

Manages a list of tasks. Provides methods to add, mark as complete, delete, and retrieve tasks by category or priority.

### TaskManagementApp

Provides a command-line interface for interacting with the TaskManager. Contains methods to display menus and handle user input.

## Unit Tests

The unit tests are written using JUnit and are located in the `tests` directory. The `TaskManagerTest` class contains tests to verify the functionality of the `TaskManager` class.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Developer

This application has been developed by John Ouma alias Ouma Arera



