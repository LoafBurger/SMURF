import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;

public class SinglePage {
    int holder = 0;
    Random random = new Random();
    int temp = random.nextInt(10) + 2;
    JFrame frame = new JFrame();
    JLabel queueLabel = new JLabel("");
    JLabel waitingLabel = new JLabel(temp + " more people until your turn...");
    SinglePage(int temp) {
        this.holder = temp;
        queueLabel.setBounds(150, 100, 120, 35);
        queueLabel.setFont(new Font(null, Font.PLAIN, 20));
        Border border = BorderFactory.createLineBorder(Color.BLACK,5);
        queueLabel.setBorder(border);

        waitingLabel.setBounds(60, 180, 2000, 35);
        waitingLabel.setFont(new Font(null, Font.PLAIN,20));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true); //so we can actually see it

        frame.add(queueLabel);
        frame.add(waitingLabel);
        queueLabel.setText(holder + "x" + holder + " queue");

    }
}
