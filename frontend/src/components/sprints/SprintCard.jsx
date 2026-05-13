import { useNavigate, useParams } from "react-router-dom";

function SprintCard({ sprint, onEdit, onDelete }) {
    const navigate = useNavigate();
    const { projectId } = useParams();

    return (
        <div style={card}>
            {/* Clickable Area */}
            <div
                onClick={() =>
                    navigate(`/projects/${projectId}/sprints/${sprint.id}`)
                }
                style={{ cursor: "pointer" }}
            >
                <h3>{sprint.name}</h3>
                <p style={{ color: "#666" }}>{sprint.goal}</p>

                {/* Progress (dummy for now) */}
                <div style={progressBar}>
                    <div style={{ ...progressFill, width: "60%" }} />
                </div>
            </div>

            {/* Actions */}
            <div style={actions}>
                <button style={editBtn} onClick={() => onEdit(sprint)}>
                    Edit
                </button>

                <button style={deleteBtn} onClick={() => onDelete(sprint.id)}>
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
    boxShadow: "0 4px 12px rgba(0,0,0,0.05)"
};

const progressBar = {
    height: "8px",
    background: "#eee",
    borderRadius: "10px",
    marginTop: "10px"
};

const progressFill = {
    height: "100%",
    background: "#6366f1",
    borderRadius: "10px"
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
    borderRadius: "6px"
};

const deleteBtn = {
    flex: 1,
    padding: "8px",
    background: "#ef4444",
    color: "#fff",
    border: "none",
    borderRadius: "6px"
};

export default SprintCard;