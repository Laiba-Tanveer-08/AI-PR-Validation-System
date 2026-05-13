import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import API from "../services/api";

function PRDetailPage() {
    const { prId } = useParams();
    const [pr, setPr] = useState(null);

    useEffect(() => {
        fetchPR();
    }, []);

    const fetchPR = async () => {
        const res = await API.get(`/prs/${prId}`);
        setPr(res.data);
    };

    return (
        <div>
            <h2>{pr?.title}</h2>

            <div style={card}>
                <h3>AI Validation Score</h3>
                <h1>{pr?.score}</h1>
            </div>

            <div style={card}>
                <h3>Summary</h3>
                <p>{pr?.summary}</p>
            </div>

            <div style={card}>
                <h3>Inline Comments</h3>
                {pr?.comments?.map((c, i) => (
                    <div key={i} style={comment}>
                        <p>{c.message}</p>
                    </div>
                ))}
            </div>
        </div>
    );
}

const card = {
    background: "#fff",
    padding: "20px",
    marginTop: "20px",
    borderRadius: "12px",
    boxShadow: "0 4px 10px rgba(0,0,0,0.05)"
};

const comment = {
    borderBottom: "1px solid #eee",
    padding: "10px 0"
};

export default PRDetailPage;