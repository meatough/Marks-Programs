using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Threading;
using System.Threading;


namespace DemoTimer
{
   public partial class MainWindow : Window
   {
      private DispatcherTimer timer;
      #region uncomment for alternative tick event handler
      //private int counter;
      //private Random rand = new Random();
      //private Brush[] colors = { Brushes.Lime, Brushes.Navy, Brushes.Yellow };
      #endregion

      public MainWindow()
      {
         InitializeComponent();
      }

      private void Button_Click(object sender, RoutedEventArgs e)
      {
         #region
         //Label1.Content = "red";
         //Label2.Content = "yellow";
         //Label3.Content = "green";

         //// how often Timer_Tick should be executed once the timer is started
         //counter = 3;

         ////  A timer that is integrated into the Dispatcher queue which is
         ////  processed at a specified interval of time and at a specified priority.
         //DispatcherTimer timer = new DispatcherTimer();
         //timer.Interval = new TimeSpan(0, 0, 2);
         //timer.Tick += Timer_Tick;
         //timer.Start(); 
         #endregion

         Label1.Content = 0;
         timer = new DispatcherTimer();
         timer.Interval = new TimeSpan(0, 0, 1);
         // timer.Tick += new EventHandler(TickEventHandler);
         timer.Tick += TickEventHandler;
         timer.Start();

         #region uncomment for alternative tick event handler
         // counter = 10;
         #endregion
      }

      #region Tick event handler we used in class
      private void TickEventHandler(Object obj, EventArgs e)
      {
         int number = int.Parse(Label1.Content.ToString());
         Label1.Content = ++number;
         System.Media.SystemSounds.Hand.Play();

         if (number >= 7)
            timer.Stop();
      }
      #endregion

      #region alternative tick event handler
      //private void TickEventHandler(object sender, EventArgs e)
      //{
      //   Label1.Background = colors[rand.Next(3)];
      //   Label2.Background = colors[rand.Next(3)];
      //   Label3.Background = colors[rand.Next(3)];

      //   if (--counter == 0)
      //   {
      //      DispatcherTimer t = sender as DispatcherTimer;
      //      t.Stop();
      //   }
      //}
      #endregion
   }
}
