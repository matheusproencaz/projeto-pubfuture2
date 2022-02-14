import React from 'react';
import{
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Navbar from 'components/Navbar';
import Curriculum from 'components/Curriculum';
import AboutProject from 'components/AboutProject';
import AboutCompany from 'components/AboutCompany';
import beApubImg from 'assets/imgs/pub.png';
import pubLogo from 'assets/imgs/logo-pub-future1.png';
import './index.css';


function App() {
  return (
    <BrowserRouter>
      <div className="container-fluid" id="container-apresentation">
        <div className="row">
          <div className="col-6" id="bePubColumn">
            <img className="img-fluid float-end" src={beApubImg} alt="Be a Pub" id="bePubLogo"/>
          </div>
          <div className="col-6" id="PubLogoColumn">
            <img className="img-fluid" src={pubLogo} alt="PubFuture Logo" />
            <h1>Desafio PubFuture</h1>
            <p>Pub Future é o Programa de Atração, Seleção e Formação da Pública Tecnologia, que oferecerá aos selecionados uma formação de 400 horas na linguagem de Programação JAVA, com contratação desde o 1° dia de aula! Top, não? A execução de todo o processo será realizada pela ProWay.</p>
          </div>
        </div>
      </div>
      <Navbar />
      <AboutProject/>
      <AboutCompany/>
      <Curriculum />
      <footer>
        <div className="container-fluid">
          <div className="row justify-content-end">
            <div className="col-md-6">
              
            </div>
            <div className="col">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-github" viewBox="0 0 16 16">
                  <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"/>
                </svg>
                <a href="https://github.com/matheusproencaz" className="">/matheusproencaz</a>
            </div>
          </div>
        </div>
      </footer>
    </BrowserRouter>
  );
}

export default App;
