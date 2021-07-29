import React from 'react';

class PokemonForm extends React.Component {
  handleClick = e => {
    console.log('Button was clicked');
  };

  render() {
    return (
      <div>
        <form onSubmit={this.props.onSubmit}>
          <div className="form-group">
            <label>Raza</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="raza"
              value={this.props.formValues.raza.valor}
            />
          </div>

          <div className="form-group">
            <label>Nombre</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="nombre"
              value={this.props.formValues.nombre.valor}
            />
          </div>
        
          <div className="form-group">
            <label>Tipo</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="tipo"
              value={this.props.formValues.tipo.valor}
            />
          </div>

          <div className="form-group">
            <label>Habilidades</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="habilidad"
              value={this.props.formValues.habilidad.valor}
            />
          </div>

          <button onClick={this.handleClick} className="btn btn-primary">
            Save
          </button>

          {this.props.error && (
            <p className="text-danger">{this.props.error.message}</p>
          )}
        </form>
      </div>
    );
  }
}

export default PokemonForm;