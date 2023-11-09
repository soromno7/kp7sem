import { useEffect } from "react";
import LoginPage from "./pages/login/LoginPage";
import MainPage from "./pages/main/MainPage";
import RegisterPage from "./pages/register/RegisterPage";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import PrivateRoute from "./components/PrivateRoute/PrivateRoute";
import UnknownPage from "./pages/unknown/UnknownPage";

function App() {
  let isAuth = !!sessionStorage.user;

  useEffect(() => {
      console.log(isAuth)
  }, [sessionStorage.user])
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
        ></Route>
        <Route path="*" element={<UnknownPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
