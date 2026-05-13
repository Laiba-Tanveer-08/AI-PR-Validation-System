import { useState } from "react";
import API from "../services/api";

function useAuth() {
    const [loading, setLoading] = useState(false);

    const login = async (email, password) => {
        try {
            setLoading(true);
            const res = await API.post("/auth/login", { email, password });

            localStorage.setItem("token", res.data.token);
            return true;
        } catch (err) {
            console.error(err);
            return false;
        } finally {
            setLoading(false);
        }
    };

    const logout = () => {
        localStorage.removeItem("token");
        window.location.href = "/login";
    };

    return { login, logout, loading };
}

export default useAuth;