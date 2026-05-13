import { useNavigate, useParams } from "react-router-dom";

function RequirementTable({ requirements, onEdit, onDelete }) {
    const navigate = useNavigate();
    const { projectId, sprintId } = useParams();

    return (
        <div style={container}>
            <table style={table}>
                <thead>
                <tr style={thead}>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>PRs</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <tbody>
                {requirements.map((req) => (
                    <tr key={req.id} style={row}>
                        <td>{req.title}</td>
                        <td>{req.description}</td>

                        <td>
                <span style={badge(req.status)}>
                  {req.status || "Pending"}
                </span>
                        </td>

                        <td>
                            <button
                                style={linkBtn}
                                onClick={() =>
                                    navigate(
                                        `/projects/${projectId}/sprints/${sprintId}/requirements/${req.id}/prs`
                                    )
                                }
                            >
                                View PRs
                            </button>
                        </td>

                        <td>
                            <button style={editBtn} onClick={() => onEdit(req)}>
                                Edit
                            </button>

                            <button
                                style={deleteBtn}
                                onClick={() => onDelete(req.id)}
                            >
                                Delete
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

/* 🎨 Styles */

const container = {
    background: "#fff",
    padding: "20px",
    borderRadius: "12px",
    boxShadow: "0 4px 10px rgba(0,0,0,0.05)"
};

const table = {
    width: "100%",
    borderCollapse: "collapse"
};

const thead = {
    textAlign: "left",
    borderBottom: "1px solid #eee"
};

const row = {
    borderBottom: "1px solid #f1f1f1"
};

const badge = (status) => ({
    padding: "4px 10px",
    borderRadius: "20px",
    background:
        status === "Done"
            ? "#d1fae5"
            : status === "Failed"
                ? "#fee2e2"
                : "#e0e7ff"
});

const linkBtn = {
    background: "#6366f1",
    color: "#fff",
    padding: "5px 10px",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer"
};

const editBtn = {
    marginRight: "5px",
    background: "#3b82f6",
    color: "#fff",
    padding: "5px 10px",
    border: "none",
    borderRadius: "6px"
};

const deleteBtn = {
    background: "#ef4444",
    color: "#fff",
    padding: "5px 10px",
    border: "none",
    borderRadius: "6px"
};

export default RequirementTable;