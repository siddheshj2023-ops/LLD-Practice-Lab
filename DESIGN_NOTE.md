# Design Note

## Main domain objects

- Problem: defines an LLD exercise and requirements.
- Attempt: represents a learner's work on one problem.
- Submission: stores the submitted solution.
- Evaluation: records evaluation state and generated feedback.
- Feedback: explains evidence and improvement suggestions.

## Responsibilities

Problem owns problem requirements. Attempt tracks learner progress. Submission represents learner-provided content. Evaluator performs evaluation. Feedback explains the result.

## Key interface

`Evaluator` abstracts the evaluation strategy. `RuleBasedEvaluator` is the current implementation. An `AiEvaluator` can be added later without changing the controller's submission flow.

## Submission lifecycle

DRAFT -> SUBMITTED -> EVALUATING -> COMPLETED / FAILED

The prototype performs evaluation synchronously after persisting the submission, while keeping status fields so asynchronous processing can be introduced later.

## Extensibility

A future diagram submission can be represented by a different submission format while retaining Attempt and Evaluation. Additional evaluator implementations can be selected by strategy or dependency injection.
