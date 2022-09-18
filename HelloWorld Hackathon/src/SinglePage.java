import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SinglePage implements ActionListener {

    JButton leaveButton = new JButton("Leave");
    int holder = 0;
    Random random = new Random();
    int temp = random.nextInt(10) + 2;
    JFrame frame = new JFrame();
    JLabel queueLabel = new JLabel("");
    //JLabel waitingLabel = new JLabel(temp + " more people until your turn...");

    //image
    //Turns the JPEG of the logo into a BufferedImage object
    BufferedImage pic = null;
    JLabel label;
    BufferedImage newPic;
    Graphics2D graphics2D;
    SinglePage(int temp) {

        //
        try {
            pic = ImageIO.read(new File("/Users/olicheung/IdeaProjects/HelloWorld Hackathon/src/DribbLink.jpeg"));
            System.out.println("Yay");
        } catch(IOException e) {}
        // Resizes the logo to fit in the JFrame Window
        newPic = new BufferedImage(420, 420, BufferedImage.TYPE_INT_RGB);
        graphics2D = newPic.createGraphics();
        graphics2D.drawImage(pic, 0, 0, 455, 420, null);
        graphics2D.dispose();


        label = new JLabel(new ImageIcon(newPic));

        label.setBounds(0, 0, 420, 420);
        label.setVisible(true);

        leaveButton.setBounds(0, 350, 100, 25);
        leaveButton.setFocusable(false);  //this removes the borders around the buttons
        leaveButton.addActionListener(this);

        this.holder = temp;
        queueLabel.setBounds(70, 10, 280, 35);
        queueLabel.setFont(new Font(null, Font.PLAIN, 20));
        Border border = BorderFactory.createLineBorder(Color.BLACK,5);
        queueLabel.setBorder(border);

        //waitingLabel.setBounds(60, 40, 2000, 35);
        //waitingLabel.setFont(new Font(null, Font.PLAIN,20));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true); //so we can actually see it

        frame.add(queueLabel);
        //frame.add(waitingLabel);
        queueLabel.setText("Waiting for " + holder + " more people...");
        frame.add(leaveButton);
        frame.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leaveButton) {
            frame.dispose();
        }
    }
}
