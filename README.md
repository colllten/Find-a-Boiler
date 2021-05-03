# Project 5 -- FindABoiler
## Instructions:
### Setting up the Server
- Profile pictures are included in the download and are labeled `ProfilePic1.jfif`, `ProfilePic2.jfif`, and 
  `ProfilePic3.jfif`so they can be displayed by the server. Copy the absolute paths of `ProfilePic1`, `ProfilePic2`, 
  and `ProfilePic3` and paste them into lines 45, 47, and 49 of `ProfilePictureFrame.java`
  - Example for ProfilePictureFrame.java lines 45, 47, 49
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
- Make sure the three profile pictures are downloaded, and their absolute file paths have been copied into their
  respective lines
  - Absolute paths must be pasted into the specified lines in `ProfilePictureFrame.java`
  - See "Setting Up the Server" above for clarity
- If the server is still not booting up correctly, contact glover44@purdue.edu
# Submissons
- Report Submitted by:
  
- Files Submitted to Vocareum by: Colten Glover, glover44@purdue.edu
  
- Video Submitted by:

# Description of each class(functionality and relationship to other classes):
### AllProfiles.java:

### Client.java:

### ExploreUpdate.java:

### FriendsProfile.java:
This JFrame shows the user's friend's profile once selected. It contains all the information that the user's profile
specifies but without a settings button. It connects to their own friends, interests, and contact information.
### LoginFrame.java:
This is what is originally called to start the program. Users can either enter in their credentials or register a new
user. If an incorrect username or password is entered, the user will be notified. Once a successful login occurs,
a new MainPage linked to the logged-in user is called, and the login frame is disposed.
### MainPage.java:
The main page is the basis of what the user uses to interact with the rest of the platform. The user can select a button
from the top bar, and it will take them to the specified page. The user can also input a string into the search bar
at the bottom, and it will bring a new frame showing all the users that contain that specified string in their
username.
### MyProfile.java:
MyProfile shows the user's profile and allows them to check their friends list, contact information, and edit their
profile through the settings button. Their profile picture is also displayed near the top.

### NotificationUpdate.java:

###ProfilePictureFrame.java:
This is where users select their profile picture, if none is selected, they can go back into their settings and select
one.

###RegisterFrame.java:
This is where new users come to register for a new account. It fills in many of the User class's parameters and leads
them to choose their profile picture.
###SearchFrame.java:

###Server.java:

###ServerWorker.java:

###SettingsFrame.java:

###User.java:

# Testing done for each class:
### General note: 
For all the classes marked with a "~", the only method 
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

# Script
Intro (entire group)
Hi, (introducing ourselves) and today we’ll be introducing you to (FindABoiler)!

(Wide shot, all people in frame, ending cut to still/vid of project)(s1)

Overall pitch: Brayden, Colten
Brayden: As much as we may hate it, we all have to work, but aren’t you tired of those “typical” business oriented social sites. 

Colten: Typical business oriented social media sites are full of clutter, offer way too many unneeded features, and overall support bigger business and companies, instead of you as a consumer.

Brayden: Exactly! That's why we created (FindABoiler)! (FindABoiler) is a simplistic and streamlined business social media platform, designed for you.

Brayden: So without further adieu, 

Brayden: Welcome to (FindABoiler)
Colten: Welcome to (FindABoiler)

(wide shot, Colten and Brayden in frame discussing)(s2)
Intro to program page
(pan into computer/screen recording) (s3)

Demo of required funct: Sud, Colten, Japneet
Colton:  (imported video of creating an account) (FindABoiler) is a social media platform, this means, you need to be social (import creation). The first step to joining (FindABoiler) is creating an account. Don't worry though, if for whatever reason you want to leave (FindABoiler), you can edit or even delete your account at any time. We see the login page when first loading the program, we create an account and sign in to access our program. All identifiers we maintain for the users are unique. This allows users to have individual user accounts without risk of lost or disrupted data.

Brayden or Sud: After creating an account to access our program, you can start creating profiles. Again, don't worry, you can create, edit, and even delete your profile at any time. For security measures, you can edit or delete your own profile, but you cannot edit or delete any other profiles that are not based on your account. After creating your profile, you can begin editing it. Your profile must contain an about me section, so visitors can get a better idea about yourself. Your profile must also contain contact information, your likes or interests, and a friends list. 

