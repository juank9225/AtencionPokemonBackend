import React from 'react';

import './styles/ConsultNew.css';
import header from '../images/vulpix.png';
import Consulta from '../components/Consulta';
import ConsultForm from '../components/ConsultForm';
import PageLoading from '../components/PageLoading';
import api from '../../infraestructura/api';
import { auth } from '../../infraestructura/firebase/firebase';

class ConsultNew extends React.Component {
  state = {
    loading: false,
    error: null,
    form: {
      fechaConsulta: '',
      causaEnfermedad: '',
      sintomas: '',
      estadoRevision: false,
      idUsuario: auth().currentUser.uid,
      idMascotaPokemon: this.props.match.params.pokemonId
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

      const response = await api.consults.create(this.state.form);
      console.log(response.fechaConsulta.valor)
      const predeterminada = {
        idConsulta: response.id,
        idDoctor: "61060fc1ef19566bacf38909",
        diagnostico: "no atendida aun",
        fechaAtencion: response.fechaConsulta.valor
      }
      const respon = await api.atenciones.create(predeterminada);
      console.log(respon)
      this.setState({ loading: false });
      this.props.history.push('/consults');
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
              <Consulta
                fechaConsulta={this.state.form.fechaConsulta || 'fecha consulta'}
                causaEnfermedad={this.state.form.causaEnfermedad || 'causa de la enfermedad'}
                sintomas={this.state.form.sintomas || 'sintomas'}
              />
            </div>

            <div className="col-6">
              <h1>Nueva Consulta Pokemon</h1>
              <ConsultForm
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

export default ConsultNew;