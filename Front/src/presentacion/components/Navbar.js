import React from 'react';

import './styles/Navbar.css';
import logo from '../images/logo.png';

class Navbar extends React.Component {
  render() {

    return (
      <div className="Navbar">
        <div className="container-fluid">
          <div className="Navbar__brand">
            <img className="Navbar__brand-logo" src={logo} alt="Logo" />
            <span className="font-weight-light">Consultorio</span>
            <span className="font-weight-bold">Pokemon</span>
          </div>
        </div>
      </div>
    );
  }
}

export default Navbar;