import { useState, useEffect } from "react";
import API from "../services/api";

function usePullRequests(requirementId) {
    const [prs, setPrs] = useState([]);

    useEffect(() => {
        if (requirementId) fetchPRs();
    }, [requirementId]);

    const fetchPRs = async () => {
        const res = await API.get(`/requirements/${requirementId}/prs`);
        setPrs(res.data);
    };

    const validatePR = async (prId) => {
        await API.post(`/prs/${prId}/validate`);
        fetchPRs();
    };

    return { prs, validatePR };
}

export default usePullRequests;