package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.GithubPrDto;

import com.fasterxml.jackson.databind.JsonNode;

public class GithubPrMapper {

    public GithubPrDto toDto(JsonNode prNode, JsonNode jsonNode) {

        GithubPrDto dto = new GithubPrDto();

        dto.setGithubPrId(prNode.path("id").asLong());
        dto.setTitle(prNode.path("title").asText(""));
        dto.setDescription(prNode.path("body").asText(""));

        dto.setSourceBranch(prNode.path("head").path("ref").asText(""));
        dto.setTargetBranch(prNode.path("base").path("ref").asText(""));

        dto.setAuthor(prNode.path("user").path("login").asText(""));
        dto.setAuthorId(prNode.path("user").path("id").asLong());

        dto.setState(prNode.path("state").asText(""));
        dto.setMerged(prNode.path("merged").asBoolean(false));
        dto.setDraft(prNode.path("draft").asBoolean(false));

        dto.setCreatedAt(prNode.path("created_at").asText(""));
        dto.setUpdatedAt(prNode.path("updated_at").asText(""));
        dto.setHtmlUrl(prNode.path("html_url").asText(""));

        dto.setRepoName(jsonNode.path("repository").path("name").asText(""));
        dto.setRepoFullName(jsonNode.path("repository").path("full_name").asText(""));

        return dto;
    }
}
