import { useParams } from "react-router-dom";
import { useEffect, useState } from 'react';
import Footer from "components/Layout/Footer/Footer";
import SideBar from "components/Layout/SideBar/SideBar";
import DespesasCard from "components/Despesas/DespesasCard/DespesasCard";
import ReceitasCard from "components/Despesas/ReceitasCard/ReceitasCard";
import { BASE_URL } from "utils/requests";
import './styles.css';

function ListaContas() {

    const [conta, setConta]:any = useState({});
    const [despesas, setDespesas]:any = useState([]);
    const [receitas, setReceitas]:any = useState([]);

    const id = useParams();

    //Requisição GET

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
            setReceitas(data.receitas);
        })
        .catch(e => console.log(e));
    }, [id])

    // Requisições DELETE

    function onClickDeletarDespesa(id:any){
        fetch(`${BASE_URL}/despesas/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
        })
        .then(() => {
            setDespesas(despesas.filter((despesas:any) => despesas.idDespesas !== id));
        })
        .catch(err => console.log(err));
    }

    function onClickDeletarReceita(id:any){
        fetch(`${BASE_URL}/receitas/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
        })
        .then(() => {
            setReceitas(receitas.filter((receitas:any) => receitas.idReceitas !== id));
        })
        .catch(err => console.log(err));
    }

    // Requisições PUT

    function onClickEditarDespesa(despesaAtualizada:any){

        const despesasAtt = despesas.filter((desp:any) => desp.idDespesas !== despesaAtualizada.idDespesas);
        
        despesasAtt.push(despesaAtualizada);

       fetch(`${BASE_URL}/despesas/${despesaAtualizada.idDespesas}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(despesaAtualizada)
        })
        .then(() => {
            setDespesas(despesasAtt);
        })
        .catch(err => console.log(err));
    }

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
                    <h3>Despesas</h3>
                    <div className="dados-despesas">
                        {despesas.length > 0 && 
                            despesas.map((despesa:any) =>  (
                                    <DespesasCard 
                                    id={despesa.idDespesas}
                                    type={despesa.tipoDespesa}
                                    value={despesa.valor}
                                    date_expected_payment={despesa.dataPagEsperado}
                                    date_payment={despesa.dataPagamento}
                                    onClickDeletar={onClickDeletarDespesa}
                                    onClickEditar={onClickEditarDespesa}
                                    data={despesa}
                                    key={despesa.idDespesas}
                                    />
                            ))}
                        {despesas.length === 0 &&
                            <p>Não há nenhuma despesa adicionada!</p>
                        }
                    </div>
                    <hr />
                    <h3>Receitas</h3>
                    <div className="dados-receitas">
                        {receitas.length > 0 &&
                            receitas.map((receita:any) => (
                                <ReceitasCard
                                    id={receita.idReceita}
                                    type={receita.tipoReceita}
                                    value={receita.valor}
                                    date_expected_receivement={receita.dataRecEsperado}
                                    date_receivement={receita.dataRecebimento}
                                    onClickDeletar={onClickDeletarReceita}
                                    data={receita}
                                    key={receita.idReceita}
                                />
                            ))}
                        {receitas.length === 0 &&
                            <p>Não há nenhuma receita adicionada!</p>
                        }
                    </div>
                </div>
            </div>
            <Footer/>
        </div>
    );
}

export default ListaContas;