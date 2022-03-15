# MiniProject-Chess

To complete the chess game, assign each team member the following responsibilities

  Role A (Keiji) : management.  
  Role B (Guilherme) : Implementing Game Logic  
  Role C (Helena) : Implementing isValidMove() method of King, Queen, and Rook  
  Role D (Cybill) : Implementing isValidMove() method of Bishop, Knight, and Pawn  

![Class Diagram](https://user-images.githubusercontent.com/90675874/158271205-ee4aac29-181d-45d7-8f38-24a32c5eee92.png)

## How to pull request
### Step 1: Fork this repository
* Fork Button on your top right.

### Step 2: Clone your forked repository
1. Open your terminal.
2. `$ git clone https://github.com/<your username>/MiniProject-Chess.git`

### Step 3: Open source and implement your code
1. Open project.
2. Implement your code.

### Step 4: Test locally
You can modify Driver.java to test your code.
But if you are not Role B, do not add to commit Driver.java.

### Step 5: Pull request to Keiji's master repository.
1. Create a new branch locally. (`$ git checkout -b <<YourFirstName>>`)
2. Edit, add and commit files.  
   Please do not add new folders or files other than those already existing in the repository (e.g., out folder).
3. Push your branch to the remote repository. (`$ git push -u origin <<YourFirstName>>`)
4. Pull Request from your forked repository. [README](https://help.github.com/articles/creating-a-pull-request-from-a-fork/)


## To implement isValidMove()
### King
The King is the most important piece on the chessboard. If he is checkmated (see objectives, below) the game is over!
The King in chess can move one space in any direction (see the diagram). He can never move in to "check" (where he is threatened by another piece). This means the king can never be in the space adjacent to the opposing King.

### Queen
The queen moves similarly to multiple pieces. It can move in any direction like a king (but the queen is not limited to a single square). The queen can move the same way a rook can, moving freely up and down on any file and left and right on any rank. The queen can move like a rook.

### Rook
The rook move in straight lines. They are able to move up and down, and side to side on the board for as many squares as you choose, so long as nothing blocks their path. If an opposing piece blocks their way they can take it and occupy its square. 

### Bishop
The bishop moves diagonally in any direction it wishes and as far as it wishes as long as the squares are free. If an opposing piece blocks its way the bishop can capture it and occupy its square.

### Knight
The knight moves unconventionally compared to other chess pieces. Whereas other pieces move in straight lines, knights move in an “L-shape”—that is, they can move two squares in any direction vertically followed by one square horizontally, or two squares in any direction horizontally followed by one square vertically.

### Pawn
Unlike the other pieces, pawns cannot move backwards. Normally a pawn moves by advancing a single square, but the first time a pawn moves, it has the additional option of advancing two squares. Pawns may not use the initial two-square advance to jump over an occupied square or to capture. Any piece immediately in front of a pawn, regardless of color, blocks its advance.
Unlike other pieces, the pawn does not capture in the same way that it moves. A pawn captures diagonally forward one square to the left or right (see diagram). 
A pawn that advances to the last rank is promoted to a queen, rook, bishop, or knight of the same color. The pawn is replaced by the new piece on the same move. 

## Special rules
For this project, only Pawn's Promotion will be considered.
Other special behaviors such as Passant and Castling are not to be implemented.
