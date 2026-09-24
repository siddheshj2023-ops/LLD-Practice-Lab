package com.lldpractice.lldpracticelab.service;

import com.lldpractice.lldpracticelab.model.Feedback;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RuleBasedEvaluator implements Evaluator {
    @Override
    public List<Feedback> evaluate(String solution, String problemTitle) {
        String s = solution == null ? "" : solution;
        List<Feedback> out = new ArrayList<>();
        boolean hasClass = s.matches("(?s).*\\bclass\\s+\\w+.*");
        boolean hasInterface = s.matches("(?s).*\\binterface\\s+\\w+.*");
        boolean hasResponsibility = s.toLowerCase().matches("(?s).*(responsib|method|service|manager|strategy).*");
        boolean hasDomainConcept = s.toLowerCase().contains(problemTitle.toLowerCase().split(" ")[0]);

        out.add(new Feedback("Class responsibilities",
                hasClass ? "Found at least one class declaration." : "No class declaration was detected.",
                hasClass ? "Responsibility evidence is present." : "The submission may not yet express concrete objects.",
                hasClass ? "Explain what each class owns and what it should not own." : "Introduce classes for the main domain objects.",
                0.95));
        out.add(new Feedback("Interfaces and abstraction",
                hasInterface ? "Found an interface declaration." : "No interface declaration was detected.",
                hasInterface ? "An abstraction point is visible." : "There is no explicit interface evidence.",
                hasInterface ? "Explain why the interface is useful and what implementations may vary." : "Add an interface only where behavior is expected to vary; avoid patterns for show.",
                0.90));
        out.add(new Feedback("Behavior and testability",
                hasResponsibility ? "Found responsibility/behavior related terms." : "Limited evidence of explicit behavior.",
                hasResponsibility ? "The design mentions behavior." : "Responsibilities are not clearly visible in the text.",
                "Name key behaviors and the objects responsible for them, then describe important edge cases.",
                0.85));
        out.add(new Feedback("Problem-domain coverage",
                hasDomainConcept ? "A domain term related to the selected problem was detected." : "The selected problem's domain term was not detected.",
                hasDomainConcept ? "The solution is connected to the chosen problem." : "The connection to the problem is unclear.",
                "Tie the main classes and interactions directly to the stated requirements.",
                0.80));
        return out;
    }
}
