import { useEffect, useState } from "react";
import Table from "../../components/Table";
import {
  Modal,
  Box,
  Typography,
  Button,
  TextField,
  InputLabel,
  MenuItem,
  FormControl,
  Select,
} from "@mui/material";
import axios from "axios";

function CarsPage() {
  const [rows, setRows] = useState([]);

  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const [dealer, setDealer] = useState();
  const [name, setName] = useState();
  const [year, setYear] = useState();
  const [isMaintained, setIsMaintained] = useState();
  const [seatsQuantity, setSeatsQuantity] = useState();
  const [engineCapacity, setEngineCapacity] = useState();
  const [plateNumber, setPlateNumber] = useState();
  const [tariff, setTariff] = useState();

  const [updateTable, setUpdateTable] = useState(() => {});
  const [selRow, setSelRow] = useState();

  const [dealers, setDealers] = useState([]);

  const createHandler = async () => {
    const car = {
      name,
      year,
      isMaintained,
      seatsQuantity,
      engineCapacity,
      plateNumber,
      tariff,
    };

    await axios
      .post(`http://localhost:8080/car/add/${dealer}`, car)
      .then((res) => {
        console.log(res);
      })
      .then(() => updateTable())
      .then(() => handleClose())
      .catch((err) => {
        console.log(err);
      });

    // console.log(car)
  };

  const deleteHandler = async () => {
    await axios
      .delete(`http://localhost:8080/car/delete/${selRow.id}`)
      .then(() => updateTable());
  };

  const loadDealers = async () => {
    await axios
      .get("http://localhost:8080/dealer/get-all")
      .then((res) => setDealers(res.data));
  };

  useEffect(() => {
    loadDealers();
  }, []);

  const cols = [
    { field: "id", headerName: "ID" },
    { field: "dealer", headerName: "Дилер" },
    { field: "name", headerName: "Название" },
    { field: "year", headerName: "Год" },
    { field: "isMaintained", headerName: "Готова к работе" },
    { field: "seatsQuantity", headerName: "Мест" },
    { field: "engineCapacity", headerName: "Объём двигателя" },
    { field: "plateNumber", headerName: "Номер" },
    { field: "tariff", headerName: "Тариф" },
  ];

  const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 350,
    bgcolor: "background.paper",
    boxShadow: 24,
    p: 4,
  };

  return (
    <div>
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
            Добавить автомобиль
          </Typography>
          <Typography id="descr" sx={{ mt: 4 }} component={"span"}>
            <div className="modal-container">
              <FormControl variant="filled" sx={{ m: 1, minWidth: 120 }}>
                <InputLabel id="dealer-label">
                  Дилер
                </InputLabel>
                <Select
                  labelId="dealer-label"
                  id="dealer-label"
                  value={dealer}
                  onChange={(e) => setDealer(e.target.value)}
                >
                  {dealers.map((el) => (
                    <MenuItem value={el.id} key={`${el.name} + ${el.id}`}>
                      {el.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
              <TextField
                id="filled-basic"
                label="Название"
                variant="filled"
                style={{ backgroundColor: "white", borderRadius: "4px" }}
                onChange={(val) => {
                  setName(val.target.value);
                }}
                sx={{
                  width: 350,
                }}
                InputProps={{ sx: { height: 52 } }}
              />
              <div
                style={{
                  display: "flex",
                  justifyContent: "space-between",
                  width: "350px",
                }}
              >
                <TextField
                  id="filled-basic"
                  label="Год"
                  variant="filled"
                  style={{ backgroundColor: "white", borderRadius: "4px" }}
                  onChange={(val) => {
                    setYear(val.target.value);
                  }}
                  sx={{
                    width: 165,
                  }}
                  InputProps={{ sx: { height: 52 } }}
                />
                <TextField
                  id="filled-basic"
                  label="Готова к работе"
                  variant="filled"
                  style={{ backgroundColor: "white", borderRadius: "4px" }}
                  onChange={(val) => {
                    setIsMaintained(val.target.value);
                  }}
                  sx={{
                    width: 165,
                  }}
                  InputProps={{ sx: { height: 52 } }}
                />
              </div>
              <div
                style={{
                  display: "flex",
                  justifyContent: "space-between",
                  width: "350px",
                }}
              >
                <TextField
                  id="filled-basic"
                  label="Мест"
                  variant="filled"
                  style={{ backgroundColor: "white", borderRadius: "4px" }}
                  onChange={(val) => {
                    setSeatsQuantity(val.target.value);
                  }}
                  sx={{
                    width: 165,
                  }}
                  InputProps={{ sx: { height: 52 } }}
                />
                <TextField
                  id="filled-basic"
                  label="Объём двигателя"
                  variant="filled"
                  style={{ backgroundColor: "white", borderRadius: "4px" }}
                  onChange={(val) => {
                    setEngineCapacity(val.target.value);
                  }}
                  sx={{
                    width: 165,
                  }}
                  InputProps={{ sx: { height: 52 } }}
                />
              </div>
              <TextField
                id="filled-basic"
                label="Номер"
                variant="filled"
                style={{ backgroundColor: "white", borderRadius: "4px" }}
                onChange={(val) => {
                  setPlateNumber(val.target.value);
                }}
                sx={{
                  width: 350,
                }}
                InputProps={{ sx: { height: 52 } }}
              />
              <TextField
                id="filled-basic"
                label="Тариф"
                variant="filled"
                style={{ backgroundColor: "white", borderRadius: "4px" }}
                onChange={(val) => {
                  setTariff(val.target.value);
                }}
                sx={{
                  width: 350,
                }}
                InputProps={{ sx: { height: 52 } }}
              />
              <Button
                variant="contained"
                style={{ backgroundColor: "white", color: "black" }}
                onClick={createHandler}
              >
                Добавить
              </Button>
            </div>
          </Typography>
        </Box>
      </Modal>
      <div className="btnContainer">
        <Button
          variant="contained"
          style={{ backgroundColor: "white", color: "black" }}
          size="small"
          onClick={handleOpen}
        >
          Добавить
        </Button>
        <Button
          variant="contained"
          style={{ backgroundColor: "white", color: "black" }}
          size="small"
          onClick={deleteHandler}
        >
          Удалить
        </Button>
      </div>
      <Table
        cols={cols}
        rows={rows}
        setRows={setRows}
        URL={"http://localhost:8080/car/get-all"}
        setUpdateTable={setUpdateTable}
        setSelectedRow={setSelRow}
        selRow={selRow}
        updateURL={"car/update"}
      />
    </div>
  );
}

export default CarsPage;
