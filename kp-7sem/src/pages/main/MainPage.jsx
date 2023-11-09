import { Outlet } from "react-router-dom";

function MainPage() {
    return (
        <div>
            <h1>Заглушка</h1>
            <Outlet />
        </div>
    );
}

export default MainPage;