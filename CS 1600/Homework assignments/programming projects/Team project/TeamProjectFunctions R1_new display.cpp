/*********************************************************** 
 * Team Project
 * Black Jack
 * Programmers:	Mark Eatough		ace 11 or 1, track money
 *						Jason Brinton		black jack or bust
 *						Derek Moulton		hit stay algorithm
 *						Bryce Wengren		select winner
 * Course: 		CS 1600 
 * Created 		April 4, 2013
 * Modified:	April 
 ***********************************************************/
#include <string>
#include<iostream>

   using namespace std;

//create constant variables for rows and columns
   const int RANK = 13;
   const int SUITE = 4;

//create static ints to keep track of cards
   static int computerIndex = 0;
   static int userIndex = 0;
   static int dealtIndex = 0;
   static int dealerCards;
   static int userCards;
   static int userTotal;
   static int dealerTotal;
   static int d;
   static int u;

   namespace blackJackNamespace
   {
   //method to populate the deck with 52 cards
      void populateDeck(string myDeck[RANK*SUITE], string value[RANK], string icon [SUITE])
      {
         int i, j, k=0;
         string of = "of ";
         string card;
      
         for(i=0; i<RANK; i++)
         {
            for(j=0; j<SUITE; j++)
            {
               card = value[i]+of+icon[j];
            
               myDeck[k] = card;
               k++;
            }
         }
      }
   
   //method to display deck, make sure all cards present
   //will not be in final submission
      void displayDeck(string cards[RANK*SUITE])
      {
         int l;
         for(l = 0;  l < RANK*SUITE; l++)
         {
            cout << cards[l] << endl;
         }		
      }
   
   
   //method to generate a random number to access a card to deal
      int generateRandom()
      {
         int myCard = rand()%52;
         return myCard;
      }//end generateRandom method
   
   //method to check to see if card has already been used 
      int alreadyUsed(int random, int usedCard[RANK*SUITE])
      {
         int newCard;
         for(int i=0; i<RANK*SUITE; i++)
         {
            if(random == usedCard[i])
            {
               newCard = generateRandom();
               random = alreadyUsed(newCard, usedCard);
            }
         }
         return random;
      }
   
   //method to deal card to dealer
      void dealDealer(string computer[11], string myDeck[RANK*SUITE], int used[RANK*SUITE])
      {
         int cardIndex = generateRandom();
         cardIndex = alreadyUsed(cardIndex, used);
         computer[computerIndex] = myDeck[cardIndex];
         used[dealtIndex] = cardIndex;
         computerIndex++;
         dealtIndex++;
         dealerCards++;
      }
   
   //method to deal card to user
      void dealUser(string you[11], string myDeck[RANK*SUITE], int used[RANK*SUITE])
      {
         int cardIndex = generateRandom();
         cardIndex = alreadyUsed(cardIndex, used);
         you[userIndex] = myDeck[cardIndex];
         used[dealtIndex] = cardIndex;
         userIndex++;
         dealtIndex++;
         userCards++;
      }
   
   //method to initialize all values of used array to -1
      void initCardsUsed(int used[RANK*SUITE])
      {
         for(int i=0; i<RANK*SUITE; i++)
         {
            used[i] = -1;
         }
      }
   
   //method to deal two cards to user and two cards to dealer, 
   //only called when game first starts
      void dealHand(string computer [11], string you [11], 
      		string myDeck[RANK*SUITE], int used[RANK*SUITE])
      {
      //shuffle deck
         computerIndex = 0;
         userIndex = 0;
         dealtIndex = 0;
         dealerCards = 0;
         userCards = 0;
         u=0;
         d=0;
         int cardIndex;
         initCardsUsed(used);
      
      //generate dealers first card
         dealDealer(computer, myDeck, used);
      
      //generate users first card
         dealUser(you, myDeck, used);
      
      //generate computers second card
         dealDealer(computer, myDeck, used);
      
      //generate users second card
         dealUser(you, myDeck, used);
      }
   	
   //method to display indexes used, will not be part of final submission
      void printUsed(int used [RANK*SUITE])
      {
         for(int i=0; i<RANK*SUITE; i++)
         {
            cout << used[i] << ", ";
         }
      }
   
   //method to start game from an empty hand
      void resetHand(string hand [11])
      {
         for(int i=0; i<11; i++)
         {
            hand[i] = "";
         }
      }
   //trim the suite off of the card, leaving only the numeric value
      string trimSuite(string card)
      {
         char nextChar;
         for (int i = 0; i < int(card.length()); i++)
         {
            nextChar = card.at(i);
            if(isspace(nextChar))
            {
               string suiteTrim = card.substr(0, i);
               return suiteTrim; 
            }
         }//end inner for loop
         return card;
      }
   //assign values to the cards
      int cardValue(string card)
      {
         int value = 10;
         string myCard = trimSuite(card);
      
         if(myCard == "Ace")
         {
            value = 11;
            return value;
         }
         else if(myCard == "Duece")
         {
            value = 2;
            return value;
         }
         else if(myCard == "Three")
         {
            value = 3;
            return value;
         }
         else if(myCard == "Four")
         {
            value = 4;
            return value;
         }
         else if(myCard == "Five")
         {
            value = 5;
            return value;
         }
         else if(myCard == "Six")
         {
            value = 6;
            return value;
         }
         else if(myCard == "Seven")
         {
            value = 7;
            return value;
         }
         else if(myCard == "Eight")
         {
            value = 8;
            return value;
         }
         else if(myCard == "Nine")
         {
            value = 9;
            return value;
         }
         else
         {
            return value;
         }
      }//end card value method
   
   //method to display the hands of the players
      void displayUserHand(string myHand[11])
      {
         for(int i=0; i<11; i++)
         {
            cout << myHand[i] << "    ";
         }
      
         userTotal = 0;	
      
         for(int i = 0; i <userCards; i++)
         {
            userTotal +=cardValue(myHand[i]);
         }
      
      /*if(userTotal > 21)
      {
      	for(int j = u; j < userCards; j++)
      	{
      		string card = trimSuite(myHand[j]);
      		if (card == "Ace")
      		{
      			userTotal -= 10;
      		}
      	}
      }*/
      
         cout << "\n" << endl;
         cout << "Total = " << userTotal;
      
      }//end displayHand method
   
      void displayDealerHand(string theHand[11])
      {
         for(int i=0; i<11; i++)
         {
            cout << theHand[i] << "    ";
         }
      
         dealerTotal = 0;	
      
         for(int i = 0; i <dealerCards; i++)
         {
            dealerTotal +=cardValue(theHand[i]);	
         }
      
      /*if(dealerTotal > 21)
      {
      	for(int j = d; j < dealerCards; j++)
      	{
      		string card = trimSuite(theHand[j]);
      		if (card == "Ace")
      		{
      			dealerTotal -= 10;
      			if(dealerTotal <= 21)
      			{
      				
      			}
      		}
      	}
      }*/
      
      
         cout << "\n" << endl;
         cout << "Total = " << dealerTotal;
      
      }//end displayHand method
   
   }//end namespace