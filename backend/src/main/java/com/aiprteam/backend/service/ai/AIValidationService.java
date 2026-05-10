package com.aiprteam.backend.service.ai;

public interface AIValidationService {
        AIAnalysisResult analyzePR(PullRequest pr, List<Requirement> requirements);
}
