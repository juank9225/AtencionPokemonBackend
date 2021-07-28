import React from 'react';

import './styles/User.css';
import logo from '../images/descarga.png';
import Gravatar from './Gravatar';

class Consult extends React.Component {
  render() {
    return (
      <div className="Badge">
        <div className="Badge__header">
          <img src={logo} alt="Logo de la conferencia" />
        </div>

        <div className="Badge__section-name">
          <Gravatar className="Badge__avatar" email={this.props[1].correo} />
          <h1>
            {this.props[1].nombre} <br /> {this.props[1].apellido}
          </h1>
        </div>

        <div className="Badge__section-info">
          <h3>{this.props[1].profesion}</h3>
          <div>{this.props[1].telefono}</div>
        </div>

        <div className="Badge__section-info">
          <h2>{this.props[2].nombre}</h2>
          <div>{this.props[2].raza}</div>
        </div>

        <div className="Badge__section-info">
          <h3>{this.props[0].sintomas}</h3>
          <div>{this.props[0].causaEnfermedad}</div>
          <div>{this.props[0].fechaConsulta}</div>
        </div>

        <div className="Badge__footer">#ConsultorioPokemon</div>
      </div>
    );
  }
}

export default Consult;