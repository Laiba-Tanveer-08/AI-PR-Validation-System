
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import API from "../services/api";

function SprintPage() {
    const { sprintId } = useParams();
    const [requirements, setRequirements] = useState([]);

    useEffect(() => {
        fetchRequirements();
    }, []);

    const fetchRequirements = async () => {
        const res = await API.get(`/requirements/sprint/${sprintId}`);
        setRequirements(res.data);
    };

    return (
        <div>
            <h2>Sprint Requirements</h2>

            <button style={btn}>+ Add Requirement</button>

            <table style={table}>
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Status</th>
                </tr>
                </thead>

                <tbody>
                {requirements.map((req) => (
                    <tr key={req.id}>
                        <td>{req.title}</td>
                        <td>{req.description}</td>
                        <td>
                <span style={badge(req.status)}>
                  {req.status || "Pending"}
                </span>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

/* Styles */
const btn = {
    marginBottom: "15px",
    padding: "8px 12px",
    background: "#6366f1",
    color: "#fff",
    border: "none",
    borderRadius: "6px"
};

const table = {
    width: "100%",
    borderCollapse: "collapse",
    background: "#fff",
    borderRadius: "10px",
    overflow: "hidden"
};

const badge = (status) => ({
    padding: "4px 10px",
    borderRadius: "20px",
    background:
        status === "Done" ? "#d1fae5" :
            status === "Failed" ? "#fee2e2" :
                "#e0e7ff"
});

export default SprintPage;