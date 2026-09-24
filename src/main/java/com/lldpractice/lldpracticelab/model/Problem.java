package com.lldpractice.lldpracticelab.model;

import java.util.List;

public record Problem(Long id, String title, String description, String difficulty, List<String> requirements) {}
