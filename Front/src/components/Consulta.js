import React from 'react';

import './styles/User.css';
import logo from '../images/descarga.png';

class Consulta extends React.Component {
  render() {
    return (
      <div className="Badge">
        <div className="Badge__header">
          <img src={logo} alt="Logo de la conferencia" />
        </div>

        <div className="Badge__section-name">
          <h1>
          {this.props.fechaConsulta}
          </h1>
        </div>

        <div className="Badge__section-info">
          <h3>{this.props.sintomas}</h3>
          <h3>{this.props.causaEnfermedad}</h3>
        </div>

        <div className="Badge__section-info">
          <h3>{this.props.estadoRevision}</h3>
        </div>

        <div className="Badge__footer">#ConsultorioPokemon</div>
      </div>
    );
  }
}

export default Consulta;