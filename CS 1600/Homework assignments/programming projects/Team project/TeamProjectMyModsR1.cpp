/********************************************************************************************************************************************* 
 * Team Project
 * Black Jack
 * Programmers:	Mark Eatough
 *						Jason Brinton
 *						Derek Moulton
 *						Bryce Wengren
 
 * Course: 		CS 1600 
 * Created 		April 4, 2013
 * Modified:	Derek -- I've done the hit/stay and cleaned up some of the display. I'll do betting next.
 								Note: I've modified the functions, so you'll need to include those.
								
					We still need:  Jason: Bust, BlackJack(21) function, (check for >= 21 then check against = vs >)
										 Bryce: Win/lose logic and display.   See end of case '4'
										 Mark?: Ace rules (total hand with ace)
										 
										 Misc : Hiding dealer bottom card and total until end -- whoever finishes first
 ***********************************************************************************************************************************************/
#include "TeamProjectFunctions.cpp"

using namespace blackJackNamespace;

static bool blackJack;
static bool bust;

   int main()
   {
   //create an array of ranks
      string rank[RANK] = 	{	"Ace ",
         						"Duece ",
         						"Three ",
         						"Four ",
         						"Five ",
         						"Six ",
         						"Seven ",
         						"Eight ",
         						"Nine ",
         						"Ten ",
         						"Jack ",
         						"Queen ",
         						"King "
         					};
   //create an array of suites
      string suite[SUITE] = 	{
         							"Diamonds",
         							"Clubs",
         							"Hearts",
         							"Spades"
         						};
   //create an array with 52 positions 
      string deck[RANK*SUITE];
   
   //populate the deck array using the rank and suite arrays to make 52 cards
      populateDeck(deck, rank, suite);
   
   //create arrays to keep track of players' hands and the cards used 
      string dealer[11];
      string user[11];
      int cardsUsed[RANK*SUITE];
      char choice;
      initCardsUsed(cardsUsed);
   
   //method to make sure array of cards is created correctly
   //displayDeck(deck);
   
   
   //do while method to run applications from menus
      do{
      //display the menu
         system("cls");
         cout	<< "Main Menu"         << endl << endl
               << "1. Play Blackjack" << endl
               << "2. Exit"           << endl << endl
               << "Your choice: ";
      	
      	//get a menu choice
         cin >> choice;
      				
      	//switch the choice
         switch(choice)
         {
            case'1':
               system("cls");
            	
               resetHand(dealer);
               resetHand(user);
					
					blackJack = false;
					bust = false;     
            	
               dealHand(dealer, user, deck, cardsUsed);
               // BJ/BUST CHECK FUNCTION HERE
            
               cout << "\nThe Dealer's Hand:" << endl;
               displayDealerHand(dealer);
               cout << endl;
            	
               cout << "\nYour Hand:" << endl;
               displayUserHand(user);
               cout << endl;
            	
               //printUsed(cardsUsed);
            	
               char decision;
            
               do{
               //display the menu
               //system("cls");
                  cout	<<"\n\nChoose an Option" << endl
                        << "3. Hit"              << endl
                        << "4. Stay"             << endl << endl
                        << "Your Decision? ";
               //get a menu choice
                  cin >> decision;
               
                  switch(decision)
                  {
                     case'3':  // Hit.  Draws card and displays hand and total
                        system("cls");
                        dealUser(user, deck, cardsUsed); // draw card
                        
                     	// BJ/BUST CHECK FUNCTION HERE
                     
                        cout << "\n\nThe Dealer's Hand:" << endl;
                        displayDealerHand(dealer);
                        cout << endl;
                     
                        cout << "\n\nYour Hand:" << endl;
                        displayUserHand(user);
								
								blackJack = isBlackjack(userTotal);
								if(blackJack == true)
								{
									decision = '+';
								}
							
								bust = isBust(userTotal);
								if(bust == true)
								{
									decision = '+';
								}

                        //cout << endl;
                        
                        break;
                  	
                     case'4': // 4 is stay choice.  This should end turn and dealer takes turn
                     // dealer goes.  Then total vs total at the end of case '4'.
                        system ("cls");
								
								//while(dealerTotal <=17)
								//{             			 
                        if(dealerTotal <= 17) // Dealer's 17 hit rule
                           dealDealer(dealer, deck, cardsUsed);
								//}                      	// BJ/BUST CHECK FUNCTION HERE
                     	
                        cout << "\n\nThe Dealer's Hand:" << endl;
                        displayDealerHand(dealer);
                     	
                        cout << endl;
                     	
                        cout << "\nYour Hand" << endl;
                        displayUserHand(user);
								
								blackJack = isBlackjack(dealerTotal);
								if(blackJack == true)
								{
									decision = '+';
								}
							
								bust = isBust(dealerTotal);
								if(bust == true)
								{
									decision = '+';
								}
								break;
                     	// Who wins?  Check Push.  To access the values of the cards in hand look at cardValue (dealer/user[i]) etc
                     	// You win this much $$$, you lose this much $$$  Total $$$.  Play again, or quit.  Default, it just starts over as is
                     	//  * The $$ is from an outside file.  Use variable name "money" for now until it's made (for display etc)
                     case('+'):break;
                     default:
                        cout << "invalid choice!" << endl;
                        break;
                  }//end inner switch
               }while(decision != '+');
            
               system("pause");
               break;
         						
            case'2': 
               break;
         		
            default:
               cout << "Invalid Choice!" << endl;
               system("pause");
               break;
            
            	
               
         }//end outer switch
      
      }while(choice != '2');
   }//end main method

//program 9.2 good example for how to handle making sure cards are not repeated

//remember to decrement by 10 if hand includes an ace and is over 21*/