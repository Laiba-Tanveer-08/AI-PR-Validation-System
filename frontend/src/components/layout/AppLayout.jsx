
import Sidebar from "./Sidebar";
import Topbar from "./Topbar";
import { Outlet } from "react-router-dom";

function AppLayout() {
    return (
        <div style={{ display: "flex" }}>
            <Sidebar />

            <div style={{ flex: 1 }}>
                <Topbar />

                <div style={{ padding: "20px" }}>
                    <Outlet />
                </div>
            </div>
        </div>
    );
}

export default AppLayout;