import StatCard from "../components/dashboard/StatCard";
import RecentPRList from "../components/dashboard/RecentPRList";
import ValidationChart from "../components/dashboard/ValidationChart";

function DashboardPage() {
    return (
        <div>
            <h1 style={{ marginBottom: "20px" }}>Dashboard</h1>

            {/* Stats */}
            <div style={grid}>
                <StatCard title="Total PRs" value="48" />
                <StatCard title="Passed" value="35" color="green" />
                <StatCard title="Failed" value="13" color="red" />
                <StatCard title="Projects" value="12" />
            </div>

            {/* Charts + Activity */}
            <div style={grid2}>
                <ValidationChart passed={35} failed={13} />
                <RecentPRList />
            </div>
        </div>
    );
}

const grid = {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fit, minmax(200px, 1fr))",
    gap: "20px",
    marginBottom: "20px"
};

const grid2 = {
    display: "grid",
    gridTemplateColumns: "2fr 1fr",
    gap: "20px"
};

export default DashboardPage;