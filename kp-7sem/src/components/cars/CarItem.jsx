import { Button } from "@mui/material";

function CarItem({ el, handleOpen }) {
  return (
    <div
      className="carItem"
      key={`${el.name} + ${el.dealer} + ${el.plateNumber}`}
    >
      <h3>
        {el.dealer} {el.name}
      </h3>
      <div className="carItemLine">
        <div className="carItemUnderline">
          <span>Год выпуска</span>
          <span>{el.year}</span>
        </div>
        <div className="carItemUnderline">
          <span>Готов к работе</span>
          <span>{el.isMaintained}</span>
        </div>
      </div>
      <div className="carItemLine">
        <div className="carItemUnderline">
          <span>Количество мест</span>
          <span>{el.seatsQuantity}</span>
        </div>
        <div className="carItemUnderline">
          <span>Объём двигателя</span>
          <span>{el.engineCapacity}</span>
        </div>
      </div>
      <div className="carItemLine">
        <div className="carItemUnderline">
          <span>Номер</span>
          <span>{el.plateNumber}</span>
        </div>
        <div className="carItemUnderline">
          <span>Тариф</span>
          <span>{el.tariff} BYN / день</span>
        </div>
      </div>
      <Button
        variant="contained"
        style={{
          backgroundColor: "white",
          color: "black",
          marginTop: "15px",
        }}
        onClick={() => handleOpen(el)}
      >
        Выбрать
      </Button>
    </div>
  );
}

export default CarItem;
