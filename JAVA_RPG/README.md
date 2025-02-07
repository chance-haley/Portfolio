# Beyond Earth
Hello user! This is my first major project in which the user embarks on a journey to save the world from certain doom.
This is currently a work in progress but contains some playable code. For instance at this point you may complete the initial
tutorial scene, create your character and battle with a desperate man. I plan on adding inventory support, branching story systems and 
an open world map with many things to interact with. 

Dependencies: This programs has no dependacies and is runnable from the Central.java out of the box.

Configuration instructions: This program is meant to execute the CMD prompt and is playable through this window. The game assumes
a standard sized console for spacing, but you may enlarge the window if preferred. 

Sample output: This program usually interacts with the user through the choose() function which allows the user to make a choice.

Design: I am using the Object Oriented Programming language to create several objects that each have certain tasks. For instance my 
Weapons class extends Items and has it's own methods depending on the weapon for how to calculate damage and return it to the battle function.
I also am attempting to implement a map using a cordinate system and an array of rooms with each room containing it's own choices and description.
I am using Central.java as a place to return the character between acts so that I can test more easily without playing through the entire game.
I am using Advent.java for the tutorial act and introduction. Act1.java will be the first act of the main story with a map already built.
I really like the use of objects instead of creating this through a single java file. It allows me a lot of flexibility and ease with creating
new characters, items and rooms.


Challenges: My biggest challenge has been implementing the choose() function with movement. Currently the way movement is programmed requires
manual coding of all the user possibilities. I need to find a way (a method) to allow the user to change room easily without manually moving them.
Another major challenge has been integrating all the methods in the way I want. For instance my getStats method needed to be rewritten so that
it didn't end up looping forever when called after the tutorial from the seeStats methods when on the map. It's the small interactions (being
able to lvlup from the Stat screen) that you add after the fact that requires alot of thinking.

Overview: Overall I hope to continue working on this project and want to finish it to a playable state that is fun for me and others.
Most of my classes and software design seems pretty straightforward and easy to understand. I hope you enjoy playing it.



+## Project Requirements

- A well documented and useful README.md including
  - A description of your project
  - Dependency and Installation instructions **excluding Geany, Git, Java, JavaFX, and ANSI/Unicode support**
  - Instructions on configuration and execution of your project
  - Sample output that may include images with captions and alt text
  - A description of your repository and overall software design 
  - Citations, Challenges, and anything else you feel is relevant
- A functioning project with a working interface (terminal or graphical) that uses many of the following
  - Lists, Sets, and/or Maps
  - Recursion
  - Stacks and/or Queues
  - Custom generic ADTs (array or node based) if the default ones are unsuitable
  - Heaps, Lambdas, and/or Streams
- Well documented and useful Javdoc including 
  - classes
  - methods and 
  - blocks of functionality
  - cryptic individual lines
- Thorough Testing via one of the following
  - Simulated keyboard input
  - JUnit test cases
  - Uploaded JaCoCo report
