import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';

import './presentacion/global.css';
import App from './presentacion/components/App';

const container = document.getElementById('app');

ReactDOM.render(<App />, container);
