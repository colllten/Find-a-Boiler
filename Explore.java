import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class Explore extends JFrame {
	

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < 100; i++) {
			users.add(new User("user" + i, "password", 1999, "User" + i, "Last" + i, null, null, null, false, null, "bio", "interests", null));
		}
		User u = new User("user32", "password", 1999, "User32", "Last32", null, null, null, true, null, "bio", "interests", null);
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Explore e = new Explore(u, users);
            }
        });
	}
	
	public Explore(User u, ArrayList<User> users) {
		JFrame explore = new JFrame("Explore");
        explore.setLocationRelativeTo(null);
        explore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        explore.setLayout(new BorderLayout());
		explore.setSize(500,500);
		String[] people = new String[users.size()];
		ArrayList<User> otherUsers = new ArrayList<User>();
		otherUsers.addAll(users);
		for (int i = 0; i < users.size(); i++) {
			String username = u.getUsername();
			User user = users.get(i);
			if (username.equals(user.getUsername())){
				otherUsers.remove(i);
			}
		}

		ArrayList<JPanel> panels = new ArrayList<JPanel>();

		if (otherUsers != null) {
			for (int i = 0; i < otherUsers.size(); i++) {
				JPanel panel = new JPanel();
				JButton profileButton = new JButton("View Profile");
				int finalI = i;
				profileButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(otherUsers.get(finalI).getUsername() + "'s Profile");
					}
				});
				JButton friendReqButton = new JButton("Send Friend Request");
				friendReqButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(otherUsers.get(finalI).getUsername() + " friend request");
					}
				});
				JLabel name = new JLabel(otherUsers.get(i).getFirstName() + " " + otherUsers.get(i).getLastName());
				if (otherUsers.get(i).getFriends() != null) {
					if (otherUsers.get(i).getFriends().contains(u)) {
						panel.add(name);
						panel.add(profileButton);
					} else {
						panel.add(name);
						panel.add(profileButton);
						panel.add(friendReqButton);
					}
				} else {
					panel.add(name);
					panel.add(profileButton);
					panel.add(friendReqButton);
				}
				panels.add(panel);
			}
		}

		JPanel panelScroll = new JPanel();
		panelScroll.setLayout(new GridLayout(panels.size(), 1));
		
		for (int i = 0; i < panels.size(); i++) {
			panelScroll.add(panels.get(i));
		}

		JScrollPane scrollPane = new JScrollPane(panelScroll);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		JPanel topPanel = new JPanel();
		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				try {
					explore.setVisible(false);
					explore.dispose();
					MainPage main = new MainPage(u);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
		topPanel.add(home);
		explore.add(topPanel, BorderLayout.NORTH);
		explore.add(scrollPane);
		explore.setVisible(true);
		
	}
	

}
