
import { NavLink } from "react-router-dom";

function Sidebar() {
    return (
        <div style={{ width: "220px", background: "#f4f4f4", height: "100vh" }}>
            <h3 style={{ padding: "20px" }}>AI PR System</h3>

            <nav style={{ display: "flex", flexDirection: "column", gap: "10px", padding: "10px" }}>
                <NavLink to="/dashboard">Dashboard</NavLink>
                <NavLink to="/projects">Projects</NavLink>
                <NavLink to="/prs">PRs</NavLink>
            </nav>
        </div>
    );
}

export default Sidebar;