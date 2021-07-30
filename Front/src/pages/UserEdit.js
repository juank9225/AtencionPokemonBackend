import React from 'react';

import './styles/UserEdit.css';
import header from '../images/vulpix.png';
import User from '../components/User';
import UserFormEdit from '../components/UserFormEdit';
import PageLoading from '../components/PageLoading';
import api from '../api';

class BadgeEdit extends React.Component {
  state = {
    loading: true,
    error: null,
    form: {
      id:this.props.match.params.userId,
      nombre: '',
      apellido: '',
      correo: '',
      profesion: '',
      telefono: '',
    },
  };

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async e => {
    this.setState({ loading: true, error: null });
    try {
      const data = await api.usuarios.read(this.props.match.params.userId);
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
          id:this.props.match.params.userId,
          nombre: data.nombre.valor || data.nombre,
          apellido: data.apellido.valor || data.apellido,
          correo: data.correo.valor || data.correo,
          profesion: data.profesion.valor || data.profesion,
          telefono: data.telefono.valor || data.telefono
        }
      } 

      await api.usuarios.update(this.props.match.params.userId, datamorfis.morfis);
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
              <User
                nombre={this.state.form.nombre.valor || this.state.form.nombre || 'NAME'}
                apellido={this.state.form.apellido.valor || this.state.form.apellido ||'LAST_NAME'}
                telefono={this.state.form.telefono.valor || this.state.form.telefono || 'twitter'}
                profesion={this.state.form.profesion.valor || this.state.form.profesion || 'JOB_TITLE'}
                correo={this.state.form.correo.valor || this.state.form.correo || 'EMAIL'}
                avatarUrl="https://www.gravatar.com/avatar/21594ed15d68ace3965642162f8d2e84?d=identicon"
              />
            </div>

            <div className="col-6">
              <h1>Editar Usuario</h1>
              <UserFormEdit
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

export default BadgeEdit;