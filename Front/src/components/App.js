import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

import Layout from './Layout';
import Home from '../pages/Home';
import Consults from '../pages/Consults';
import UserNew from '../pages/UserNew';
import PokemonNew from '../pages/PokemonNew.js';
import ConsultDetails from '../pages/ConsultDetailsContainer';
import UserEdit from '../pages/UserEdit';

/*
import BadgeDetails from '../pages/BadgeDetailsContainer';
import BadgeEdit from '../pages/BadgeEdit';
import NotFound from '../pages/NotFound';*/

/*
          <Route exact path="/badges/:badgeId/edit" component={BadgeEdit} />
          <Route component={NotFound} />
*/ 

function App() {
  return (
    <BrowserRouter>
      <Layout>
        <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/consults" component={Consults} />
        <Route exact path="/consults/usernew" component={UserNew} />
        <Route exact path="/consults/pokemonnew" component={PokemonNew} />
        <Route exact path="/consults/:consultId" component={ConsultDetails} />
        <Route exact path="/consults/:userId/edituser/:consultId" component={UserEdit} />
        </Switch>
      </Layout>
    </BrowserRouter>
  );
}

export default App;