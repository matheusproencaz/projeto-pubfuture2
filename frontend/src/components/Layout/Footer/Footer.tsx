import "./styles.css";
import { BsGithub } from 'react-icons/bs';

function Footer(){
    return(
        <footer >
            <div className="container-fluid" id="footerContainer">
                <div className="d-flex flex-row" id="divFooter">
                    <BsGithub/>
                    <a href="https://github.com/matheusproencaz" className="">/matheusproencaz</a>
                </div>
            </div> 
        </footer>
    );
}

export default Footer;