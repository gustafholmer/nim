# nim
An implementation of the classic game "Nim" using Java. This project was part of an assignment in object-oriented programming course.

# Author: Gustaf Holmer

# How to run the program:
Compile and then run nmGame.java.

# Program structure:
I wrote the program by having a class called "nmGame" where the main method is available that takes the input from the terminal when the game is started in the terminal. An object is created from the "Game" class. In "Game" there is the method "activate" where two player objects are created. You can choose the type of player to play the game, computers or human players. These players inherit methods from class player (). This gives a structure to the program and makes it possible to see what unique methods are needed in the inherited player classes.

When the selection of the type of player you want "Game" is ready, a while loop is activated that loops through itself until the "startValue" from the input in the terminal reaches 1, when this happens the game ends. In the while loop, methods such as input from the terminal from human players are activated. In the loop, the current number of knitting needles is written and which player ultimately wins. I made the decision that when it says 0 in the variable "answer1", it means the next player is lost.

In the superclass "player", the player classes inherit the method "playerTurn". The method is overwritten in each player class. This is because this is where the choice of the amount of knitting needles is chosen.

In "ComputerPlayer"'s method "playerTurn" there is the algorithm that with "java.util.random" selects random numbers. The numbers selected are between 0 and the maximum ceiling is the current amount of knitting needles. It tests the numbers in the common method "inputCheck", which is also found in "HumanPlayer". Once the number has been checked that it is allowed, this number is then subtracted from the current amount of needles. However, many random numbers are tested until one is allowed. I could have done this step better by letting it select numbers in the amount of current stitches.

"PlayerTurn" in "HumanPlayer" becomes "overrided" to receive input using "java.util.scanner". The input is tested in the inherited method "inputCheck". A warning message is printed if an unauthorized number is entered. In this case, the loop is restarted.

In the superclass there is a method "inpuCheck" which will return "false" if the selected digit does not meet the requirement of being at most half of the digits for which the entered digit is zero. The method could therefore be used in both the human player and the computer player.

In the "Game" class, the selected number from the input made in the "playerTurn" then returns. This number is then subtracted from the starting number defined at the beginning of the game. If the number sent to "turnPlayer" is one, the number 0 is automatically returned and the game ends

