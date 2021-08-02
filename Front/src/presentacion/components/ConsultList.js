import React from 'react';
import { Link } from 'react-router-dom';

import './styles/ConsultList.css';
import Gravatar from './Gravatar';

class ConsultListItem extends React.Component {
  render() {
    return (
      <div className="BadgesListItem">
        <Gravatar
          className="BadgesListItem__avatar"
          email={this.props.consult[1].correo.valor}
        />

        <div>
          <strong>
            {this.props.consult[1].nombre.valor} {this.props.consult[1].apellido.valor}
          </strong>
          <br />
          {this.props.consult[1].telefono.valor}
          <br />
          {this.props.consult[1].profesion.valor}
          <br />
          <strong>
            {this.props.consult[2].raza.valor}
          </strong>
          <br />
          Nombre: {this.props.consult[2].nombre.valor}
          <br />
          <strong>
          Sintomas:
          </strong>
          <br />
           {this.props.consult[0].sintomas.valor}
          <br />
          <strong>
          Causas:
          </strong>
          <br /> 
          {this.props.consult[0].causaEnfermedad.valor}

        </div>
      </div>
    );
  }
}

function useSearchBadges(consults) {
  const [query, setQuery] = React.useState('');
  const [filteredBadges, setFilteredBadges] = React.useState(consults);

  React.useMemo(() => {
    const result = consults.filter(consult => {
      return `${consult[1].nombre.valor} ${consult[1].apellido.valor} ${consult[2].nombre.valor} ${consult[2].raza.valor}`
        .toLowerCase()
        .includes(query.toLowerCase());
    });

    setFilteredBadges(result);
  }, [consults, query]);

  return { query, setQuery, filteredBadges };
}

function ConsultsList(props) {
  const consults = props.consults;
  const { query, setQuery, filteredBadges } = useSearchBadges(consults);

  if (filteredBadges.length === 0) {
    return (
      <div>
        <div className="form-group">
          <label>Filtrar Consultas</label>
          <input
            type="text"
            className="form-control"
            value={query}
            onChange={e => {
              setQuery(e.target.value);
            }}
          />
        </div>

        <h3>No consults were found</h3>
        <Link className="btn btn-primary" to="/consult/new">
          Crear Nueva Consulta
        </Link>
      </div>
    );
  }

  return (
    <div className="BadgesList">
      <div className="form-group">
        <label>Filtrar Consulta</label>
        <input
          type="text"
          className="form-control"
          value={query}
          onChange={e => {
            setQuery(e.target.value);
          }}
        />
      </div>

      <ul className="list-unstyled">
        {filteredBadges.map(consult => {
          return (
            <li key={consult[0].id}>
              <Link
                className="text-reset text-decoration-none"
                to={`/consults/${consult[0].id}`}
              >
                <ConsultListItem consult={consult} />
              </Link>
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default ConsultsList;