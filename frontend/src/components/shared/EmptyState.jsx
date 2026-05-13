function EmptyState({ message = "No data found" }) {
    return (
        <div style={container}>
            <h3>{message}</h3>
            <p style={{ color: "#666" }}>Try adding new data</p>
        </div>
    );
}

const container = {
    textAlign: "center",
    padding: "40px",
    background: "#fff",
    borderRadius: "12px"
};

export default EmptyState;