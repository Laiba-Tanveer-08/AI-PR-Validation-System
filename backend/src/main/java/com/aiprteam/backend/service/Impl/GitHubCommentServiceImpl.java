package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.service.GithubCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GitHubCommentServiceImpl implements GithubCommentService {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String GITHUB_API =
            "https://api.github.com/repos/";

    // =========================
    // 1. SUMMARY COMMENT
    // =========================
    @Override
    public void postSummaryComment(String owner, String repo, int prNumber, String comment) {

        String url = GITHUB_API + owner + "/" + repo + "/issues/" + prNumber + "/comments";

        Map<String, String> body = new HashMap<>();
        body.put("body", comment);

        send(url, body);
    }

    // =========================
    // 2. INLINE COMMENT
    // =========================
    @Override
    public void postInlineComment(String owner, String repo, int prNumber,
                                  String file, int line, String comment) {

        String url = GITHUB_API + owner + "/" + repo + "/pulls/" + prNumber + "/comments";

        Map<String, Object> body = new HashMap<>();
        body.put("body", comment);
        body.put("path", file);
        body.put("line", line);

        send(url, body);
    }

    // =========================
    // 3. REVIEW STATUS
    // =========================
    @Override
    public void updateReviewStatus(String owner, String repo, int prNumber, String state) {

        String url = GITHUB_API + owner + "/" + repo + "/pulls/" + prNumber + "/reviews";

        Map<String, String> body = new HashMap<>();
        body.put("event", state); // APPROVE / REQUEST_CHANGES / COMMENT

        send(url, body);
    }

    // =========================
    // COMMON SENDER
    // =========================
    private void send(String url, Object body) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer YOUR_GITHUB_TOKEN");
        headers.set("Accept", "application/vnd.github+json");

        HttpEntity<Object> entity = new HttpEntity<>(body, headers);

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}