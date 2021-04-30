import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("Registration");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);

        //REGISTER PANEL//
        JPanel regPanel = new JPanel();
        regPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        setBackground(Color.LIGHT_GRAY);
        //REGISTER PANEL//

        // CHECK BOXES//
        JCheckBox vg = new JCheckBox("Video Games");
        JCheckBox reading = new JCheckBox("Reading");
        JCheckBox running = new JCheckBox("Running");
        JCheckBox hiking = new JCheckBox("Hiking");
        JCheckBox basketball = new JCheckBox("Basketball");
        JCheckBox football = new JCheckBox("Football");
        JCheckBox cc = new JCheckBox("Content Creation");
        JCheckBox singing = new JCheckBox("Singing");
        JCheckBox dancing = new JCheckBox("Dancing");
        JCheckBox studying = new JCheckBox("Studying");
        //CHECK BOXES//

        //LABELS & THEIR TEXT FIELDS//
        JLabel fName = new JLabel("First Name: ");
        JTextField fNameTxt = new JTextField(10);

        JLabel lName = new JLabel("Last Name: ");
        JTextField lNameTxt = new JTextField(10);

        JLabel email = new JLabel("Email: ");
        JTextField emailTxt = new JTextField(10);

        JLabel username = new JLabel("Username: ");
        JTextField usernameTxt = new JTextField(10);

        JLabel password = new JLabel("Password: ");
        JPasswordField passwordTxt = new JPasswordField(10);

        JLabel confirmPassword = new JLabel("Confirm Password: ");
        JPasswordField confirmPasswordTxt = new JPasswordField(10);

        JLabel birthYear = new JLabel("Birth Year: ");
        JTextField birthYearTxt = new JTextField(4);

        JLabel bio = new JLabel("Bio: ");
        JTextField bioTxt = new JTextField(20);

        JLabel interests = new JLabel("Interests: ");

        JLabel privacy = new JLabel("Privacy: ");
        String[] options = {"Public", "Protected", "Private"};
        JComboBox<String> cb = new JComboBox<>(options);

        //LABELS & THEIR TEXT FIELDS//

        //REGISTER BUTTONS//
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
                    } else if (!emailTxt.getText().contains("@") || !emailTxt.getText().contains(".")) {
                        JOptionPane.showMessageDialog(null, "Incorrect email format", "Email Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        while (!isTaken && i < Server.totalUsers.size()) {
                            if (usernameTxt.getText().equals(Server.totalUsers.get(i).getUsername())) {
                                isTaken = true;
                                JOptionPane.showMessageDialog(null, "Username is taken", "Username in Use", JOptionPane.ERROR_MESSAGE);
                            } else {
                                i++;
                            }
                        }
                        if (!isTaken) {
                            String bio = bioTxt.getText();
                            String email = emailTxt.getText();
                            ArrayList<User> friends = new ArrayList<>();
                            ArrayList<User> sent = new ArrayList<>();
                            ArrayList<User> received = new ArrayList<>();
                            ArrayList<User> notifications = new ArrayList<>();
                            ArrayList<String> interests = new ArrayList<>();
                            if (vg.isSelected()) {
                                interests.add("Video Games");
                            }
                            if (reading.isSelected()) {
                                interests.add("Reading");
                            }
                            if (running.isSelected()) {
                                interests.add("Running");
                            }
                            if (basketball.isSelected()) {
                                interests.add("Basketball");
                            }
                            if (football.isSelected()) {
                                interests.add("Football");
                            }
                            if (dancing.isSelected()) {
                                interests.add("Dancing");
                            }
                            if (singing.isSelected()) {
                                interests.add("Singing");
                            }
                            if (studying.isSelected()) {
                                interests.add("Studying");
                            }
                            if (cc.isSelected()) {
                                interests.add("Content Creation");
                            }
                            if (hiking.isSelected()) {
                                interests.add("Hiking");
                            }
                            String choice = (String) cb.getSelectedItem();
                            choice = choice.toLowerCase(Locale.ROOT);
                            User user = new User(usernameTxt.getText(), String.valueOf(passwordTxt.getPassword()),
                                    Integer.parseInt(birthYearTxt.getText()), fNameTxt.getText(), lNameTxt.getText(),
                                    friends, sent, received, false, notifications, bio, email, interests, choice);
                            Server.totalUsers.add(user);
                            for (int j = 0; j < user.getInterests().size(); j++) {
                                System.out.println(user.getInterests().get(j));
                            }
                            setVisible(false);
                            Server.writeToFile();
                            LoginFrame lf = new LoginFrame();
                            dispose();

                        }
                    }
                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(null, "Year must be an integer", "Year Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                Server.writeToFile();
                try {
                    LoginFrame lf = new LoginFrame();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JLabel importPathLabel = new JLabel("File Path: ");
        JTextField importPathTxt = new JTextField(20);
        JButton importUser = new JButton("Import CSV");
        importUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String filePath = importPathTxt.getText();
                    BufferedReader br = new BufferedReader(new FileReader(filePath));

                    String line = br.readLine();
                    while (line != null) {
                        String username = "";
                        String password = "";
                        int birthYear = 0;
                        String firstName = "";
                        String lastName = "";
                        ArrayList<User> friends = new ArrayList<>();
                        ArrayList<User> sentReqs = new ArrayList<>();
                        ArrayList<User> receivedReqs = new ArrayList<>();
                        boolean isOnline = false;
                        ArrayList<User> notifications = new ArrayList<>();
                        String bio = "";
                        String email = "";
                        ArrayList<String> interests = new ArrayList<>();
                        String visibility = "";

                        boolean correctFormat = true;
                        String[] currentLine = line.split(", ");
                        if (currentLine[0].equals("Username") && currentLine[1].length() > 2 && currentLine[1].length() < 11) {
                            username = currentLine[1];
                        } else if (currentLine[0].equals("Username") && currentLine[1].length() < 2 && currentLine[1].length() > 11){
                            JOptionPane.showMessageDialog(null, "Username is formatted incorrectly" +
                                    " formatted", "Username Error", JOptionPane.ERROR_MESSAGE);
                            correctFormat = false;
                        }
                        if (currentLine[2].equals("Password") && currentLine[3].length() > 2 && currentLine[3].length() < 21) {
                            password = currentLine[3];
                        } else if (currentLine[2].equals("Password") && currentLine[3].length() < 2 && currentLine[3].length() > 21){
                            JOptionPane.showMessageDialog(null, "Password is formatted incorrectly",
                                    "Password Error", JOptionPane.ERROR_MESSAGE);
                            correctFormat = false;
                        }
                        if (currentLine[4].equals("BirthYear") && Integer.parseInt(currentLine[5]) > 0 && Integer.parseInt(currentLine[5]) < 2022) {
                            birthYear = Integer.parseInt(currentLine[5]);
                        } else if (currentLine[4].equals("BirthYear") && Integer.parseInt(currentLine[5]) < 0 && Integer.parseInt(currentLine[5]) > 2022){
                            JOptionPane.showMessageDialog(null, "Birth Year is formatted incorrectly" +
                                    " formatted", "Birth Year Error", JOptionPane.ERROR_MESSAGE);
                            correctFormat = false;
                        }
                        if (currentLine[6].equals("FirstName")) {
                            firstName = currentLine[7];
                        }
                        if (currentLine[8].equals("LastName")) {
                            lastName = currentLine[9];
                        }
                        if (currentLine[10].equals("Bio")) {
                            bio = currentLine[11];
                        }
                        if (currentLine[12].equals("Email")) {
                            email = currentLine[13];
                        }
                        if (currentLine[14].equals("Visibility")) {
                            visibility = currentLine[15];
                        }
                        if (currentLine[16].equals("Break") && correctFormat) {
                            Server.totalUsers.add(new User(username, password, birthYear, firstName, lastName, friends,
                                    sentReqs, receivedReqs, isOnline, notifications,
                                    bio, email, interests, visibility));
                            Server.writeToFile();
                            setVisible(false);
                            LoginFrame lf = new LoginFrame();
                            dispose();
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "File was generally not formatted" +
                                    " correctly", "File Format Issue", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }

                } catch (FileNotFoundException fileNotFoundException) {
                    JOptionPane.showMessageDialog(null, "File cannot be found",
                            "Undefined File Path", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //REGISTER BUTTONS//

        //ADDING COMPONENTS//
        //ADDING LABELS//
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        regPanel.add(fName, gc);
        gc.gridy++;
        regPanel.add(lName, gc);
        gc.gridy++;
        regPanel.add(email, gc);
        gc.gridy++;
        regPanel.add(username, gc);
        gc.gridy++;
        regPanel.add(password, gc);
        gc.gridy++;
        regPanel.add(confirmPassword, gc);
        gc.gridy++;
        regPanel.add(birthYear, gc);
        gc.gridy++;
        regPanel.add(bio, gc);
        gc.gridy++;
        regPanel.add(interests, gc);
        gc.gridy += 5;
        regPanel.add(privacy, gc);
        //ADDING LABELS//

        //ADDING TEXT FIELDS//
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        regPanel.add(fNameTxt, gc);
        gc.gridy++;
        regPanel.add(lNameTxt, gc);
        gc.gridy++;
        regPanel.add(emailTxt, gc);
        gc.gridy++;
        regPanel.add(usernameTxt, gc);
        gc.gridy++;
        regPanel.add(passwordTxt, gc);
        gc.gridy++;
        regPanel.add(confirmPasswordTxt, gc);
        gc.gridy++;
        regPanel.add(birthYearTxt, gc);
        gc.gridy++;
        regPanel.add(bioTxt, gc);
        gc.gridy++;
        regPanel.add(vg, gc);
        gc.gridy++;
        regPanel.add(reading, gc);
        gc.gridy++;
        regPanel.add(running, gc);
        gc.gridy++;
        regPanel.add(hiking, gc);
        gc.gridy++;
        regPanel.add(football, gc);
        gc.gridy++;
        regPanel.add(cb, gc);

        gc.gridx++;
        gc.gridy = gc.gridy - 5;
        regPanel.add(basketball, gc);
        gc.gridy++;
        regPanel.add(cc, gc);
        gc.gridy++;
        regPanel.add(singing, gc);
        gc.gridy++;
        regPanel.add(dancing, gc);
        gc.gridy++;
        regPanel.add(studying, gc);
        //ADDING TEXT FIELDS//

        gc.gridy += 6;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.CENTER;
        regPanel.add(submit, gc);
        gc.gridy--;
        regPanel.add(cancel, gc);

        gc.gridx = 0;
        gc.gridy = 19;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        regPanel.add(importPathLabel, gc);
        gc.gridx = 1;
        gc.gridy = 19;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        regPanel.add(importPathTxt, gc);
        gc.gridx = 2;
        gc.gridy = 19;
        gc.anchor = GridBagConstraints.CENTER;
        regPanel.add(importUser, gc);

        add(regPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
        //ADDING COMPONENTS//
    }

}
