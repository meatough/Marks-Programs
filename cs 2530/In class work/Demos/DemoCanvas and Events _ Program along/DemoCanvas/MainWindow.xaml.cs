using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace DemoCanvas
{
   public partial class MainWindow : Window
   {
      public MainWindow()
      {
         InitializeComponent();
         DrawEllipse(50, Brushes.Gold);
         //BackgroundButton_Click(sender, e);
         //OverlappingCirclesButton_Click(sender, e);

      }

      // Draw Circle
      private void DrawEllipse(double top, Brush color)
      {
          Ellipse ellipse = new Ellipse();
          ellipse.Height = 200;
          ellipse.Width = 400;
          ellipse.Fill = color;

          Canvas.SetTop(ellipse, top);
          Canvas.SetLeft(ellipse, 50);

          MyCanvas.Children.Add(ellipse);
      }

      // Change Background
      private void BackgroundButton_Click(object sender, RoutedEventArgs e)
      {

          MyCanvas.Background = (MyCanvas.Background == Brushes.DarkRed ? Brushes.Navy : Brushes.DarkRed);
          //below is a longer way to do the same thing as above.
          /*if (MyCanvas.Background == Brushes.DarkRed)
          {
              MyCanvas.Background = Brushes.Navy;
          }
          else
          {
              MyCanvas.Background = Brushes.DarkRed;
          }*/
      }
      // TODO 3: Overlapping Circles
      private void OverlappingCirclesButton_Click(object sender, RoutedEventArgs e)
      {
          DrawEllipse(50, Brushes.Gold);
          DrawEllipse(150, Brushes.Lime);
          DrawEllipse(250, Brushes.Gold);
      }
   }
}
