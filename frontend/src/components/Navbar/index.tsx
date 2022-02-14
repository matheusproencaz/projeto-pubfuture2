import pub from 'assets/imgs/logo-pub-future1.png';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/js/dist/dropdown'
import "./styles.css";

function Navbar(){

    return (
            <nav className="navbar navbar-expand-lg fixed-top navbar-dark">
                <div className="container-fluid" id="nav-container">
                    <a className="navbar-brand" href="/#">
                    <img id="logo" className="" src={pub} alt="Be a Pub" />
                    </a>
                    <button 
                    className="navbar-toggler" 
                    type="button" 
                    data-bs-toggle="collapse" 
                    data-bs-target="#navbar-items" 
                    aria-controls="navbar-items" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation"
                    >
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbar-items">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a href="/#" className="nav-link active" aria-current="page">Home</a>
                            </li>
                            <li className="nav-item dropdown">
                                <a className="nav-link dropdown-toggle" href="/#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="true">
                                    Sobre
                                </a>
                                <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a className="dropdown-item" href="/#">O Desafio</a></li>
                                    <li><a className="dropdown-item" href="/#">A Empresa</a></li>
                                    <li><a className="dropdown-item" href="curriculum">Currículo</a></li>
                                </ul>
                            </li>
                        </ul>
                        <div id="btns">
                            <button type="button" className="btn">Login</button> 
                            <button type="button" className="btn">Criar conta</button>
                        </div>
                    </div>
                </div>
            </nav>
    );
}

export default Navbar;