import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import API from "../services/api";

function ProjectDetailPage() {
    const { projectId } = useParams();
    const navigate = useNavigate();

    const [project, setProject] = useState(null);
    const [sprints, setSprints] = useState([]);

    useEffect(() => {
        fetchProject();
        fetchSprints();
    }, []);

    const fetchProject = async () => {
        const res = await API.get(`/projects/${projectId}`);
        setProject(res.data);
    };

    const fetchSprints = async () => {
        const res = await API.get(`/sprints/project/${projectId}`);
        setSprints(res.data);
    };

    return (
        <div>
            {/* Project Header */}
            <div style={{ marginBottom: "20px" }}>
                <h2>{project?.name}</h2>
                <p style={{ color: "#666" }}>{project?.description}</p>
            </div>

            {/* Sprint Header */}
            <div style={headerStyle}>
                <h3>Sprints</h3>
                <button style={primaryBtn}>+ Create Sprint</button>
            </div>

            {/* Sprint Grid */}
            <div style={gridStyle}>
                {sprints.map((sprint) => (
                    <div
                        key={sprint.id}
                        onClick={() =>
                            navigate(`/projects/${projectId}/sprints/${sprint.id}`)
                        }
                        style={cardStyle}
                    >
                        <h3>{sprint.name}</h3>
                        <p>{sprint.goal}</p>
                    </div>
                ))}
            </div>
        </div>
    );
}

/* Reuse styles */
const headerStyle = {
    display: "flex",
    justifyContent: "space-between",
    marginBottom: "20px"
};

const gridStyle = {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fill, minmax(250px, 1fr))",
    gap: "20px"
};

const cardStyle = {
    background: "#fff",
    padding: "20px",
    borderRadius: "14px",
    boxShadow: "0 4px 12px rgba(0,0,0,0.05)",
    cursor: "pointer"
};

const primaryBtn = {
    background: "#6366f1",
    color: "#fff",
    padding: "10px 15px",
    border: "none",
    borderRadius: "8px"
};

export default ProjectDetailPage;