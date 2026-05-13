function ScoreMeter({ score }) {
    return (
        <div style={container}>
            <div style={circle}>
                <span style={text}>{score}</span>
            </div>
            <p>AI Score</p>
        </div>
    );
}

const container = {
    textAlign: "center"
};

const circle = {
    width: "100px",
    height: "100px",
    borderRadius: "50%",
    background: "#6366f1",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    color: "#fff",
    fontSize: "24px",
    margin: "auto"
};

const text = {
    fontWeight: "bold"
};

export default ScoreMeter;