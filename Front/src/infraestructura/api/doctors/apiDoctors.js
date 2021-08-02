import { callApi } from '../callApi';

const doctor = {
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
}

export default doctor;