# LLD Practice Lab

A small practice platform for learning Low-Level Design through problem solving, submission, evaluation, feedback, and attempt history.

## MVP

- 4 LLD problems: Parking Lot, Vending Machine, Elevator System, Library Management
- Start an attempt
- Submit a structured text/code solution
- Deterministic rubric checks
- Explainable feedback with criterion, evidence, concern, suggestion and confidence
- Attempt history
- Simple responsive browser UI
- Spring Boot monolith with H2 persistence

## Run

Requirements: Java 21+ and Maven.

```bash
mvn spring-boot:run
```

Open `http://localhost:8080`.

## API

- `GET /api/problems`
- `GET /api/attempts`
- `POST /api/attempts`
- `POST /api/attempts/{id}/submit`

Example submission:
```json
{"solution":"class ParkingLot { Vehicle vehicle; ParkingSpot spot; ParkingStrategy strategy; }\ninterface ParkingStrategy { Spot findSpot(Vehicle vehicle); }"}
```

## Design choices

The prototype uses a simple monolith because the assignment explicitly allows it and the core challenge is LLD rather than infrastructure. Submission is stored before evaluation. Evaluation is deterministic for the MVP so feedback is repeatable and explainable.

## Limitations

The evaluator uses lightweight structural heuristics rather than an LLM. A future version can add a separate AI evaluator behind an `Evaluator` interface without changing the attempt flow.
