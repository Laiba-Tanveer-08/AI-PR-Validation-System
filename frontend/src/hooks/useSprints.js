import { useState, useEffect } from "react";
import API from "../services/api";

function useSprints(projectId) {
    const [sprints, setSprints] = useState([]);

    useEffect(() => {
        if (projectId) fetchSprints();
    }, [projectId]);

    const fetchSprints = async () => {
        const res = await API.get(`/projects/${projectId}/sprints`);
        setSprints(res.data);
    };

    const createSprint = async (data) => {
        await API.post(`/projects/${projectId}/sprints`, data);
        fetchSprints();
    };

    const updateSprint = async (id, data) => {
        await API.put(`/sprints/${id}`, data);
        fetchSprints();
    };

    const deleteSprint = async (id) => {
        await API.delete(`/sprints/${id}`);
        fetchSprints();
    };

    return { sprints, createSprint, updateSprint, deleteSprint };
}

export default useSprints;