import { callApi } from '../callApi';

const consults = {
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
    }
}

export default consults;