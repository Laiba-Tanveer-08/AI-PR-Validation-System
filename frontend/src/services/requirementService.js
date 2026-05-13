import API from "./api";

export const getRequirements = (sprintId) =>
    API.get(`/sprints/${sprintId}/requirements`);

export const createRequirement = (sprintId, data) =>
    API.post(`/sprints/${sprintId}/requirements`, data);

export const updateRequirement = (id, data) =>
    API.put(`/requirements/${id}`, data);

export const deleteRequirement = (id) =>
    API.delete(`/requirements/${id}`);