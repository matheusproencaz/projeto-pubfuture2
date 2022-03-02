import imgAPublica from "assets/imgs/a-publica.png";
import imgAExecutora from "assets/imgs/a-executora.png";
import seloProway from "assets/imgs/selo-proway.png";
import fotoPublica from "assets/imgs/foto-publica.png";
import logoPublica from "assets/imgs/logo-publica.png";

import "./styles.css";

function AboutCompany(){

    return(
        
        <div className="container-fluid" id="container-company">
            <div className="row">
                <div className="col-6" id="columnPublica">
                <div className="row">
                    <div className="col text-center">
                        <img className="img-fluid" id="aPublica" src={imgAPublica} alt="A Pública" />
                    </div>
                    <p>Sempre acreditamos que a tecnologia, aliada ao conhecimento humano, nos leva a resultados surpreendentes. Contribuimos para uma sociedade mais ética, justa e transparente, com softwares modernos e eficientes para prefeituras, câmaras municipais, autarquias e entidades públicas.</p></div>
                <div className="col text-center">
                        <img src={fotoPublica} className="fotoPub" alt="" />
                        <img src={logoPublica} className="fotoPub" alt="" />
                    </div>
                </div>
                <div className="col-6" id="columnProway">
                    <div className="row">
                        <div className="col text-center">
                        <img className="img-fluid" id="aExecutora" src={imgAExecutora} alt="" />
                        </div>
                    </div>
                    <div className="clearfix">
                        <img className="img-fluid float-end" id="seloProway" src={seloProway} alt="" />
                        <p>Desde 2005 a ProWay tem executado programas de formação tech fechados para empresas, tanto exclusivos como compostos por pool de empresas. Com essa experiência, atraiu diversos cases de sucesso, ganhando conotação como uma marca forte para atração, seleção, treinamento e acompanhamento pedagógico de novos profissionais para a área da tecnologia, atendendo as necessidades específicas de cada empresa. Com 26 anos de história, também oferece treinamentos presenciais, EAD e online nas mais diversas áreas do TI.</p>
                    </div>
                </div>
            </div>
        </div>

    );
}

export default AboutCompany;