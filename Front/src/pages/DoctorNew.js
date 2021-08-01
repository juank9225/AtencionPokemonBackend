import React from 'react';

import './styles/ConsultNew.css';
import header from '../images/vulpix.png';
import Doctor from '../components/Doctor';
import DoctorFormEdit from '../components/DoctorFormEdit';
import PageLoading from '../components/PageLoading';
import api from '../api';
import { auth } from '../firebase';

class BadgeEdit extends React.Component {
  state = {
    loading: true,
    error: null,
    form: {
      id:auth().currentUser.uid,
      nombre: '',
      apellido: '',
      correo: '',
      especialidad: '',
      telefono: '',
    },
  };

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async e => {
    this.setState({ loading: true, error: null });
    try {
      const data = {
        id:auth().currentUser.uid,
        nombre: auth().currentUser.displayName,
        apellido: '',
        correo: auth().currentUser.email,
        especialidad: '',
        telefono: '',
      }
      
      this.setState({ loading: false, form: data });
    } catch (error) {
      this.setState({ loading: false, error: error});
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
          id:auth().currentUser.uid,
          nombre: data.nombre.valor || data.nombre,
          apellido: data.apellido.valor || data.apellido,
          correo: data.correo.valor || data.correo,
          especialidad: data.especialidad.valor || data.especialidad,
          telefono: data.telefono.valor || data.telefono
        }
      } 

      var creacion = await api.doctor.create(datamorfis.morfis);
      console.log(creacion)

      const predeterminada = {
        usuario: {
          id: '1',
          nombre: "Robert",
          apellido: 'Velandia',
          correo: 'Robert@gmail.com',
          profesion: 'Entrenador',
          telefono: '3222115155',
        },
        pokemon: {
          id: '1',
          nombre: 'Pit',
          raza: 'pidgey',
          tipo: 'volador',
          habilidad: 'comer gusanos',
        },
        consulta: {
          id:'1',
          fechaConsulta: '01-08-2021',
          causaEnfermedad: 'Caida de un arbol',
          sintomas: 'no puede volar',
          estadoRevision: false,
          idUsuario: '1',
          idMascotaPokemon: '1'
        },
        atencion: {
            idConsulta:'1',
            idDoctor:creacion.id,
            diagnostico:'Debes hacerle ejercicios en sus alas',
            fechaAtencion:'02/08/2021'
        }
      }

      await api.usuarios.create(predeterminada.usuario);
      await api.pokemon.create(predeterminada.pokemon);
      await api.consults.create(predeterminada.consulta);
      await api.atenciones.create(predeterminada.atencion)


      this.setState({ loading: false });

      this.props.history.push(`/atenciones`);
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  render() {
    if (this.state.loading) {
      return <PageLoading />;
    }

    console.log("hello")

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
              <Doctor
                nombre={this.state.form.nombre.valor || this.state.form.nombre || 'NAME'}
                apellido={this.state.form.apellido.valor || this.state.form.apellido ||'LAST_NAME'}
                telefono={this.state.form.telefono.valor || this.state.form.telefono || 'TELEFONO'}
                especialidad={this.state.form.especialidad.valor || this.state.form.especialidad || 'ESPECIALIDAD'}
                correo={this.state.form.correo.valor || this.state.form.correo || 'EMAIL'}
                avatarUrl="https://www.gravatar.com/avatar/21594ed15d68ace3965642162f8d2e84?d=identicon"
              />
            </div>

            <div className="col-6">
              <h1>Crear Doctor</h1>
              <DoctorFormEdit
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