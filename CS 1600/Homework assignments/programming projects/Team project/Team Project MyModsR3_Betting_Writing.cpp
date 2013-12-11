/********************************************************************************************************************************************* 
 * Team Project
 * Black Jack
 * Programmers:	Mark Eatough
 *						Jason Brinton
 *						Derek Moulton
 *						Bryce Wengren
 
 * Course: 		CS 1600 
 * Created 		April 4, 2013
 * Modified:	Game now has: Money, Betting, hit/stay, dealer rules, replay, exit, reset.  Tested and shown to work without any bugs so far
 					Still need: BJ/Bust check, Ace rules, Hidden dealer
 ***********************************************************************************************************************************************/
#include "TeamProjectFunctions.cpp"
#include <fstream>
   using namespace blackJackNamespace;
   
   int main()
   {	
      double money = 0;
      double betMoney = 0;
      double BJwin, regWin;
   //create an array of ranks
      string rank[RANK] = {"Ace ",
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
      string suite[SUITE] = {"Diamonds",
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
            case'1':  // Play blackjack
               system("cls");
               cout << "Total Available Money is $ " << money << endl;
               cout << "How much money do you want to bet? $";
               cin >>betMoney;
               system("cls");
               cout  << "Total Available Money is $" << money - betMoney << endl;   
               cout << "Your bet is: $"<<betMoney <<"\n";
            	
               resetHand(dealer); // Shuffles deck for new game
               resetHand(user);
               dealerTotal = 0;
               userTotal = 0;
            	
               dealHand(dealer, user, deck, cardsUsed);
               // BJ/BUST CHECK FUNCTION HERE
            
               cout << "\nThe Dealer's Hand:" << endl;
               displayDealerHand(dealer);
               cout << endl;
            	
               cout << "\nYour Hand:" << endl;
               displayUserHand(user);
               cout << endl;
            		
               char decision;
            
               do{ // Submenu for playing the game
                  cout	<<"\n\nChoose an Option" << endl
                        << "4. Hit"              << endl
                        << "5. Stay"             << endl << endl
                        << "Your Decision? ";
               //get a menu choice
                  cin >> decision;
               
                  switch(decision)
                  {
                     case'4':  // Hit.  Draws card and displays hand and total
                        system("cls");
                        cout  << "Total Available Money Is $" << money - betMoney << endl;
                        cout << "Your bet is: $"<<betMoney;
                     	
                        dealUser(user, deck, cardsUsed); // Draw card
                        
                     	// BJ/BUST CHECK FUNCTION HERE
                     
                        cout << "\n\nThe Dealer's Hand:" << endl;
                        displayDealerHand(dealer);
                        cout << endl;
                     
                        cout << "\n\nYour Hand:" << endl;
                        displayUserHand(user);
                        
                        break;
                  	
                     case'5': // 5 is stay choice. Dealer's turn.
                        system ("cls");
                        
                        cout << "Total Available Money is $" << money - betMoney << endl;
                        cout << "Your bet is: $" << betMoney;
                     			 
                        if(dealerTotal <= 17) // Dealer's 17 hit rule
                           dealDealer(dealer, deck, cardsUsed);
                      	// BJ/BUST CHECK FUNCTION HERE
                     	
                        cout << "\n\nThe Dealer's Hand:" << endl;
                        displayDealerHand(dealer);
                     	
                        cout << endl;
                     	
                        cout << "\nYour Hand" << endl;
                        displayUserHand(user);
                        
                        if (userTotal == 21)
                        {	
                           BJwin = betMoney*5;
                           money = money + BJwin;
                           cout << "\n\nYOU HAVE BLACKJACK!!!!! YOU WIN $" << BJwin << endl;
                           cout << "Total Available Money is $" << money << endl;
                        }
                        
                        if (userTotal<=20)
                        {	
                           if(dealerTotal > 21)
                           {
                              regWin = betMoney*2;
                              money = money + regWin;
                              cout <<"\n\nDEALER BUSTS!!! YOU WIN $" << regWin << endl;
                              cout << "\nTotal money in the banks is $" << money << endl;
                           }
                        }
                        
                        if (userTotal == dealerTotal)
                        {
                           cout << "\n\nDealer Push!!! You win your bet back: $" << betMoney << endl;
                           cout << "\nTotal Available Money is $" << money << endl;
                        }
                        
                        if (userTotal > 21)
                        {
                           money = money - betMoney;
                           cout <<"\n\nYOU BUSTED!!! YOU LOSE $" << betMoney << endl;
                           cout << "\nTotal Available Money is $" << money << endl;
                        }
                        
                        if (dealerTotal <= 21)
                        {
                           if(userTotal < dealerTotal)
                           {
                              money = money - betMoney;
                              cout << "\n\nYOU LOST!!! YOU LOSE $" << betMoney << endl;
                              cout << "\nTotal Available Money is $" << money << endl;
                           }
                        }
                        
                     	// write winnings to file and store for money
                     
                     default:
                        if (decision != '5')
                        {
                           cout << "invalid choice!" << endl;
                        }
                        else
                           cout << "\n\nEnd of Game" << endl;
                        system("pause");
                        break;
                  }//end inner switch
                  
               }while(decision != '5');
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
               cout << "Invalid Choice!" << endl;
               system("pause");
               break;
               
         }//end outer switch
         // Write money/winnings to file for future games
         ofstream outFileMoney;
         outFileMoney.open("Money.txt");
         outFileMoney << money;
         outFileMoney.close();
      	
      }while(choice != '2');
      
   }//end main method