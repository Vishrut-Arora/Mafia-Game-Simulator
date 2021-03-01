# Mafia-Game-Simulator

Mafia is a popular party game that requires one to think, manipulate, and deceive others in
order to win. 
This is a mafia game simulator. For this project,
I have used OOPs concepts like inheritance and polymorphism, demonstration of object
comparison, and object equality check.
## Rules of the game:
### Plot: 
There is a village of N players. A player can be either a commoner, a detective, a healer,
or a mafia. A commoner only knows that he is a commoner. A detective knows all the other
detectives. A mafia knows all the other Mafia players. A healer knows all other healers in the
game.
Objectives: The objective for the mafias is to kill or eliminate all the non-mafias such that the
ratio of the alive mafias to all others is 1:1. A player can be eliminated in two ways: 1) By being
killed by the Mafia or 2) Be eliminated in a vote out. Once a player is eliminated, they cannot be
brought back to life. Mafias cannot kill themselves.
The objective for all other players(except the mafias) is to eliminate the mafias through a vote
out(as the Mafias cannot be killed). Therefore, by using special powers of detectives and
healers, they are required to save themselves and vote out the Mafias.
### Role of different type of players:
1. Mafia: To kill all other players to achieve a 1:1 ratio. They start with an HP of 2500 each.
2. Detective: They can randomly test one of the players (except detective) to test whether
the player is mafia or not. If they correctly identify a mafia, the caught mafia will be voted
out in that round by default.They start with an HP of 800 each.
3. Healer: They randomly select a player from the game to give him a boost of 500 HP (All
players, including mafias and healers themselves). They start with an HP of 800 each.
4. Commoner: They don’t have any special role. They only take part in the voting process. 
They start with an HP of 1000 each.
### End of Game:
The game ends when either all mafias are voted out or the ratio of mafias to others becomes
1:1.
The Mafia wins in the latter case and loses in the former.
You need to announce the winners at the end of the game along with the roles of each player.
