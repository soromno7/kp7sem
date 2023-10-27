import "./style.css"
import loginPic from "./login.svg";
import TextField from "@mui/material/TextField"
import Button from "@mui/material/Button"


function LoginPage() {
    return (
        <div className="loginPageContainer">
            <img src={loginPic} alt="login pic" style={{width: '400px'}}/>
            <div className="loginPageData">
                <h2>Авторизация</h2>
                <TextField id="filled-basic" label="Почта" variant="filled" style={{backgroundColor: 'white'}}/>
                <TextField id="filled-basic" label="Пароль" variant="filled" style={{backgroundColor: 'white'}}/>
                <Button variant="contained" style={{backgroundColor: 'white', color: 'black'}}>Войти</Button>
                <span>Ещё не зарегистрированы?</span>
                <span>Зарегистрироваться</span>
            </div>
        </div>
    );
}

export default LoginPage;