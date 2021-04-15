import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    JButton profile;
    JPanel panel;

    public MainPage(User user) {
        setTitle("Welcome " + user.getFirstName());
        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        profile = new JButton("Profile");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(profile, BorderLayout.EAST);
        this.add(panel, BorderLayout.CENTER);

        //SEARCH FUNCTION//
        JLabel search = new JLabel("Search: ");
        JTextField searchTxt = new JTextField(15);
        panel.add(search, BorderLayout.NORTH);
        panel.add(searchTxt, BorderLayout.NORTH);
        //SEARCH FUNCTION//

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
