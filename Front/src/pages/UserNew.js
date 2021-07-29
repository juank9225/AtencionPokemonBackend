import React from 'react';

import './styles/ConsultNew.css';
import header from '../images/vulpix.png';
import User from '../components/User';
import UserForm from '../components/UserForm';
import PageLoading from '../components/PageLoading';
import api from '../api';

class UserNew extends React.Component {
  state = {
    loading: false,
    error: null,
    form: {
      nombre: '',
      apellido: '',
      correo: '',
      profesion: '',
      telefono: '',
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
      await api.usuarios.create(this.state.form);
      this.setState({ loading: false });

      this.props.history.push('/consults/pokemonnew');
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
              <User
                nombre={this.state.form.nombre || 'Nombre'}
                apellido={this.state.form.apellido || 'Apellido'}
                telefono={this.state.form.telefono || 'Telefono'}
                profesion={this.state.form.profesion || 'Profesion'}
                correo={this.state.form.correo || 'Email'}
                avatarUrl="https://www.gravatar.com/avatar/21594ed15d68ace3965642162f8d2e84?d=identicon"
              />
            </div>

            <div className="col-6">
              <h1>Nuevo Usuario</h1>
              <UserForm
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

export default UserNew;