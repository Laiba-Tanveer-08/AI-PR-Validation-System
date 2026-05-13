function Topbar() {
    return (
        <div style={topbar}>
            <h3 style={{ margin: 0 }}>AI PR Validation</h3>

            <div>
                <button
                    onClick={() => {
                        localStorage.removeItem("token");
                        window.location.href = "/";
                    }}
                    style={logoutBtn}
                >
                    Logout
                </button>
            </div>
        </div>
    );
}

const topbar = {
    height: "60px",
    background: "#fff",
    borderBottom: "1px solid #eee",
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    padding: "0 20px"
};

const logoutBtn = {
    padding: "8px 12px",
    background: "#ef4444",
    color: "#fff",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer"
};

export default Topbar;