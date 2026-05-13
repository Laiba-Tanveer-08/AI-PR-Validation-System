package com.aiprteam.backend.service;

public interface GithubCommentService {

        void postSummaryComment(String owner, String repo, int prNumber, String comment);

        void postInlineComment(String owner, String repo, int prNumber, String file, int line, String comment);

        void updateReviewStatus(String owner, String repo, int prNumber, String state);
    }

