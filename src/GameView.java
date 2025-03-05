import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    // Instance Variables
    public final int BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT, FELT_X, FELT_Y, FELT_WIDTH, FELT_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT, DICE_X, DICE_Y;
    private Game game;
    private Image board, one, two, three, four, five, six, felt;
    private int gameOver;

    // Constructor
    public GameView(Game game) {
        // Set instance variable to proper values
        this.game = game;
        this.BOX_X = 240;
        this.BOX_Y = 300;
        this.BOX_WIDTH = 70;
        this.BOX_HEIGHT = 100;
        this.FELT_X = 300;
        this.FELT_Y = 600;
        this.DICE_X = 480;
        this.DICE_Y = 650;
        this.FELT_WIDTH = 300;
        this.FELT_HEIGHT = 200;
        this.WINDOW_WIDTH = 1100;
        this.WINDOW_HEIGHT = 1100;
        this.board = new ImageIcon("Resources/Board.png").getImage();
        this.one = new ImageIcon("Resources/One.png").getImage();
        this.two = new ImageIcon("Resources/Two.png").getImage();
        this.three = new ImageIcon("Resources/Three.png").getImage();
        this.four = new ImageIcon("Resources/Four.png").getImage();
        this.five = new ImageIcon("Resources/Five.png").getImage();
        this.six = new ImageIcon("Resources/Six.png").getImage();
        this.felt = new ImageIcon("Resources/Felt.png").getImage();

        // Initialize the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Shut The Box");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    // Draws out the instructions, game, and end of game scenarios
    public void paint(Graphics g) {
        super.paint(g);
        // First time printed it prints the instructions
        if (game.getInstructions()) {
            drawInstructions(g);
        }
        // Every other time draw the board first, then the dice, then the boxes
        else {
            drawBoard(g);
            drawDice(g);
            game.p1.draw(g);
            // If the game is over draw the end screen
            if (this.gameOver > 0) {
                drawEndScreen(g);
            }
        }
    }

    // Draws out instructions of the game
    public void drawInstructions(Graphics g) {
        // Set the font
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.BLACK);

        // Write the instructions
        g.drawString("Welcome to Shut The Box!", 50, 50);
        g.drawString("Each turn you will automatically roll dice which will appear on the felt on the screen!", 50, 80);
        g.drawString("After each roll type 'each' to shut the box corresponding to the first roll and corresponding to the second roll", 50, 110);
        g.drawString("or you can type sum to shut the box corresponding to the sum of both dice", 50, 140);
        g.drawString("If you shut all the boxes you win!", 50, 170);
        g.drawString("Type 'start' to start the game. Good Luck :)", 50, 200);
    }

    // Draws the board - both the background image and the felt
    public void drawBoard(Graphics g) {
        g.drawImage(board, 0, 0, 1100, 1100, this);
        g.drawImage(felt, FELT_X, FELT_Y, 500, 200, this);
    }

    // Draws the dice after every new roll
    public void drawDice(Graphics g) {
        // For each die print the corresponding image
        switch (game.roll1) {
            case 1:
                g.drawImage(one, DICE_X, DICE_Y, 50, 50, this);
                break;
            case 2:
                g.drawImage(two, DICE_X, DICE_Y, 50, 50, this);
                break;
            case 3:
                g.drawImage(three, DICE_X, DICE_Y, 50, 50, this);
                break;
            case 4:
                g.drawImage(four, DICE_X, DICE_Y, 50, 50, this);
                break;
            case 5:
                g.drawImage(five, DICE_X, DICE_Y, 50, 50, this);
                break;
            case 6:
                g.drawImage(six, DICE_X, DICE_Y, 50, 50, this);
                break;
        }
        switch (game.roll2) {
            case 1:
                g.drawImage(one, DICE_X + 100, DICE_Y, 50, 50, this);
                break;
            case 2:
                g.drawImage(two, DICE_X + 100, DICE_Y, 50, 50, this);
                break;
            case 3:
                g.drawImage(three, DICE_X + 100, DICE_Y, 50, 50, this);
                break;
            case 4:
                g.drawImage(four, DICE_X + 100, DICE_Y, 50, 50, this);
                break;
            case 5:
                g.drawImage(five, DICE_X + 100, DICE_Y, 50, 50, this);
                break;
            case 6:
                g.drawImage(six, DICE_X + 100, DICE_Y, 50, 50, this);
                break;
        }
    }

    // Set the game over variable
    public void gameOver(int a) {
        this.gameOver = a;
    }

    // Draw the end screen based on the type of game over scenario
    public void drawEndScreen(Graphics g) {
        drawBoard(g);
        // If game over scenario 1 - the player loses
        if (gameOver == 1) {
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(Color.BLACK);
            g.drawString("Game Over :(", BOX_X, BOX_Y);
        }
        // If game over scenario 2 - the player wins!
        if(gameOver == 2) {
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(Color.BLACK);
            g.drawString("You Win!", BOX_X, BOX_Y);
        }
    }
}
