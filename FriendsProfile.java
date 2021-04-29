//not being able to do dispose on close
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class FriendsProfile
{
    public FriendsProfile(User user) {
        JFrame jf = new JFrame("Friends");
        
        jf.setLayout(new BorderLayout());
        jf.setSize(500, 500);
        /** why cant i do this */
        //jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel jp = new JPanel();
        jp.setBackground(Color.PINK);
        jp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JButton returnto = new JButton("return to My Profile");
        returnto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                jf.dispose();
                new MyProfile(user);
            }
        });
        
        returnto.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        jp.add(returnto, gbc);
        
        int y = 1;
        int yy = 1;
        for(int i = 0; i < ((user.getFriends()).size()); i++) {
            String[] names = new String[(user.getFriends()).size()];
            User[] fname = new User[(user.getFriends()).size()];
            names[i] = String.valueOf((user.getFriends()).get(i));
            JLabel flist = new JLabel(names[i]);
            
            flist.setPreferredSize(new Dimension(150, 30));
            gbc.gridx = 0;
            gbc.gridy = y++;
            jp.add(flist, gbc);
            
            User fname1 = fname[i];
            
            JButton jb = new JButton("view profile");
            jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                jf.dispose();
                new AllProfiles(fname1);
            }
        });
            jb.setPreferredSize(new Dimension(150, 30));
            gbc.gridx = 1;
            gbc.gridy = yy++;
            jp.add(jb, gbc);
        }
        
        
        jf.add(jp, BorderLayout.CENTER);
        //jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jf.setSize(500, 500);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
