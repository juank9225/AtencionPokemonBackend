import React from 'react';

class BadgeForm extends React.Component {
  handleClick = e => {
    console.log('Button was clicked');
  };

  render() {
    return (
      <div>
        <form onSubmit={this.props.onSubmit}>
          <div className="form-group">
            <label>Nombre</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="nombre"
              value={this.props.formValues.nombre}
            />
          </div>

          <div className="form-group">
            <label>Apellido</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="apellido"
              value={this.props.formValues.apellido}
            />
          </div>

          <div className="form-group">
            <label>Correo</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="email"
              name="correo"
              value={this.props.formValues.correo}
            />
          </div>

          <div className="form-group">
            <label>Profesion</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="profesion"
              value={this.props.formValues.profesion}
            />
          </div>

          <div className="form-group">
            <label>Telefono</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="telefono"
              value={this.props.formValues.telefono}
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

export default BadgeForm;