import { useEffect, useState } from "react";
import API from "../../services/api";

function RecentPRList() {
    const [prs, setPrs] = useState([]);

    useEffect(() => {
        fetchPRs();
    }, []);

    const fetchPRs = async () => {
        try {
            const res = await API.get("/prs");
            setPrs(res.data.slice(0, 5)); // latest 5
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <div style={card}>
            <h3 style={{ marginBottom: "15px" }}>Recent PR Activity</h3>

            {prs.map((pr) => (
                <div key={pr.id} style={item}>
                    <div>
                        <strong>{pr.title}</strong>
                        <p style={{ color: "#666", fontSize: "13px" }}>
                            Score: {pr.score}
                        </p>
                    </div>

                    <span style={badge(pr.score)}>
            {pr.score > 70 ? "Passed" : "Failed"}
          </span>
                </div>
            ))}
        </div>
    );
}

const card = {
    background: "#fff",
    padding: "20px",
    borderRadius: "14px",
    boxShadow: "0 4px 10px rgba(0,0,0,0.05)"
};

const item = {
    display: "flex",
    justifyContent: "space-between",
    padding: "10px 0",
    borderBottom: "1px solid #eee"
};

const badge = (score) => ({
    background: score > 70 ? "#d1fae5" : "#fee2e2",
    padding: "5px 10px",
    borderRadius: "20px",
    fontSize: "12px"
});

export default RecentPRList;