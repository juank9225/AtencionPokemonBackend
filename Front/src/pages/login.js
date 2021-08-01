import React, { Component } from 'react';

import './styles/Home.css';
import pok from '../images/Pokemons.png';
import { signInWithGoogle} from '../Auth';

export default class Home extends Component {
  
  render() {

    const login = () => {
      signInWithGoogle().then(r => {
        this.props.history.push(`/consults/usernew`)
    }).catch(error => {
        console.log(error)
    })
    }

    return ( 
      <div className="Home">
        <div className="container">
          <div className="row">
            <div className="Home__col col-12 col-md-4">
              <h1>Bienvenido A<br>
              </br>
              Consultas Pokemon
              </h1>
              <button className="btn btn-primary" onClick={login}>
                Start
              </button>
            </div>

            <div className="Home__col d-none d-md-block col-md-8">
              <img
                src={pok}
                alt="Astronauts"
                className="img-fluid main p-4"
              />
            </div>

            


          </div>
        </div>
      </div>
    );
  }
}