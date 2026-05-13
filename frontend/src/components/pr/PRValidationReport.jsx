function PRValidationReport({ report }) {
    return (
        <div style={container}>
            <h2>AI Validation Report</h2>

            <p style={{ marginTop: "10px" }}>
                {report.summary || "No summary available"}
            </p>

            <div style={{ marginTop: "20px" }}>
                <h4>Issues:</h4>

                {report.issues?.map((issue, i) => (
                    <div key={i} style={issueBox}>
                        {issue}
                    </div>
                ))}
            </div>
        </div>
    );
}

const container = {
    background: "#fff",
    padding: "20px",
    borderRadius: "12px",
    marginTop: "20px"
};

const issueBox = {
    background: "#fee2e2",
    padding: "10px",
    borderRadius: "6px",
    marginBottom: "10px"
};

export default PRValidationReport;