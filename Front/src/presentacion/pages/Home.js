import React, { Component } from 'react';

import './styles/Home.css';
import Meoth from '../images/meoth.svg';
import Gigli from '../images/gigli.svg';
import pok from '../images/vulpix.png';
import api from '../../infraestructura/api';
import { auth } from '../../infraestructura/firebase/firebase';

export default class Home extends Component {
  
  render() {

    const loginDoctor = async e => {
      e.preventDefault();

      try {
       const validar = await api.usuarios.validar(auth().currentUser.email)
      
        if(validar.resgistrado === true){
          return this.props.history.push(`/atenciones`) 
        }
        this.props.history.push(`/atencion/doctornew`)
      } catch (error) {
        
      }
    }

    const login = async e => {
      e.preventDefault();

      try {
       const validar = await api.doctor.validar(auth().currentUser.email)
      
        if(validar.resgistrado === true){
          return this.props.history.push(`/consults`) 
        }
        this.props.history.push(`/consults/usernew`)
      } catch (error) {
        
      }
    }

    return ( 
      <div className="Home">
        <div className="container">
          <div className="row">
            <div className="Home__col col-12 col-md-4">
              <img
                src={Meoth}
                alt="Platzi Conf Logo"
                className="img-fluid mb-2"
              />

              <h1>Usuario Pokemon</h1>
              <button className="btn btn-primary" onClick={login}>
                Iniciar
              </button>
            </div>

            <div className="Home__col d-none d-md-block col-md-4">
              <img
                src={pok}
                alt="Astronauts"
                className="img-fluid main p-4"
              />
            </div>

            <div className="Home__col col-12 col-md-4">
              <img
                src={Gigli}
                alt="Platzi Conf Logo"
                className="img-fluid mb-2"
              />

              <h1>Doctor Pokemon</h1>
              <button className="btn btn-primary" onClick={loginDoctor}>
                Iniciar
              </button>
            </div>


          </div>
        </div>
      </div>
    );
  }
}