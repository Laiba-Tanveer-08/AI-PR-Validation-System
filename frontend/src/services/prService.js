import API from "./api";

export const getPRs = (requirementId) =>
    API.get(`/requirements/${requirementId}/prs`);

export const getPRById = (id) =>
    API.get(`/prs/${id}`);

export const validatePR = (id) =>
    API.post(`/prs/${id}/validate`);