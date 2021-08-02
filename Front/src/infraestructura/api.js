import consults from './api/consults/apiConsults';
import atenciones from './api/attentions/apiAttentions';
import doctor from './api/doctors/apiDoctors';
import pokemon from './api/pokemon/apiPokemon';
import usuarios from './api/users/apiUsers';

const api = {
  consults,
  atenciones,
  usuarios,
  doctor,
  pokemon
};

export default api;