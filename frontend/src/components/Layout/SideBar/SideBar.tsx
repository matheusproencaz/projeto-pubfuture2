import "./styles.css";
import Profile from "assets/imgs/test.png";
import {BsPiggyBank, BsHouseDoor} from 'react-icons/bs';
import {GiPayMoney, GiReceiveMoney} from 'react-icons/gi';
import { useState } from "react";


function SideBar( {name}: any){

    return(
        <div id="sidebar">
            <div className="d-flex flex-column flex-shrink-0 p-3 bg-light" id="test">
                <div className="d-flex align-items-center"> 
                    <BsPiggyBank className="svg-title"/> <span className="spanText">Gerenciamento</span>
                </div>
                <hr />
                <ul className="nav nav-pills flex-column mb-auto">
                <li className="nav-item">
                    <div className={`nav-link active`} aria-current="page">
                        <BsHouseDoor  className="svg-span"/>
                        <span>Home</span>
                    </div>
                </li>
                <li>
                    <div className="nav-link link-dark">
                    <GiPayMoney className="svg-span"/>
                    <span>Despesas</span>
                    </div>
                </li>
                <li>
                    <div className="nav-link link-dark">
                    <GiReceiveMoney className="svg-span"/>
                    <span>Receitas</span>
                    </div>
                </li>
                 </ul>
                <div className="dropdown">
                <a href="/#" className="d-flex align-items-center link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src={Profile} alt="" width="32" height="32" className="rounded-circle me-2"/>
                    <strong>{name}</strong>
                </a>
                <ul className="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
                    <li><a className="dropdown-item" href="//#">New project...</a></li>
                    <li><a className="dropdown-item" href="//#">Settings</a></li>
                    <li><a className="dropdown-item" href="/#">Profile</a></li>
                    <li></li>
                    <li><a className="dropdown-item" href="/#">Sign out</a></li>
                </ul>
                </div>
            </div>
        </div>
    );

}

export default SideBar;