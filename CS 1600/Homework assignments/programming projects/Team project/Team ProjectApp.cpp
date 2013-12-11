/*********************************************************** 
 * Team Project
 * Black Jack
 * Programmers:	Mark Eatough		ace 11 or 1, track money
 *						Jason Brinton		black jack or bust
 *						Derek Moulton		hit stay algorithm
 *						Bryce Wengren		select winner
 * Course: 		CS 1600 
 * Created 		April 4, 2013
 * Modified:	April 30, 2013
 
 *This program contains the main method to execute 
 *a blackjack game.
 ***********************************************************/
#include "TeamProjectFunctions.cpp"
#include <fstream>

using namespace blackJackNamespace;

static bool blackJack;
static bool bust;

int main()
{
	//double values to keep track of money
	double money = 0;
   double betMoney = 0;
   double BJwin, regWin;
	
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
	char decision;
	initCardsUsed(cardsUsed);
	
	// Files for betting money of the player
   string MoneyFile = "Money.txt";
   string ResetMoneyFile = "ResetMoney.txt";
   ifstream inFileMoney;
   ifstream inFileResetMoney;
      
   inFileMoney.open("Money.txt");
   if(inFileMoney.fail())
   {
   	cout << "\n The file: " << MoneyFile << " failed to open" << endl;
      system("pause");
      exit(1);
   }
   		
   inFileMoney >> money;
   inFileMoney.close();

	
	//do while method to run applications from menus
	do{
	//display the menu
	system("cls");
         cout  << "Total Available Money is $" << money << endl;
         cout	<< "\nWelcome to BlackJack!  Select an option below.\n" << endl
               << "1. Play Blackjack" << endl
               << "2. Exit"           << endl 
               << "3. Reset Game & Money"      << endl << endl
               << "Your choice: ";
			
			//get a menu choice
			cin >> choice;
						
			//switch the choice
			switch(choice)
			{
				case'1':
					system("cls");
               cout << "Total Available Money is $ " << money << endl;
               cout << "How much money do you want to bet? $";
               cin >>betMoney;
               system("cls");
               cout  << "Total Available Money is $" << money - betMoney << endl;   
               cout << "Your bet is: $"<<betMoney <<"\n";

					
					resetHand(dealer);
					resetHand(user);
					blackJack = false;
					bust = false;
					
					dealHand(dealer, user, deck, cardsUsed);
					
					cout << "\n\nDealer's Hand:" << endl;
					displayDealerHand(dealer);
					cout << endl;
					
					cout << "\n\nYour Hand:" << endl;
					displayUserHand(user);
					cout << endl;
					
					//check if user and dealer have blackjack
					if(isBlackjack(userTotal) == true && isBlackjack(dealerTotal) == true)
					{
						
						cout << "\n\nThe Dealer's Hand:" << endl;
                  displayDealerHandEnd(dealer);
                     	
                  cout << endl;
                     	
                  cout << "\nYour Hand: " << endl;
                  displayUserHand(user);
								
						cout << "\n\nDealer Push!!! You win your bet back: $" << betMoney << endl;
                  cout << "\nTotal Available Money is $" << money << endl;

						
						blackJack = true;
					}//end check user for blackjack

					
					//check user for blackjack
					if(isBlackjack(userTotal) == true)
					{
						
						cout << "\n\nThe Dealer's Hand:" << endl;
                  displayDealerHandEnd(dealer);
                     	
                  cout << endl;
                     	
                  cout << "\nYour Hand: " << endl;
                  displayUserHand(user);
								
						BJwin = betMoney*5;
                  money = money + BJwin;
                  cout << "\n\nYou Have Blackjack!!!!! You Win $" << BJwin << endl;
                  cout << "Total Available Money is $" << money << endl;

						
						blackJack = true;
					}//end check user for blackjack
					
					//check dealer for blackjack
					if(isBlackjack(dealerTotal) == true)
					{
						
						cout << "\n\nThe Dealer's Hand:" << endl;
                  displayDealerHandEnd(dealer);
                     	
                  cout << endl;
                     	
                  cout << "\nYour Hand: " << endl;
                  displayUserHand(user);
						
						money = money - betMoney;		
						cout << "\n\nDealer got Blackjack" << endl;
						cout <<"\n\nYou Lose $" << betMoney << endl;
						cout << "\nTotal Available Money is $" << money << endl;
						
						blackJack = true;
								
					}//end check dealer for blackjack
					
				do{
					//display the game menu
					if (blackJack == false)
					{
		                  cout	<<"\n\nChoose an Option" << endl
                        << "4. Hit"              << endl
                        << "5. Stay"             << endl << endl
                        << "Your Decision? ";

						//get a menu choice
						cin >> decision;
					}
					else
					{
						decision = '*';
					}
					
					switch(decision)
					{
					
						case'4':
							system("cls");			
							
							cout  << "Total Available Money Is $" << money - betMoney << endl;
                     cout << "Your bet is: $"<<betMoney;

							
                     dealUser(user, deck, cardsUsed); // draw card
                     
							//output player's hands
                     cout << "\n\nThe Dealer's Hand:" << endl;
                     displayDealerHand(dealer);
                     cout << endl;             
                     cout << "\n\nYour Hand:" << endl;
                     displayUserHand(user);
							cout << endl;
							
							//check user for blackjack
							if(isBlackjack(userTotal) == true)
							{
								
								cout << "\n\nThe Dealer's Hand:" << endl;
                        displayDealerHandEnd(dealer);
                     	
                        cout << endl;
                     	
                        cout << "\nYour Hand: " << endl;
                        displayUserHand(user);
								
										
								BJwin = betMoney*5;
                  		money = money + BJwin;
                  		cout << "\n\nYOU HAVE BLACKJACK!!!!! YOU WIN $" << BJwin << endl;
                  		cout << "Total Available Money is $" << money << endl;
								
								
								decision = '*';
								
							}//end check user for blackjack
							//check user for bust
							if(isBust(userTotal) == true)
							{
								
								cout << "\n\nThe Dealer's Hand:" << endl;
                        displayDealerHandEnd(dealer);
                     	
                        cout << endl;
                     	
                        cout << "\nYour Hand: " << endl;
                        displayUserHand(user);
							
								cout << "\n\nYou Bust" << endl;
								cout <<"\n\nYOU LOSE $" << betMoney << endl;
								money = money - betMoney;
								cout << "\nTotal Available Money is $" << money << endl;

								
								decision = '*';
							}//end check user for bust 	
						break;
							
						 	case'5': // 4 is stay choice.  This should end turn and dealer takes turn
                     // dealer goes.  Then total vs total at the end of case '4'.
                     	system ("cls");
								
								cout << "Total Available Money is $" << money - betMoney << endl;
                        cout << "Your bet is: $" << betMoney;
								
								         			 
                     	if(dealerTotal < 17) // Dealer's 17 hit rule
								{
         						
									while(dealerTotal < 17)
									{ 
										cout << endl << endl;                 
										dealDealer(dealer, deck, cardsUsed);
										displayDealerHand(dealer);
										cout << endl << endl;
										displayUserHand(user);
										cout << endl << endl << endl;
									}
								}
                     	
                        cout << "\n\nThe Dealer's Hand:" << endl;
                        displayDealerHandEnd(dealer);
                     	
                        cout << endl;
                     	
                        cout << "\nYour Hand: " << endl;
                        displayUserHand(user);
								
								if(isBlackjack(dealerTotal) == true)
								{
									cout << "\n\nDealer got Blackjack, you loose.... So pay up!!!" << endl;
									decision = '*';
									
									cout <<"\n\nYOU LOSE $" << betMoney << endl;
									money = money - betMoney;
									cout << "\nTotal Available Money is $" << money << endl;
									
									
								}
								else if(isBust(dealerTotal) == true)
								{
									cout << "\n\nDealer busts... You are one lucky duck" << endl;
									regWin = betMoney*2;
									cout <<"\n\nYOU WIN $" << regWin << endl;
                           money = money + regWin;
									cout << "\nTotal money in the banks is $" << money << endl;
									
									decision = '*';
								}
								else
								{
									if(dealerTotal > userTotal)
									{
										cout << "\n\nDealer wins " << dealerTotal << " to " << userTotal 
										<< endl;
										
										money = money - betMoney;
										cout <<"\n\nYOU LOSE $" << betMoney << endl;
										cout << "\nTotal Available Money is $" << money << endl;
										
										decision = '*';
									}
									
									else if(userTotal > dealerTotal)
									{
										cout << "\n\nYou win!!! " << userTotal << " to " << dealerTotal 
										<< " Collect your winnings!!!" << endl;
										
										
										
										regWin = betMoney*2;
										cout <<"\n\nYOU WIN $" << regWin << endl;
                           	money = money + regWin;
										cout << "\nTotal money in the banks is $" << money << endl;
										
										decision = '*';
									}
									else
									{
										cout << "\n\nDealer Push!!! You win your bet back: $" << betMoney << endl;
                           	cout << "\nTotal Available Money is $" << money << endl;

										decision = '*';
									}
								}
							break;
							                        
							case'*': break;
					
						default:
						cout << "invalid choice!" << endl;
						system("pause");
						break;
					}//end inner switch
				}while(decision != '*');
				
				system("pause");
				break;
					
				case'2': 
               cout << "Goody-bye!" << endl;
               system("pause");
               break;
               
            case '3':
               inFileResetMoney.open("ResetMoney.txt");
               if(inFileMoney.fail())
               {
                  cout << "\n The file: " << ResetMoneyFile << " failed to open" << endl;
                  system ("pause");
                  exit(1);
               }
            	
               inFileResetMoney >> money;			
               cout << "Money has been reset to the default value of: $" << money << endl;
               system ("pause");
               inFileResetMoney.close();
               break;
					
					default:
					cout << "invalid choice!" << endl;
					system("pause");
					break;
			}//end outer switch
			
		ofstream outFileMoney;
      outFileMoney.open("Money.txt");
      outFileMoney << money;
      outFileMoney.close();
	
	}while(choice != '2');
}//end main method