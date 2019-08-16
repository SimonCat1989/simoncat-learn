import React from 'react';
import ReactDOM from 'react-dom';

class MyForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      value: ''
    };

  }

  handleSubmit(event) {
    alert('Submitting ' + this.state.value);
    event.preventDefault();
  }

  handleChange(event) {
    this.setState({
      value: event.target.value.toUpperCase()
    });
  }

  render() {
    return (
      <form onSubmit={(event) => this.handleSubmit(event)}>
        <label>Name:</label>
        <input type="text" value={this.state.value} onChange={(event) => this.handleChange(event)} />
        <textarea value={this.state.value} onChange={(event) => this.handleChange(event)} />
        <input type="submit" value="提交" />
      </form>
    );
  }
}

class SelectForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      value: 'coconut'
    };
  }

  handleChange = (event) => {
    this.setState({
      value: event.target.value
    });
  }

  handleSubmit = (event) => {
    alert('You like: ' + this.state.value);
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>Please Select: </label>
        <select value={this.state.value} onChange={this.handleChange}>
          <option value="grape">Grape</option>
          <option value="orange">Orange</option>
          <option value="coconut">Coconut</option>
          <option value="banana">Banana</option>
        </select>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}

class MyContainer extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="test">
        {this.props.left}
        {this.props.right}
      </div>
    );
  }
}

ReactDOM.render(<MyContainer left={
  <div>Heelo Left</div>
} right={
  <div>Heelo Right</div>
}></MyContainer>, document.getElementById('root'));
