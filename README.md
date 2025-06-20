# Test API - Kotlin REST API

A simple Kotlin REST API built with Spring Boot that provides a `testadd` endpoint to add two numbers.

## Project Structure

```
test-api/
├── build.gradle.kts              # Gradle build configuration
├── settings.gradle.kts           # Gradle settings
├── gradlew                       # Gradle wrapper script (Unix)
├── gradlew.bat                   # Gradle wrapper script (Windows)
├── src/
│   ├── main/kotlin/com/example/testapi/
│   │   ├── TestApiApplication.kt     # Main Spring Boot application
│   │   ├── controller/
│   │   │   └── TestController.kt     # REST controller
│   │   ├── model/
│   │   │   ├── AddRequest.kt         # Request model
│   │   │   └── AddResponse.kt        # Response model
│   │   └── service/
│   │       └── CalculatorService.kt  # Business logic service
│   └── test/kotlin/com/example/testapi/
│       ├── TestApiApplicationTests.kt    # Application tests
│       ├── controller/
│       │   └── TestControllerTest.kt     # Controller integration tests
│       └── service/
│           └── CalculatorServiceTest.kt  # Service unit tests
└── README.md
```

## Prerequisites

- Java 17 or higher
- Gradle (or use the included Gradle wrapper)

## Getting Started

### 1. Build the Project

```bash
./gradlew build
```

### 2. Run the Application

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

### 3. Run Tests

```bash
./gradlew test
```

## API Endpoints

### POST /api/testadd

Adds two numbers using a JSON request body.

**Request:**
```json
{
  "a": 5,
  "b": 3
}
```

**Response:**
```json
{
  "result": 8
}
```

**Example using curl:**
```bash
curl -X POST http://localhost:8080/api/testadd \
  -H "Content-Type: application/json" \
  -d '{"a": 5, "b": 3}'
```

### GET /api/testadd

Adds two numbers using query parameters.

**Request:**
```
GET /api/testadd?a=5&b=3
```

**Response:**
```json
{
  "result": 8
}
```

**Example using curl:**
```bash
curl "http://localhost:8080/api/testadd?a=5&b=3"
```

## Test Cases

The project includes comprehensive test cases covering:

### Service Layer Tests (`CalculatorServiceTest`)
- Adding positive numbers
- Adding negative numbers
- Adding with zero
- Adding large numbers
- Adding mixed positive and negative numbers

### Controller Layer Tests (`TestControllerTest`)
- POST endpoint with valid JSON request
- POST endpoint with negative numbers
- GET endpoint with query parameters
- GET endpoint with zero values
- GET endpoint with large numbers

## Technology Stack

- **Kotlin**: 1.9.22
- **Spring Boot**: 3.2.0
- **Gradle**: 8.5
- **Java**: 17
- **JUnit 5**: For testing
- **Jackson**: For JSON serialization/deserialization

## Development

### Project Configuration

The project uses:
- Kotlin JVM plugin version 1.9.22
- Spring Boot 3.2.0
- Spring Web starter for REST API functionality
- Jackson module for Kotlin for JSON handling
- JUnit 5 for testing

### Building and Running

1. **Build**: `./gradlew build`
2. **Run**: `./gradlew bootRun`
3. **Test**: `./gradlew test`
4. **Clean**: `./gradlew clean`

## API Documentation

The API provides a simple addition service with two endpoints:

1. **POST /api/testadd**: Accepts JSON request body with `a` and `b` parameters
2. **GET /api/testadd**: Accepts query parameters `a` and `b`

Both endpoints return a JSON response with the `result` field containing the sum of the two numbers. 