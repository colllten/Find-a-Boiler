import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchFrame extends JFrame {
    
 /**
 * Class for Search feature that allows user to find a specific user on site
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 5
 * @author Sudhanva Bharadwaj, Colten Glover, Brayden Hall, Japneet Mavi, Jeff Woodhouse
 * @version May 3, 2021
 */

    public SearchFrame (ArrayList<User> users, User user) {
        //FRAME SETUP//
        setTitle("Possible Users");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel foundUsers = new JPanel();
        foundUsers.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                user.setOnline(false);
            }
        });
        // FRAME SETUP //

        //LABEL AND BUTTON SETUP//
        g.weighty = 0.5;
        g.anchor = GridBagConstraints.FIRST_LINE_END;
        g.gridx = 0;
        g.gridy = 0;
        for (int i = 0; i < users.size(); i++) {
            JLabel label = new JLabel(users.get(i).getUsername());
            foundUsers.add(label, g);
            g.gridy++;
        }

        g.gridx = 1;
        g.gridy = 0;
        g.weighty = 0.5;
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        for (int i = 0; i < users.size(); i++) {
            JButton button = new JButton("Profile");
            foundUsers.add(button, g);
            g.gridy++;
        }
        //LABEL AND BUTTON SETUP//

        //TODO Add links to frames for user profile frames from Japneet

        add(foundUsers, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);


    }
}
