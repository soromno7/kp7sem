import "./reg.css";
import registerPic from "./register.svg";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function RegisterPage() {
  const [date, setDate] = useState({});
  useEffect(() => {
    console.log(date);
  });
  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <div className="loginPageContainer">
        <div className="loginPageData">
          <h2>Регистрация</h2>
          <div className="firstAndLastNameReg">
            <TextField
              id="filled-basic"
              label="Имя"
              variant="filled"
              style={{ backgroundColor: "white", borderRadius: "4px" }}
              sx={{
                width: 165,
              }}
              InputProps={{ sx: { height: 52 } }}
            />
            <TextField
              id="filled-basic"
              label="Фамилия"
              variant="filled"
              style={{ backgroundColor: "white", borderRadius: "4px" }}
              sx={{
                width: 165,
              }}
              InputProps={{ sx: { height: 52 } }}
            />
          </div>
          <div style={{ background: "white", borderRadius: "4px" }}>
            <DatePicker
              label="Дата рождения"
              onChange={(val) => {
                setDate(
                  val.$d
                    .toLocaleDateString("en-GB")
                    .replace("/", ".")
                    .replace("/", ".")
                );
              }}
              format="DD.MM.YYYY"
            />
          </div>
          <TextField
            id="filled-basic"
            label="Номер телефона"
            variant="filled"
            style={{ backgroundColor: "white", borderRadius: "4px" }}
            sx={{
              width: 350,
            }}
            InputProps={{ sx: { height: 52 } }}
          />
          <TextField
            id="filled-basic"
            label="Почта"
            variant="filled"
            style={{ backgroundColor: "white", borderRadius: "4px" }}
            sx={{
              width: 350,
            }}
            InputProps={{ sx: { height: 52 } }}
          />
          <TextField
            id="filled-basic"
            label="Пароль"
            variant="filled"
            style={{ backgroundColor: "white", borderRadius: "4px" }}
            sx={{
              width: 350,
            }}
            InputProps={{ sx: { height: 52 } }}
          />
          <TextField
            id="filled-basic"
            label="Подтвердите пароль"
            variant="filled"
            style={{ backgroundColor: "white", borderRadius: "4px" }}
            sx={{
              width: 350,
            }}
            InputProps={{ sx: { height: 52 } }}
          />
          <Button
            variant="contained"
            style={{ backgroundColor: "white", color: "black" }}
          >
            Войти
          </Button>
          <span>Уже есть аккаунт?</span>
          <Link to={'/login'} style={{textDecoration: 'none'}}>Войти</Link>
        </div>
        <img src={registerPic} alt="login pic" style={{ width: "400px" }} />
      </div>
    </LocalizationProvider>
  );
}

export default RegisterPage;
