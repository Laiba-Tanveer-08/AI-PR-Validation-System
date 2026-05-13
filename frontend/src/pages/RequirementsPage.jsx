function RequirementsPage() {
    return (
        <div>
            <h2>Manage Requirements</h2>

            <button style={btn}>+ Create Requirement</button>

            <table style={table}>
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>Login Feature</td>
                    <td>User can login</td>
                    <td>
                        <button>Edit</button>
                        <button style={{ color: "red" }}>Delete</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
}

const btn = {
    marginBottom: "15px",
    padding: "8px",
    background: "#6366f1",
    color: "#fff",
    border: "none",
    borderRadius: "6px"
};

const table = {
    width: "100%",
    borderCollapse: "collapse"
};

export default RequirementsPage;