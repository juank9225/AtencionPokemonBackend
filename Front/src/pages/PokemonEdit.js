import React from 'react';

import './styles/UserEdit.css';
import header from '../images/vulpix.png';
import Pokemon from '../components/Pokemon';
import PokemonForm from '../components/PokemonForm';
import PageLoading from '../components/PageLoading';
import api from '../api';

class PokemonEdit extends React.Component {
  state = {
    loading: true,
    error: null,
    form: {
      nombre: '',
      raza: '',
      tipo: [],
      habilidad: '',
    },
  };

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async e => {
    this.setState({ loading: true, error: null });
    try {
      const data = await api.pokemon.read(this.props.match.params.pokemonId);
      console.log(data)
      this.setState({ loading: false, form: data });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
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
      await api.pokemon.update(this.props.match.params.pokemonId, this.state.form);
      this.setState({ loading: false });

      this.props.history.push(`/consults/${this.props.match.params.consultId}`);
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  render() {
    if (this.state.loading) {
      return <PageLoading />;
    }

    console.log(this.state.form.raza.valor)  
    console.log(this.state.form.raza)

    return (
      <React.Fragment>
        <div className="BadgeEdit__hero">
          <img
            className="BadgeEdit__hero-image img-fluid"
            src={header}
            alt="Logo"
          />
        </div>

        <div className="container">
          <div className="row">
            <div className="col-6">
              <Pokemon
                raza={this.state.form.raza.valor || this.state.form.raza ||'RAZA'}
                nombre={this.state.form.nombre.valor || this.state.form.nombre || 'NOMBRE'}
                tipo={this.state.form.tipo[0].valor || this.state.form.tipo || 'TIPO'}
                habilidad={this.state.form.habilidad.valor || this.state.form.habilidad || 'HABILIDAD'}
               />
            </div>

            <div className="col-6">
              <h1>Editar Usuario</h1>
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

export default PokemonEdit;