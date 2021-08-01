import React, { Component } from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import { auth } from '../firebase';

import Layout from './Layout';
import Home from '../pages/Home';
import Consults from '../pages/Consults';
import Atenciones from '../pages/Atenciones';
import UserNew from '../pages/UserNew';
import DoctorNew from '../pages/DoctorNew';
import PokemonNew from '../pages/PokemonNew.js';
import ConsultNew from '../pages/ConsultNew.js';
import ConsultDetails from '../pages/ConsultDetailsContainer';
import UserEdit from '../pages/UserEdit';
import PokemonEdit from '../pages/PokemonEdit';
import ConsultEdit from '../pages/ConsultEdit';
import NotFound from '../pages/NotFound';

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
        : <Redirect to='/consults/usernew' />}
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
    return this.state.loading === true ? <h2>Loading...</h2> : (
    <BrowserRouter>
      <Layout>
        <Switch>
        <PublicRoute exact path="/" authenticated = {this.state.authenticated} component={Home} />
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