import React from 'react';

import './styles/ConsultNew.css';
import header from '../images/vulpix.png';
import Pokemon from '../components/Pokemon';
import PokemonForm from '../components/PokemonForm';
import PageLoading from '../components/PageLoading';
import api from '../../infraestructura/api';

class PokemonNew extends React.Component {
  state = {
    loading: false,
    error: null,
    form: {
      nombre: '',
      raza: '',
      tipo: '',
      habilidad: '',
    },
  };

  handleChange = e => {
    this.setState({
      form: {
        ...this.state.form,
        [e.target.name]: e.target.value,
      },
    });
  };

  handleSubmit = async e => {
    e.preventDefault();
    this.setState({ loading: true, error: null });
    try {
      const response = await api.pokemon.create(this.state.form);
      this.setState({ loading: false });

      this.props.history.push(`/consults/consultnew/${response.id}`);
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  render() {
    if (this.state.loading) {
      return <PageLoading />;
    }

    return (
      <React.Fragment>
        <div className="BadgeNew__hero">
          <img
            className="BadgeNew__hero-image img-fluid"
            src={header}
            alt="Logo"
          />
        </div>

        <div className="container">
          <div className="row">
            <div className="col-6">
              <Pokemon
                nombre={this.state.form.nombre || 'Nombre'}
                raza={this.state.form.raza || 'Raza'}
                tipo={this.state.form.tipo || 'Tipo'}
                habilidad={this.state.form.habilidad || 'Habilidad'}
              />
            </div>

            <div className="col-6">
              <h1>Nuevo Pokemon</h1>
              <PokemonForm
                onChange={this.handleChange}
                onSubmit={this.handleSubmit}
                formValues={this.state.form}
                error={this.state.error}
              />
            </div>
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default PokemonNew;