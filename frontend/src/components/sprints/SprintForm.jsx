import { useState, useEffect } from "react";
import API from "../../services/api";
import { useParams } from "react-router-dom";

function SprintForm({ isOpen, onClose, onSuccess, editData }) {
    const { projectId } = useParams();

    const [name, setName] = useState("");
    const [goal, setGoal] = useState("");

    useEffect(() => {
        if (editData) {
            setName(editData.name);
            setGoal(editData.goal);
        }
    }, [editData]);

    const handleSubmit = async () => {
        if (!name) {
            alert("Sprint name required");
            return;
        }

        try {
            if (editData) {
                // UPDATE
                await API.put(`/sprints/${editData.id}`, {
                    name,
                    goal
                });
            } else {
                // CREATE
                await API.post(`/sprints/project/${projectId}`, {
                    name,
                    goal
                });
            }

            onSuccess();
            onClose();
        } catch (err) {
            console.error(err);
            alert("Error saving sprint");
        }
    };

    if (!isOpen) return null;

    return (
        <div style={overlay}>
            <div style={modal}>
                <h2>{editData ? "Edit Sprint" : "Create Sprint"}</h2>

                <input
                    placeholder="Sprint Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    style={input}
                />

                <textarea
                    placeholder="Goal"
                    value={goal}
                    onChange={(e) => setGoal(e.target.value)}
                    style={input}
                />

                <div style={actions}>
                    <button style={cancelBtn} onClick={onClose}>
                        Cancel
                    </button>

                    <button style={saveBtn} onClick={handleSubmit}>
                        {editData ? "Update" : "Create"}
                    </button>
                </div>
            </div>
        </div>
    );
}

/* 🎨 Styles */

const overlay = {
    position: "fixed",
    top: 0,
    left: 0,
    width: "100%",
    height: "100%",
    background: "rgba(0,0,0,0.4)",
    display: "flex",
    justifyContent: "center",
    alignItems: "center"
};

const modal = {
    background: "#fff",
    padding: "25px",
    borderRadius: "12px",
    width: "400px"
};

const input = {
    width: "100%",
    padding: "10px",
    marginBottom: "10px",
    borderRadius: "6px",
    border: "1px solid #ddd"
};

const actions = {
    display: "flex",
    justifyContent: "flex-end",
    gap: "10px"
};

const cancelBtn = {
    padding: "8px",
    background: "#e5e7eb",
    border: "none",
    borderRadius: "6px"
};

const saveBtn = {
    padding: "8px",
    background: "#6366f1",
    color: "#fff",
    border: "none",
    borderRadius: "6px"
};

export default SprintForm;