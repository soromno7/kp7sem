import { useEffect } from "react";
import LoginPage from "./pages/login/LoginPage";
import MainPage from "./pages/main/MainPage";
import RegisterPage from "./pages/register/RegisterPage";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import PrivateRoute from "./components/PrivateRoute";
import UnknownPage from "./pages/unknown/UnknownPage";
import ProfilePage from "./pages/profile/ProfilePage";
import UsersPage from "./pages/users/UsersPage";
import StationsPage from "./pages/stations/StationsPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Navigate to="login" replace />} />
        <Route path="login" element={<LoginPage />} />
        <Route path="register" element={<RegisterPage />} />
        <Route
          path="main"
          element={
            <PrivateRoute>
              <MainPage />
            </PrivateRoute>
          }
        >
          <Route path="users" element={<UsersPage />} />
          <Route path="stations" element={<StationsPage />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="profile" element={<ProfilePage />} />
        </Route>
        <Route path="*" element={<UnknownPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
