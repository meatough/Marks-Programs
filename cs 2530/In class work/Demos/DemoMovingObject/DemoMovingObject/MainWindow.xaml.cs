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

namespace DemoMovingObject
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private DispatcherTimer timer = new DispatcherTimer();
        private Rectangle dropSquare;
        private int bottom;

        public MainWindow()
        {
            InitializeComponent();
            InitializeCanvas();
        }

        private void DrawLine(int x1, int y1, int x2, int y2)
        {
            Line line = new Line();
            line.Stroke = Brushes.LightGray;
            line.StrokeThickness = 2;
            line.X1 = x1;
            line.X2 = x2;
            line.Y1 = y1;
            line.Y2 = y2;
            Canvas1.Children.Add(line);
        }

        private void InitializeCanvas() 
        {
            DrawLine(5, 20, 5, 380);
            DrawLine(75, 20, 75, 380);
            DrawLine(155, 20, 155, 380);
            DrawLine(230, 20, 230, 380);
            DrawLine(5, 380, 230, 380);
        }

        private void Button2_Click(object sender, RoutedEventArgs e)
        {
            DropSquare(50, 330);
        }

        private void DropSquare(int from, int to)
        {
            bottom = to;
            dropSquare = newSquare(from);
            timer = new DispatcherTimer();
            timer.Interval = new TimeSpan(0,0,0,0,40);
            timer.Tick += DropSquare;
            timer.Start();
        }

        private Rectangle newSquare(int from)
        {
            Rectangle square = new Rectangle();
            square.Height = 50;
            square.Width = 50;
            square.Fill = Brushes.Gold;
            Canvas.SetTop(square, from);
            Canvas.SetLeft(square, 90);

            Canvas1.Children.Add(square);
            return square;
        }

        private void DropSquare(Object obj, EventArgs args)
        {
            double currentTop = Canvas.GetTop(dropSquare);
            if (currentTop+8 < bottom)
            {
                Canvas.SetTop(dropSquare, currentTop+=8);
            }
            else
            {
                Canvas.SetTop(dropSquare, bottom);
                timer.Stop();
            }
        }


    }
}
