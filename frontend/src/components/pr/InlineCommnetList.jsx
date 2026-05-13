function InlineCommentList({ comments }) {
    return (
        <div style={container}>
            <h3>Inline Comments</h3>

            {comments.map((c, index) => (
                <div key={index} style={commentBox}>
                    <p style={{ fontWeight: "bold" }}>
                        {c.file} (Line {c.line})
                    </p>

                    <p>{c.message}</p>
                </div>
            ))}
        </div>
    );
}

const container = {
    background: "#fff",
    padding: "20px",
    borderRadius: "12px",
    marginTop: "20px"
};

const commentBox = {
    padding: "10px",
    borderBottom: "1px solid #eee"
};

export default InlineCommentList;