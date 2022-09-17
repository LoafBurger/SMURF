import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

public class Smurf {
    public static void main(String[] args) {

        // Turns the JPEG of the logo into a BufferedImage object
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("/Users/edwardkelley/IdeaProjects/Smurf/src/logo.jpeg"));
            System.out.println("Yay");
        } catch(IOException e) {}

        // Resizes the logo to fit in the JFrame Window
        BufferedImage newPic = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = newPic.createGraphics();
        graphics2D.drawImage(pic, 0, 0, 500, 500, null);
        graphics2D.dispose();

        // Creates the JFrame Window and a JLabel that contains the logo
        JFrame screen = new JFrame();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(newPic));

        // Titles the JFrame and sets the size of the Window to match the logo
        screen.setTitle("DribbLink");
        screen.setSize(new Dimension(500, 500));

        // Adds the JLabel to the JFrame Window and makes the Window visible
        screen.add(label);
        screen.setVisible(true);

        // Makes the program end when the JFrame Window is closed
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
