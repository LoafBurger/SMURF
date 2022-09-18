import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CourtsGroups implements ActionListener {
    JFrame frame = new JFrame();
    JLabel tbt = new JLabel("3v3");
    JLabel fbf = new JLabel("5v5");
    JLabel queue = new JLabel("Queue: ");
    JLabel queue1 = new JLabel("Queue: ");
    JButton button = new JButton("Select");
    JButton button1 = new JButton("Select");

    //image
    //Turns the JPEG of the logo into a BufferedImage object
    BufferedImage pic = null;
    JLabel label;
    BufferedImage newPic;
    Graphics2D graphics2D;

    CourtsGroups() {

        try {
            pic = ImageIO.read(new File("/Users/olicheung/IdeaProjects/HelloWorld Hackathon/src/DribbLink.jpeg"));
            System.out.println("Yay");
        } catch(IOException e) {}
        // Resizes the logo to fit in the JFrame Window
        newPic = new BufferedImage(420, 420, BufferedImage.TYPE_INT_RGB);
        graphics2D = newPic.createGraphics();
        graphics2D.drawImage(pic, 0, 0, 435, 420, null);
        graphics2D.dispose();


        label = new JLabel(new ImageIcon(newPic));

        label.setBounds(0, 0, 420, 420);
        label.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true); //so we can actually see it

        tbt.setBounds(10, 140, 100, 55);
        tbt.setFont(new Font(null, Font.PLAIN, 50));
        Border border = BorderFactory.createLineBorder(Color.BLACK,5);
        tbt.setBorder(border);

        fbf.setBounds(315, 140, 100, 55);
        fbf.setFont(new Font(null, Font.PLAIN, 50));
        Border border1 = BorderFactory.createLineBorder(Color.BLACK,5);
        fbf.setBorder(border);

        button.setBounds(10, 200, 100, 30);
        button.setFocusable(false);  //this removes the borders around the buttons
        button.addActionListener(this);

        button1.setBounds(315, 200, 100, 30);
        button1.setFocusable(false);  //this removes the borders around the buttons
        button1.addActionListener(this);

        frame.add(tbt);
        frame.add(fbf);
        frame.add(button);
        frame.add(button1);
        frame.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            SinglePage singplepage = new SinglePage(3);
        } else if(e.getSource() == button1) {
            SinglePage singplepage = new SinglePage(5);
        }
    }
}
