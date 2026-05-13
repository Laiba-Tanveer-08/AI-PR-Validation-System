import { useState, useEffect } from "react";
import API from "../services/api";

function useRequirements(sprintId) {
    const [requirements, setRequirements] = useState([]);

    useEffect(() => {
        if (sprintId) fetchRequirements();
    }, [sprintId]);

    const fetchRequirements = async () => {
        const res = await API.get(`/sprints/${sprintId}/requirements`);
        setRequirements(res.data);
    };

    const createRequirement = async (data) => {
        await API.post(`/sprints/${sprintId}/requirements`, data);
        fetchRequirements();
    };

    const updateRequirement = async (id, data) => {
        await API.put(`/requirements/${id}`, data);
        fetchRequirements();
    };

    const deleteRequirement = async (id) => {
        await API.delete(`/requirements/${id}`);
        fetchRequirements();
    };

    return {
        requirements,
        createRequirement,
        updateRequirement,
        deleteRequirement
    };
}

export default useRequirements;