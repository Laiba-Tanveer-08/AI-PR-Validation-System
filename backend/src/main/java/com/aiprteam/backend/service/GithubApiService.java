package com.aiprteam.backend.service;

import com.aiprteam.backend.dto.ChangedFileDto;

import java.util.List;

public interface GithubApiService {

    List<ChangedFileDto> getPrFiles(String owner, String repo, int prNumber);
}
