function StatCard({ title, value, color }) {
    return (
        <div style={card}>
            <h4 style={{ color: "#666" }}>{title}</h4>
            <h1 style={{ color: color || "#111" }}>{value}</h1>
        </div>
    );
}

const card = {
    background: "#fff",
    padding: "20px",
    borderRadius: "14px",
    boxShadow: "0 4px 10px rgba(0,0,0,0.05)"
};

export default StatCard;