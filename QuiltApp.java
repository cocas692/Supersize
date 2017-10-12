import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class QuiltApp implements ActionListener {
    
    public static ArrayList<String> input = new ArrayList<String>();
    public static ArrayList<Double> scale = new ArrayList<Double>();
    public static ArrayList<Integer> r = new ArrayList<Integer>();
    public static ArrayList<Integer> g = new ArrayList<Integer>();
    public static ArrayList<Integer> b = new ArrayList<Integer>();
    public static JButton button;
    public static JSlider slider;
    public static JTextField layerValue;
    public static JTextField rValue;
    public static JTextField gValue;
    public static JTextField bValue;
    public static JFrame frame;
    public static Quilt quilt;
    
    public static void main(String[] args) {
        System.out.println("Starting...");
        Scanner input = new Scanner(System.in);
        boolean finish = true;
        while (finish && input.hasNextLine()) {
            String in = input.nextLine();
            
            if (!in.isEmpty()) {
                String[] inList = in.split("\\s");
                scale.add(Double.parseDouble(inList[0]));
                r.add(Integer.parseInt(inList[1]));
                g.add(Integer.parseInt(inList[2]));
                b.add(Integer.parseInt(inList[3]));
            }
        }
        
        button = new JButton("Change Colour");
        JLabel layerText = new JLabel("Layer: ");
        layerValue = new JTextField();
        layerValue.setColumns(3);
        JLabel rText = new JLabel("R: ");
        rValue = new JTextField();
        rValue.setColumns(3);
        JLabel gText = new JLabel("G: ");
        gValue = new JTextField();
        gValue.setColumns(3);
        JLabel bText = new JLabel("B: ");
        bValue = new JTextField();
        bValue.setColumns(3);
        
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMaximum(20);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);
        
        QuiltApp listener = new QuiltApp();
        button.addActionListener(listener);
        
        System.out.println("Building...");
        frame = new JFrame();
        quilt = new Quilt(scale, r, g, b);
        
        quilt.add(button);
        quilt.add(layerText);
        quilt.add(layerValue);
        quilt.add(rText);
        quilt.add(rValue);
        quilt.add(gText);
        quilt.add(gValue);
        quilt.add(bText);
        quilt.add(bValue);
        quilt.add(slider);
        
        int [] nil = {-1,-1};
        quilt.buildQuilt(0, nil);
        
        
        frame.setLayout(new BorderLayout());
        frame.add(quilt, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
    public void actionPerformed (ActionEvent event){
        int rInt,gInt,bInt,layerIndex;
        double sDouble;
        
        if (event.getSource() == button){
            System.out.println("Working");
            rInt = Integer.parseInt(rValue.getText());
            gInt = Integer.parseInt(gValue.getText());
            bInt = Integer.parseInt(bValue.getText());
            sDouble = (double) slider.getValue();
            layerIndex = Integer.parseInt(layerValue.getText());
            
            r.remove(layerIndex-1);
            g.remove(layerIndex-1);
            b.remove(layerIndex-1);
            scale.remove(layerIndex-1);
            r.add(layerIndex-1, rInt);
            g.add(layerIndex-1, gInt);
            b.add(layerIndex-1, bInt);
            scale.add(layerIndex-1, sDouble);
            
            
        }
        
        quilt = new Quilt(scale,r,g,b);
    
        
        int [] nil = {-1,-1};
        quilt.buildQuilt(0, nil);
        
        frame.add(quilt);
        frame.getContentPane().repaint();
        
    }
    
    
}

