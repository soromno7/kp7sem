import { Swiper, SwiperSlide } from "swiper/react";
import { Navigation } from "swiper/modules";
import "swiper/css";
import "swiper/css/navigation";
import "./main.css"
import one from "./images/2.jpg"
import two from "./images/1.jpg"
import three from "./images/3.jpg"
import axios from "axios";
import { useEffect, useState } from "react";

function MainPage() {

  const [promocode, setPromocode] = useState('')

  const getPromocode = async () => {
    await axios.get('http://localhost:8080/order/get-promocode')
    .then((res) => setPromocode(res.data))
  }

  useEffect(() => {
    getPromocode()
  }, [])
  
  return (
    <div>
      <div>
        <Swiper navigation={true} modules={[Navigation]}>
          <SwiperSlide>
            <img src={one} />
          </SwiperSlide>
          <SwiperSlide>
            <img src={two} style={{height: '839px'}}/>
          </SwiperSlide>
          <SwiperSlide>
            <img src={three} />
          </SwiperSlide>
        </Swiper>
      </div>
      <div>
        {/* <h1 style={{textAlign: 'center'}}>Почему мы?</h1>
        <div></div> */}
        <h1 style={{textAlign: 'center'}}>Скрытая секция</h1>
        <div style={{textAlign: 'center'}}>Промокод на сегодня: {promocode}</div>
      </div>
    </div>
  );
}

export default MainPage;
