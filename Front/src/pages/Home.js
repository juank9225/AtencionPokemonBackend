import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import './styles/Home.css';
import Meoth from '../images/meoth.svg';
import Gigli from '../images/gigli.svg';
import pok from '../images/vulpix.png';
import { signInWithGoogle} from '../Auth';
import { auth } from '../firebase';

export default class Home extends Component {
  
  render() {

    const login = () => {
      signInWithGoogle().then(r => {
        console.log("success")
        console.log(auth().currentUser)
        setTimeout(this.props.history.push(`/consults/usernew`), 3000)
        console.log(":v")
    }).catch(error => {
        console.log(error)
    })
    }

    return ( 
      <div className="Home">
        <div className="container">
          <div className="row">
            <div className="Home__col col-12 col-md-4">
              <img
                src={Meoth}
                alt="Platzi Conf Logo"
                className="img-fluid mb-2"
              />

              <h1>Usuario Pokemon</h1>
              <Link className="btn btn-primary" onClick={login}>
                Start
              </Link>
            </div>

            <div className="Home__col d-none d-md-block col-md-4">
              <img
                src={pok}
                alt="Astronauts"
                className="img-fluid main p-4"
              />
            </div>

            <div className="Home__col col-12 col-md-4">
              <img
                src={Gigli}
                alt="Platzi Conf Logo"
                className="img-fluid mb-2"
              />

              <h1>Doctor Pokemon</h1>
              <Link className="btn btn-primary" to="/badges">
                Start
              </Link>
            </div>


          </div>
        </div>
      </div>
    );
  }
}