Colten: After creating and filling out your profile, you can begin to create friends lists of other users on (FindABoiler). Once you find someone you want to friend, you can send them a friend request. The users will become friends automatically, unless the recipient of the request is private. If the recipient is private, the friend request will have to be accepted. 

Brayden: Here we have updated the friend request functionality (import required funct here) Users can see a list of their sent and received friend requests here. They can then deny them or confirm them. If the sender decides to rescind the friend request before the recipient has accepted it, the notification will no longer appear for the recipient or the sender. If a friend request is accepted, the notification will no longer appear for the sender or the recipient. Outside of sending requests to specific friends, users are able to view a list of (FindABoilers) users, and are able to send friend requests or requests to view their profile. 

Sud: Due to (FindABoiler) being a Business oriented professionally driven Social Media program, we needed to create a server to host it so multiple clients could connect at one time. This allows updates of individual programs to be modified, updated, and viewed in real time.

Colten: These actions and all other user interactions, as seen here (import video of preformed funct) are GUI based. We did this due to the obvious necessity of needing a graphic interface to display the program.

Sud: As we can see here (import video of preformed funct), the active data being accessed persists, whether or not a user is connected. This allows users to stay updated with the server, regardless if they are presently active on the program. If a user disconnects, their data is still available and accessible. 

Colten: Descriptive errors within the program appear as appropriate, as we can see here (import video of required funct), this will also not crash.

Japneet: All profile information imported is saved. This is done by converting the information to an importable and exportable csv file
 
 
Demo of optional feat: Japneet and Brayden
Brayden: Along with the required features of our social platform, we have also imported a way to see if a user is online.(import video required funct here)

Japneet: Another feature we have added is the ability to add profile pictures. We thought that although this isn't a necissity, it is important that users have yet another form of identification and customization. 

Japneet: Another feature we’re proud of at FindABoiler is the ability to have a private or protected profile. This feature allows users to set their profiles as unviewable to others, or private with accessibility strictly to the users friends.

Explanation of testing: Jeff, Brayden, Sud
Jeff: Our first test case is improper username and password upon login. If a user attempts to login with an invalid username or password, the user will receive an error message, as we can see here. 

Brayden: Our next test case is during registration. A user must input the same password twice, otherwise they will be thrown an error message. 

Sud: Another test case that we performed takes place during registration. The email a user inputs must contain an @ symbol, followed by more characters, one of which must be a period. This assures us and users that the email they provide is correct. 

Jeff: Another way we have assured the best functionality for our users is through the implementation of birth year requiring an integer input. This assures the system that a number is being inputted. 

Brayden: Another way we have tested our program is that in the eventuality that a user attempts to create a username that is already taken, the user will receive an error message that prompts them to pick another username.

Sud: Our last test case we performed for our users optimal experience, is that in the eventuality that a user attempts to search a username that doesn’t exist, they will receive an error message. 

Q&A: Colten, Jeff, Japneet
Japneet: A question we might be asked would be how do we ensure safety for our users? Our response to this is that not only do we have private profiles, but the way our data is saved and imported to the server, it is mandatory that you provide accurate login information, as well as the ability to rescind or deny friend requests in the event that our profile is private. 

Jeff: Another question we might be asked is how do we ensure that a user will not only always have access to their profiles, but will have their data saved indefinitely unless they themselves terminate their account. Our response is that all data is saved through our server and it is converted to text files. This means that all a user will need to do is input their correct username and password, and they will have full access to their account, regardless of how long it has been since the account was last accessed. However, if they delete their account, the information will be purged from our servers.

Colten: Another question we might be asked is what our plans are for expansion and integration to other features as well as locations. Our response to this is that in terms of expansion to other locations, we will likely need to change the name and some of the GUI based features that may be Purdue specific. Our plans for further integration to enhance our users experience is to offer more features. We would like to add a direct messaging feature to allow users to communicate through our app, this will allow users to make more business oriented connections within our app. Another feature we would like to add is a portfolio option. We think our users would enjoy a feature that allowed them to upload their portfolios. We think this would be a good addition to our program because it would allow users to portray themselves more professionally as well as advertising their abilities.
