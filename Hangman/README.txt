=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: jastran
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. Collections
  		I used to chose a List, but I changed my collection choices to Sets and Maps. The AI
  		will need a set of words instead of a single word, thus a set is nice for this case. Each
  		words is distinct and the invariant for sets will help with that.  
  		Also, I used a map in two cases, one for the WordScanner class and Evil Hang man class. The
  		one in the WordScanner class is for iterating through a file and keeping tracking of the
  		strings and their word lengths. This is necessary because the game will be prompting for a 
  		valid word length. The map will have keys as the word and the values as the words' length.
  		Also, in Evil Hang man class there's another map for the AI to cheat! This map has 
  		possible board layouts as the key and word families or group of words (sets) as values. 
  		With this logic, the AI will be steps ahead of the user and the AI will choose the maximum
  		set size in the map (to keep it simple of course). With this logic, the AI will change 
  		the guessed word and will be a couple of steps ahead of the user. 

  2. Advanced Topic
  		The EvilHangman AI, without this AI, the traditional Hangman would be too easy to implement.
  		Unlike the original Hangman, the AI will keep a set of words instead of one word. Thus, 
  		at each move the AI will generate all possibilities based on the character input. While 
  		generating possibilities it will need to generate possible boards and word families 
  		associated with that board. The AI will try to cheat as much as possible and be a couple of 
  		steps ahead without the user even knowing!

  3. Testing
  		Testing is very important for my game, since my game requires lots of updates and changes
  		to the current state. It is very important to test each of my classes and making sure that
  		there are correct changes to the state of the game when the user interacts with it. 

  4. File I/O Concept
  		This concept will be used to save and load the state of the game into a file. At any point 
  		the user can save his/her progress (considering how evil the AI is) and the user can 
  		load back the game, once the user feels ready. The idea has both read and write methods 
  		that uses a file. 


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  	Game - specifies the frame and widgets of the GUI, keeps all the GUI stuff together
  	GameCourt - primary game logic for how different objects interact with one another, the layout 
  		for an Evil Hang man game, all the game interactions happens here
  	Evilhangman - responsible for the logic of Hangman and the AI EvilHangman, only the logic of
  		the game is in this class!
  	Words - responsible for takings words from a file and putting them into a map and also keeping 
  		track of the word lengths, this class is basically an iterator to read from a file
  	WordScanner -  uses a BufferedReader to read in lines of words for the EvilHangman AI, 
  		reads a line whenever the next() method is called
  	SaveAndLoad - responsible for reading and writing file to save or load in the current game 
  		state 

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
	No

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  	There is a good separation of functionality and the states are will encapsulated. 
  
	After taking CIS 121, I would refactor the logic of the AI, because if a player
	knows the algorithm, he/she can simply win the game since the logic is very straight forward. 
	The algorithm itself does not mislead the player entirely. Otherwise, I feel that the methods 
	that I written and the data structure choices are pretty good at this level. 

========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  I used this website to understand the logic behind EvilHangman
  http://nifty.stanford.edu/2011/schwarz-evil-hangman/
  
