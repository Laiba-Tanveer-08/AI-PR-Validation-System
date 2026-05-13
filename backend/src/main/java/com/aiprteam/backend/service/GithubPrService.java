package com.aiprteam.backend.service;

import com.aiprteam.backend.entity.PullRequest;

public interface GithubPrService {

    PullRequest syncPRFromGitHub(String webhookPayload);
}