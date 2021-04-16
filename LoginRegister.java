import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginRegister {

    static ArrayList<User> users = new ArrayList<>();

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
        JPasswordField passwordText;
        JButton loginButton;
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
                ArrayList<User> friends = new ArrayList<>();
                ArrayList<User> sent = new ArrayList<>();
                ArrayList<User> received = new ArrayList<>();
                User user = new User("admin", "admin", 2001, "Colten", "Glover", friends, sent, received, true);
                users.add(user);
                boolean loginSuccess = false;
                for (int i = 0; i < users.size(); i++) {
                    if (usernameText.getText().equals(users.get(i).getUsername()) && String.valueOf(passwordText.getPassword()).equals(users.get(i).getPassword())) {
                        //JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.PLAIN_MESSAGE);
                        user = users.get(i);
                        loginSuccess = true;
                        break;
                    }
                }
                if (!loginSuccess) {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Invalid Login", JOptionPane.ERROR_MESSAGE);
                } else {
                    login.setVisible(false);
                    login.dispose();
                    MainPage mainPage = new MainPage(user);
                }
            }
        });

        register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //REGISTER FRAME//
                JFrame regFrame = new JFrame("Register");
                regFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                regFrame.setLayout(new BorderLayout());
                regFrame.setSize(500, 500);
                //REGISTER FRAME//

                //REGISTER PANEL//
                JPanel regPanel = new JPanel();
                regPanel.setLayout(new GridBagLayout());
                GridBagConstraints gc = new GridBagConstraints();
                regFrame.setBackground(Color.LIGHT_GRAY);
                //REGISTER PANEL//

                //LABELS & THEIR TEXT FIELDS//
                JLabel fName = new JLabel("First Name: ");
                JTextField fNameTxt = new JTextField(10);

                JLabel lName = new JLabel("Last Name: ");
                JTextField lNameTxt = new JTextField(10);

                JLabel username = new JLabel("Username: ");
                JTextField usernameTxt = new JTextField(10);

                JLabel password = new JLabel("Password: ");
                JPasswordField passwordTxt = new JPasswordField(10);

                JLabel confirmPassword = new JLabel("Confirm Password: ");
                JPasswordField confirmPasswordTxt = new JPasswordField(10);

                JLabel birthYear = new JLabel("Birth Year: ");
                JTextField birthYearTxt = new JTextField(4);
                //LABELS & THEIR TEXT FIELDS//

                //REGISTRATION BUTTONS//
                JButton submit = new JButton("Submit");
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boolean isTaken = false;
                        int i = 0;
                        try {
                            if (usernameTxt.getText().isBlank() || usernameTxt.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Username is required", "Username Error", JOptionPane.ERROR_MESSAGE);
                            } else if (usernameTxt.getText().length() > 10) {
                                JOptionPane.showMessageDialog(null, "Username must be less than 11 characters", "Username Error", JOptionPane.ERROR_MESSAGE);
                            } else if (usernameTxt.getText().length() < 3) {
                                JOptionPane.showMessageDialog(null, "Username must be longer than 2 characters", "Username Error", JOptionPane.ERROR_MESSAGE);
                            } else if (String.valueOf(passwordTxt.getPassword()).isBlank() || String.valueOf(passwordTxt.getPassword()).isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Password is required", "Password Error", JOptionPane.ERROR_MESSAGE);
                            } else if (String.valueOf(passwordTxt.getPassword()).length() < 3) {
                                JOptionPane.showMessageDialog(null, "Password must be longer than 2 characters", "Password Error", JOptionPane.ERROR_MESSAGE);
                            } else if (String.valueOf(passwordTxt.getPassword()).length() > 20) {
                                JOptionPane.showMessageDialog(null, "Password must be less than 21 characters", "Password Error", JOptionPane.ERROR_MESSAGE);
                            } else if (!String.valueOf(passwordTxt.getPassword()).equals(String.valueOf(confirmPasswordTxt.getPassword()))) {
                                JOptionPane.showMessageDialog(null, "Passwords do not match", "Password Error", JOptionPane.ERROR_MESSAGE);
                            } else if (Integer.parseInt(birthYearTxt.getText()) > 2010) {
                                JOptionPane.showMessageDialog(null, "Must be born before 2011", "Age Error", JOptionPane.ERROR_MESSAGE);
                            } else if (fNameTxt.getText().isEmpty() || fNameTxt.getText().isBlank() || lNameTxt.getText().isBlank() || lNameTxt.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "First & last names must not be blank", "Name Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                while (!isTaken && i < users.size()) {
                                    if (usernameTxt.getText().equals(users.get(i).getUsername())) {
                                        isTaken = true;
                                        JOptionPane.showMessageDialog(null, "Username is taken", "Username in Use", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        i++;
                                    }
                                }
                                if (!isTaken) {
                                    ArrayList<User> friends = new ArrayList<>();
                                    ArrayList<User> sent = new ArrayList<>();
                                    ArrayList<User> received = new ArrayList<>();
                                    User user = new User(usernameTxt.getText(), String.valueOf(passwordTxt.getPassword()), Integer.parseInt(birthYearTxt.getText()), fNameTxt.getText(), lNameTxt.getText(), friends, sent, received, false);
                                    users.add(user);
                                    regFrame.setVisible(false);
                                    regFrame.dispose();
                                }
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Year must be an integer", "Year Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                JButton cancel = new JButton("Cancel");
                cancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        regFrame.setVisible(false);
                        regFrame.dispose();
                    }
                });
                //REGISTRATION BUTTONS//

                //ADDING LABELS//
                gc.gridx = 0;
                gc.gridy = 0;
                gc.anchor = GridBagConstraints.FIRST_LINE_END;
                regPanel.add(fName, gc);
                gc.gridy++;
                regPanel.add(lName, gc);
                gc.gridy++;
                regPanel.add(username, gc);
                gc.gridy++;
                regPanel.add(password, gc);
                gc.gridy++;
                regPanel.add(confirmPassword, gc);
                gc.gridy++;
                regPanel.add(birthYear, gc);
                //ADDING LABELS//

                //ADDING TEXT FIELDS//
                gc.gridx = 1;
                gc.gridy = 0;
                gc.anchor = GridBagConstraints.FIRST_LINE_START;
                regPanel.add(fNameTxt, gc);
                gc.gridy++;
                regPanel.add(lNameTxt, gc);
                gc.gridy++;
                regPanel.add(usernameTxt, gc);
                gc.gridy++;
                regPanel.add(passwordTxt, gc);
                gc.gridy++;
                regPanel.add(confirmPasswordTxt, gc);
                gc.gridy++;
                regPanel.add(birthYearTxt, gc);
                //ADDING TEXT FIELDS//

                gc.gridy++;
                gc.gridy++;
                regPanel.add(submit, gc);
                gc.gridy--;
                regPanel.add(cancel, gc);

                regFrame.add(regPanel, BorderLayout.CENTER);
                regFrame.setLocationRelativeTo(null);
                regFrame.setVisible(true);
            }
        });
        //LOGIN & REGISTER BUTTONS//

        //ADDING LOGIN & REGISTER BUTTONS//
        g.anchor = GridBagConstraints.CENTER;
        g.gridx = 1;
        g.gridy = 2;
        loginPanel.add(loginButton, g);
        g.gridy++;
        loginPanel.add(register, g);
        //ADDING LOGIN & REGISTER BUTTONS//

        login.add(loginPanel, BorderLayout.CENTER);
        login.setLocationRelativeTo(null);
        login.setVisible(true);

    }
}
