import React from 'react';

import './styles/User.css';
import logo from '../images/descarga.png';
import Gravatar from './Gravatar';

class Badge extends React.Component {
  render() {
    return (
      <div className="Badge">
        <div className="Badge__header">
          <img src={logo} alt="Logo de la conferencia" />
        </div>

        <div className="Badge__section-name">
          <Gravatar className="Badge__avatar" email={this.props.correo} />
          <h1>
            {this.props.nombre} <br /> {this.props.apellido}
          </h1>
        </div>

        <div className="Badge__section-info">
          <h3>{this.props.profesion}</h3>
          <div>{this.props.telefono}</div>
        </div>

        <div className="Badge__footer">#ConsultorioPokemon</div>
      </div>
    );
  }
}

export default Badge;