import Navbar from 'components/Layout/Navbar/Navbar';
import Curriculum from 'components/About/Curriculum/Curriculum';
import AboutProject from 'components/About/AboutProject/AboutProject';
import AboutCompany from 'components/About/AboutCompany/AboutCompany';
import Footer from 'components/Layout/Footer/Footer';
import beApubImg from 'assets/imgs/pub.png';
import pubLogo from 'assets/imgs/logo-pub-future1.png';
import './index.css';


function initialPage(){
    
    return(
        <div>
            <Navbar/>
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
            <AboutProject/>
            <AboutCompany/>
            <Curriculum />
            <Footer />
        </div>
    );
}

export default initialPage;