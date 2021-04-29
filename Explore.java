import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

//use ExploreUpdate instead
@Deprecated
public class Explore extends JFrame {

	//create new explore object
	public Explore(User u, ArrayList<User> users) {
		JFrame explore = new JFrame("Explore");
        explore.setLocationRelativeTo(null);
        explore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        explore.setLayout(new BorderLayout());
		explore.setSize(500,500);
		String[] people = new String[users.size()];
		ArrayList<User> otherUsers = new ArrayList<User>();
		otherUsers.addAll(users);
		//remove current user and any private users from list of all visible users
		for (int i = 0; i < users.size(); i++) {
			String username = u.getUsername();
			User user = users.get(i);
			if (username.equals(user.getUsername())){
				otherUsers.remove(i);
			}
			if (user.getVisibility().equals("private")){
				otherUsers.remove(i);
			}
		}

		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		//create a JPanel for each user
		if (otherUsers != null) {
			for (int i = 0; i < otherUsers.size(); i++) {
				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				JButton profileButton = new JButton("View Profile");
				int finalI = i;
				User user = otherUsers.get(i);

				//create button to view user profile
				profileButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(user.getUsername() + "'s Profile");
					}
				});

				//create a button to send a friend request
				JButton friendReqButton = new JButton("Send Friend Request");
				friendReqButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// NEW FRIEND REQUEST METHOD IN USE //
						System.out.println(user.getUsername() + " friend request");
						u.sendFriendReq(u, user);
						System.out.println("Main User sent request" + u.getSentReqs().get(0));
						System.out.println("Receiver received: " + user.getReceivedReqs().get(0));
						// NEW FRIEND REQUEST METHOD IN USE //
					}
				});

				//create a new JLabel to display the user's name
				JLabel name = new JLabel(user.getFirstName() + " " + user.getLastName());
				panel.add(name);

				//if the user is public, add buttons to see their profile and send a friend request...
				//...if the users aren't already friends
				if (user.getVisibility().equals("public")) {
					if (user.getFriends().contains(u)) {
						panel.add(profileButton);
					} else {
						panel.add(profileButton);
						panel.add(friendReqButton);
					}
				//if the user is private, add a button to send a friend request if users are not friends
				//and if they are friends add a button to view profile
				} else if (user.getVisibility().equals("private")){
					if (user.getFriends().contains(u)) {
						panel.add(profileButton);
					} else {
						panel.add(friendReqButton);
					}
				}
				JLabel online = new JLabel("Online");
				if (user.isOnline()){
					panel.add(online);
				}
				panels.add(panel);
			}
		}

		//create a JScrollPane to contain all of the Jpanels created for each user
		JPanel panelScroll = new JPanel();
		panelScroll.setLayout(new GridLayout(panels.size(), 1));
		
		for (int i = 0; i < panels.size(); i++) {
			panelScroll.add(panels.get(i));
		}

		JScrollPane scrollPane = new JScrollPane(panelScroll);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

		//add other panels and buttons to make it look pretty and be able to go home
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
		explore.setLocationRelativeTo(null);
		explore.setVisible(true);
		
	}
}
