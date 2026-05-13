import { useState, useEffect } from "react";
import API from "../services/api";

function useProjects() {
    const [projects, setProjects] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        fetchProjects();
    }, []);

    const fetchProjects = async () => {
        try {
            setLoading(true);
            const res = await API.get("/projects");
            setProjects(res.data);
        } catch (err) {
            console.error(err);
        } finally {
            setLoading(false);
        }
    };

    const createProject = async (data) => {
        await API.post("/projects", data);
        fetchProjects();
    };

    const updateProject = async (id, data) => {
        await API.put(`/projects/${id}`, data);
        fetchProjects();
    };

    const deleteProject = async (id) => {
        await API.delete(`/projects/${id}`);
        fetchProjects();
    };

    return {
        projects,
        loading,
        createProject,
        updateProject,
        deleteProject
    };
}

export default useProjects;