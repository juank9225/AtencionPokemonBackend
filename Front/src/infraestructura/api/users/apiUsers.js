import { callApi } from '../callApi';

const usuarios = {
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
}

export default usuarios;