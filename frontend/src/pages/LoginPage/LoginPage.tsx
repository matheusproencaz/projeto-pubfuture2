import "./styles.css";
import logoPub from "assets/imgs/logo-pub.png";
import Footer from "../../components/Layout/Footer/Footer";
import { Link, useNavigate } from "react-router-dom";
import { useState, useEffect } from 'react';
import { BASE_URL } from '../../utils/requests';
import Input from "components/Form/Input/Input";
import Message from "components/Layout/Message/Message";

function LoginPage() {

    const [username, setUsername] = useState('');
    const [senha, setSenha] = useState('');
    const [conta, setConta] = useState([]);
    const [message, setMessage] = useState('');

    const navigate = useNavigate();

    function handleOnChange(e:any) {
        if (e.target.name === 'Usuário') {
            setUsername(e.target.value);
        } else if (e.target.name === 'Senha') {
            setSenha(e.target.value);
        }
    }

    function verifyAccount() {
        setMessage('');
        fetch(`${BASE_URL}/conta/${username}`, {
            method: 'GET',
            headers: {
                'Content-type': 'application/json',
            },
        })
            .then(resp => {
                if( resp.ok ){
                    return resp.json();
                } else {
                    setMessage("Usuário não encontrado!");
                    throw Error("Usuário não encontrado!");
                }
            })
            .then((data) => {
                if(data.senha === senha){    
                    setConta(data);
                    navigate(`/conta/${data.idConta}`);
                } else {
                    setMessage("Senha Incorreta!")
                }
            })
            .catch(err => console.log(err));
    }

    return (
        <div>
            <div className="container-fluid" id="loginContainer">
                <div className="container">
                    <div className="row img-fluid">
                        <img src={logoPub} className="img-fluid" alt="logo pubfuture" />
                    </div>
                    <div className="row">
                        <Input
                            name='Usuário'
                            id='username'
                            type='text'
                            handleOnChange={handleOnChange}
                        />
                        <Input
                            name='Senha'
                            id='password'
                            type='password'
                            handleOnChange={handleOnChange}
                        />
                        {message && (<Message msg={message} type="error"/>)}
                        <div className="row">
                            <div className="col">
                                <button className="btn btn-primary" onClick={verifyAccount}>Entrar</button>
                            </div>
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

export default LoginPage;