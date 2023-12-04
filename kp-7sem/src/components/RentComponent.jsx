import { Button } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";

function RentComponent({ setSelectedDealer }) {
  
  const [dealers, setDealers] = useState([]);


  const loadDealers = async () => {
    await axios
      .get("http://localhost:8080/dealer/get-all")
      .then((res) => setDealers(res.data));
  };

  useEffect(() => {
    loadDealers();
  }, []);

  return (
    <div className="rentContainer">
      <h2>Выберите желаемого Дилера</h2>
      <div className="dealerContainer">
        {dealers.map((el) => (
          <div className="dealerItem" key={`${el.name} + ${el.image}`}>
            <img src={`${el.image}`} alt="no image" className="dealerIcon" />
            <div className="dealerContent">
              <h4>« {el.slogan} »</h4>
              <span>{el.descr}</span>
              <Button
                variant="contained"
                style={{ backgroundColor: "white", color: "black" }}
                onClick={() => setSelectedDealer(el)}
              >
                Выбрать
              </Button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default RentComponent;
