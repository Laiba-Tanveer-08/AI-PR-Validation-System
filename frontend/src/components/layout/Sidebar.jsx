
import { NavLink } from "react-router-dom";

function Sidebar() {
    return (
        <div style={sidebar}>
            <h2 style={logo}>AI PR</h2>

            <nav>
                <NavLink to="/dashboard" style={link}>
                    Dashboard
                </NavLink>

                <NavLink to="/projects" style={link}>
                    Projects
                </NavLink>

                <NavLink to="/prs" style={link}>
                    Pull Requests
                </NavLink>
            </nav>
        </div>
    );
}

const sidebar = {
    width: "240px",
    height: "100vh",
    background: "#111827",
    color: "#fff",
    padding: "20px",
    display: "flex",
    flexDirection: "column"
};

const logo = {
    marginBottom: "30px",
    fontWeight: "bold",
    fontSize: "20px"
};

const link = ({ isActive }) => ({
    display: "block",
    padding: "12px 15px",
    marginBottom: "10px",
    borderRadius: "8px",
    textDecoration: "none",
    color: isActive ? "#111827" : "#fff",
    background: isActive ? "#6366f1" : "transparent",
    transition: "0.2s"
});

export default Sidebar;