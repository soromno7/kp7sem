import LoginPage from "./pages/login/LoginPage";
import RegisterPage from "./pages/register/RegisterPage";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import PrivateRoute from "./components/PrivateRoute";
import UnknownPage from "./pages/unknown/UnknownPage";
import ProfilePage from "./pages/profile/ProfilePage";
import UsersPage from "./pages/users/UsersPage";
import StationsPage from "./pages/stations/StationsPage";
import DealersPage from "./pages/dealers/DealersPage";
import CarsPage from "./pages/cars/CarsPage";
import ContractsPage from "./pages/contracts/ContractsPage";
import RentPage from "./pages/rent/RentPage";
import WrapperPage from "./pages/wrapper/WrapperPage";
import MainPage from "./pages/main/MainPage";

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
              <WrapperPage />
            </PrivateRoute>
          }
        >
          <Route index element={<MainPage />} />
          <Route path="users" element={<UsersPage />} />
          <Route path="stations" element={<StationsPage />} />
          <Route path="dealers" element={<DealersPage />} />
          <Route path="cars" element={<CarsPage />} />
          <Route path="contracts" element={<ContractsPage />} />
          <Route path="rent" element={<RentPage />} />
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
