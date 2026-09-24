# AI_USAGE.md

## 1. Domain model
AI was used to brainstorm a small domain model around Problem, Attempt, Submission, Evaluation and Feedback. The final design kept these boundaries because they map directly to the required practice loop.

## 2. Evaluation strategy
AI suggested combining deterministic checks with LLM feedback. For this MVP, deterministic checks were chosen first because they are repeatable, testable and explainable. An `Evaluator` interface is used so an AI evaluator can be added later.

## 3. Feedback structure
AI suggested structured feedback instead of a single overall score. The implementation returns criterion, evidence, concern, suggestion and confidence so a learner can understand what to change.

## 4. Submission flow
AI suggested storing a submission before evaluation. The implementation follows that approach and represents evaluation status as PENDING, COMPLETED or FAILED.

## 5. Extensibility
AI suggested keeping evaluation behind an interface and submission as its own domain object. This was accepted because the assignment asks how the system could evolve to other evaluators and submission formats.
