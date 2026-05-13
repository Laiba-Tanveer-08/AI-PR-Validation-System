import { useNavigate } from "react-router-dom";

function PRCard({ pr }) {
    const navigate = useNavigate();

    return (
        <div style={card} onClick={() => navigate(`/prs/${pr.id}`)}>
            <h3>{pr.title}</h3>

            <p style={{ color: "#666" }}>
                {pr.description || "No description"}
            </p>

            <div style={footer}>
        <span style={badge(pr.score)}>
          Score: {pr.score}
        </span>

                <span style={{ fontSize: "12px", color: "#999" }}>
          #{pr.id}
        </span>
            </div>
        </div>
    );
}

/* 🎨 Styles */

const card = {
    background: "#fff",
    padding: "20px",
    borderRadius: "12px",
    boxShadow: "0 4px 10px rgba(0,0,0,0.05)",
    cursor: "pointer",
    marginBottom: "15px"
};

const footer = {
    display: "flex",
    justifyContent: "space-between",
    marginTop: "10px"
};

const badge = (score) => ({
    background:
        score > 70 ? "#d1fae5" : score > 40 ? "#fef9c3" : "#fee2e2",
    padding: "5px 10px",
    borderRadius: "20px"
});

export default PRCard;