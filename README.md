# Project 5 -- FindABoiler
## Instructions:
### Setting up the Server
- Profile pictures are included in the download and are labeled `ProfilePic1.jfif`, `ProfilePic2.jfif`, and 
  `ProfilePic3.jfif`so they can be displayed by the server. Copy the absolute paths of ProfilePic1, ProfilePic2, 
  and ProfilePic3 and paste them into lines 44, 46, and 48. It is optimal that they are saved into the SRC folder 
  of the project.
  - Example for ProfilePictureFrame.java lines 44, 46, 48
    - `ImageIcon icon1 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\PJ5\\src\\ProfilePic1.jfif");`
    - `ImageIcon icon2 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\PJ5\\src\\ProfilePic2.jfif");`
    -  `ImageIcon icon3 = new ImageIcon("C:\\Users\\Colten\\IdeaProjects\\PJ5\\src\\ProfilePic3.jfif");`
    
- Comments will be under these lines for clarity, reading `//GRADER: ...`
    
  
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
- A demo importable CSV file is available to test. Copy `import.txt`'s absolute path and paste it into the
text field located in the registration frame.
  
#### Exporting
- Exporting can be achieved by logging in > My Profile > Settings > Export. This exports a file named `exportedUser.txt`
and that same file can be imported back into the program with a changed username.
  
#### Searching
- The search function at the bottom of the main page allows for users to search the database of any username's that
contain the specified string they input into the text field. When wanting to exit the search frame, just click the
  red X at the top of your frame, bringing you back to the main page
  
# Troubleshooting 
- Ensure that UserData.txt exists after the first attempt at running the server is over
- Make sure the three profile pictures are downloaded and their absolute file paths have been copied into their
  respective lines
  - Absolute paths must be pasted into the specified lines in `ProfilePictureFrame.java`
  - See "Setting Up the Server" above for clarity
- If the server is still not booting up correctly, contact glover44@purdue.edu
# Submissons
- Report Submitted by:
  
- Files Submitted to Vocareum by:
  
- Video Submitted by:

# Description of each class(functionality and relationship to other classes):
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

# Testing done for each class:
General note: For all the classes marked with a ~, the only method 
is a constructor, and the failing test for those constructors is to enter 
a null user into the parameters for the constructor. However, this will not 
happen during the running of the program, as the automatic updates remove any
deleted accounts and null users aren't created at any time.

~AllProfiles.java:
For this class the passing case is when AllProfiles(user) is called with a 
valid user. This occurs any time within the program where you click on a 
"View Profile" button. For example, go into the explore page, find a user, and
click on "View Profile", and it will call on AllProfiles(user) with the specific
user.

Client.java:
For this class the passing case is when the Server is running, and the user
runs the Client main method. This will create the server-client connection, create a 
thread, and call the login page. The failing case for this class is when the Server is not
running when the Client main method runs and therefore no server-client connection can 
be established.

~ExploreUpdate.java:
For this class the passing case is when the class is called within the GUI. Do this
by running the Server and the Client, logging in, and clicking on the "Explore" tab.
This will run ExploreUpdate, which displays all the users other than the current user
and updates automatically with new information.

~FriendsProfile.java:
For this class the passing case is when the class is called within the GUI. 
Do this by running the Server and the Client, logging in, going to "My Profile", 
and clicking on "Friends". This will call the constructor for FriendsProfile, 
which displays a list of all the user's friends with links to view all of their
profiles and to go back to the current user's profile.

LoginFrame.java:
For this class the passing case is when the class is called from the Client.
Do this by running the Server then running the Client, and the login page will appear,
as set by the constructor for LoginFrame. There are invalid inputs to test on the 
login page. Test these by entering an invalid username or an invalid password, then click 
on the "Login" button. There will be a GUI displayed that informs the user that 
the information they entered was incorrect.

~MainPage.java:
For this class the passing case is when the class is called within the GUI.
Do this by running the Server and the Client, and logging in. This will call the constructor for MainPage,
which is the main landing page to navigate to other pages. 

~MyProfile.java:
For this class the passing case is when MyProfile is called with a
valid user. This occurs any time within the program where you click on the
"My Profile" button. Do this by running the Server and the Client, logging in, then
clicking on "My Profile" in the top of the main page. 

~NotificationUpdate.java:
For this class the passing case is when NotificationUpdate is called within
the GUI. Do this by running the Server and the Client, logging in, then
clicking on "Notifications" in the top of the main page.

ProfilePictureFrame.java:
For this class the passing case is when creating a new user. Do this by 
running the server and the client, then on the login page, select "Register". Fill
out all the information as appropriate, then select "Submit". This will take you to 
the ProfilePictureFrame, which prompts you to select your profile picture. Select a 
profile picture, then select "Submit" again. The failing case follows the same format, except
this time don't select a profile picture, then try hitting "Submit". An error message will
appear telling you that you need to select a profile picture, and it won't let you continue
until you select one.

RegisterFrame.java:
For this class the passing case is when creating a new user. Do this by
running the server and the client, then on the login page, select "Register". Fill out 
all the information using correct inputs. For example, when entering an email, enter an actual
email address, then select "Submit", and a new user will be created with that information. The
failing case follows a similar format, but the program requires that some information
is correct. For example, the text in the password input and in the repeat password input need to match.
Try making the passwords not match, and an error message will appear telling you
that the passwords need to match.

SearchFrame.java:
The passing case for this class is when searching for a user that exists. Do this
by logging in to an account other than "admin", then clicking on the search bar and typing in 
"admin". The admin user will show up here. The failing case is when the user being searched for
does not exist. Do this by entering a user that doesn't exist, such as "obama",
assuming no Obama user has been created. No users will show up and the searchFrame will let you 
know that the user you are searching for does not exist.

Server.java:
This will fail the first time it runs. It does not take in any inputs, so every time
it writes to UserData.txt. The first time the code runs, UserData.txt does not exist,
so it fails. However, it then creates the file, so the next time the server is run, it will work.
The passing test would be any time it runs after the first time.

ServerWorker.java:
This will pass the test any time it runs. The only time it would fail is if there is
an interrupted exception, which is hard to replicate. 

SettingsFrame.java:
The passing case for this class is when editing a user and entering correct inputs. Do this by
logging in, then going to "My Profile", then clicking on "Settings". For example, when entering a new email, 
enter an actual  email address, then select "Submit", and the user will be modified with that information. The
failing case follows a similar format, but the program requires that some information
is correct. For example, the text in the password input and in the repeat password input need to match.
Try making the passwords not match, and an error message will appear telling you
that the passwords need to match.

User.java:
All the tests for User.java and all of its methods are in the RunLocalTest.java
class. To test these methods, simply run RunLocalTest.java. The error messages
will display for the failing cases and nothing will display for the passing cases.
One thing to note about these, is that all the failing cases were made using a null user,
which will never happen in the program due to the automatic updating which gets rid of
the displays for any user that doesn't exist anymore.
