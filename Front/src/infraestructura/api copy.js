//const BASE_URL = 'http://localhost:3001';
//const BASE_URL = 'https://protected-garden-88860.herokuapp.com/api'
const BASE_URL = 'https://atencion-pokemon.herokuapp.com/api'

/*const delay = ms => new Promise(resolve => setTimeout(resolve, ms));
const randomNumber = (min = 0, max = 1) =>
  Math.floor(Math.random() * (max - min + 1)) + min;
const simulateNetworkLatency = (min = 30, max = 1500) =>
  delay(randomNumber(min, max));
*/
async function callApi(endpoint, options = {}) {
  //await simulateNetworkLatency();

  options.headers = {
    'Content-Type': 'application/json',
    Accept: 'application/json',
  };

  const url = BASE_URL + endpoint;
  const response = await fetch(url, options);
  const data = await response.json();

  return data;
}

const api = {
  consults: {
    list() {
      return callApi('/listar/consultas');
    },
    listByIDUser(idUser) {
      return callApi(`/listar/consulta/usuario/${idUser}`);
    },
    create(consult) {
      // throw new Error('500: Server error');
      return callApi(`/crear/consulta`, {
        method: 'POST',
        body: JSON.stringify(consult),
      });
    },
    read(consultId) {
      return callApi(`/listar/consulta/${consultId}`);
    },
    update(consultId, updates) {
      return callApi(`/actualizar/consulta`, {
        method: 'PUT',
        body: JSON.stringify(updates),
      });
    },
    // Lo hubiera llamado `delete`, pero `delete` es un keyword en JavaScript asi que no es buena idea :P
    remove(consultId) {
      return callApi(`/consults/${consultId}`, {
        method: 'DELETE',
      });
    },
  },
  atenciones:{
    list(){
      return callApi('/listar/atenciones');
    },
    listByIDDoctor(idUser) {
      return callApi(`/listar/atencion/doctor/${idUser}`);
    },
    create(consult) {
      // throw new Error('500: Server error');
      return callApi(`/crear/atencion`, {
        method: 'POST',
        body: JSON.stringify(consult),
      });
    },
    read(consultId) {
      return callApi(`/listar/atencion/${consultId}`);
    },
    update(consultId, updates) {
      return callApi(`/actualizar/atencion`, {
        method: 'PUT',
        body: JSON.stringify(updates),
      });
    }
  },
  usuarios: {
    list() {
      return callApi('/listar/usuarios');
    },
    validar(email){
      return callApi(`/validar/usuario/${email}`)
    },
    create(consult) {
      // throw new Error('500: Server error');
      return callApi(`/crear/usuario`, {
        method: 'POST',
        body: JSON.stringify(consult),
      });
    },
    read(consultId) {
      return callApi(`/listar/usuario/${consultId}`);
    },
    update(consultId, updates) {
      return callApi(`/actualizar/usuario`, {
        method: 'PUT',
        body: JSON.stringify(updates),
      });
    },
    // Lo hubiera llamado `delete`, pero `delete` es un keyword en JavaScript asi que no es buena idea :P
    remove(consultId) {
      return callApi(`/usuarios/${consultId}`, {
        method: 'DELETE',
      });
    },
  },
  doctor: {
    list() {
      return callApi('/listar/doctores');
    },
    create(consult) {
      // throw new Error('500: Server error');
      return callApi(`/crear/doctor`, {
        method: 'POST',
        body: JSON.stringify(consult),
      });
    },
    read(consultId) {
      return callApi(`/listar/doctor/${consultId}`);
    },
    update(consultId, updates) {
      return callApi(`/actualizar/doctor`, {
        method: 'PUT',
        body: JSON.stringify(updates),
      });
    },
    // Lo hubiera llamado `delete`, pero `delete` es un keyword en JavaScript asi que no es buena idea :P
    remove(consultId) {
      return callApi(`/usuarios/${consultId}`, {
        method: 'DELETE',
      });
    },
  },
  pokemon: {
    list() {
      return callApi('/listar/pokemones');
    },
    read(consultId) {
      return callApi(`/listar/mascota/${consultId}`);
    },
    create(consult) {
      // throw new Error('500: Server error');
      return callApi(`/crear/mascota`, {
        method: 'POST',
        body: JSON.stringify(consult),
      });
    },
    update(consultId, updates) {
      return callApi(`/actualizar/mascota`, {
        method: 'PUT',
        body: JSON.stringify(updates),
      });
    },
  },
};

export default api;