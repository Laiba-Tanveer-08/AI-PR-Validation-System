function ValidationChart({ passed = 0, failed = 0 }) {
    const total = passed + failed || 1;

    const passedPercent = (passed / total) * 100;
    const failedPercent = (failed / total) * 100;

    return (
        <div style={card}>
            <h3 style={{ marginBottom: "20px" }}>Validation Overview</h3>

            <div style={{ display: "flex", height: "20px", borderRadius: "10px", overflow: "hidden" }}>
                <div
                    style={{
                        width: `${passedPercent}%`,
                        background: "#22c55e"
                    }}
                />
                <div
                    style={{
                        width: `${failedPercent}%`,
                        background: "#ef4444"
                    }}
                />
            </div>

            <div style={{ marginTop: "10px", display: "flex", justifyContent: "space-between" }}>
                <span>Passed: {passed}</span>
                <span>Failed: {failed}</span>
            </div>
        </div>
    );
}

const card = {
    background: "#fff",
    padding: "20px",
    borderRadius: "14px",
    boxShadow: "0 4px 10px rgba(0,0,0,0.05)"
};

export default ValidationChart;