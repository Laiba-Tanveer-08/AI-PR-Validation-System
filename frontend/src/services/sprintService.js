import API from "./api";

export const getSprints = (projectId) =>
    API.get(`/projects/${projectId}/sprints`);

export const createSprint = (projectId, data) =>
    API.post(`/projects/${projectId}/sprints`, data);

export const updateSprint = (id, data) =>
    API.put(`/sprints/${id}`, data);

export const deleteSprint = (id) =>
    API.delete(`/sprints/${id}`);