import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

import Layout from './Layout';
import Home from '../pages/Home';
import Consults from '../pages/Consults';
//import ConsultNew from '../pages/ConsultNew';
/*
import BadgeNew from '../pages/BadgeNew';
import BadgeDetails from '../pages/BadgeDetailsContainer';
import BadgeEdit from '../pages/BadgeEdit';
import NotFound from '../pages/NotFound';*/

/*
<Route exact path="/consults/new" component={ConsultNew} />
          <Route exact path="/consults/new" component={ConsulstNew} />
          <Route exact path="/badges/:badgeId" component={BadgeDetails} />
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
        
        </Switch>
      </Layout>
    </BrowserRouter>
  );
}

export default App;