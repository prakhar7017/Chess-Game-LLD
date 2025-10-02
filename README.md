# Chess Game Implementation

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8.0-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Build Status](https://github.com/prakhar7017/Chess-Game-LLD/actions/workflows/maven.yml/badge.svg)](https://github.com/prakhar7017/Chess-Game-LLD/actions/workflows/maven.yml)

![Chess Banner](https://raw.githubusercontent.com/prakhar7017/Chess-Game-LLD/main/chess-banner.png)

A console-based chess game implementation using object-oriented design principles and design patterns. This project demonstrates clean architecture and separation of concerns while implementing the classic game of chess.

## 🎮 Features

- **8x8 Chess Board**: Standard chess board with proper piece placement
- **Two Human Players**: Support for two players (White and Black)
- **Alternating Turns**: Players take turns moving their pieces
- **Move Validation**: Comprehensive validation of moves based on chess rules
- **Piece Movement**: All pieces move according to standard chess rules
- **Interactive UI**: Console-based UI with board visualization after each move
- **Piece Selection**: Players can select which piece to move and see valid moves

## 🏗️ Architecture & Design Patterns

### Design Patterns Implemented

| Pattern | Implementation |
|---------|----------------|
| **Singleton Pattern** | Used in the `Board` class to ensure only one board instance exists throughout the game |
| **Strategy Pattern** | Used for piece movement logic with the `MovementStrategy` interface and different implementations for each piece type |
| **Factory Pattern** | `PieceFactory` class creates different types of pieces with appropriate movement strategies |
| **MVC Pattern** | Model (Board, Piece), View (Board printing), Controller (ChessGame) |

### Class Structure

```text
com.prakhar
├── Board
│   └── Board.java
├── ChessGame.java
├── Enums
│   ├── Color.java
│   └── PieceType.java
├── Movement
│   ├── BishopMovementStrategy.java
│   ├── KingMovementStrategy.java
│   ├── KnightMovementStrategy.java
│   ├── MovementStrategy.java
│   ├── PawnMovementStrategy.java
│   ├── QueenMovementStrategy.java
│   └── RookMovementStrategy.java
├── Piece
│   ├── Piece.java
│   └── PieceFactory.java
├── Player
│   └── Player.java
└── Sqaure
    └── Square.java
```

## 🚀 How to Run

### Prerequisites

- Java 8 or higher
- Maven

### Build & Run

1. Clone the repository:

   ```bash
   git clone https://github.com/prakhar7017/Chess-Game-LLD.git
   cd Chess-Game-LLD
   ```

2. Compile the project:

   ```bash
   mvn clean compile
   ```

3. Run the game:

   ```bash
   java -cp target/classes com.prakhar.ChessGame
   ```

## 🎯 Game Instructions

1. The game starts with White's turn
2. Enter the position of the piece you want to move (row col)
3. The game will show you the valid moves for that piece
4. Enter the destination position (row col)
5. The board will be updated and the turn will switch to the other player
6. To select a different piece, enter "-1 -1" when prompted for the destination

## 🎲 Board Representation

```text
  0 1 2 3 4 5 6 7
  ---------------
0|R N B Q K B N R|
1|P P P P P P P P|
2|· . · . · . · .|
3|. · . · . · . ·|
4|· . · . · . · .|
5|. · . · . · . ·|
6|p p p p p p p p|
7|r n b q k b n r|
  ---------------
```

- Uppercase letters represent WHITE pieces
- Lowercase letters represent BLACK pieces
- Piece notation:
  - P/p: Pawn
  - R/r: Rook
  - N/n: Knight (Note: N is used instead of K to avoid confusion with the King)
  - B/b: Bishop
  - Q/q: Queen
  - K/k: King
- Empty squares are represented by dots (· or .)

## 🔮 Future Enhancements

- [ ] Implement check and checkmate detection
- [ ] Add castling, en passant, and pawn promotion
- [ ] Implement game state persistence
- [ ] Add a graphical user interface
- [ ] Support for computer player (AI)

## 🚀 CI/CD Pipeline

This project uses GitHub Actions for continuous integration and deployment:

### Maven Workflow

- **Trigger**: Runs on push to main branch and pull requests
- **Actions**:
  - Builds the project with Maven
  - Runs all unit tests
  - Uploads build artifacts

### Setup for Contributors

1. Fork and clone the repository
2. Make your changes
3. Push to your fork and submit a pull request
4. CI pipeline will automatically run on your PR
5. Check the build status and fix any issues before merging

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

- [Prakhar](https://github.com/prakhar7017)

---

## Built with ❤️ by Prakhar
