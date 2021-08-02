import React from 'react';
import { Link } from 'react-router-dom';

import '../styles/Consults.css';
import confLogo from '../../images/descarga.png';
import AtendList from '../../components/AtendList';
import PageLoading from '../../components/PageLoading';
import PageError from '../../components/PageError';
import MiniLoader from '../../components/MiniLoader';
import api from '../../../infraestructura/api';
import { auth } from '../../../infraestructura/firebase/firebase';

class Consults extends React.Component {
  state = {
    loading: true,
    error: null,
    data: undefined,
    consulta : undefined,
    consulta2 : undefined
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
      const atencion = await api.atenciones.listByIDDoctor(auth().currentUser.uid)
      const atend = await api.atenciones.list()
      const user = await api.usuarios.list();
      const poke = await api.pokemon.list();
      var userID
      var pokemonID
      var userid
      var consultaid
      var atencionid
      var atencionID
      var consultaidU
      var consultaidP
      var pokemonid

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

        function filterAtByIDC(value, index, array) {
          consultaid = consult.id
          atencionid = value.idConsulta
          return consultaid === atencionid;
        }

        userID = user.filter(filterByID)
        pokemonID = poke.filter(filterByIDP)
        atencionID = atend.filter(filterAtByIDC)

        return [consult , userID[0] , pokemonID[0], atencionID[0]]
      })

      const datamorfis2 = atencion.map((aten) => {
        function filterByIDCons(value, index, array) {
          consultaid = aten.idConsulta
          userid = value.id
          return aten.idConsulta === value.id;
        }
        return data.filter(filterByIDCons)
      })

      //console.log(datamorfis2)
      //console.log("datamorfis2")

      const datamorfis3 = datamorfis2.map((consult) => {
        function filterByID(value, index, array) {
          consultaidU = consult[0].idUsuario
          userid = value.id 
          return userid === consultaidU;
        }

        function filterByIDP(value, index, array) {
          consultaidP = consult[0].idMascotaPokemon
          pokemonid = value.id 
          return pokemonid === consultaidP;
        }

        function filterAtByIDC(value, index, array) {
          consultaid = consult[0].id
          atencionid = value.idConsulta
          return consultaid === atencionid;
        }

        userID = user.filter(filterByID)
        pokemonID = poke.filter(filterByIDP)
        atencionID = atend.filter(filterAtByIDC)
        return [consult[0] , userID[0] , pokemonID[0], atencionID[0]]
      })

      //console.log("datamorfis")
      //console.log(datamorfis)

      var dataa = datamorfis.map(()=>{
        function filterU(value, index, array) {
          return value[3] !== undefined;
        }
        return datamorfis.filter(filterU)

      });

      //console.log(dataa)

      var dataaa = datamorfis3.map(()=>{
        function filterU(value, index, array) {
          return value[3] !== undefined;
        }
        return datamorfis3.filter(filterU)

      });
      //console.log(datamorfis)
      //console.log(datamorfis.atencionID)
      this.setState({ loading: false, data: data, consulta:dataa[0], consulta2:dataaa[0] });
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

    const log = (event)=>{
      event.preventDefault()
      auth().signOut()
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

        <div className="container">
          <div className="Badges__buttons">
          <Link className="btn btn-warning"  onClick={log} >
            Cerrar Sesion
          </Link>
          </div>
          <div className="container">
          <div className="row">
            <div className="col-6">
            <AtendList consults = {this.state.consulta} />
            </div>
            <div className="col-6">
            <AtendList consults = {this.state.consulta2} />
            </div>
          </div>
          </div>
        </div>

        {this.state.loading && <MiniLoader />}
        
      </React.Fragment>
    );
  }
}

export default Consults;