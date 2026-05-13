import Sidebar from "./Sidebar";
import Topbar from "./Topbar";
import { Outlet } from "react-router-dom";

function AppLayout() {
    return (
        <div style={layout}>
            <Sidebar />

            <div style={main}>
                <Topbar />

                <div style={content}>
                    <Outlet />
                </div>
            </div>
        </div>
    );
}

const layout = {
    display: "flex",
    background: "#f9fafb"
};

const main = {
    flex: 1,
    display: "flex",
    flexDirection: "column"
};

const content = {
    padding: "20px"
};

export default AppLayout;