package com.aiprteam.backend.mapper;

import com.aiprteam.backend.dto.GithubPrDto;

import tools.jackson.databind.JsonNode;

public class GithubPrMapper {

    public GithubPrDto toDto(JsonNode prNode, JsonNode jsonNode) {

        GithubPrDto dto = new GithubPrDto();

        dto.setGithubPrId(prNode.path("id").asLong());
        dto.setTitle(prNode.path("title").asString(""));
        dto.setDescription(prNode.path("body").asString(""));

        dto.setSourceBranch(prNode.path("head").path("ref").asString(""));
        dto.setTargetBranch(prNode.path("base").path("ref").asString(""));

        dto.setAuthor(prNode.path("user").path("login").asString(""));
        dto.setAuthorId(prNode.path("user").path("id").asLong());

        dto.setState(prNode.path("state").asString(""));
        dto.setMerged(prNode.path("merged").asBoolean(false));
        dto.setDraft(prNode.path("draft").asBoolean(false));

        dto.setCreatedAt(prNode.path("created_at").asString(""));
        dto.setUpdatedAt(prNode.path("updated_at").asString(""));
        dto.setHtmlUrl(prNode.path("html_url").asString(""));

        dto.setRepoName(jsonNode.path("repository").path("name").asString(""));
        dto.setRepoFullName(jsonNode.path("repository").path("full_name").asString(""));

        return dto;
    }
}
