package com.lldpractice.lldpracticelab.controller;

import com.lldpractice.lldpracticelab.model.Problem;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {
    @GetMapping
    public List<Problem> getProblems() {
        return List.of(
            new Problem(1L, "Parking Lot", "Design a parking lot system that manages vehicles and parking spaces.", "Easy",
                List.of("Support multiple vehicle types", "Assign a parking space", "Track occupied and available spaces", "Calculate parking charges")),
            new Problem(2L, "Vending Machine", "Design a vending machine that allows users to purchase products.", "Easy",
                List.of("Display products", "Accept payment", "Dispense product", "Return change")),
            new Problem(3L, "Elevator System", "Design an elevator system that handles floor requests.", "Medium",
                List.of("Support multiple floors", "Handle internal and external requests", "Move elevator between floors", "Handle multiple requests")),
            new Problem(4L, "Library Management", "Design a library system for managing books and members.", "Medium",
                List.of("Manage books", "Manage members", "Borrow and return books", "Track book availability"))
        );
    }
}
