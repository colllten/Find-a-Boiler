import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserTest {

    private static String username;
    private static String password;
    private static String birthMonth;
    private static int birthYear;
    private static int birthDay;

    private static JButton submit;
    private static JButton register;
    private static JButton regSubmit;
    private static JTextField usernameInput;
    private static JPasswordField passwordInput;

    private static JTextField usernameText;
    private static JTextField passText;


    private static String[] month = {"January", "February", "March", "April", "May", "June", "July", "August",
                                        "September", "October", "November", "December"};
    private static JComboBox<String> months = new JComboBox<>();

    private static UserTest[] activeUsers;

    public UserTest(String username, String password, String birthMonth, int birthYear, int birthDay) {
        username = username;
        this.password = password;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.birthDay = birthDay;
    }

    static ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                System.out.println("Submit Worked!");
            }

            if (e.getSource() == register) {

                JFrame frame = new JFrame("Register");
                frame.setLayout(new BorderLayout());
                frame.setSize(600, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JPanel panel = new JPanel(new GridBagLayout());
                JLabel usernameLabel = new JLabel("Username: ");
                JLabel passLabel = new JLabel("Password: ");
                JLabel firstNameLabel = new JLabel("First Name: ");
                JLabel lastNameLabel = new JLabel("Last Name: ");

                usernameText = new JTextField(null, 10);
                passText = new JTextField(10);
                JTextField firstNameText = new JTextField(10);
                JTextField lastNameText = new JTextField(10);

                regSubmit = new JButton("Submit");
                regSubmit.addActionListener(actionListener);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.weightx = 0.5;
                gbc.weighty = 0.1;
                gbc.anchor = GridBagConstraints.FIRST_LINE_END;

                //LABELS//
                gbc.gridx = 0;
                gbc.gridy = 0;
                panel.add(usernameLabel, gbc);
                gbc.gridy++;
                panel.add(passLabel, gbc);
                gbc.gridy++;
                panel.add(firstNameLabel, gbc);
                gbc.gridy++;
                panel.add(lastNameLabel, gbc);
                //LABELS//

                //TEXT FIELDS//
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridx = 1;
                gbc.gridy = 0;
                panel.add(usernameText, gbc);
                gbc.gridy++;
                panel.add(passText, gbc);
                gbc.gridy++;
                panel.add(firstNameText, gbc);
                gbc.gridy++;
                panel.add(lastNameText, gbc);
                //TEXT FIELDS//

                //BIRTHDAY LABELS//
                JLabel birthMonth = new JLabel("Birth Month: ");
                gbc.gridx = 0;
                gbc.gridy++;
                gbc.anchor = GridBagConstraints.FIRST_LINE_END;
                panel.add(birthMonth, gbc);
                JLabel birthDay = new JLabel("Day: ");
                JLabel birthYear = new JLabel("Year: ");
                gbc.gridy++;
                panel.add(birthDay, gbc);
                gbc.gridy++;
                panel.add(birthYear, gbc);
                //BIRTHDAY LABELS//

                //BIRTHDAY COMPONENTS//
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                for (int i = 0; i < month.length; i++) {
                    months.addItem(month[i]);
                }
                gbc.gridx = 1;
                gbc.gridy = 4;
                panel.add(months, gbc);
                JTextField day = new JTextField(3);
                JTextField year = new JTextField(4);
                gbc.gridy++;
                panel.add(day, gbc);
                gbc.gridy++;
                panel.add(year, gbc);
                //BIRTHDAY COMPONENTS//


                gbc.gridx = 1;
                gbc.gridy++;
                panel.add(regSubmit, gbc);

                frame.add(panel, BorderLayout.CENTER);
                frame.setVisible(true);
            }

            if (e.getSource() == regSubmit) {
                if (usernameText.getText().length() < 3) {
                    JOptionPane.showMessageDialog(null, "Username must be longer than 2 characters", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (usernameText.getText().length() > 10) {
                    JOptionPane.showMessageDialog(null, "Username must be less than 11 characters", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    username = usernameText.getText();
                    System.out.println("Username: " + username);
                }

                if (passText.getText().length() < 3) {
                    JOptionPane.showMessageDialog(null, "Password must be longer than 2 characters", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (passText.getText().length() > 10) {
                    JOptionPane.showMessageDialog(null, "Password must be less than 11 characters", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    password = passText.getText();
                    System.out.println("Password: " + password);
                }


            }
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        //JOptionPane.showMessageDialog(null, "Welcome to Social Media.", "Welcome", JOptionPane.INFORMATION_MESSAGE);

        JFrame frame = new JFrame("Sign In");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel login = new JPanel();
        usernameInput = new JTextField(null, 10);
        JLabel username = new JLabel("Username: ");
        passwordInput = new JPasswordField(null, 10);
        JLabel password = new JLabel("Password: ");
        login.add(username);
        login.add(usernameInput);
        login.add(password);
        login.add(passwordInput);
        frame.add(login, BorderLayout.CENTER);

        JPanel submitPanel = new JPanel();
        submit = new JButton("Submit");
        submit.addActionListener(actionListener);
        register = new JButton("Register");
        register.addActionListener(actionListener);
        submitPanel.add(submit);
        submitPanel.add(register);
        frame.add(submitPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }


}
