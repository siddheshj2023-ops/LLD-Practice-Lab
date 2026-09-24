package com.lldpractice.lldpracticelab.controller;

import com.lldpractice.lldpracticelab.model.Attempt;
import com.lldpractice.lldpracticelab.model.Problem;
import com.lldpractice.lldpracticelab.model.SubmissionRequest;
import com.lldpractice.lldpracticelab.service.AttemptService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/attempts")
public class AttemptController {

    private final AttemptService service;

    private final List<Problem> problems = List.of(
            new Problem(
                    1L,
                    "Parking Lot",
                    "Design a parking lot system.",
                    "Easy",
                    List.of()
            ),
            new Problem(
                    2L,
                    "Vending Machine",
                    "Design a vending machine.",
                    "Easy",
                    List.of()
            ),
            new Problem(
                    3L,
                    "Elevator System",
                    "Design an elevator system.",
                    "Medium",
                    List.of()
            ),
            new Problem(
                    4L,
                    "Library Management",
                    "Design a library system.",
                    "Medium",
                    List.of()
            )
    );

    public AttemptController(AttemptService service) {
        this.service = service;
    }

    @GetMapping
    public List<Attempt> all() {
        return service.all();
    }

    @PostMapping
    public ResponseEntity<?> start(@RequestParam Long problemId) {

        for (Problem problem : problems) {

            if (problem.id().equals(problemId)) {
                Attempt attempt = service.start(problem);
                return ResponseEntity.ok(attempt);
            }
        }

        return ResponseEntity
                .badRequest()
                .body(Map.of("error", "Unknown problemId"));
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<?> submit(
            @PathVariable Long id,
            @RequestBody SubmissionRequest request) {

        try {
            Attempt attempt = service.submit(id, request.solution());
            return ResponseEntity.ok(attempt);

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}