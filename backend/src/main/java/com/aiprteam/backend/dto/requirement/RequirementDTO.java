package com.aiprteam.backend.dto.requirement;


public class RequirementDTO {
    private Long id;
    private String name;          // ✅ must be name (not title)
    private String description;

    public Long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
