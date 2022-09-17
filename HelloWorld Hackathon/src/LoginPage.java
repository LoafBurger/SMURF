import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login"); //Parameter what the button shows
    JButton resetButton = new JButton("Reset"); //Parameter what the button shows
    JTextField userIDField = new JTextField();  //user input
    JPasswordField userPasswordField = new JPasswordField();    //password input

    //creating the different labels that will be added later
    JLabel programName = new JLabel("Dribblink");
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("password: ");
    JLabel messageLabel = new JLabel("");

    //image
    ImageIcon image = new ImageIcon(getClass().getResource("DribbLink.jpeg"));
    JLabel displayImage = new JLabel(image);
    HashMap<String, String> logininfo = new HashMap<String, String>();
    LoginPage(HashMap<String, String> loginInfoOriginal) {
        logininfo = loginInfoOriginal;  //copy of hashmap that is globally available.

        programName.setBounds(160, 0, 2000, 35);
        programName.setFont(new Font(null, Font.PLAIN, 20));

        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);   //creating the bounds of the text field
        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);  //this removes the borders around the buttons
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);  //this removes the borders around the buttons
        resetButton.addActionListener(this);

        displayImage.setBounds(170, 260, 110, 110);
        displayImage.setVisible(true);

        frame.add(programName);
        frame.add(messageLabel);
        frame.add(userIDLabel); //the add function actually creates the labels on the screen.
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(displayImage);

        //creating the login page
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true); //so we can actually see it


    }

    @Override
    public void actionPerformed(ActionEvent e) {    //handle events with this
        if(e.getSource() == resetButton) {  //everytime the reset button gets clicked
            userIDField.setText("");    //reset the text field like we are clearing it
            userPasswordField.setText("");
            messageLabel.setText("");
        }

        if(e.getSource() == loginButton) {//when you cick the login button to try and sign in
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());//retrieve the passowrd, change to string, and store in a string called password

            if(logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");
                    WelcomePage welcomePage = new WelcomePage();
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Incorrect Password");
                }
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Incorrect Username");
            }
        }
    }
}
