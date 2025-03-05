import javax.swing.*;
import java.awt.*;

public class Die {

    // Instance Variable
    private int numSides;

    // Constructor
    public Die() {
        numSides = 6;
    }

    // Rolls dice and returns random int
    public int roll() {
        return (int) (Math.random() * numSides + 1);
    }

    // Returns string
    public String toString() {
        return "Rolling both " + numSides + "-sided dice.";
    }
}