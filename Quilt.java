
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Quilt extends JPanel {

    public static ArrayList<Square> squares = new ArrayList<Square>();
    public static ArrayList<Double> scale = new ArrayList<Double>();
    public static ArrayList<Integer> r = new ArrayList<Integer>();
    public static ArrayList<Integer> g = new ArrayList<Integer>();
    public static ArrayList<Integer> b = new ArrayList<Integer>();
    int size = 0;

    public Quilt(ArrayList<Double> scale, ArrayList<Integer> r,
                 ArrayList<Integer> g, ArrayList<Integer> b) {
        this.scale = scale;
        this.r = r;
        this.g= g;
        this.b = b;
        setPreferredSize(new Dimension(1024,800));
    }

    public void buildQuilt(int layer, int []centrePoint) {
        double max = 0;
        if (layer == scale.size()) {
            return;
        }

        if (centrePoint[0] == -1) {
            centrePoint[0] = 512;
            centrePoint[1] = 400;

            for (int i = 0; i < scale.size(); i++) {
                if (scale.get(i) > max) {
                    max = scale.get(i);
                }
            }
            size = (int) (400/max);
        }
        Color colour = new Color(r.get(layer), g.get(layer), b.get(layer));
        Square square = new Square(centrePoint, scale.get(layer), colour);
        squares.add(square);
        layer++;

        if (layer < scale.size()) {
            buildQuilt(layer, square.topLeft);
            buildQuilt(layer, square.topRight);
            buildQuilt(layer, square.bottomLeft);
            buildQuilt(layer, square.bottomRight);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < squares.size(); i++) {
            squares.get(i).display(g);
        }
    }
    
}
