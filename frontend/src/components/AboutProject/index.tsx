import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/js/dist/dropdown'
import "./styles.css";
import iconSpring from "assets/imgs/icone-spring.png";
import iconPostgre from "assets/imgs/icone-postgresql.png";
import iconVscode from "assets/imgs/icone-vscode.png";
import iconReact from "assets/imgs/icone-react.png";
import Slider from "components/Slider";

function AboutProject(){

    return(
        <div className="container" id="AboutProject">
            <div className="row">
                <div className="d-flex align-items-center" id="container-desafio">
                    <h2 className="title">Desafio</h2>
                </div>
                <div className="col-12" id="p-desafio">
                    <p>O desafio desenvolvido consiste em um programa que auxilia o controle das finanças pessoais. O foco do desafio é testar os conhecimentos em back-end, programando um sistema responsável por gerenciar finanças.</p>
                    <p>Minha primeira aplicação foi desenvolvida usando apenas Java, MySQL e JavaFX, consistia em um CRUD em que o usuário poderia criar uma conta ou entrar no programa em um sismples sistema de login, que apenas verificava se a conta constava no banco de dados.
                    no mesmo programa também era possível acessar as delas de cadastro de uma conta como também de receitas e despesas, também foram feitos filtros e um simples sistema de transação de saldo entre contas. O primeiro slider apresenta como eram as telas.</p>
                    <p>Afim de aprender mais sobre o assunto, decidi fazer o mesmo sistema, porém utilizando novos conhecimentos adquiridos, utilizando SpringBoot, PostgreeSQL, fiz o BackEnd como uma API REST
                        e para o FrontEnd decidi utilizar React.
                    </p>
                    <p id="p-title">Programas e linguagens Utilizados:</p>
                    <div className="row" id="row-dentro">
                        <div className="col-6">
                            <p><b>BackEnd:</b></p>
                            <ul>
                                <li>
                                    <p>JAVA - Spring Tool Suite 4 (Eclipse) <img src={iconSpring} alt="" /></p>
                                </li>
                                <li>
                                    <p>Postgress <img src={iconPostgre} alt="post" /></p>
                                </li>
                            </ul>
                        </div>
                        <div className="col-6">
                            <p><b>FrontEnd:</b></p>
                            <ul>
                                <li>
                                    <p>VSCode <img src={iconVscode} alt="" /></p>
                                </li>
                                <li>
                                    <p>React <img src={iconReact} alt="" /></p>
                                </li>
                            </ul>
                        </div>
                    </div>
                    </div>
                    <div className="col-12" id="slider">
                        <Slider></Slider>
                    </div>
                </div>
            </div>
    );
}

export default AboutProject;