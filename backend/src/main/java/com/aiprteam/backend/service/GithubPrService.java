package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.ChangedFileDto;
import com.aiprteam.backend.dto.GithubPrDto;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface GithubPrService {
    GithubPrDto extractGithubPr(String payload);
     List<ChangedFileDto> extractChangedFiles(JsonNode jsonNode);
}
