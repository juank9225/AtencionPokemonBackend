import { callApi } from '../callApi';

const pokemon = {
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
}
export default pokemon;