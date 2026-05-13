function Modal({ isOpen, onClose, children, title }) {
    if (!isOpen) return null;

    return (
        <div style={overlay}>
            <div style={modal}>
                <div style={header}>
                    <h3>{title}</h3>
                    <button onClick={onClose} style={closeBtn}>✕</button>
                </div>

                <div>{children}</div>
            </div>
        </div>
    );
}

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
    width: "400px",
    boxShadow: "0 10px 30px rgba(0,0,0,0.1)"
};

const header = {
    display: "flex",
    justifyContent: "space-between",
    marginBottom: "10px"
};

const closeBtn = {
    background: "transparent",
    border: "none",
    fontSize: "18px",
    cursor: "pointer"
};

export default Modal;