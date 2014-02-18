using System;
using System.IO;
using System.Windows;
using Microsoft.Win32;

namespace FileDialog
{
   public partial class MainWindow : Window
   {
      public MainWindow()
      {
         InitializeComponent();
      }

      private void SelectFileButton_Click(object sender, RoutedEventArgs e)
      {
         // TODO 1 open file dialog and choose directoy to start


         // TODO 2 if the user selected a file display file/dir name and text

      }

      private void saveFileButton_Click(object sender, RoutedEventArgs e)
      {
         // TODO 4 open the save file dialog, set director to start, save content to file

      }

      private void ClearButton_Click(object sender, RoutedEventArgs e)
      {
         // TODO 3 clear all text fields

      }
   }
}
