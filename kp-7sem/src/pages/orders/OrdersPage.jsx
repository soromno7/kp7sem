import { useEffect, useState } from "react";
import Table from "../../components/Table";
import {
  Button,
} from "@mui/material";
import axios from "axios";

function OrdersPage() {
  const [rows, setRows] = useState([]);

  const [updateTable, setUpdateTable] = useState(() => {});
  const [selRow, setSelRow] = useState();

  const deleteHandler = async () => {
    await axios
      .delete(`http://localhost:8080/order/delete/${selRow.id}`)
      .then(() => updateTable());
  };

  const cols = [
    { field: "id", headerName: "ID" },
    { field: "firstName", headerName: "Имя" },
    { field: "lastName", headerName: "Фамилия" },
    { field: "orderDate", headerName: "Дата заказа" },
    { field: "orderTime", headerName: "Время заказа" },
    { field: "startDate", headerName: "С" },
    { field: "endDate", headerName: "По" },
    { field: "price", headerName: "Цена" },
    { field: "promocode", headerName: "Промокод" },
    { field: "dealer", headerName: "Дилер" },
    { field: "carName", headerName: "Автомобиль" },
    { field: "year", headerName: "Год" },
    { field: "engineCapacity", headerName: "Объём" },
    { field: "plateNumber", headerName: "Номер" },
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
      <div className="btnContainer">
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
        URL={"http://localhost:8080/order/get-all"}
        setUpdateTable={setUpdateTable}
        setSelectedRow={setSelRow}
        selRow={selRow}
        updateURL={"order/update"}
      />
    </div>
  );
}

export default OrdersPage;
