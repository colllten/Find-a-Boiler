import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class Explore extends JFrame {
	

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < 100; i++) {
			users.add(new User("user" + i, "password", 1999, "User" + i, "Last" + i, null, null, null, false, null, "Bio", "email@email.com", null));
		}
		User u = new User("user32", "password", 1999, "User32", "Last32", null, null, null, true, null, "Bio", "email@email.com", null);
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
		if (otherUsers != null) {
			for (int i = 0; i < otherUsers.size(); i++) {
				people[i] = otherUsers.get(i).getFirstName() + " " + otherUsers.get(i).getLastName();
			}
//			for (int i = 0; i < people.length; i++) {
//				System.out.println(people[i]);
//			}
		}
		JList list = new JList(people);
		
		JScrollPane scrollPane = new JScrollPane(list);
		
		JPanel topPanel = new JPanel();
		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				// INSERT CODE HERE TO SWITCH BACK TO MAIN PAGE

				try {
					explore.setVisible(false);
					explore.dispose();
					MainPage main = new MainPage(u);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}

				System.out.println("Home button pressed");
			}
			
			
		});
		topPanel.add(home);
		explore.add(topPanel, BorderLayout.NORTH);
		explore.add(scrollPane);
		explore.setVisible(true);
		
	}
	

}
