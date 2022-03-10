import React from 'react';
import './styles.css';
import Input from '../Input/Input';
import Select from '../Select/Select';
import SubmitButton from '../SubmitButton/SubmitButton';
import { useState } from 'react';

export default function DespesasForm({ data, handleSubmit }: any) {

  const tipoDespesa = ["Alimentação", "Educação", "Lazer", "Moradia", "Roupas", "Transporte", "Outros"];

  const [despesaState, setDespesaState]: any = useState(data);

  function addZ(n: any) { return n < 10 ? '0' + n : '' + n; }

  function JsonToDate(jsonDate: any) {
    var currentTime = new Date(jsonDate);
    var month = currentTime.getMonth() + 1;
    var day = currentTime.getDate();
    var year = currentTime.getFullYear();

    return (year + "-" + addZ(month) + "-" + addZ(day));
  }

  function DateToJson(data: any) {
    return data + "T00:00:00Z"
  }

  const submit = (e: any) => {
    e.preventDefault();
    handleSubmit(despesaState);
  }

  function handleChange(e: any) {
    if (e.target.name === 'dataPag') {
      setDespesaState({ ...despesaState, dataPagamento: DateToJson(e.target.value) })
    } else if (e.target.name === 'dataPagEsp') {
      setDespesaState({ ...despesaState, dataPagEsperado: DateToJson(e.target.value) })
    } else {
      setDespesaState({ ...despesaState, [e.target.name]: e.target.value });
    }
  }

  function handleChangeSelect(e: any) {
    setDespesaState({ ...despesaState, tipoDespesa: e.target.options[e.target.selectedIndex].text });
  }

  return (
    <form id="formulario" onSubmit={submit}>
      <h3>Editar</h3>
      <Input
        type="number"
        text="Valor"
        name="valor"
        value={despesaState.valor}
        handleOnChange={handleChange}
      />
      <Input
        type="date"
        name="dataPag"
        text="Data Pagamento"
        placeholder=""
        value={JsonToDate(Date.parse(despesaState.dataPagamento))}
        handleOnChange={handleChange}
      />
      <Input
        type="date"
        name="dataPagEsp"
        text="Data Pagamento Esperado"
        placeholder=""
        value={JsonToDate(Date.parse(despesaState.dataPagEsperado))}
        handleOnChange={handleChange}
      />
      <Select
        name="Tipo"
        text="Tipo"
        id={data.id}
        options={tipoDespesa}
        handleOnChange={handleChangeSelect}
      />
      <SubmitButton text="Salvar" />
    </form>
  );
}
