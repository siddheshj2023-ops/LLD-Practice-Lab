# Research Note

## Problem understanding

LLD practice is most useful when a learner can move through a repeatable loop: choose a problem, understand requirements, design classes and responsibilities, submit, receive useful feedback, review the attempt and try again.

The MVP therefore focuses on four representative problems: Parking Lot, Vending Machine, Elevator System and Library Management.

## What counts as a useful attempt

An attempt should preserve the selected problem, the learner's solution, submission time, evaluation status and feedback. This makes progress review possible instead of treating each submission as a disposable answer.

## Evaluation approach

The platform uses deterministic checks for simple structural evidence such as whether the submission contains classes, interfaces, responsibilities and domain concepts. More subjective dimensions such as abstraction quality and trade-offs are represented in the feedback model and can later be evaluated by an LLM.

This split is deliberate: deterministic checks are repeatable and explainable, while an LLM is better suited to nuanced design discussion.

## Feedback

Feedback is structured as criterion, evidence, concern, suggestion and confidence. The goal is to point to observable evidence in the learner's submission instead of returning an unexplained score.

## Extensibility

Evaluation is hidden behind an `Evaluator` interface. A future implementation can support an AI evaluator or human review. The submission object can also be extended to support diagram or structured formats.

## Reliability

The submission is stored before evaluation. Evaluation status is tracked, so a future asynchronous worker can process slow evaluations without blocking the submission request.

## Trade-offs

This prototype intentionally uses a simple Spring Boot monolith and H2. The assignment permits a small monolith, and this keeps attention on LLD/domain design rather than unnecessary infrastructure.
