package com.lldpractice.lldpracticelab.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Attempt {
    private Long id;
    private Long problemId;
    private String problemTitle;
    private String status;
    private String solution;
    private LocalDateTime createdAt;
    private LocalDateTime submittedAt;
    private List<Feedback> feedback = new ArrayList<>();

    public Attempt() {}
    public Attempt(Long id, Long problemId, String problemTitle) {
        this.id = id; this.problemId = problemId; this.problemTitle = problemTitle;
        this.status = "DRAFT"; this.createdAt = LocalDateTime.now();
    }
    public Long getId(){return id;}
    public Long getProblemId(){return problemId;}
    public String getProblemTitle(){return problemTitle;}
    public String getStatus(){return status;}
    public String getSolution(){return solution;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public LocalDateTime getSubmittedAt(){return submittedAt;}
    public List<Feedback> getFeedback(){return feedback;}
    public void setStatus(String v){status=v;}
    public void setSolution(String v){solution=v;}
    public void setSubmittedAt(LocalDateTime v){submittedAt=v;}
    public void setFeedback(List<Feedback> v){feedback=v;}
}
