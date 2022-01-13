# blackjack-simulator

This repo is a simulation of a simple blackjack game.
It allows for multiple players and interacts with the players through the console.

To run the project, run the BlackjackSimulator class.

Things I would improve if I had more time:
- Test the BlackjackSimulator class more thoroughly: I decided the BlackjackSimulator be a static class which makes it more difficult to test.
Moreover, the code relies on a lot of user input, which poses another difficulty for testing. If I had more time I would reconsider
making it a static class and do more research on how to test thoroughly with user input. One approach may be to modularize it more and split
up the main logic loop. I mainly tested the functionality of the Player class, which, however, mostly consists of simple operations,
 getters, and setters.
- Make the code more robust: it currently does not handle wrong user input (e.g., a string instead of a number).
