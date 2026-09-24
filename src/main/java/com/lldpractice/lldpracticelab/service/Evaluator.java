package com.lldpractice.lldpracticelab.service;

import com.lldpractice.lldpracticelab.model.Feedback;
import java.util.List;

public interface Evaluator {
    List<Feedback> evaluate(String solution, String problemTitle);
}
