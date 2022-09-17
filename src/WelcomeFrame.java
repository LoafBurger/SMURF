import javax.swing.*;
import java.awt.*;
public class WelcomeFrame extends JFrame {
    JPanel Welcome;
    WelcomeFrame() {
        //Setting up the frame
        this.setTitle("Welcome");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Welcome Panel
        Welcome = new JPanel();
        Welcome.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        Welcome.setBackground(Color.CYAN);
        Welcome.setLayout(new GridLayout(3, 0));
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        Welcome.add(one);
        Welcome.add(two);
        Welcome.add(three);
        Welcome.add(four);
        Welcome.add(five);
        Welcome.add(six);
        Welcome.add(seven);
        Welcome.add(eight);
        Welcome.add(nine);
        this.add(Welcome);






        this.setVisible(true);
    }
}
