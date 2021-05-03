# Project 5 -- FindABoiler
## Instructions:
### Setting up the Server
- Profile pictures will need to be saved onto your computer so they can be displayed by the server. Pick any three
  random pictures from Google and copy their absolute paths and paste them into lines 44, 45, and 46. It is optimal
  that they are saved into the SRC folder of the project.Then on line 61:37 in Server.java, insert the file name of
  whatever profile picture the admin login will have.
  - Example for ProfilePictureFrame.java lines 44-46
    
`ImageIcon icon1 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\PJ5\\src\\ProfilePic1.jfif");`

`ImageIcon icon2 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\PJ5\\src\\ProfilePic2.jfif");`

`ImageIcon icon3 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\PJ5\\src\\ProfilePic3.jfif");`
- - Example for Server.java 61:37
  
  `new JLabel("ProfilePic1.jfif")));`
    
  
- To begin, first run Server.java once. It will have a runtime error, but it will have created UserData.txt on your
    local computer. This is the file that the program reads and writes objects to, so it is important that it is
    created by crashing Server.java first. It also contains a default login with the username and password as "admin."
  - once it has crashed once, it will be able to run correctly from there on out. No more crashes will occur, if you
  have any questions or cannot get UserData.txt to work properly, contact glover44@purdue.edu
    
### Running the Program
- Begin by starting Server.java first, then execute Client.java. Client.java will bring up a login page where you can
enter the admin credentials or create a new user. From there, the program is functioning and no further steps are needed
  
#### Registration
- Users can register unique users. There are error JOptionPanes that pop up if any info is incorrectly formatted or
if a username is already taken. Users must be born before 2011 (mock age requirement).
  - If all the information is correct, the program will take you to select your profile picture. If correctly downloaded
  on your computer, there should be three options with radio buttons below them.
    
- After registering, it will take you back to the login screen to enter your credentials

#### My Profile
- My Profile allows users to see what their profile looks like. You can access your friends list, settings, contact
information, or go back to the main page.
  
#### Explore
- The Explore tab allows you to see all users in the program that are not private. You can either view their profiles,
or send them a friend request. This also displays whether the users are currently online
  
#### Notifications
- When sending and receiving friend requests, they will appear in the Notifications tab/button. When you send a friend
request, it will appear in your Sent box within Notifications. It allows you to rescind (or cancel) the request. On the
  flip side, the other use can accept or decline the request.
  
#### Importing
- A demo importable CSV file is available to test. Copy `import.txt`'s absolute location and paste it into the
textfield located in the registration frame.
  
#### Exporting
- Exporting can be achieved by logging in > My Profile > Settings > Export. This exports a file named `exportedUser.txt`
and that same file can be imported back into the program with a changed username.
  
#### Searching
- The search function at the bottom of the main page allows for users to search the database of any username's that
contain the specified string they input into the text field. When wanting to exit the search frame, just click the
  red X at the top of your frame, bringing you back to the main page
  
# Troubleshooting 
- Ensure that UserData.txt is in your SRC folder
- Make sure to download any three pictures and enter them into their respective lines
- If the server is still not booting up correctly, contact glover44@purdue.edu

## Submissons
- Report Submitted by:
- Files Submitted to Vocareum by:
- Video Submitted by:

### Description of each class(functionality and relationship to other classes):
AllProfiles.java:
Client.java:
ExploreUpdate.java:
FriendsProfile.java:
LoginFrame.java:
MainPage.java:
MyProfile.java:
NotificationUpdate.java:
ProfilePictureFrame.java:
RegisterFrame.java:
SearchFrame.java:
Server.java:
ServerWorker.java:
SettingsFrame.java:
User.java:

#### Testing done for each class:
AllProfiles.java:
Client.java:
ExploreUpdate.java:
FriendsProfile.java:
LoginFrame.java:
MainPage.java:
MyProfile.java:
NotificationUpdate.java:
ProfilePictureFrame.java:
RegisterFrame.java:
SearchFrame.java:
Server.java:
ServerWorker.java:
SettingsFrame.java:
User.java:
