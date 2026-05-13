package com.aiprteam.backend.service.Impl;

import com.aiprteam.backend.dto.ChangedFileDto;
import com.aiprteam.backend.dto.GithubPrDto;
import com.aiprteam.backend.mapper.ChangedFileMapper;
import com.aiprteam.backend.mapper.GithubPrMapper;
import com.aiprteam.backend.service.GithubPrService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GithubPrServiceImpl implements GithubPrService {
    private final ObjectMapper objectMapper;
    private final GithubPrMapper githubPrMapper = new GithubPrMapper();
    private final ChangedFileMapper changedFileMapper = new ChangedFileMapper();
    @Override
    public GithubPrDto extractGithubPr(String payload) {
        JsonNode jsonNode = objectMapper.readTree(payload);
        JsonNode githubPrNode = jsonNode.get("pull_request");

        GithubPrDto dto = new GithubPrDto();
                dto= githubPrMapper.toDto(githubPrNode, jsonNode);

        return dto;
    }
    public List<ChangedFileDto> extractChangedFiles(JsonNode prNode){
        List<ChangedFileDto> dto = new ArrayList<>();
        JsonNode filesNode = prNode.path("files");

        if(filesNode.isArray()){
            for(JsonNode fileNode : filesNode){
                ChangedFileDto dtoFile = changedFileMapper.toDto(fileNode);
                dto.add(dtoFile);
            }
        }
        return dto;
    }
}


