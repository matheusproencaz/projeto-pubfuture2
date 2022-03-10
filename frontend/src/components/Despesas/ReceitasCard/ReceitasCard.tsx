import React from 'react';
import '../DespesasCard/styles.css';
import ReceitasForm from 'components/Form/FormsCards/ReceitasForm';
import { useState } from 'react';
import { BsFillTrashFill, BsFillPencilFill } from 'react-icons/bs';

export default function DespesasCard({ value, type, date_expected_receivement, date_receivement, description, onClickEditar, onClickDeletar , data}: any) {

  const [showReceitasForm, setShowReceitasForm] = useState(false);


  const remove = (e: any) => {
    e.preventDefault();
    onClickDeletar();
  }

  function toggleReceitasForm() {
    setShowReceitasForm(!showReceitasForm);
  }

  const edit = (e: any) => {
    e.preventDefault();
    setShowReceitasForm(!showReceitasForm);
    //onClickEditar();
  }

  return (
    <>
      <div id='despesa-card-container'>
        {!showReceitasForm ? (
          <div>
            <div className='title-card'>
              <h3>{type}</h3>
            </div>
            <div className='content-card'>
              <p><span>Valor: </span>R${value}</p>
              <span>Pagamento Esperado: </span>
              <p>{date_expected_receivement}</p>
              <span>Data Pagamento: </span>
              <p>{date_receivement}</p>
              <span>Descrição: </span>
              <p>{description}</p>
            </div>
            <div className='btns'>
              <button type="button" className="btn" onClick={edit}> <BsFillPencilFill /> Editar</button>
              <button type="button" className="btn" onClick={remove}> <BsFillTrashFill /> Excluir</button>
            </div>
          </div>
        ) : (
          <ReceitasForm data={data}/>
        )}
      </div>
    </>
  );
}
