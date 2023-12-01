import { useState } from "react";
import Table from "../../components/Table";
import { Modal, Box, Typography, Button, TextField } from "@mui/material";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import axios from "axios";

function StationsPage() {
  const [rows, setRows] = useState([]);
  const [open, setOpen] = useState(false);

  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const [name, setName] = useState();
  const [address, setAddress] = useState();

  const [updateTable, setUpdateTable] = useState(() => {});
  const [selRow, setSelRow] = useState();

  const createHandler = async () => {
    const user = {
        name,
        address
    };

    await axios
      .post("http://localhost:8080/registration", user)
      .then((res) => {
        console.log(res);
      })
      .then(() => updateTable())
      .then(() => handleClose())
      .catch((err) => {
        console.log(err);
      });
  };

  const deleteHandler = async () => {
    await axios
      .delete(`http://localhost:8080/user/delete/${selRow.id}`)
      .then(() => updateTable());
  };

  const cols = [
    { field: "id", headerName: "ID" },
    { field: "first_name", headerName: "Имя" },
    { field: "last_name", headerName: "Фамилия" },
    { field: "email", headerName: "Почта" },
    { field: "date_of_birth", headerName: "Дата рождения" },
    { field: "phone", headerName: "Номер телефона" },
    { field: "password", headerName: "Пароль" },
    { field: "status", headerName: "Статус" },
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
            Добавить СТО
          </Typography>
          <Typography id="descr" sx={{ mt: 4 }} component={"span"}>
            <div className="modal-container">
              <TextField
                id="filled-basic"
                label="Дилер"
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
              <TextField
                id="filled-basic"
                label="Адрес"
                variant="filled"
                style={{ backgroundColor: "white", borderRadius: "4px" }}
                onChange={(val) => {
                  setAddress(val.target.value);
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
        URL={"http://localhost:8080/service/get-all"}
        setUpdateTable={setUpdateTable}
        setSelectedRow={setSelRow}
        selRow={selRow}
      />
    </div>
  );
}

export default StationsPage;
