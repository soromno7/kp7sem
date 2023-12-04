import axios from "axios";
import { useEffect, useState } from "react";
import "./rent.css";
import RentComponent from "../../components/RentComponent";
import CarsComponent from "../../components/cars/CarsComponent";

function RentPage() {
  const [selectedDealer, setSelectedDealer] = useState("");

  if (selectedDealer === "") return <RentComponent setSelectedDealer={setSelectedDealer}/>;
  else return <CarsComponent selectedDealer={selectedDealer} />
}

export default RentPage;
