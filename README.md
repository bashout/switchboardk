# SwitchboardK 🚩

A centralized store for managing feature switches (flags). Built using Kotlin 2.0.2 and the Spring framework, 
it allows you to easily manage, toggle, and evaluate feature switches across multiple components, enabling feature releases, A/B testing, and gradual rollouts with minimal impact on your codebase!

## Features
* **Centralized Flag Storage**: Store and manage feature flags in one place.
* **Flag Toggle Control**: Enable or disable flags in real time.
* **Gradual Rollouts**: Easily control staged feature rollouts.
* **Type-Safe Flag Access**: Access flags using Kotlin’s type-safe constructs.
* **Extensible Architecture**: Customize and extend flag sources and evaluation logic.

## How to Run the Application with Docker

Follow these steps to build and run the application in a Docker container.

### Prerequisites
Ensure that you have:
- Docker installed on your system.

### Steps to Build and Run

1. **Build the Docker Image**

   Run the following command in the directory containing your `Dockerfile` to build the Docker image:

   ```bash
   docker build -t switchboardk-app .
   
2. **Run the Docker Image**
    
    Run the following command to run the docker container you just built.
   ```bash
    docker run -d --name switchboardk-app switchboardk-app

**Alternatively, you can run the app in IntelliJ IDEA with no issues**