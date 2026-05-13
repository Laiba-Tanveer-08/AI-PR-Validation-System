function ConfirmDialog({ isOpen, onClose, onConfirm, message }) {
    if (!isOpen) return null;

    return (
        <div style={overlay}>
            <div style={modal}>
                <h3>Confirm Action</h3>
                <p>{message || "Are you sure?"}</p>

                <div style={actions}>
                    <button style={cancelBtn} onClick={onClose}>
                        Cancel
                    </button>

                    <button style={deleteBtn} onClick={onConfirm}>
                        Confirm
                    </button>
                </div>
            </div>
        </div>
    );
}

/* styles */

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
    padding: "20px",
    borderRadius: "12px",
    width: "300px"
};

const actions = {
    marginTop: "15px",
    display: "flex",
    justifyContent: "flex-end",
    gap: "10px"
};

const cancelBtn = {
    background: "#e5e7eb",
    padding: "6px 10px",
    border: "none",
    borderRadius: "6px"
};

const deleteBtn = {
    background: "#ef4444",
    color: "#fff",
    padding: "6px 10px",
    border: "none",
    borderRadius: "6px"
};

export default ConfirmDialog;