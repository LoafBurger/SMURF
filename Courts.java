import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Courts implements ActionListener {
    JFrame frame = new JFrame();
    JLabel tbt = new JLabel("3v3");
    JLabel fbf = new JLabel("5v5");
    JLabel ovo = new JLabel("1v1");
    JButton button = new JButton("Queue");
    JButton button1 = new JButton("Queue");
    JButton button2 = new JButton("Queue");

    Courts() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true); //so we can actually see it

        tbt.setBounds(30, 100, 100, 55);
        tbt.setFont(new Font(null, Font.PLAIN, 50));
        Border border = BorderFactory.createLineBorder(Color.BLACK,5);
        tbt.setBorder(border);

        fbf.setBounds(150, 100, 100, 55);
        fbf.setFont(new Font(null, Font.PLAIN, 50));
        Border border1 = BorderFactory.createLineBorder(Color.BLACK,5);
        fbf.setBorder(border);

        ovo.setBounds(270, 100, 100, 55);
        ovo.setFont(new Font(null, Font.PLAIN, 50));
        Border border2 = BorderFactory.createLineBorder(Color.BLACK,5);
        ovo.setBorder(border);


        button.setBounds(30, 200, 100, 30);
        button.setFocusable(false);  //this removes the borders around the buttons
        button.addActionListener(this);

        button1.setBounds(150, 200, 100, 30);
        button1.setFocusable(false);  //this removes the borders around the buttons
        button1.addActionListener(this);

        button2.setBounds(270, 200, 100, 30);
        button2.setFocusable(false);  //this removes the borders around the buttons
        button2.addActionListener(this);

        frame.add(tbt);
        frame.add(fbf);
        frame.add(ovo);
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            SinglePage singplepage = new SinglePage(3);
        } else if(e.getSource() == button1) {
            SinglePage singplepage = new SinglePage(5);
        } else if (e.getSource() == button2) {
            SinglePage singplepage = new SinglePage(1);
        }
    }
}
