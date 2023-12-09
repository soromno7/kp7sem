import axios from "axios";
import { useEffect, useState } from "react";
import { Modal, Box, Typography, Button, TextField } from "@mui/material";
import { LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import "./cars.css";
import CarItem from "./CarItem";
import { useNavigate } from "react-router-dom";

function CarsComponent({ selectedDealer }) {
  const [cars, setCars] = useState([]);

  const [open, setOpen] = useState(false);

  const handleOpen = (el) => {
    setSelectedCar(el);
    setOpen(true);
  };
  const handleClose = () => {
    setPrice('')
    setOpen(false)
  };

  const [selectedCar, setSelectedCar] = useState({});
  const [startDate, setStartDate] = useState({});
  const [endDate, setEndDate] = useState({});
  const [price, setPrice] = useState('');
  const [promocode, setPromocode] = useState('')

  const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 390,
    bgcolor: "background.paper",
    boxShadow: 24,
    p: 4,
  };

  const loadCars = async () => {
    await axios
      .get(`http://localhost:8080/car/get-by-dealer/${selectedDealer.id}`)
      .then((res) => setCars(res.data));
  };

  const calculateDays = (start, end) => {
    start = start.split(".");
    const date1 = new Date([start[1], ".", start[0], ".", start[2]].join(""));

    end = end.split(".");
    const date2 = new Date([end[1], ".", end[0], ".", end[2]].join(""));

    let Difference_In_Time = date2.getTime() - date1.getTime();

    let Difference_In_Days = Math.round(
      Difference_In_Time / (1000 * 3600 * 24)
    );

    return Difference_In_Days;
  };

  const navigate = useNavigate();

  const calculatePrice = async () => {
    const days = calculateDays(startDate, endDate);

    const data = {
      days,
      tariff: selectedCar.tariff,
      promocode
    }
    
    await axios.post('http://localhost:8080/order/get-price', data)
    .then((res) => setPrice(res.data))
  }

  const userData = sessionStorage.user;
  const id = Number(JSON.parse(userData).id);

  const createHandler = async () => {
    const order = {
      price,
      start_date: startDate,
      end_date: endDate,
      promocode
    }

    handleClose()

    await axios.post(`http://localhost:8080/order/create/${id}/${selectedDealer.id}/${selectedCar.id}`, order)
  };

  useEffect(() => {
    loadCars();
  }, []);

  return (
    <div
      style={{ display: "flex", alignItems: "center", flexDirection: "column" }}
    >
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="title"
        aria-describedby="descr"
      >
        <Box sx={style}>
          <Typography
            id="title"
            variant="h6"
            component="h4"
            style={{ textAlign: "center" }}
          >
            Оформить заказ
          </Typography>
          <Typography id="descr" sx={{ mt: 4 }} component={"span"}>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <div className="modal-container">
                <div
                  style={{
                    display: "flex",
                    justifyContent: "space-between",
                    width: "380px",
                  }}
                >
                  <div
                    style={{
                      backgroundColor: "#ebebeb",
                      borderRadius: "4px",
                      width: "175px",
                      display: "flex",
                    }}
                  >
                    <DatePicker
                      label="Начало аренды"
                      onChange={(val) => {
                        setStartDate(
                          val.$d
                            .toLocaleDateString("en-GB")
                            .replace("/", ".")
                            .replace("/", ".")
                        );
                      }}
                      format="DD.MM.YYYY"
                    />
                  </div>
                  <div
                    style={{
                      backgroundColor: "#ebebeb",
                      borderRadius: "4px",
                      width: "175px",
                      display: "flex",
                    }}
                  >
                    <DatePicker
                      label="Конец аренды"
                      onChange={(val) => {
                        setEndDate(
                          val.$d
                            .toLocaleDateString("en-GB")
                            .replace("/", ".")
                            .replace("/", ".")
                        );
                      }}
                      format="DD.MM.YYYY"
                    />
                  </div>
                </div>
                <TextField
                  id="filled-basic"
                  label="Промокод"
                  variant="filled"
                  style={{ backgroundColor: "white", borderRadius: "4px" }}
                  onChange={(val) => {
                    setPromocode(val.target.value);
                  }}
                  sx={{
                    width: 390,
                  }}
                  InputProps={{ sx: { height: 52 } }}
                />
                <span>Итого к оплате: {price} {price ? 'BYN' : ''}</span>
                <div>
                  <Button
                    variant="contained"
                    style={{ backgroundColor: "white", color: "black", marginRight: '10px' }}
                    onClick={calculatePrice}
                  >
                    Рассчитать оплату
                  </Button>
                  {price ? <Button
                    variant="contained"
                    style={{ backgroundColor: "white", color: "black" }}
                    onClick={createHandler}
                  >
                    Оформить заказ
                  </Button> : ""}
                </div>
              </div>
            </LocalizationProvider>
          </Typography>
        </Box>
      </Modal>
      <h2 style={{ textAlign: "center" }}>Выберите желаемый автомобиль</h2>
      <div className="carsContainer">
        {/* {cars.length === 0) && <span>karasik</span>} */}
        {cars.map((el) => (
          <CarItem
            el={el}
            handleOpen={handleOpen}
            key={`${el.name} + ${el.tariff}`}
          />
        ))}
      </div>
    </div>
  );
}

export default CarsComponent;
