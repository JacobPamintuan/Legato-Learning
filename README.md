<p align="center"><img src="https://user-images.githubusercontent.com/36178603/112568788-694c3400-8db9-11eb-832a-8794e347465e.png" alt="Logo"></p>

---

Legato Learning is the final, solo-culminating project for the ICS4U course. 

Legato Learning is an application designed to introduce musicians to the world of Music Theory.
Learn through the lessons provided and test your knowledge by completing the quizzes.
Track your Strengths and Weaknesses and review lessons and quizzes until you are confident.

I mainly focused on the UI and UX aspect rather than the complexity of the program (In my opinion, a huge step up from [project 1](https://github.com/JacobPamintuan/AmazingLabyrinth) and especiallly [project 2](https://github.com/JacobPamintuan/Post-Secondary-App/tree/main/src/postApp)). 

Using Figma for prototyping the GUI, I learned how having a clear prototype can speed up the coding process. As Java is not primarily built for front-end development, it was a challenge to make it look as nice as it is using Java Swing. 
I took inspiration from several learning websites like Duolingo and Quizlet when it came to how the user interacts with the program, and the different visual cues to help the user navigate through the UI seamlessly. Furthermore, I used MuseScore 3 to create multiple-choice selections for the quizzes.

---

### Screenshots:
![Login](https://user-images.githubusercontent.com/36178603/112567227-dca07680-8db6-11eb-9581-190f4e69df90.png)
###### Legato Learning Login Page

Returning user? Simply just enter your username and password. First time? Click on "Create an account" to be redirected to the Sign Up page.


![Signup](https://user-images.githubusercontent.com/36178603/112568420-d612fe80-8db8-11eb-9525-744f0e49c96e.png)
###### Sign Up Page

Create an account by entering your first and last name, as well as your username and password. However, unfortunately, if the username is already taken, you need to choose a different one.
All user information is saved onto a text file, and each user has their own quiz and lesson file which is loaded upon login. If it is a first-time user, new text files get created.

---

![Home](https://user-images.githubusercontent.com/36178603/112568050-43725f80-8db8-11eb-96c9-c9b2a3e11b5d.png)
###### Home

After logging in or signing up, you are first greeted by the home screen, based on the time frame that I was given, I decided to create only a one-course package, however, it would not be that difficult to add a second or a third. Each course would have a profile photo, as well as a short description of the content. By clicking on a course, it would bring the user to the corresponding course page.


![Course Page](https://user-images.githubusercontent.com/36178603/112569828-47ec4780-8dbb-11eb-86af-60e92e6af7b0.png)
###### Course Page - Intervals

The course page is the portal to all the lessons and quizzes. To unlock the quizzes, the user must complete their respective lesson first. Completed lessons/quizzes are marked with a green checkmark, and locked quizzes are greyed out.

---

![Lesson](https://user-images.githubusercontent.com/36178603/112570044-b03b2900-8dbb-11eb-9c3a-5e2f712eb86b.png)
###### Sample lesson - Augmented and Diminished Intervals

The user can complete the lessons at their own pace. It is essentially a PowerPoint presentation and the user navigates by pressing next or previous. Once completed, the user is directed back to the course page, and the corresponding quizzes are now unlocked. 

---

![Quiz Plain](https://user-images.githubusercontent.com/36178603/112570377-4f602080-8dbc-11eb-93f9-769127ed4e62.png)
###### Sample Quiz - Before answering, Name the Interval

The quizzes in Legato Learning are all multiple choice. In this specific course, Intervals, a staff is presented to the user with different intervals, and the purple rectangle dictates which question must be answered. There are two types of quizzes in this course, 'Name the following interval' and 'Select the interval that satisfies the note', see below.


![Quiz Correct](https://user-images.githubusercontent.com/36178603/112570173-ed9fb680-8dbb-11eb-934c-36f6acbac3c0.png)
###### Sample Quiz - User gets question correct

This is an example of the user selecting the correct answer, it is highlighted in green with a checkmark. 


![Quiz Incorrect](https://user-images.githubusercontent.com/36178603/112570635-ca293b80-8dbc-11eb-9410-9aef87a18092.png)
###### Sample Quiz - User gets question incorrect

This is an example of the user selecting the incorrect answer. Their selection is highlighted red, and the correct answer is highlighted in green with a checkmark. After completing the quiz once, it will repeat with the incorrect answers until the user gets everything correct.

---

![Results Order](https://user-images.githubusercontent.com/36178603/112571005-8125b700-8dbd-11eb-9872-a4b844e9cb4b.png)
###### Results Page - In order of difficulty

The results page allows the user to track their progress. They can redo quizzes to try to achieve higher scores. Additionally, there are different ways to sort the scores, shown is the difficulty, but it is also possible to sort by worst to best and best to worst. 

---

### Challenges I faced

Several all-nighters were pulled.

It was my first time attempting file-saving, i.e. reading and writing data to text files. I had to learn from previous group projects and understand the code to implement it in my program. Furthermore, Java is not a front-end language, and it was quite difficult to get it looking how I wanted. If I had not prototyped in Figma, I doubt I could have accomplished such a clean UI. I originally planned to do two courses instead of one but decided to focus on quality rather than quantity, adding the smallest of features and details to make the user experience as best as I could.

Also, it was my first time using Figma, so I had to learn how to use completely new software, but it helped in the end. 
One of the hardest and most time-intensive parts of the project was creating the quizzes. I had to painstakingly scan all of the "questions" and tweak them in Figma, which is not really designed to edit images in such a way, unlike Photoshop, so that it would line up with the purple box, as you can see in the quiz pages. Also, for all of the "Select the interval" quizzes, I had to create all of the different selections in MuseScore 3, screenshot them, and color them.

After that, I had to create the files for the quizzes, which housed all of the data, essentially a formatting nightmare. 

### Accomplishments

This was by far the most complex and best-looking GUI I have created so far, and am especially proud since I was able to create it on Java Swing, which is known to be outdated and clunky. 

- Leanred a new prototyping software: Figma
- Used MuseScore 3
- Implemented a variety of Swing features
- Learned how to use Comparators to sort data
- Created a Modern UI with an outdated, non-front-end language
- Learned how to read and write text files

### Areas of Concern
  - Only runs on macOS (UI doesn't load at all on Windows)
  - Screen size of at least 1440x820 (just barely fits on MacBook Pro 13-inch)
  - Wait at least 2 seconds logging/signing in to allow the program to load
      - "Load complete" will appear in the console

### Credits:
  - All lessons and quizzes (images) were taken/based on the book: Mark Sarnecki, M. S. (2021). 
      - The Complete Elementary Music Rudiments, 2nd Edition. Music One Select. 
      - Multiple choice selection images created by me
  - Implementation of Colours and Fonts class inspired by @itslinotlie
  - Reading and writing files to similar to the previous project - [Post-Secondary-App](https://github.com/JacobPamintuan/Post-Secondary-App)
