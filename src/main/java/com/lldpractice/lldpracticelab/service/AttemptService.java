package com.lldpractice.lldpracticelab.service;

import com.lldpractice.lldpracticelab.model.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AttemptService {
    private final Map<Long, Attempt> attempts = new LinkedHashMap<>();
    private final AtomicLong ids = new AtomicLong(1);
    private final Evaluator evaluator;

    public AttemptService(Evaluator evaluator) { this.evaluator = evaluator; }

    public synchronized Attempt start(Problem p) {
        Attempt a = new Attempt(ids.getAndIncrement(), p.id(), p.title());
        attempts.put(a.getId(), a);
        return a;
    }

    public synchronized List<Attempt> all() { return new ArrayList<>(attempts.values()); }

    public synchronized Attempt get(long id) {
        Attempt a = attempts.get(id);
        if (a == null) throw new NoSuchElementException("Attempt not found");
        return a;
    }

    public synchronized Attempt submit(long id, String solution) {
        Attempt a = get(id);
        a.setSolution(solution == null ? "" : solution);
        a.setStatus("EVALUATING");
        a.setSubmittedAt(LocalDateTime.now());
        try {
            a.setFeedback(evaluator.evaluate(a.getSolution(), a.getProblemTitle()));
            a.setStatus("COMPLETED");
        } catch (RuntimeException ex) {
            a.setStatus("FAILED");
            throw ex;
        }
        return a;
    }
}
