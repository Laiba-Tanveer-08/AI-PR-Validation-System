import { useEffect, useState } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";

function ProjectsPage() {
    const [projects, setProjects] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetchProjects();
    }, []);

    const fetchProjects = async () => {
        try {
            const res = await API.get("/projects");
            setProjects(res.data);
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <div>
            {/* Header */}
            <div style={headerStyle}>
                <h2>Projects</h2>
                <button style={primaryBtn}>+ New Project</button>
            </div>

            {/* Grid */}
            <div style={gridStyle}>
                {projects.map((project) => (
                    <div
                        key={project.id}
                        onClick={() => navigate(`/projects/${project.id}`)}
                        style={cardStyle}
                    >
                        <h3>{project.name}</h3>
                        <p style={{ color: "#666" }}>
                            {project.description || "No description"}
                        </p>

                        <div style={{ marginTop: "15px" }}>
                            <span style={badge}>Active</span>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

/* Styles */
const headerStyle = {
    display: "flex",
    justifyContent: "space-between",
    marginBottom: "20px"
};

const gridStyle = {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fill, minmax(260px, 1fr))",
    gap: "20px"
};

const cardStyle = {
    background: "#fff",
    padding: "20px",
    borderRadius: "14px",
    boxShadow: "0 4px 12px rgba(0,0,0,0.05)",
    cursor: "pointer",
    transition: "0.2s"
};

const primaryBtn = {
    background: "#6366f1",
    color: "#fff",
    padding: "10px 15px",
    border: "none",
    borderRadius: "8px"
};

const badge = {
    background: "#e0e7ff",
    color: "#4338ca",
    padding: "4px 10px",
    borderRadius: "20px",
    fontSize: "12px"
};

export default ProjectsPage;