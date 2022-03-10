import React from 'react';
import './styles.css';
import DespesasForm from 'components/Form/FormsCards/DespesasForm';
import { useState } from 'react';
import { BsFillTrashFill, BsFillPencilFill } from 'react-icons/bs';

export default function DespesasCard({ value, type, date_expected_payment, date_payment, onClickEditar, onClickDeletar , data}: any) {

  const [showDespesasForm, setShowDespesasForm] = useState(false);

  function JsonToDate(jsonDate:any){
    var currentTime = new Date(jsonDate);
    var month = currentTime.getMonth() + 1;
    let day = currentTime.getDate();
    var year = currentTime.getFullYear();
    return (day + "/" + month + "/" + year);
  }

  const remove = (e: any) => {
    e.preventDefault();
    onClickDeletar(data.idDespesas);
  }

  function toggleDespesasForm() {
    setShowDespesasForm(!showDespesasForm);
  }

  //Arumar editar
  const edit = (e: any) => {
    e.preventDefault();
    toggleDespesasForm();
  }

  const salvar = (despesaAtualizada:any) =>{
    onClickEditar(despesaAtualizada);
    setShowDespesasForm(!showDespesasForm);
  }

  return (
    <>
      <div id='despesa-card-container'>
      {!showDespesasForm ? (
        <div>
          <div className='title-card'>
            <h3>{type}</h3>
          </div>
          <div className='content-card'>
            <p><span>Valor: </span>R$ {value}</p>
            <span>Pagamento Esperado: </span>
            <p>{`${JsonToDate(Date.parse(date_expected_payment))}`}</p>
            <span>Data Pagamento: </span>
            <p>{`${JsonToDate(Date.parse(date_payment))}`}</p>
          </div>
          <div className='btns'>
            <button type="button" className="btn" onClick={edit}> <BsFillPencilFill /> Editar</button>
            <button type="button" className="btn" onClick={remove}> <BsFillTrashFill /> Excluir</button>
          </div>
        </div>
      ) : (
        <DespesasForm data={data} handleSubmit={salvar}/>
      )}
      </div>
    </>
  );
}