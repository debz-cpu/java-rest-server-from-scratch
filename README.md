# Java REST Server from Scratch

A REST server built in plain Java, with no Spring or other web framework.
It uses the JDK's built-in `HttpServer` for the HTTP layer and hand-written
layers for routing, business logic and persistence.

The goal is to understand what frameworks like Spring Boot do under the hood.
A Todo API is included as an example resource.

> Status: in progress (Milestone 1)

## Architecture

| Layer | Responsibility | Example |
| --- | --- | --- |
| Server | starts `HttpServer`, maps paths to handlers | `Server` |
| Presentation | reads method, path and body; sends the response | `TodoHandler` |
| Business | rules, JSON mapping, status codes | `TodoController` |
| Data | storage via the Repository and Unit of Work patterns | `TodoRepository`, `UnitOfWork` |
| Model / DTO | plain data objects | `Todo` |

Each layer only calls the one below it.

## Tech stack

- Java 21, Maven
- `com.sun.net.httpserver.HttpServer` (JDK)
- Jackson for JSON
- JUnit 5
- PostgreSQL + Docker (planned)

## API

| Method | Path | Description | Success |
| --- | --- | --- | --- |
| GET | `/todos` | list all todos | 200 |
| GET | `/todos/{id}` | get one todo | 200 / 404 |
| POST | `/todos` | create a todo | 201 |
| PUT | `/todos/{id}` | update a todo | 200 / 404 |
| DELETE | `/todos/{id}` | delete a todo | 204 / 404 |

Invalid ids or JSON return `400`; unsupported methods return `405`.

## Run it

    mvn clean package
    java -cp target/classes io.github.debzcpu.Main

Server runs on `http://localhost:10001`.

    curl -i localhost:10001/todos

## Roadmap

- [ ] Milestone 1: HTTP skeleton (Server, Request, Response, enums)
- [ ] Milestone 2: Todo CRUD with correct status codes and tests
- [ ] Milestone 3: PostgreSQL, Unit of Work, Docker
- [ ] Milestone 4: thread pool, logging filter, token auth

## What I learned

(Fill in after each milestone: one or two lines on what clicked.)
