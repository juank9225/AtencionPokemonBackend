  
import React from 'react';

import './styles/NotFound.css';
import notf from '../images/magneton.gif';

function NotFound() {
  return  <div className="not">
    <img src={notf} alt="Snorlax" className="img-fluid img"/>;
  </div>;
}

export default NotFound;