import java.util.Scanner;

public class BattleshipGame {
    private static final int BOARD_SIZE = 5;
    private static final int NUM_SHIPS = 3;

    private char[][] playerBoard;
    private char[][] computerBoard;

    private int playerShips;
    private int computerShips;

    public BattleshipGame() {
        playerBoard = new char[BOARD_SIZE][BOARD_SIZE];
        computerBoard = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoards();
    }

    private void initializeBoards() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                playerBoard[row][col] = '-';
                computerBoard[row][col] = '-';
            }
        }
    }

    private void printBoard(char[][] board) {
        System.out.print("   ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.print(row + " |");
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println("|");
        }

        System.out.println();
    }

    private void placeShips(char[][] board, int numShips) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= numShips; i++) {
            System.out.println("Placing ship #" + i);
            int row, col;
            do {
                System.out.print("Enter the row (0-" + (BOARD_SIZE - 1) + "): ");
                row = scanner.nextInt();
                System.out.print("Enter the column (0-" + (BOARD_SIZE - 1) + "): ");
                col = scanner.nextInt();
            } while (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] == 'S');

            board[row][col] = 'S';
        }
    }

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your turn.");
        int row, col;
        do {
            System.out.print("Enter the row (0-" + (BOARD_SIZE - 1) + "): ");
            row = scanner.nextInt();
            System.out.print("Enter the column (0-" + (BOARD_SIZE - 1) + "): ");
            col = scanner.nextInt();
        } while (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE);

        if (computerBoard[row][col] == 'S') {
            System.out.println("You hit a ship!");
            computerBoard[row][col] = 'X';
            computerShips--;
        } else {
            System.out.println("You missed!");
            computerBoard[row][col] = 'O';
        }
    }

    private void computerTurn() {
        System.out.println("Computer's turn.");
        int row, col;
        do {
            row = (int) (Math.random() * BOARD_SIZE);
            col = (int) (Math.random() * BOARD_SIZE);
        } while (playerBoard[row][col] == 'X' || playerBoard[row][col] == 'O');

        if (playerBoard[row][col] == 'S') {
            System.out.println("Computer hit your ship!");
            playerBoard[row][col] = 'X';
            playerShips--;
        } else {
            System.out.println("Computer missed!");
            playerBoard[row][col] = 'O';
        }
    }

    private boolean isGameOver() {
        return playerShips == 0 || computerShips == 0;
    }

    public void play() {
        System.out.println("Welcome to Battleship!");
        System.out.println("You have " + NUM_SHIPS + " ships to place.");

        placeShips(playerBoard, NUM_SHIPS);
        placeShips(computerBoard, NUM_SHIPS);

        playerShips = NUM_SHIPS;
        computerShips = NUM_SHIPS;

        while (!isGameOver()) {
            System.out.println("Your board:");
            printBoard(playerBoard);
            System.out.println("Computer's board:");
            printBoard(computerBoard);

            playerTurn();
            if (isGameOver()) {
                break;
            }

            computerTurn();
        }

        if (playerShips == 0) {
            System.out.println("You lost. Game over!");
        } else {
            System.out.println("Congratulations! You won!");
        }
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.play();
    }
}
