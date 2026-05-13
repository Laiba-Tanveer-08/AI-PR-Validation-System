import { useEffect, useState } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";

function PRListPage() {
    const [prs, setPrs] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetchPRs();
    }, []);

    const fetchPRs = async () => {
        const res = await API.get("/prs");
        setPrs(res.data);
    };

    return (
        <div>
            <h2>Pull Requests</h2>

            <div style={grid}>
                {prs.map((pr) => (
                    <div
                        key={pr.id}
                        style={card}
                        onClick={() => navigate(`/prs/${pr.id}`)}
                    >
                        <h3>{pr.title}</h3>
                        <p>Score: {pr.score}</p>
                        <span style={badge(pr.score)}>
              {pr.score > 70 ? "Passed" : "Failed"}
            </span>
                    </div>
                ))}
            </div>
        </div>
    );
}

const grid = {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fill, minmax(250px,1fr))",
    gap: "20px"
};

const card = {
    background: "#fff",
    padding: "20px",
    borderRadius: "12px",
    boxShadow: "0 4px 10px rgba(0,0,0,0.05)",
    cursor: "pointer"
};

const badge = (score) => ({
    background: score > 70 ? "#d1fae5" : "#fee2e2",
    padding: "5px 10px",
    borderRadius: "20px"
});

export default PRListPage;