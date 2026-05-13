package com.aiprteam.backend.dto;

public class PrDto {


        private Long id;
        private String name;
        private String gitHubPrId;
        private String status;

        //  Relationship IDs
        private Long requirementId;
        private Long sprintId;
        private Long projectId;

        //  GETTERS & SETTERS

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGitHubPrId() {
            return gitHubPrId;
        }

        public void setGitHubPrId(String gitHubPrId) {
            this.gitHubPrId = gitHubPrId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Long getRequirementId() {
            return requirementId;
        }

        public void setRequirementId(Long requirementId) {
            this.requirementId = requirementId;
        }

        public Long getSprintId() {
            return sprintId;
        }

        public void setSprintId(Long sprintId) {
            this.sprintId = sprintId;
        }

        public Long getProjectId() {
            return projectId;
        }

        public void setProjectId(Long projectId) {
            this.projectId = projectId;
        }
    }

