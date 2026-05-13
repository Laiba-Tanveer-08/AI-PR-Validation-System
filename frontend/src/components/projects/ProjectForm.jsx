import { useState, useEffect } from "react";
import API from "../../services/api";

function ProjectForm({ isOpen, onClose, onSuccess, editData }) {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");

    useEffect(() => {
        if (editData) {
            setName(editData.name);
            setDescription(editData.description);
        }
    }, [editData]);

    const handleSubmit = async () => {
        if (!name) {
            alert("Project name required");
            return;
        }

        try {
            if (editData) {
                // UPDATE
                await API.put(`/projects/${editData.id}`, {
                    name,
                    description
                });
            } else {
                // CREATE
                await API.post("/projects", {
                    name,
                    description
                });
            }

            onSuccess();   // refresh list
            onClose();     // close modal
        } catch (err) {
            console.error(err);
            alert("Error saving project");
        }
    };

    if (!isOpen) return null;

    return (
        <div style={overlay}>
            <div style={modal}>
                <h2>{editData ? "Edit Project" : "Create Project"}</h2>

                <input
                    placeholder="Project Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    style={input}
                />

                <textarea
                    placeholder="Description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
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
    width: "400px",
    boxShadow: "0 10px 30px rgba(0,0,0,0.1)"
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
    padding: "8px 12px",
    background: "#e5e7eb",
    border: "none",
    borderRadius: "6px"
};

const saveBtn = {
    padding: "8px 12px",
    background: "#6366f1",
    color: "#fff",
    border: "none",
    borderRadius: "6px"
};

export default ProjectForm;