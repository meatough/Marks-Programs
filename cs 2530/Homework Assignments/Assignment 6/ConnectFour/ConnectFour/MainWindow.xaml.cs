using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace ConnectFour
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Player player1 = new Player("Player 1", 1);
        private Player player2 = new Player("Player 2", 2);
        private Player player = new Player();
        private Grid myGrid = new Grid();
        private int turn = 1;
        private Brush myBrush;
        //private Button CloseButton = new Button();
        DispatcherTimer timer = new DispatcherTimer();
        public MainWindow()
        {
            InitializeComponent();
            DisplayGrid();
            TextBox.Foreground = Brushes.Red;
            SetColor();
            turn++;
            BackgroundCanvas.Children.Remove(ClickToClose);
        }
        //method to set output color
        public int SetColor()
        {
            int color;
            if (turn % 2 == 0)
            {
                TextBox.Foreground = Brushes.Blue;
                string twoTurn = player2.getName() + "'s turn";
                TextBox.Text = twoTurn;
                color = player1.getColor();
            }
            else
            {
                TextBox.Foreground = Brushes.Red;
                string oneTurn = player1.getName() + "'s turn";
                TextBox.Text = oneTurn;
                color = player2.getColor();
            }
            return color;
        }
        //returns player object, used for output when someone wins
        private Player setPlayer()
        {
            Player myPlayer;
            if (turn % 2 == 0)
            {
                myPlayer = player1;
                myBrush = Brushes.Red;
            }
            else
            {
                myPlayer = player2;
                myBrush = Brushes.Blue;
            }
            return myPlayer;
        }
        //method to draw the circles used in the grid
        public void DrawCircle(int top, int left, Brush color)
        {
            // create circle
            Ellipse circle = new Ellipse();
            circle.Width = 60;
            circle.Height = circle.Width;
            circle.Fill = color;

            // set position 
            Canvas.SetLeft(circle, left);
            Canvas.SetTop(circle, top);

            // add circle to canvas
            BackgroundCanvas.Children.Add(circle);
        }
        
        //prints the current gameGrid
        public void DisplayGrid()
        {
            int size = 60;
            int top = 120;
            int left = 15;
            //Brush brush;
            for (int r = 0; r < myGrid.GetLength(0); r++)
            {
                for (int c = 0; c < myGrid.GetLength(1); c++)
                {
                    if (myGrid.Value(r, c) == 0)
                    {
                        DrawCircle(top, left, Brushes.White);
                    }
                    else if (myGrid.Value(r, c) == 1)
                    {
                        DrawCircle(top, left, Brushes.Red);
                    }
                    else
                    {
                        DrawCircle(top, left, Brushes.Blue);
                    }
                    left += size+8;
                }//end inner for loop
                left = 15;
                top += size+8;
            }//end outer for loop
        }
        //update the game grid through the temp grid
        public int UpdateGameGrid(int column, int color)
        {
            int r;
            for (r = 0; r < myGrid.GetLength(0); r++)
            {
                if (myGrid.tempGrid[r, column - 1] == 0)
                {
                    if (r > 0)
                    {
                        myGrid.tempGrid[r - 1, column - 1] = 0;
                    }

                    myGrid.tempGrid[r, column - 1] = color;
                    myGrid.CopyTempGridToGrid();
                    DisplayGrid();
                }
                else
                {
                    return r;
                }
            }
            return r;
        }//end update grid method
        //method to determine output after button is clicked
        public void Output(int column)
        {
            int color = SetColor();
            int row = UpdateGameGrid(column, color);
            if(myGrid.IsWinner(row - 1, column - 1, color) == true)
            {
                string name = setPlayer().getName();
                TextBox.Foreground = myBrush;
                TextBox.Text = "Congratulations " + setPlayer().getName() + ", you win!!!\n Game Over";
                BackgroundCanvas.Children.Remove(Column1Button);
                BackgroundCanvas.Children.Remove(Column2Button);
                BackgroundCanvas.Children.Remove(Column3Button);
                BackgroundCanvas.Children.Remove(Column4Button);
                BackgroundCanvas.Children.Remove(Column5Button);
                BackgroundCanvas.Children.Remove(Column6Button);
                BackgroundCanvas.Children.Remove(Column7Button);
                BackgroundCanvas.Children.Add(ClickToClose);
            }
            turn++;
            if (myGrid.GridFull())
            {
                TextBox.Foreground = Brushes.Green;
                TextBox.Text = "Grid is full, game ends in a draw, no one wins";
            }
        }
        private void Column1Button_Click(object sender, RoutedEventArgs e)
        {
            int column = 1;
            Output(column);
            if(myGrid.ColumnFull(column))
            {
                BackgroundCanvas.Children.Remove(Column1Button);
            }
        }
        private void Column2Button_Click(object sender, RoutedEventArgs e)
        {
            int column = 2;
            Output(column);
            if (myGrid.ColumnFull(column))
            {
                BackgroundCanvas.Children.Remove(Column2Button);
            }
        }

        private void Column3Button_Click(object sender, RoutedEventArgs e)
        {
            int column = 3;
            Output(column);
            if(myGrid.ColumnFull(column))
            {
                BackgroundCanvas.Children.Remove(Column3Button);
            }
        }

        private void Column4Button_Click(object sender, RoutedEventArgs e)
        {
            int column = 4;
            Output(column);
            if (myGrid.ColumnFull(column))
            {
                BackgroundCanvas.Children.Remove(Column4Button);
            }
        }

        private void Column5Button_Click(object sender, RoutedEventArgs e)
        {
            int column = 5;
            Output(column);
            if (myGrid.ColumnFull(column))
            {
                BackgroundCanvas.Children.Remove(Column5Button);
            }
        }

        private void Column6Button_Click(object sender, RoutedEventArgs e)
        {
            int column = 6;
            Output(column);
            if (myGrid.ColumnFull(column))
            {
                BackgroundCanvas.Children.Remove(Column6Button);
            }
        }

        private void Column7Button_Click(object sender, RoutedEventArgs e)
        {
            int column = 7;
            Output(column);
            if (myGrid.ColumnFull(column))
            {
                BackgroundCanvas.Children.Remove(Column7Button);
            }
        }

        private void ClickToClose_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

    }
}
