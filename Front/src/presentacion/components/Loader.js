import React, { Component } from 'react';

import './styles/Loader.css';
import uno from '../images/uno.svg';
import dos from '../images/dos.svg';
import tres from '../images/tres.svg';
import cuatro from '../images/cuatro.svg';
import cinco from '../images/cinco.svg';
import seis from '../images/seis.svg';
import siete from '../images/siete.svg';
import ocho from '../images/ocho.svg';
import nueve from '../images/nueve.svg';

export default class Loader extends Component {
  render() {
    return (
      <div className="lds-grid">
        <div> 
          <img
            src={uno}
            alt="circulo"
            className="circulo"/>
        </div>
        <div> 
          <img
            src={dos}
            alt="circulo"
            className="circulo"/>
        </div>
        <div> 
          <img
            src={tres}
            alt="circulo"
            className="circulo"/>
        </div>
        <div> 
          <img
            src={cuatro}
            alt="circulo"
            className="circulo"/>
        </div>
        <div> 
          <img
            src={cinco}
            alt="circulo"
            className="circulo"/>
        </div>
        <div> 
          <img
            src={seis}
            alt="circulo"
            className="circulo"/>
        </div>
        <div> 
          <img
            src={siete}
            alt="circulo"
            className="circulo"/>
        </div>
        <div> 
          <img
            src={ocho}
            alt="circulo"
            className="circulo"/>
        </div>
        <div> 
          <img
            src={nueve}
            alt="circulo"
            className="circulo"/>
        </div>
      </div>
    );
  }
}