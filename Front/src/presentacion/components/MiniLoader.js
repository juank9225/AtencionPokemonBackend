import React, { Component } from 'react';

import './styles/Loader.css';
import uno from '../images/uno.svg';
import dos from '../images/dos.svg';
import tres from '../images/tres.svg';

export default class MiniLoader extends Component {
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
      </div>
    );
  }
}