import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Choose your matchup: ");
    JButton singleButton = new JButton("Single");
    JButton groupButton = new JButton("Group");

    WelcomePage() {
        welcomeLabel.setBounds(100, 20, 2000, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 20));

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);  //I dont want a layout manager
        frame.setVisible(true);

        singleButton.setBounds(60, 100, 300, 50);
        singleButton.setFocusable(false);  //this removes the borders around the buttons
        singleButton.addActionListener(this);

        groupButton.setBounds(60, 200, 300, 50);
        groupButton.setFocusable(false);  //this removes the borders around the buttons
        groupButton.addActionListener(this);


        frame.add(singleButton);
        frame.add(groupButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == singleButton) {
            Courts courts = new Courts();
        } else if (e.getSource() == groupButton) {
            Courts courts = new Courts();
        }
    }
}
