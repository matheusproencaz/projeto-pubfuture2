import slider1 from "assets/imgs/slider1.png";
import slider2 from "assets/imgs/slider2.png";
import slider3 from "assets/imgs/slider3.png";
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/js/dist/dropdown'
import "./styles.css";

function Slider(){

    return(
        <div id="carouselExampleIndicators" className="carousel slide" data-bs-ride="carousel">
            <div className="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" className="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div className="carousel-inner">
                <div className="carousel-item active">
                    <img src={slider1} className="d-block w-100" alt="Projeto Antigo"></img>
                    <div className="carousel-caption d-none d-md-block text-center" id="comentario">
                        <h5 className="">Projeto Antigo</h5>
                        <p>Telas do projeto antigo, com JAVA, JavaFx e MySQL</p>
                    </div>
                </div>
                <div className="carousel-item">
                    <img src={slider2} className="d-block w-100" alt="Código SpringBoot"></img>
                    <div className="carousel-caption d-none d-md-block" id="comentario">
                        <h5>Back-End</h5>
                        <p>API Rest utilizando SpringBoot</p>
                    </div>
                </div>
                <div className="carousel-item">
                    <img src={slider3} className="d-block w-100" alt="Código React"></img>
                    <div className="carousel-caption d-none d-md-block" id="comentario">
                        <h5>Front-End</h5>
                        <p>Telas desenvolvidas com React</p>
                    </div>
                </div>
            </div>

            <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                <span className="visually-hidden">Previous</span>
            </button>
            <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                <span className="visually-hidden">Next</span>
            </button>
        </div>
    );
}

export default Slider;