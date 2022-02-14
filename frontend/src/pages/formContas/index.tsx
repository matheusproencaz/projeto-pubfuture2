import "./style.css";
import Footer from "../../components/Footer";
import logoPub from "assets/imgs/logo-pub.png";
import { Link } from "react-router-dom";

function FormContas() {

    return (
        <div>
            <div className="container-fluid" id="formContas">
                <div className="container">
                    <div className="row img-fluid">
                        <img src={logoPub} className="img-fluid" alt="logo pubfuture" />
                    </div>
                    <div className="row">
                        {/* Input ID */}
                        <input type="hidden" />

                        <div className="field">
                            <input type="text" required autoComplete="true" id="username" />
                            <label className="label" htmlFor="username" title="Usuário" data-title="Usuário"></label>
                        </div>
                        <div className="field">
                            <input type="password" required autoComplete="off" id="password" />
                            <label className="label" htmlFor="password" title="Senha" data-title="Senha"></label>
                        </div>
                        <div className="field">
                            <input type="number" required autoComplete="off" id="balance" />
                            <label className="label" htmlFor="balance" title="Saldo" data-title="Saldo"></label>
                        </div>
                        <div className="field">
                            <input type="text" required list="listaTipoConta" autoComplete="off" id="accountType" />
                            <label className="label" htmlFor="accountType" title="Tipo Conta" data-title="Tipo Conta"></label>
                            <datalist id="listaTipoConta">
                                <option value="Salário"></option>
                                <option value="Corrente"></option>
                                <option value="Carteira"></option>
                                <option value="Poupança"></option>
                            </datalist>
                        </div>
                        <div className="field">
                            <input type="text" required list="listaInstituicao" autoComplete="off" id="accountType" />
                            <label className="label" htmlFor="accountType" title="Instituição Financeira" data-title="Instituição Financeira"></label>
                            <datalist id="listaInstituicao">
                                <option value="Viacredi"></option>
                                <option value="Sicredi"></option>
                                <option value="Nunbank"></option>
                                <option value="BancoInter"></option>
                                <option value="Itáu"></option>
                                <option value="BancoDoBrasil"></option>
                            </datalist>
                        </div>
                    </div>
                    <div className="btns">
                        <Link to={"/listas"}>
                            <div className="btn btn-primary">Cadastrar-se</div>
                        </Link>
                    </div>
                    <div className="row row-have-account">
                        <Link className="col" to={"/login"}>
                            <div className="float-end">Já possui uma conta?</div>
                        </Link>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default FormContas;