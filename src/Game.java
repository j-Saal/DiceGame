// Shut the Box by Jared Saal
import java.util.Scanner;

public class Game {

    // Instance Variables
    private Die d1;
    public Player p1;
    private Scanner input;
    private GameView window;
    public int roll1, roll2;
    private boolean instructions;

    // Constructor
    public Game() {
        window = new GameView(this);
        d1 = new Die();
        p1 = new Player(window);
        input = new Scanner(System.in);
        roll1 = 0;
        roll2 = 0;
        instructions = true;
    }

    // Rolls the dice and shuts corresponding tiles based on input
    public void roll() {
        // Roll both dice and print the results
        System.out.println(d1);
        roll1 = d1.roll();
        roll2 = d1.roll();
        window.repaint();
        System.out.println("You rolled a " + roll1 + " and a " + roll2);
        System.out.println("Would you like to shut the sum or each?");
        String choice = input.nextLine();
        // Shut  tiles
        shut(choice, roll1, roll2);
    }

    // Shuts tiles in the box
    public void shut(String choice, int roll1, int roll2) {
        // If user wants sum, shut the tile with sum
        if (choice.equals("sum")) {
            p1.shutTile((roll1 + roll2));

        }
        // If user wants each, shut both tiles
        else if (choice.equals("each")) {
            p1.shutTile(roll1);
            p1.shutTile(roll2);
        }
        // Check if game is won
        p1.isWon();
        // Print gameboard after shut tiles
        if (!p1.isGameOver()) {
            System.out.println(p1);
        }
    }

    // Prints instructions and initializes box
    public void setUp() {
        String startInput;
        // Wait to start the game until player types start
        do {
            startInput = input.nextLine();
        } while (!startInput.equals("start"));
        instructions = false;
        p1.boxInitialize();
    }

    // Play game until player loses or box is shut
    public void playGame() {
        setUp();
        while (!p1.isGameOver()) {
            roll();
        }
        if (p1.gameOverWin()) {
            window.gameOver(2);
        }
        else {
            window.gameOver(1);
        }
        window.repaint();
    }

    // Returns instance variable instructions
    public boolean getInstructions() {
        return this.instructions;
    }

    // Creates a instance of game and plays it
    public static void main(String[] args) {
        Game g = new Game();
        g.playGame();
    }
}