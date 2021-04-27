import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame {

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
                } //else if (newPasswordTxt. || newPasswordTxt.getText().isEmpty() || confirmNewPasswordTxt.getText().isBlank() || usernameTxt.getText().isEmpty())

                //TODO: Check if username is already taken
                user.setFirstName(firstNameTxt.getText());
            }
        });
        JButton cancel = new JButton("Cancel");
        //BUTTONS//
    }
}
