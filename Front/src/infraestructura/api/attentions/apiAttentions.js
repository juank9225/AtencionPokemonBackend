import { callApi } from '../callApi';

const atenciones = {
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
}

export default atenciones;