import { useState, useEffect } from "react";
import API from "../../services/api";
import { useParams } from "react-router-dom";

function RequirementForm({ isOpen, onClose, onSuccess, editData }) {
    const { sprintId } = useParams();

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    useEffect(() => {
        if (editData) {
            setTitle(editData.title);
            setDescription(editData.description);
        }
    }, [editData]);

    const handleSubmit = async () => {
        if (!title) {
            alert("Title required");
            return;
        }

        try {
            if (editData) {
                // UPDATE
                await API.put(`/requirements/${editData.id}`, {
                    title,
                    description
                });
            } else {
                // CREATE
                await API.post(`/requirements/sprint/${sprintId}`, {
                    title,
                    description
                });
            }

            onSuccess();
            onClose();
        } catch (err) {
            console.error(err);
            alert("Error saving requirement");
        }
    };

    if (!isOpen) return null;

    return (
        <div style={overlay}>
            <div style={modal}>
                <h2>{editData ? "Edit Requirement" : "Add Requirement"}</h2>

                <input
                    placeholder="Title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
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

export default RequirementForm;