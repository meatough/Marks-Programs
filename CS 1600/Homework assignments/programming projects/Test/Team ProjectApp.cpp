/*********************************************************** 
 * Team Project
 * Black Jack
 * Programmers:	Mark Eatough
 *						Jason Brinton
 *						Derek Moulton
 *						Bryce Wengren
 * Course: 		CS 1600 
 * Created 		April 4, 2013
 * Modified:	
 ***********************************************************/
//#include<C:\\MyCPP\\Team Project\\TeamProjectFunctions.cpp>
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
	
	//do while method to run applications from menus
	do{
	//display the menu
	system("cls");
	cout	<<"Main Menu" << endl << endl
			<<"1. Play Blackjack" << endl
			<<"2. Exit" << endl << endl
			<<"Your choice: ";
			
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
					
					cout << "\n\ndealers hand:" << endl;
					displayDealerHand(dealer);
					cout << endl;
					
					cout << "\n\nYour hand:" << endl;
					displayUserHand(user);
					cout << endl;
					
					char decision;
					
					do{
					//display the game menu
					//system("cls");
					cout	<<"Game Menu" << endl << endl
							<<"3. Hit" << endl
							<<"4. Stay" << endl << endl
							<< "Your Decision? ";
					//get a menu choice
					cin >> decision;
					
					switch(decision)
					{
					
						case'3':
							system("cls");			
                     dealUser(user, deck, cardsUsed); // draw card
                     
							//output player's hands
                     cout << "\n\nThe Dealer's Hand:" << endl;
                     displayDealerHand(dealer);
                     cout << endl;             
                     cout << "\n\nYour Hand:" << endl;
                     displayUserHand(user);
							cout << endl;
							
							//check user for blackjack
							//blackJack = isBlackjack(userTotal);
							if(userTotal == 21)
							{
								cout << "\n\nBlackjack!!! Winner winner chicken dinner!!!" << endl;
								decision = '*';
							}
							//check user for bust
							if(userTotal > 21)
							{
								cout << "\n\nSucks to suck, you got bust" << endl;
								decision = '*';
							}	
						break;
							
						 	case'4': 
                     	system ("cls");
								
								         			 
                     	if(dealerTotal < 17) // Dealer's 17 hit rule
								{
         						//for(i; i < 17; i+=value)
									while(dealerTotal < 17)
									{                  
										dealDealer(dealer, deck, cardsUsed);
										displayDealerHand(dealer);
										displayUserHand(user);
									}
								}
								                     	
                     cout << "\n\nThe Dealer's Hand:" << endl;
                     displayDealerHand(dealer);
                     	
                     cout << endl;
                     	
                     cout << "\nYour Hand" << endl;
                     displayUserHand(user);
							
							//check dealer for blackjack
							if(dealerTotal == 21)
							{
								cout << "\n\nDealer got Blackjack, you loose.... So pay up!!!" << endl;
								decision = '*';
							}
							//check dealer for bust
							if(dealerTotal > 21)
							{
								cout << "\n\nDealer busts... You are one lucky duck" << endl;
								decision = '*';
							}
							//check for winner in no blackjack/bust
							if(dealerTotal > userTotal)
							{
								cout << "Dealer wins " << dealerTotal << " to " << userTotal 
										<< "Pay up!!!" << endl;
										
								decision = '*';
							}
							if(userTotal > dealerTotal)
							{
								cout << "You win!!! " << userTotal << " to " << dealerTotal 
										<< "Collect your winnings!!!" << endl;
										
								decision = '*';
							}
							if(userTotal == dealerTotal)
							{
								cout << "Push... " << userTotal << " to " << dealerTotal
										<< endl <<"No money changes hands... LAME!!!" << endl;
								decision = '*';
							}
							

							decision = '*';
								
							break;
							
							/*case '+':
								if(isBlackjack(userTotal) == true)
								{
									cout << "Blackjack!!! Winner winner chicken dinner!!!" << endl;
								}
								else if(isBust(userTotal) == true)
								{
									cout << "Sucks to suck, you got bust" << endl;
								}
								else if(isBlackjack(dealerTotal) == true)
								{
									cout << "Dealer got Blackjack, you loose.... So pay up!!!" << endl;
								}
								else if(isBust(dealerTotal) == true)
								{
									cout << "Dealer busts... You are one lucky duck" << endl;
								}
								else
								{
									if(dealerTotal > userTotal)
									{
										cout << "Dealer wins " << dealerTotal << " to " << userTotal 
										<< "Pay up!!!" << endl;
									}
									
									else if(userTotal > dealerTotal)
									{
										cout << "You win!!! " << userTotal << " to " << dealerTotal 
										<< "Collect your winnings!!!" << endl;
									}
									else
									{
										cout << "Push... " << userTotal << " to " << dealerTotal
										<< endl <<"No money changes hands... LAME!!!" << endl;
									}
								}
								
								decision = '*';
							break;
             			*/           
							case'*': break;
					
						default:
						cout << "invalid choice!" << endl;
						system("pause");
						break;
					}//end inner switch
				}while(decision != '*');
				
				system("pause");
				break;
					
				case'2': break;
					
					default:
					cout << "invalid choice!" << endl;
					system("pause");
					break;
			}//end outer switch
	
	}while(choice != '2');
}//end main method

//program 9.2 good example for how to handle making sure cards are not repeated

/*maybe use trim function to parse out strings to first word only
Then use if statement to associate values with cards
create int values for dealer and user totals, add as game progresses
remember to decrement by 10 if hand includes an ace and is over 21*/