import React from 'react';
import { Link } from 'react-router-dom';

import './styles/ConsultDetails.css';
import confLogo from '../images/descarga.png';
import Consult from '../components/Consult';
//import DeleteBadgeModal from '../components/DeleteBadgeModal';

function ConsultDetails(props) {
  const consult = props.consult;
  return (
    <div>
      <div className="BadgeDetails__hero">
        <div className="container">
          <div className="row">
            <div className="col-6">
              <img className="logo" src={confLogo} alt="Logo de la Conferencia" />
            </div>
            <div className="col-6 BadgeDetails__hero-attendant-name">
              <h1>
                {consult[1].nombre.valor} {consult[1].apellido.valor}
              </h1>
            </div>
          </div>
        </div>
      </div>

      <div className="container">
        <div className="row">
          <div className="col">
            <Consult
              nombre = {consult[1].nombre.valor}
              apellido = {consult[1].apellido.valor}
              correo = {consult[1].correo.valor}
              telefono = {consult[1].telefono.valor}
              profesion = {consult[1].profesion.valor}
              nombrepok = {consult[2].nombre.valor}
              raza = {consult[2].raza.valor}
              sintomas = {consult[0].sintomas.valor}
              causaEnfermedad = {consult[0].causaEnfermedad.valor}
              fechaConsulta = {consult[0].fechaConsulta.valor}

            />
          </div>
          <div className="col">
            <h2>Actions</h2>
            <div>
              <div>
                <Link
                  className="btn btn-primary mb-4"
                  to={`/consults/${consult[1].id}/edituser/${consult[0].id}`}
                >
                  Editar Usuario
                </Link>
              </div>
              <div>
                <Link
                  className="btn btn-primary mb-4"
                  to={`/consults/${consult[2].id}/editpokemon/${consult[0].id}`}
                >
                  Editar Pokemon
                </Link>
              </div>
              <div>
                <Link
                  className="btn btn-primary mb-4"
                  to={`/consults/${consult[0].id}/editconsult`}
                >
                  Editar Consulta
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ConsultDetails;