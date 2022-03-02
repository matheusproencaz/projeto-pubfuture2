import { useParams } from "react-router-dom";
import { useEffect, useState } from 'react';
import Footer from "components/Layout/Footer/Footer";
import SideBar from "components/Layout/SideBar/SideBar";
import { BASE_URL } from "utils/requests";
import './styles.css';

function ListaContas() {

    const [conta, setConta]:any = useState({});
    const [despesas, setDespesas]:any = useState([]);
    const [receitas, setReceitas]:any = useState([]);

    const id = useParams();

    //const [despesasVisible, setDespesaVisible] = useState(false);
    //const [receitasVisible, setReceitasVisible] = useState(false);

    useEffect(() => {
        fetch(`${BASE_URL}/contas/${id.id}`,{
            method:'GET',
            headers:{
                'Content-Type': 'application/json',
            },
        })
        .then((resp) => resp.json())
        .then(data => {
            setConta(data);
            setDespesas(data.despesas);
            setReceitas(data.receitas)
        })
        .catch(e => console.log(e));
    }, [id])

    return (
        <div >
            <div id="listaContas">
                <SideBar name={conta.nomeUsuario}/>
                <div className="content">
                    <div className="dados-conta">
                        <h2> Dados da conta [{conta.tipoConta}]</h2>
                        <h3>Nome: {conta.nomeUsuario}</h3>
                        <hr />
                        <h4>Saldo: R${conta.saldo}</h4>
                        <h4>Insituição Financeira: {conta.instituicaoFin}</h4>
                    </div>
                    <hr />
                    <div className="dados-despesa">
                        {despesas > 0 && 
                            despesas.map((despesa:any) =>  (
                                <h3>{despesa.id}</h3>
                            ))
                        }
                    </div>
                    <hr />
                    <div className="dados-receitas">

                    </div>
                </div>
            </div>
            <Footer/>
        </div>
    );
}

export default ListaContas;