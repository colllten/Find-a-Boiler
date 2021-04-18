import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class LoginFrame extends JFrame {
    JLabel username;
    JLabel password;
    JTextField usernameText;
    JPasswordField passwordText;
    JButton loginButton;
    JButton register;

    public LoginFrame() throws IOException {
        //FRAME CREATION//
        setTitle("Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Temporary (maybe)
        setLayout(new BorderLayout());
        setSize(500, 500);
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
        passwordText = new JPasswordField(10);
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
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //CHECKING SERVER IF USERNAME IS THERE//
                User user = new User();
                boolean loginSuccess = false;
                for (int i = 0; i < Server.totalUsers.size(); i++) {
                    if (usernameText.getText().equals(Server.totalUsers.get(i).getUsername()) && String.valueOf(passwordText.getPassword()).equals(Server.totalUsers.get(i).getPassword())) {
                        //JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.PLAIN_MESSAGE);
                        user = Server.totalUsers.get(i);
                        Server.activeUsers.add(user);
                        user.setOnline(true);
                        loginSuccess = true;
                        break;
                    }
                }
                if (!loginSuccess) {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Invalid Login", JOptionPane.ERROR_MESSAGE);
                } else {
                    setVisible(false);
                    dispose();
                    try {
                        MainPage mainPage = new MainPage(user);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterFrame rg = new RegisterFrame();
            }
        });
        //LOGIN AND REGISTER BUTTONS//

        //ADDING LOGIN & REGISTER BUTTONS//
        g.anchor = GridBagConstraints.CENTER;
        g.gridx = 1;
        g.gridy = 2;
        loginPanel.add(loginButton, g);
        g.gridy++;
        loginPanel.add(register, g);
        //ADDING LOGIN & REGISTER BUTTONS//

        setLocationRelativeTo(null);
        this.add(loginPanel, BorderLayout.CENTER);
        setVisible(true);
}
}
