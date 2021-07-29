import React from 'react';

class ConsultForm extends React.Component {
  handleClick = e => {
    console.log('Button was clicked');
  };

  render() {
    return (
      <div>
        <form onSubmit={this.props.onSubmit}>
          <div className="form-group">
            <label>Fecha Consulta</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="fechaConsulta"
              value={this.props.formValues.fechaConsulta.valor}
            />
          </div>

          <div className="form-group">
            <label>Sintomas</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="sintomas"
              value={this.props.formValues.sintomas.valor}
            />
          </div>
        
          <div className="form-group">
            <label>Causas de la Enfermedad</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="causaEnfermedad"
              value={this.props.formValues.causaEnfermedad.valor}
            />
          </div>

          <div className="form-group">
            <label>Estado de Revison</label>
            <input
              onChange={this.props.onChange}
              className="form-control"
              type="text"
              name="estadoRevision"
              value={this.props.formValues.estadoRevision.valor}
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

export default ConsultForm;