import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Player {

    // Instance Variables
    private int[] box;
    private boolean gameOver;
    private GameView viewer;
    private Image closed, open;
    private boolean gameOverWin;

    // Constructor
    public Player(GameView viewer) {
        box = new int[12];
        gameOver = false;
        gameOverWin = false;
        this.closed = new ImageIcon("Resources/Closed.png").getImage();
        this.open = new ImageIcon("Resources/Open.png").getImage();
        this.viewer = viewer;
    }

    // Shuts corresponding tile
    public void shutTile(int a) {
        // Check if there is a valid input
        if (gameOver){
            return;
        }
        if (box[a-1] == 0) {
            System.out.println("Game Over - You Cant Flip A Tile Twice");
            // Flags game as over
            gameOver = true;
        } else {
            // Shut tile
            box[a - 1] = 0;
        }
    }

    // Check if game is won
    public void isWon() {
        // Checks if all integers in array are 0
        for (int i = 0; i < 12; i++) {
            if (box[i] != 0) {
                return;
            }
        }
        System.out.println("Congrats! You won!");
        gameOverWin = true;
        gameOver = true;
    }

    public boolean gameOverWin() {
        return this.gameOverWin;
    }

    // Creates and prints the box
    public void boxInitialize() {
        // Create the box with numbers 1-12
        for (int i = 0; i < 12; i++) {
            box[i] = i + 1;
        }
        // Print the box
        System.out.println(Arrays.toString(box));
    }

    // Returns true if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < 12; i++) {
            if (box[i] == 0) {
                g.drawImage(closed, viewer.BOX_X + (i * 50), viewer.BOX_Y, viewer.BOX_WIDTH, viewer.BOX_HEIGHT, viewer);
            }
            else {
                g.drawImage(open, viewer.BOX_X + (i * 50), viewer.BOX_Y - 25, viewer.BOX_WIDTH, viewer.BOX_HEIGHT, viewer);
            }
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(i + 1), viewer.BOX_X + 30 + ((viewer.BOX_WIDTH - 20) * i), viewer.BOX_Y + 50);
        }
    }

    // Prints box
    public String toString() {
        return Arrays.toString(box);
    }
}