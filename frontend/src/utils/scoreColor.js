import getScoreColor from "../utils/scoreColor";

function getScoreColor(score) {
    if (score >= 80) return "#22c55e";   // green
    if (score >= 50) return "#f59e0b";   // yellow
    return "#ef4444";                    // red
}

export default getScoreColor;