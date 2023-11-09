import { Navigate } from "react-router-dom";

function PrivateRoute({children}) {
    return (  
        <>
            {
                !!sessionStorage.user ? (children) : (<Navigate to="/login" />)
            }
        </>
    );
}

export default PrivateRoute;