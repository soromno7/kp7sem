import axios from "axios";
import { useEffect, useState } from "react";
import { Modal, Box, Typography, Button, TextField } from "@mui/material";
import { LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import "./cars.css";
import CarItem from "./CarItem";

function CarsComponent({ selectedDealer }) {
  const [cars, setCars] = useState([]);

  const [open, setOpen] = useState(false);

  const handleOpen = (el) => {
    setSelectedCar(el);
    setOpen(true);
  };
  const handleClose = () => setOpen(false);

  const [a, setA] = useState();
  const [selectedCar, setSelectedCar] = useState({});
  const [startDate, setStartDate] = useState({});
  const [endDate, setEndDate] = useState({});

  const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 380,
    bgcolor: "background.paper",
    boxShadow: 24,
    p: 4,
  };

  const loadCars = async () => {
    await axios
      .get(`http://localhost:8080/car/get-by-dealer/${selectedDealer.id}`)
      .then((res) => setCars(res.data))
  };

  const createHandler = () => {};

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
                <Button
                  variant="contained"
                  style={{ backgroundColor: "white", color: "black" }}
                  onClick={createHandler}
                >
                  Рассчитать оплату
                </Button>
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
