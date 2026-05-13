
import { useState } from "react";
import API from "../services/api";

function LoginPage() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);

    const handleLogin = async () => {
        if (!email || !password) {
            alert("Please fill all fields");
            return;
        }

        try {
            setLoading(true);

            const res = await API.post("/auth/login", { email, password });

            localStorage.setItem("token", res.data.token);

            window.location.href = "/dashboard";
        } catch (err) {
            console.error(err);
            alert(err.response?.data?.message || "Login failed");
        } finally {
            setLoading(false);
        }
    };

    return (
        <div style={container}>
            <div style={card}>
                <h2 style={{ marginBottom: "10px" }}>Welcome Back 👋</h2>
                <p style={{ color: "#666", marginBottom: "20px" }}>
                    Login to AI PR Validation System
                </p>

                <input
                    type="email"
                    placeholder="Enter email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    style={input}
                />

                <input
                    type="password"
                    placeholder="Enter password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    style={input}
                />

                <button onClick={handleLogin} style={button} disabled={loading}>
                    {loading ? "Logging in..." : "Login"}
                </button>
            </div>
        </div>
    );
}

/* 🎨 Styles */

const container = {
    height: "100vh",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    background: "linear-gradient(135deg, #6366f1, #8b5cf6)"
};

const card = {
    background: "#fff",
    padding: "40px",
    borderRadius: "16px",
    width: "350px",
    boxShadow: "0 10px 30px rgba(0,0,0,0.1)",
    textAlign: "center"
};

const input = {
    width: "100%",
    padding: "12px",
    marginBottom: "15px",
    borderRadius: "8px",
    border: "1px solid #ddd",
    outline: "none",
    fontSize: "14px"
};

const button = {
    width: "100%",
    padding: "12px",
    background: "#6366f1",
    color: "#fff",
    border: "none",
    borderRadius: "8px",
    fontSize: "16px",
    cursor: "pointer"
};

export default LoginPage;