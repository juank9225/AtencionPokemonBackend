import React from 'react';

import './styles/UserEdit.css';
import header from '../images/vulpix.png';
import Consult from '../components/Consulta';
import ConsultForm from '../components/ConsultForm';
import PageLoading from '../components/PageLoading';
import api from '../../infraestructura/api';

class ConsultEdit extends React.Component {
  state = {
    loading: true,
    error: null,
    form: {
      id:this.props.match.params.consultId,
      fechaConsulta: '',
      causaEnfermedad: '',
      sintomas: '',
      estadoRevision: false,
      idUsuario: this.props.match.params.userId,
      idMascotaPokemon: this.props.match.params.pokemonId
    },
  };

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async e => {
    this.setState({ loading: true, error: null });
    try {
      const data = await api.consults.read(this.props.match.params.consultId);
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

      const data = this.state.form

      const datamorfis = {
        morfis:{
          id:this.props.match.params.consultId,
          fechaConsulta: data.fechaConsulta.valor || data.fechaConsulta,
          causaEnfermedad: data.causaEnfermedad.valor || data.causaEnfermedad,
          sintomas: data.sintomas.valor || data.sintomas,
          estadoRevision: false,
          idUsuario: data.idUsuario,
          idMascotaPokemon: data.idMascotaPokemon
        }

      } 
      await api.consults.update(this.props.match.params.consultId, datamorfis.morfis);
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
              <Consult
                fechaConsulta={ this.state.form.fechaConsulta.valor ||this.state.form.fechaConsulta || 'NAME'}
                causaEnfermedad={this.state.form.causaEnfermedad.valor ||this.state.form.causaEnfermedad ||'LAST_NAME'}
                sintomas={this.state.form.sintomas.valor ||this.state.form.sintomas || 'twitter'}
              />
            </div>

            <div className="col-6">
              <h1>Editar Consulta</h1>
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

export default ConsultEdit;