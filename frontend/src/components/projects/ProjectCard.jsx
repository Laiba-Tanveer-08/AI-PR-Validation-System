import { useNavigate } from "react-router-dom";

function ProjectCard({ project, onEdit, onDelete }) {
    const navigate = useNavigate();

    return (
        <div style={card}>
            <div onClick={() => navigate(`/projects/${project.id}`)} style={{ cursor: "pointer" }}>
                <h3>{project.name}</h3>
                <p style={{ color: "#666" }}>
                    {project.description || "No description"}
                </p>
            </div>

            {/* Actions */}
            <div style={actions}>
                <button style={editBtn} onClick={() => onEdit(project)}>
                    Edit
                </button>

                <button style={deleteBtn} onClick={() => onDelete(project.id)}>
                    Delete
                </button>
            </div>
        </div>
    );
}

/* 🎨 Styles */

const card = {
    background: "#fff",
    padding: "20px",
    borderRadius: "14px",
    boxShadow: "0 4px 12px rgba(0,0,0,0.05)",
    display: "flex",
    flexDirection: "column",
    justifyContent: "space-between"
};

const actions = {
    marginTop: "15px",
    display: "flex",
    gap: "10px"
};

const editBtn = {
    flex: 1,
    padding: "8px",
    background: "#3b82f6",
    color: "#fff",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer"
};

const deleteBtn = {
    flex: 1,
    padding: "8px",
    background: "#ef4444",
    color: "#fff",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer"
};

export default ProjectCard;