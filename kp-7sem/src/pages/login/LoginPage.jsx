import "./log.css";
import loginPic from "./login.svg";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";

function LoginPage() {
  return (
    <div className="loginPageContainer">
      <img src={loginPic} alt="login pic" style={{ width: "400px"}} />
      <div className="loginPageData">
        <h2>Авторизация</h2>
        <TextField
          id="filled-basic"
          label="Почта"
          variant="filled"
          style={{ backgroundColor: "white", borderRadius: '4px' }}
          InputProps={{ sx: { height: 52 } }}
        />
        <TextField
          id="filled-basic"
          label="Пароль"
          variant="filled"
          style={{ backgroundColor: "white", borderRadius: '4px' }}
          InputProps={{ sx: { height: 52 } }}
        />
        <Button
          variant="contained"
          style={{ backgroundColor: "white", color: "black" }}
        >
          Войти
        </Button>
        <span>Ещё не зарегистрированы?</span>
        <Link to={'/register'} style={{textDecoration: 'none'}}>Зарегистрироваться</Link>
      </div>
    </div>
  );
}

export default LoginPage;
