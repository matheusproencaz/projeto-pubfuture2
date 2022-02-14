import imgMatheus from 'assets/imgs/test.png'
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/js/dist/dropdown'
import "./styles.css";

function About() {

    return (
        <div className="container" id="curriculum">
            <div className="row" id="title-container">
                <h2 className="title">Curriculum vitæ</h2>
            </div>
            <div className="row">
                <div className="col" id="column-img">
                    <img className="img-fluid" id="imgAutor" src={imgMatheus} alt="Autor" />
                </div>
                <div className="col" id="column-text">
                    <h2>Matheus Proença</h2>
                    <h3>OBJETIVO</h3>
                    <p>Oportunidade relacionada com Tecnologia da Informação (TI) com possibilidade de crescimento profissional e de adquirir experiência na área.</p>
                    <h3>FORMAÇÃO ACADÊMICA</h3>
                    <p>Curso técnico em Informática. SENAI, conclusão em 2014/2. </p>
                    <p>Graduação em Engenharia Química. FURB, conclusão em 2019/2.</p> 
                    <p>Cursando graduação em Engenharia ambiental e Sanitária. Uniasselvi.</p> 
                    <p>Curso de 50 horas em JAVA e programação orientada a objetos na Udemy, professor Nelio Alves. Conclusão em 2022.</p> 
                    
                    <h3>EXPERIÊNCIAS PROFISSIONAIS</h3>
                    <h4>SAMAE – Serviço Autônomo Municipal de Água e Esgoto.</h4>
                    <p> Estágio Obrigatório / Agosto de 2019 – Fevereiro de 2020.</p>
                    <p> Estágio não obrigatório / Abril de 2020 – Março de 2021.</p>
                    <p> Funções: Operação, manutenção e análises laboratoriais da água na estação de tratamento de água 3, participação e elaboração de projetos de tratamento de esgoto individual, participação no Programa de Educação em Saneamento (P.E.S) e elaboração de orçamentos.</p>
                    <h4>COTEMINAS</h4>
                    <p>Analista de Laboratório Jr / Junho de 2021 – Janeiro de 2022.</p>
                    <p>Funções: Desenvolvimento de cor para tecidos felpudos, lisos e fios (Algodão, Poliéster e misto); Teste de corante (contratipagem e força de tingimento), elaboração de relatórios para clientes, controle de qualidade da cor tinta em produção.</p>                
                    <h3>QUALIFICAÇÕES E ATIVIDADES COMPLEMENTARES</h3>
                    <p>Trabalho de conclusão de curso em tratamento de efluentes.</p>
                    <p>Inglês – Intermediário (B2).</p>
                    <p>Pacote Office – Conhecimento Intermediário/Avançado.</p>
                    <p>Linguagens de Programação – conhecimento intermediário em linguagens JAVA e FORTRAN e lógica de programação. Conhecimento básico em HTML, CSS e Javascript.</p>
                    <p>Simuladores de processo – conhecimento intermediário em simuladores de processo (UNISIM, COCO).</p>
                    <p>Softwares de Desenho Técnico – conhecimento intermediário em AutoCad.</p>
                </div>
            </div>
        </div>

    );
}

export default About;






















