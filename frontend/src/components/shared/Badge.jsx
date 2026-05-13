function Badge({ text, type = "default" }) {
    const colors = {
        success: "#d1fae5",
        error: "#fee2e2",
        warning: "#fef9c3",
        default: "#e5e7eb"
    };

    return (
        <span
            style={{
                background: colors[type],
                padding: "5px 10px",
                borderRadius: "20px",
                fontSize: "12px",
                fontWeight: "500"
            }}
        >
      {text}
    </span>
    );
}

export default Badge;