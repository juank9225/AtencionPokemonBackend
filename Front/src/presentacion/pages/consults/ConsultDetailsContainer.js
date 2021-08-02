import React from 'react';

import BadgeDetails from './ConsultDetails';
import PageLoading from '../../components/PageLoading';
import PageError from '../../components/PageError';
import api from '../../../infraestructura/api';

class BadgeDetailsContainer extends React.Component {
  state = {
    loading: true,
    error: null,
    data: undefined,
    modalIsOpen: false,
  };

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async () => {
    this.setState({ loading: true, error: null });

    try {
      const data = await api.consults.read(this.props.match.params.consultId);
      const userId = await api.usuarios.read(data.idUsuario);
      const pokeId = await api.pokemon.read(data.idMascotaPokemon);
      const datamorfis = [data, userId, pokeId]

      this.setState({ loading: false, data: datamorfis });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  handleOpenModal = e => {
    this.setState({ modalIsOpen: true });
  };

  handleCloseModal = e => {
    this.setState({ modalIsOpen: false });
  };

  render() {
    if (this.state.loading) {
      return <PageLoading />;
    }

    if (this.state.error) {
      return <PageError error={this.state.error} />;
    }

    return (
      <BadgeDetails
        onCloseModal={this.handleCloseModal}
        onOpenModal={this.handleOpenModal}
        modalIsOpen={this.state.modalIsOpen}
        consult={this.state.data}
      />
    );
  }
}

export default BadgeDetailsContainer;