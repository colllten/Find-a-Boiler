import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame {
    //TODO: add button to delete account

    public SettingsFrame(User user) {
        //FRAME CREATION//
        setTitle("Profile Settings");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);
        //FRAME CREATION//

        //PANEL CREATION//
        JPanel sp = new JPanel();
        sp.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        //PANEL CREATION//

        //LABELS & TEXT FIELDS//
        JLabel firstName = new JLabel("First Name: ");
        JTextField firstNameTxt = new JTextField(user.getFirstName(), 10);
        JLabel lastName = new JLabel("Last Name: ");
        JTextField lastNameTxt = new JTextField(user.getLastName(), 10);
        JLabel username = new JLabel("Username: ");
        JTextField usernameTxt = new JTextField(user.getUsername(), 10);
        JLabel newPassword = new JLabel("New Password: ");
        JPasswordField newPasswordTxt = new JPasswordField(user.getPassword(), 10);
        JLabel confirmNewPassword = new JLabel("Confirm New Password: ");
        JPasswordField confirmNewPasswordTxt = new JPasswordField(user.getPassword(), 10);
        JLabel email = new JLabel("Email: ");
        JTextField emailTxt = new JTextField(user.getEmail(), 10);
        JLabel bio = new JLabel("Bio: ");
        JTextField bioTxt = new JTextField(user.getBio(), 10);
        //LABELS & TEXT FIELDS//

        //BUTTONS//
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(firstNameTxt.getText().isBlank() || firstNameTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "First name cannot be empty", "Name Error", JOptionPane.ERROR_MESSAGE);
                } else if (lastNameTxt.getText().isBlank() || lastNameTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Last name cannot be empty", "Name Error", JOptionPane.ERROR_MESSAGE);
                } else if (usernameTxt.getText().isBlank() || usernameTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username cannot be empty", "Username Error", JOptionPane.ERROR_MESSAGE);
                } else if (usernameTxt.getText().length() < 3 || usernameTxt.getText().length() > 10) {
                    JOptionPane.showMessageDialog(null, "Username must be between 3 and 10 characters", "Username Error", JOptionPane.ERROR_MESSAGE);
                } else if (String.valueOf(newPasswordTxt).isEmpty() || String.valueOf(newPasswordTxt).isBlank() || String.valueOf(confirmNewPasswordTxt).isEmpty() || String.valueOf(confirmNewPasswordTxt).isBlank()) {
                    JOptionPane.showMessageDialog(null, "Password cannot be empty", "Password Error", JOptionPane.ERROR_MESSAGE);
                } else if (String.valueOf(newPasswordTxt.getPassword()).length() < 3 || String.valueOf(newPasswordTxt.getPassword()).length() > 20) {
                    JOptionPane.showMessageDialog(null, "Password length must be between 3 and 20 characters in length", "Password Error", JOptionPane.ERROR_MESSAGE);
                } else if (!String.valueOf(newPasswordTxt.getPassword()).equals(String.valueOf(confirmNewPasswordTxt.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match", "Password Error", JOptionPane.ERROR_MESSAGE);
                } else if (!emailTxt.getText().contains("@") || !emailTxt.getText().contains(".")) {
                    JOptionPane.showMessageDialog(null, "Email does not contain and '@' or '.'", "Email Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int counter = 0;
                    while (counter < Server.totalUsers.size()) {
                        if (user.getUsername().equals(Server.totalUsers.get(counter).getUsername())) {
                            break;
                        }
                        counter++;
                    }
                    Server.totalUsers.remove(counter);
                    boolean isTaken = false;
                    for (int i = 0; i < Server.totalUsers.size(); i++) {
                        if (usernameTxt.getText().equals(Server.totalUsers.get(i).getUsername())) {
                            JOptionPane.showMessageDialog(null, "Username is already taken", "Password Error", JOptionPane.ERROR_MESSAGE);
                            isTaken = true;
                        }
                    }
                    if (!isTaken) {
                        user.setFirstName(firstNameTxt.getText());
                        user.setLastName(lastNameTxt.getText());
                        user.setUsername(usernameTxt.getText());
                        user.setPassword(String.valueOf(newPasswordTxt.getPassword()));
                        user.setEmail(emailTxt.getText());
                        user.setBio(bioTxt.getText());
                        setVisible(false);
                        dispose();
                        new MyProfile(user);
                    }
                    Server.totalUsers.add(user);
                }
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new MyProfile(user);
            }
        });
        //BUTTONS//

        // LAYING OUT TEXT FIELDS AND LABELS //
        g.gridx = 0;
        g.gridy = 0;
        g.anchor = GridBagConstraints.FIRST_LINE_END;
        sp.add(firstName, g);
        g.gridy++;
        sp.add(lastName, g);
        g.gridy++;
        sp.add(username, g);
        g.gridy++;
        sp.add(newPassword, g);
        g.gridy++;
        sp.add(confirmNewPassword, g);
        g.gridy++;
        sp.add(email, g);
        g.gridy++;
        sp.add(bio, g);

        g.gridx = 1;
        g.gridy = 0;
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        sp.add(firstNameTxt, g);
        g.gridy++;
        sp.add(lastNameTxt, g);
        g.gridy++;
        sp.add(usernameTxt, g);
        g.gridy++;
        sp.add(newPasswordTxt, g);
        g.gridy++;
        sp.add(confirmNewPasswordTxt, g);
        g.gridy++;
        sp.add(emailTxt, g);
        g.gridy++;
        sp.add(bioTxt, g);
        g.gridy++;
        g.anchor = GridBagConstraints.CENTER;
        sp.add(submit, g);
        g.gridy++;
        sp.add(cancel, g);
        // LAYING OUT TEXT FIELDS AND LABELS //

        add(sp, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
