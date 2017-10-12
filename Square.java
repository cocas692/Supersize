import java.awt.*;

public class Square {

    int [] centre;
    int [] topLeft;
    int [] topRight;
    int [] bottomLeft;
    int [] bottomRight;
    int size;
    Color colour;

    public Square(int[] centre, double scale, Color colour) {
        int beginSize = 35;
        this.centre = centre;
        this.colour = colour;
        this.size = (int)scale * beginSize;
        topLeft = new int [] {centre[0]-(size/2), centre[1]-(size/2)};
        topRight = new int [] {centre[0]+(size/2), centre[1]-(size/2)};
        bottomLeft = new int [] {centre[0]-(size/2), centre[1]+(size/2)};
        bottomRight = new int [] {centre[0]+(size/2), centre[1]+(size/2)};

    }

    public void display(Graphics g) {
        g.setColor(colour);
        g.fillRect(topLeft[0],topLeft[1], size, size);
    }
}
