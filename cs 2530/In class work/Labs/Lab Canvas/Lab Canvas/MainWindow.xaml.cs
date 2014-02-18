using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Lab_Canvas
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            DrawCircle(400, 50, 50, Brushes.White);
        }

        #region DrawCircle
        private void DrawCircle(int diameter, int top, int left, Brush color)
        {
            // create circle
            Ellipse circle = new Ellipse();
            circle.Width = diameter;
            circle.Height = circle.Width;
            circle.Fill = color;

            // set position 
            Canvas.SetLeft(circle, left);
            Canvas.SetTop(circle, top);

            // add circle to canvas
            BackgroundCanvas.Children.Add(circle);
        }
        #endregion

        private void ConcentricCirclesdButton_Click(object sender, RoutedEventArgs e)
        {
            int i;
            int size = 400;
            int top = 50;
            int left = 50;
            Brush brush;

            for(i=0; i<9; i++)
            {
                brush = (i % 2 == 0) ?Brushes.White:Brushes.Red;
                DrawCircle(size, top, left, brush);
                size -= 46;
                top += 23;
                left += 23;
            }


        }

        private void OverlappingCircles_Click(object sender, RoutedEventArgs e)
        {
            int i;
            int size = 400;
            int top = 50;
            int left = 50;
            Brush brush;

            for (i = 0; i < 9; i++)
            {
                brush = (i % 2 == 0) ? Brushes.White : Brushes.Red;
                DrawCircle(size, top, left, brush);
                size -= 46;
                top += 46;
                left += 23;
            }
        }
    }
}
