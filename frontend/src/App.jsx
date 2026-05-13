import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import LoginPage from "./pages/LoginPage";
import DashboardPage from "./pages/DashboardPage";
import ProjectsPage from "./pages/ProjectsPage";
import ProjectDetailPage from "./pages/ProjectDetailPage";
import SprintPage from "./pages/SprintPage";
import RequirementsPage from "./pages/RequirementsPage";
import PRListPage from "./pages/PRListPage";
import PRDetailPage from "./pages/PRDetailPage";

import AppLayout from "./components/layout/AppLayout";

function App() {
   // const isAuth = localStorage.getItem("token");
    const isAuth = true;
    return (
        <BrowserRouter>
            <Routes>
                {/* PUBLIC */}
                <Route path="/login" element={<LoginPage />} />

                {/* PROTECTED */}
                {isAuth ? (
                    <Route path="/" element={<AppLayout />}>
                        <Route path="dashboard" element={<DashboardPage />} />
                        <Route path="projects" element={<ProjectsPage />} />
                        <Route path="projects/:projectId" element={<ProjectDetailPage />} />
                        <Route path="sprints/:projectId" element={<SprintPage />} />
                        <Route path="requirements/:sprintId" element={<RequirementsPage />} />
                        <Route path="prs/:requirementId" element={<PRListPage />} />
                        <Route path="prs/detail/:prId" element={<PRDetailPage />} />
                    </Route>
                ) : (
                    <Route path="*" element={<Navigate to="/login" />} />
                )}
            </Routes>
        </BrowserRouter>
    );
}

export default App;
