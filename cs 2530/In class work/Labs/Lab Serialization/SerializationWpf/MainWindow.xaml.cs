using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Windows;
using System.Xml.Serialization;
using Microsoft.Win32;

namespace CS2530.SerializationWpf
{
   public partial class MainWindow : Window
   {
      #region field (stock data)
      List<Stock> stocks = new List<Stock> {
            new Stock ("Google", "goog", new DateTime(2004, 04, 18), 565.10m),
            new Stock ("Microsoft", "msft", new DateTime(1986, 03, 25), 29.29m),
            new Stock ("British Petrol", "bp", new DateTime(2005, 09, 12), 39.02m),
            new Stock ("Toyota MC", "tm", new DateTime(2006, 08, 12), 76.49m),
            new Stock ("Costco", "cost", new DateTime(2004, 08, 28), 88.50m),
            new Stock ("Oracle", "orcl", new DateTime(1996, 03, 12), 27.03m),
            new Stock ("Facebook", "fb", new DateTime(2012, 05, 17), 27.40m)
        };
      #endregion

      public MainWindow()
      {
         InitializeComponent();
         DisplayStocks(stocks, "Stocks:");
      }

      #region private methods
      /// <summary>
      /// Displays the the content of a Stock list in the ContentTb textbox.
      /// </summary>
      /// <param name="stockList"></param>
      /// <param name="title"></param>
      private void DisplayStocks(List<Stock> stockList, string title)
      {
         StringBuilder strBuilder = new StringBuilder();
         //  title
         strBuilder.Append(title);
         strBuilder.Append("\n\n");

         //  header
         strBuilder.Append(string.Format("{0,-16} {1,-8} {2,-11} {3, 7}\n",
                 "Name", "Symbol", "Ipo", "Value"));

         //  stock data
         foreach (Stock s in stockList)
         {
            strBuilder.Append(string.Format("{0,-16} {1,-8} {2,-11} {3, 7}\n",
                s.Name, s.Symbol, s.Ipo.ToShortDateString(), s.Value));
         }

         // print to ContentTb textbox
         ContentTb.Text = strBuilder.ToString();
      }
      #endregion

      #region event handlers
      //not completed
      private void SelectFileButton_Click(object sender, RoutedEventArgs e)
      {
          OpenFileDialog dialog = new OpenFileDialog();
        
          if (dialog.ShowDialog() != null)
          {
              
              ContentTb.Text = File.ReadAllText(dialog.FileName);
          }
      }
      //not completed
      private void SerializeAndSaveButton_Click(object sender, RoutedEventArgs e)
      {
          SaveFileDialog dialog = new SaveFileDialog();
         
            if (dialog.ShowDialog() != null)
            {
                try
                {
                    using (Stream stream = new FileStream(dialog.FileName, FileMode.OpenOrCreate))
                    {
                        XmlSerializer serializer = new XmlSerializer(stocks.GetType());
                        serializer.Serialize(stream, stocks);
                        //dialog.OpenFile();
                    }
                    StatusLb.Content = "Serialization complete";
                }
                catch (Exception ex)
                {
                    StatusLb.Content = "Problem serializing: " + ex.Message;
                    System.Media.SystemSounds.Beep.Play();
                }
            }
      }
      //Need to allow to select file
      private void DeserializeButton_Click(object sender, RoutedEventArgs e)
      {
          List<Stock> stocks1;
          OpenFileDialog dialog = new OpenFileDialog();
          if (dialog.ShowDialog() != null)
          {
              try
              {
                  using (Stream stream = new FileStream(dialog.FileName, FileMode.OpenOrCreate))
                  {
                      XmlSerializer serializer = new XmlSerializer(typeof(List<Stock>));
                      stocks1 = serializer.Deserialize(stream) as List<Stock>;
                  }
                  DisplayStocks(stocks1, "Deserialized stocks:");
                  StatusLb.Content = "Deserialization complete";
              }
              catch (Exception ex)
              {
                  StatusLb.Content = "Problem deserializing: " + ex.Message;
                  System.Media.SystemSounds.Beep.Play();

              }
          }
      }

      private void ClearButton_Click(object sender, RoutedEventArgs e)
      {
         ContentTb.Text = string.Empty;
         StatusLb.Content = string.Empty;
      }
      #endregion
   }
}
