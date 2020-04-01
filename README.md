# cmpe202

## Team Hackathon group project

## fa18-202-team-flash

## Know Your Patterns

### About the game

We have built a design patterns quiz game using Swing framework. There are total three screens in this game. The first page is the homepage which lets user choose the level of difficulty of the game he/she wants to play. The second screen would display a set of questions with multiple choice questions. User can optionally use the hints button to get hints related to that question. And, the last page displays the score of the user and the right answers of all the questions.

### Game flow

Initially on the homepage, three buttons are displayed to the user : Easy, Medium, Difficult. User chooses one of the three options and is then redirected to the next page. The next page contains a list of questions where the user has to identify a particular design pattern from the given four options. After selecting the answer, user has to press the ‘Next’ button which displays the next question from the pool of questions which are stored a JSON file.

The user can also opt to get hints by clicking the ‘Hint’ button. On clicking the ‘Hint’ button once, one portion of the image of that design pattern in displayed. Similarly, after clicking ‘Hint’ button twice, half of the image is displayed. Likewise, user can unveil the whole image after clicking the ‘Hint’ button four times.

The points calculations is done in such a way that, if the user rightly answers the question without taking any hints then, he/she can get maximum points for that questions. If the user clicks the ‘Hint’ button once and sees one portion of the image, then some points are deducted. Similarly, if the user chooses to use the ‘Hint’ button again to see two portions of the image, some more points will be deducted. On the other hand, if the user answers incorrectly, he/she will get zero points.

Lastly, after attempting all the questions, the user is redirected to the scores page which displays the points of that user. Also, we have displayed the correct answers of the questions below the score and the answers the user chose. This way user can review his/her performance in the quiz.  

### UML Diagrams
 
#### Class Diagram
![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/UML_diagrams_images/Class_Diagram.png)

#### Activity Diagram
![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/UML_diagrams_images/Activity_Diagram.png)

#### UseCase Diagram
![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/UML_diagrams_images/UseCase_Diagram.png)

#### System Sequence Diagrams
![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/UML_diagrams_images/System_Sequence_1.png)

![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/UML_diagrams_images/System_Sequence_2.png)

![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/UML_diagrams_images/System_Sequence_3.png)

![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/UML_diagrams_images/System_Sequence_4.png)


### Design notes
![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/designImages/brainstorming1.jpg)
![alt text](https://github.com/nguyensjsu/fa18-202-team-flash/blob/master/designImages/brainstorming2.jpg)


