OIBSIP Task 1 - Guess the Number Game 🎮

💡 Description
This is a simple **Java-based console game** where the user tries to guess a randomly generated number. The game gives feedback to the user whether their guess is too low, too high, or correct.

🛠️ How It Works
- The program generates a random number between 1 and 100.
- The user has limited attempts to guess the number.
- After each guess, the program provides a hint.
- If the user guesses correctly, a congratulatory message is shown.
- If the user fails within the allowed attempts, the correct number is revealed.

⚙️ Technologies Used
- Java
- Scanner for input
- Random class

 🚀 Run the Program
1. Open your Java IDE (Eclipse/IntelliJ/VSCode) or terminal.
2. Compile the file:
   ```bash
   javac GuessTheNumber.java
3. Run the program
   java GuessTheNumber

Errors Faced and Solution

Error: Scanner not closed warning 
Solution: Used sc.close() after input

Error: Logic skipping inputs 
Solution: Ensured nextInt() and loop conditions were handled properly

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


## ✅ `oibsip_task2` – **Reservation System**

📄 OIBSIP Task 2 - Railway Reservation System 🚆

💡 Description
A Java-based console application that simulates a basic railway reservation system. It includes user login, reservation, cancellation, and viewing ticket details.

 🛠️ How It Works
- Login System: for passengers (static username/password used).
- Reservation Module: where users enter details like name, train number, and seats.
- Cancellation Module: that removes a reservation by name.
- Display Module: to show current reservations.

 📋 Features
- Add new reservations
- Cancel existing reservations
- View all reserved tickets
- Input validation

 ⚙️ Technologies Used
- Java
- Classes and Objects
- ArrayLists
- Scanner

🚀 Run the Program
1. Open your Java IDE or terminal.
2. Compile the file:
   ```bash
   javac ReservationSystem.java
3. Run this program:
   java ReservationSystem

Error Faced and Solution:

Error: ArrayIndexOutOfBounds 

Solution: Checked list size before accessing elements


Error: Input mismatch exception 

Solution: Used nextLine() correctly after nextInt()

Error: Reservation not found on cancellation 

Solution: Handled case-insensitive string matching

Failed in connecting Database.

Note: Don't forget to install Jdbc and Remeber to Start the APASHE and MYsql On Xampp Control paanel before running this program.


