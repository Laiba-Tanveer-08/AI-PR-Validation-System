function Spinner() {
    return (
        <div style={container}>
            <div style={spinner}></div>
        </div>
    );
}

const container = {
    display: "flex",
    justifyContent: "center",
    padding: "20px"
};

const spinner = {
    width: "40px",
    height: "40px",
    border: "4px solid #eee",
    borderTop: "4px solid #6366f1",
    borderRadius: "50%",
    animation: "spin 1s linear infinite"
};

export default Spinner;