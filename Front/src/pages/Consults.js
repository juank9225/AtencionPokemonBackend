import React from 'react';
import { Link } from 'react-router-dom';

import './styles/Consults.css';
import confLogo from '../images/descarga.png';
import ConsultList from '../components/ConsultList';
import PageLoading from '../components/PageLoading';
import PageError from '../components/PageError';
import MiniLoader from '../components/MiniLoader';
import api from '../api';

class Consults extends React.Component {
  state = {
    loading: true,
    error: null,
    data: undefined,
    consulta : undefined
  };

  componentDidMount() {
    this.fetchData();

    this.intervalId = setInterval(this.fetchData, 5000);
  }

  componentWillUnmount() {
    clearInterval(this.intervalId);
  }

  

  fetchData = async () => {
    this.setState({ loading: true, error: null });

    try {
      const data = await api.consults.list()

      //const userID = await api.usuarios.read(data[0].idUsuario);
      //const pokeID = await api.pokemon.read(data[0].idMascotaPokemon);
      
      const user = await api.usuarios.list();
      const poke = await api.pokemon.list();
      var userID
      var pokemonID
      var userid
      var consultaidU
      var consultaidP
      var pokemonid

      //console.log(user)

      const datamorfis = data.map((consult) => {
        function filterByID(value, index, array) {
          consultaidU = consult.idUsuario
          userid = value.id 
          return userid === consultaidU;
        }

        function filterByIDP(value, index, array) {
          consultaidP = consult.idMascotaPokemon
          pokemonid = value.id 
          return pokemonid === consultaidP;
        }

        userID = user.filter(filterByID)
        pokemonID = poke.filter(filterByIDP)

        return [consult , userID[0] , pokemonID[0]]
      })

      this.setState({ loading: false, data: data, consulta:datamorfis });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  render() {
    if (this.state.loading === true && !this.state.data) {
      return <PageLoading />;
    }

    if (this.state.error) {
      return <PageError error={this.state.error} />;
    }

    return (
      <React.Fragment>
        <div className="Badges">
          <div className="Badges__hero">
            <div className="Badges__container">
              <img
                className="Badges_conf-logo"
                src={confLogo}
                alt="Conf Logo"
              />
            </div>
          </div>
        </div>

        <div className="Badges__container">
          <div className="Badges__buttons">
            <Link to="/consults/usernew" className="btn btn-primary">
              New Consult
            </Link>
          </div>

          <ConsultList consults = {this.state.consulta} />
        </div>

        {this.state.loading && <MiniLoader />}
        
      </React.Fragment>
    );
  }
}

export default Consults;