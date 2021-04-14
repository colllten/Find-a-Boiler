import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegister {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JLabel username;
        JLabel password;
        JTextField usernameText;
        JTextField passwordText;
        JButton submit;
        JButton register;

        //FRAME CREATION//
        JFrame login = new JFrame("Login");
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLayout(new BorderLayout());
        login.setSize(500, 500);
        //FRAME CREATION//

        //PANEL CREATION//
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        loginPanel.setBackground(Color.LIGHT_GRAY);
        //PANEL CREATION//

        //LABELS//
        username = new JLabel("Username: ");
        password = new JLabel("Password: ");
        //LABELS//

        //TEXT FIELDS//
        usernameText = new JTextField(10);
        passwordText = new JTextField(10);
        //TEXT FIELDS//

        //ADDING LABELS//
        g.gridx = 0;
        g.anchor = GridBagConstraints.FIRST_LINE_END;
        loginPanel.add(username, g);
        g.gridy++;
        g.gridy++;
        loginPanel.add(password, g);
        //ADDING LABELS//

        //ADDING TEXT FIELDS//
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.gridx = 1;
        g.gridy = 0;
        loginPanel.add(usernameText, g);
        g.gridy++;
        loginPanel.add(passwordText, g);
        //ADDING TEXT FIELDS//

        //LOGIN & REGISTER BUTTONS//
        submit = new JButton("Login");
        register = new JButton("Register");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submit works");
            }
        });
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register works");
            }
        });
        //LOGIN & REGISTER BUTTONS//

        //ADDING LOGIN & REGISTER BUTTONS//
        g.anchor = GridBagConstraints.CENTER;
        g.gridx = 1;
        g.gridy = 2;
        loginPanel.add(submit, g);
        g.gridy++;
        loginPanel.add(register, g);
        //ADDING LOGIN & REGISTER BUTTONS//

        login.add(loginPanel, BorderLayout.CENTER);
        login.setVisible(true);

    }
}
