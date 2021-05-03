import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Class used for user's selection of profile picture
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

public class ProfilePictureFrame extends JFrame {

    public ProfilePictureFrame(User user) {
        setTitle(user.getUsername() + "'s Profile Picture");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                user.setOnline(false);
                Server.writeToFile();
            }
        });

        //PANEL FOR CHOOSING//
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        //PANEL FOR CHOOSING//

        //COMPONENTS//
        ButtonGroup group = new ButtonGroup();
        JRadioButton smileyFace = new JRadioButton("#1");
        group.add(smileyFace);
        JRadioButton frownyMike = new JRadioButton("#2");
        group.add(frownyMike);
        JRadioButton woods = new JRadioButton("#3");
        group.add(woods);

        ImageIcon icon1 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\Solo PJ5\\src\\ProfilePic1.jfif");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\Solo PJ5\\src\\ProfilePic2.jfif");
        ImageIcon icon3 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\Solo PJ5\\src\\ProfilePic3.jfif");

        Image image = icon1.getImage();
        Image newImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(newImage);
        JLabel pic1 = new JLabel(icon1);

        image = icon2.getImage();
        newImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(newImage);
        JLabel pic2 = new JLabel(icon2);

        image = icon3.getImage();
        newImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        icon3 = new ImageIcon(newImage);
        JLabel pic3 = new JLabel(icon3);

        g.gridx = 0;
        g.gridy = 0;
        g.weightx = 0.5;
        g.anchor = GridBagConstraints.CENTER;
        panel.add(pic1, g);
        g.gridx++;
        panel.add(pic2, g);
        g.gridx++;
        panel.add(pic3, g);

        g.gridx = 0;
        g.gridy = 1;
        panel.add(smileyFace, g);
        g.gridx++;
        panel.add(frownyMike, g);
        g.gridx++;
        panel.add(woods, g);

        g.gridx = 1;
        g.gridy = 2;
        JButton submit = new JButton("Submit");
        panel.add(submit, g);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (smileyFace.isSelected()) {
                    user.setIcon(pic1);
                    setVisible(false);
                    Server.writeToFile();
                    try {
                        new LoginFrame();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    dispose();
                } else if (frownyMike.isSelected()) {
                    user.setIcon(pic2);
                    setVisible(false);
                    Server.writeToFile();
                    try {
                        new LoginFrame();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    dispose();
                } else if (woods.isSelected()) {
                    user.setIcon(pic3);
                    setVisible(false);
                    Server.writeToFile();
                    try {
                        new LoginFrame();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a profile picture",
                            "Profile Picture Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //COMPONENTS//

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
