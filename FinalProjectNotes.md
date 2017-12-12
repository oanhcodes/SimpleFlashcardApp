# Final Project Submission notes

####Project Contributors: Linda Ho & Eunice Montenegro

## Data structures Implemented

1. ArrayList
2. Queue 
3. Map<Card, Integer>

## Classes Created
1. Card
2. Deck
3. FlashcardGame
4. ScoreCard (Map-based class based off of Lab 8)

## Interface Used

1. SimpleQueue (Used interface from Lab 6)

## Project Description
This simple flashcard game uses an array list to hold newly created cards. The array list of cards is then used to populate a deck (queue) and to create a scorecard (Map<Card, Integer>) with default values of 0. We chose to use a queue for the deck because we wanted to use first in and first out policy for card retrieval during review.

When the flashcard review starts, the first card in the deck (head of the queue) is retrieved and the question is displayed to the user. The user is prompted for an answer which gets checked for correctness. If the card was answered incorrectly, it is added to the back of the queue. Every time the user provides an answer for a card, the scorecard will increment the value of the card by 1. At the end of the game, the percentage of cards answered correct on the first try is given to the user.

To test our program, we created fake card data for state capitals. As a stretch, we provided an option to create a custom deck of cards. This offers more flexibility for the user. Custom cards get reviewed immediately after being added to the deck queue.

We wrote one test class for Card. We committed to a code freeze Monday 12/11 to ensure we had a working solution to submit.

Our program has limitations due to a lack of database. A database would have allowed us to keep track of decks, users, games played, etc. 

To run the program:

```
./gradlew goJF
```

```
./gradlew verGJF
```

```
./gradlew build
```

```
./build/scripts/SimpleFlashcardApp
```
