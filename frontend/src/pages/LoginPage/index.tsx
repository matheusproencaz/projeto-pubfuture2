import "./styles.css";
import logoPub from "assets/imgs/logo-pub.png";
import Footer from "../../components/Footer";
import { Link } from "react-router-dom";

function loginPage() {
    return (
        <div>
            <div className="container-fluid" id="loginContainer">
                <div className="container">
                    <div className="row img-fluid">
                        <img src={logoPub} className="img-fluid" alt="logo pubfuture" />
                    </div>
                    <div className="row">
                        <div className="field">
                            <input type="text" required autoComplete="true" id="username" />
                            <label className="label" htmlFor="username" title="Usuário" data-title="Usuário"></label>
                        </div>
                        <div className="field">
                            <input type="password" required autoComplete="off" id="password" />
                            <label className="label" htmlFor="password" title="Senha" data-title="Senha"></label>
                        </div>
                        <div className="row">
                            <Link className="col" to={"/lista"}>
                                <div className="btn btn-primary">Entrar</div>
                            </Link>
                            <Link className="col" to={"/"}>
                                <div className="btn btn-primary">Cancelar</div>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default loginPage;