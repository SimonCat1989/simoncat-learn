import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

function Square(props) {
  return (
    <button
      className={props.isWinner ? 'square square-win' : 'square'}
      onClick={props.onClick}>
      {props.value}
    </button>
  );
}

class Board extends React.Component {

  renderSquare(i) {
    const isWinner = this.props.winners ? this.props.winners.includes(i) : false;
    return (
      <Square
        value={this.props.squares[i]}
        isWinner={isWinner}
        onClick={() => this.props.onClick(i)}
      />
    );
  }

  renderRow(rowIndex, rowCapacity) {
    const row = Array(rowCapacity).fill(null);
    for (let j = 0; j < rowCapacity; j++) {
      row.push(this.renderSquare(rowIndex * rowCapacity + j))
    }
    return (
      <div className="board-row">
        {row}
      </div>
    );
  }

  render() {
    const size = 3;
    let rows = [];
    for (let i = 0; i < size; i++) {
      rows.push(this.renderRow(i, size))
    }

    return (
      <div>
        {rows}
      </div>
    );
  }
}

class Game extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      history: [{
        squares: Array(9).fill(null),
        current_loc: null
      }],
      history_status: [],
      xIsNext: true,
      stepNumber: 0
    };
  }

  handleClick(i) {
    const history = this.state.history.slice(0, this.state.stepNumber + 1);
    const current = history[history.length - 1];
    const squares = current.squares.slice();
    if (calculateWinner(squares) || squares[i]) {
      return;
    }
    squares[i] = this.state.xIsNext ? 'X' : 'O';
    this.setState({
      history: history.concat([{
        squares: squares,
        current_loc: i
      }]),
      stepNumber: history.length,
      xIsNext: !this.state.xIsNext
    });
  }

  jumpTo(step) {
    this.setState({
      stepNumber: step,
      xIsNext: (step % 2) === 0,

    });
  }

  render() {
    const history = this.state.history;
    const current = history[this.state.stepNumber];
    const winner = calculateWinner(current.squares);

    const moves = history.map((step, move) => {
      const loc_x = Math.floor(step.current_loc / 3);
      const loc_y = step.current_loc % 3;
      const info = ' (' + loc_x + ', ' + loc_y + ')';
      const desc = move ? (move % 2) === 0 ? 'X' + info : 'O' + info : 'Game start';
      return (
        <li key={move}><button onClick={() => this.jumpTo(move)}>
          <span className={this.state.stepNumber === move ? 'game-info-focus' : ''}>{desc}</span>
        </button></li>
      );
    });

    let status;
    if (winner) {
      status = 'Winner: ' + current.squares[winner[0]];
    } else {
      if (this.state.stepNumber === 9) {
        status = 'Game Over';
      } else {
        status = 'Next player: ' + (this.state.xIsNext ? 'X' : 'O');
      }
    }

    return (
      <div className="game">
        <div className="game-board">
          <Board
            squares={current.squares}
            winners={winner}
            onClick={(i) => this.handleClick(i)}
          />
        </div>
        <div className="game-info">
          <div>{status}</div>
          <ol>{moves}</ol>
        </div>
      </div>
    );
  }
}

// ========================================

ReactDOM.render(
  <Game />,
  document.getElementById('root')
);

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
  ];
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return [a, b, c];
    }
  }
  return null;
}
