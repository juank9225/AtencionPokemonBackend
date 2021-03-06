import React, { Component } from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import { auth } from '../../infraestructura/firebase/firebase';

import Layout from './Layout';
import Home from '../pages/Home';
import Consults from '../pages/consults/Consults';
import Atenciones from '../pages/attentions/Atenciones';
import UserNew from '../pages/users/UserNew';
import DoctorNew from '../pages/doctors/DoctorNew';
import PokemonNew from '../pages/pokemons/PokemonNew';
import ConsultNew from '../pages/consults/ConsultNew';
import ConsultDetails from '../pages/consults/ConsultDetailsContainer';
import UserEdit from '../pages/users/UserEdit';
import PokemonEdit from '../pages/pokemons/PokemonEdit';
import ConsultEdit from '../pages/consults/ConsultEdit';
import Login from '../pages/login'
import NotFound from '../pages/NotFound';
import Loader from './MiniLoader'

function PrivateRoute({ component: Component, authenticated, ...rest }) {
  return (
    <Route
      {...rest}
      render={(props) => authenticated === true
        ? <Component {...props} />
        : <Redirect to={{ pathname: '/', state: { from: props.location } }} />}
    />
  )
}

function PublicRoute({ component: Component, authenticated, ...rest }) {
  return (
    <Route
      {...rest}
      render={(props) => authenticated === false
        ? <Component {...props} />
        : <Redirect to='/home' />}
    />
  )
}


class App extends Component {
  constructor() {
    super();
    this.state = {
      authenticated: false,
      loading: true,
    };
  }

  componentDidMount() {
    auth().onAuthStateChanged((user) => {
      if (user) {
        this.setState({
          authenticated: true,
          loading: false,
        });
      } else {
        this.setState({
          authenticated: false,
          loading: false,
        });
      }
    })
  }

  render (){
    return this.state.loading === true ? <Loader></Loader> : (
    <BrowserRouter>
      <Layout>
        <Switch>
        <PublicRoute exact path="/" authenticated = {this.state.authenticated} component={Login} />
        <PrivateRoute exact path="/home" authenticated = {this.state.authenticated} component={Home} />
        <PrivateRoute exact path = "/consults" authenticated = {this.state.authenticated} component = {Consults} />
        <PrivateRoute exact path = "/consults/usernew" authenticated = {this.state.authenticated} component = {UserNew} />
        <PrivateRoute exact path = "/consults/pokemonnew" authenticated = {this.state.authenticated} component = {PokemonNew} />
        <PrivateRoute exact path = "/consults/consultnew/:pokemonId" authenticated = {this.state.authenticated} component = {ConsultNew} />
        <PrivateRoute exact path = "/consults/:consultId" authenticated = {this.state.authenticated} component = {ConsultDetails} />
        <PrivateRoute exact path = "/consults/:userId/edituser/:consultId" authenticated = {this.state.authenticated} component = {UserEdit} />
        <PrivateRoute exact path = "/consults/:pokemonId/editpokemon/:consultId" authenticated = {this.state.authenticated} component = {PokemonEdit} />
        <PrivateRoute exact path = "/consults/:consultId/editconsult" authenticated = {this.state.authenticated} component = {ConsultEdit} />
        <PrivateRoute exact path = "/atencion/doctornew" authenticated = {this.state.authenticated} component = {DoctorNew} />
        <PrivateRoute exact path = "/atenciones" authenticated = {this.state.authenticated} component = {Atenciones} />
        <Route component={NotFound} />
        </Switch>
      </Layout>
    </BrowserRouter>
    );
  }
  }


export default App;