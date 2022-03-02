import React from 'react';
import{
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import InitialPage from 'pages/InitialPage/InitialPage';
import FormContas from 'pages/FormContas/FormContas';
import LoginPage from 'pages/LoginPage/LoginPage';
import ListaContas from 'pages/ListaContas/ListaContas';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<InitialPage/>}/>
        <Route path="/form" element={<FormContas/>}/>
        <Route path="/login" element={<LoginPage/>}/>
        <Route path="/conta/:id" element={<ListaContas/>}/>
      </Routes>
    </BrowserRouter>
  ); 
}

export default App;
