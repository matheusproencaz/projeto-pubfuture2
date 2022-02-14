import React from 'react';
import{
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import InitialPage from 'pages/initialPage';
import FormContas from 'pages/formContas';
import LoginPage from 'pages/LoginPage';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<InitialPage/>}/>
        <Route path="/form" element={<FormContas/>}/>
        <Route path="/login" element={<LoginPage/>}/>
      </Routes>
    </BrowserRouter>
  ); 
}

export default App;
