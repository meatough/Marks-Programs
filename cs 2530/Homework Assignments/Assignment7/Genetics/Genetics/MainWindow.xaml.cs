/***************************************************************
 * Intermiadiate Programming in c#
 * Game of Life Program
 * Programmer: Mark Eatough
 * Course: CSIS 2530 
 * Created October 17, 2013
 *  
 * This program takes a user selected spreadsheet file, uses the 
 * data from the file, and creates two new spreadsheet files 
 * based on the data from the first file.  One of the new files
 * is just a subset of the original file, and the other new file
 * is a summary of the subset file.
 ****************************************************************/

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
using System.IO;
using Microsoft.Win32;

namespace Genetics
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void ClearButton_Click(object sender, RoutedEventArgs e)
        {
            ContentTb.Text = string.Empty;
            StatusLb.Content = string.Empty;
        }

        private void CreateSubsetAndSummaryButton_Click(object sender, RoutedEventArgs e)
        {
            string path;
            OpenFileDialog dialog = new OpenFileDialog();
            if (dialog.ShowDialog() != null)
            {
                path = dialog.FileName;
                StreamReader stream = new StreamReader(File.OpenRead(path));
                List<string> subset = SignificantGenesData(stream);
                string summary = GenerateSummary(subset);
                StringBuilder mutationSubset = new StringBuilder();
                foreach (string s in subset)
                {
                    mutationSubset.Append(s);
                }
                SaveFiles(path, mutationSubset.ToString(), summary);             
            }           
        }//end create subset button
        private string buildRowString(string[] row)
        {
            StringBuilder myBuilder = new StringBuilder();
            for (int i = 0; i < row.Length; i++)
            {

                myBuilder.Append(row[i] + ", ");
            }
            myBuilder.Append("\n");
            string myString = myBuilder.ToString();
            return myString;
        }


        private List<String> SignificantGenesData(StreamReader stream)
        {
            string[] csvRow = null;
            List<string> subset = new List<string>();
            int rowNum = 0;         
            while (!stream.EndOfStream)
            {
                csvRow = stream.ReadLine().Split(',');
                if (rowNum > 0)
                {
                    int number = Convert.ToInt32(csvRow.ElementAt(35));
                    if (number > 2)
                    {
                        subset.Add(buildRowString(csvRow));
                    }
                }
                if (rowNum == 0)
                {
                    subset.Add(buildRowString(csvRow));
                }
                csvRow = null;
                rowNum++;
            }
            return subset;
        }//End display csv method
        private string SummaryHeader()
        {
            StringBuilder myBuilder = new StringBuilder();
            myBuilder.Append("Gene,");
            myBuilder.Append("NumberOfPeopleWithMuataions,");
            myBuilder.Append("NumberOfMutationsOfGene,");
            for (int i = 1; i < 16; i++)
            {
                myBuilder.Append("P" + (i));
                if (i != 15)
                {
                    myBuilder.Append(",");
                }
            }
            myBuilder.Append("\n");
            string summaryHeader = myBuilder.ToString();
            return summaryHeader;
        }

        public List<string> Subset(List<string> sub)
        {
            List<string> subset = new List<string>();
            foreach (string s in sub)
            {
                subset.Add(s);
            }
            subset.RemoveAt(0);

            return subset;
        }

        private string GenerateSummary(List<string> sub)
        {
            string[] summaryArray = null;
            StringBuilder data = new StringBuilder();
            StringBuilder values = new StringBuilder();
            int mutations =  0;
            int mutationsPerGene = 1;
            string geneName = null;

            data.Append(SummaryHeader());
            foreach (string s in Subset(sub))
            {
                summaryArray = s.Split(',');

                data.Append(summaryArray[3] + ",");
                if (summaryArray[3] == geneName)
                {
                    mutationsPerGene++;
                }

                geneName = summaryArray[3];

                for (int i = 0; i < summaryArray.Length; i++)
                {
                    if (i >= 20 && i <= 34)
                    {
                        values.Append(summaryArray[i] + ",");
                        int number = Convert.ToInt32(summaryArray.ElementAt(i));
                        if (number == 1)
                        {
                            mutations++;
                        }
                    }
                }
                data.Append(mutations.ToString() + ",");
                data.Append(mutationsPerGene.ToString() + ",");
                data.Append(values.ToString());
                data.Append("\n");
                values.Clear();
                mutations = 0;
            }
            return data.ToString();
        }//end generate summary method

        private void SaveFiles(string path, string significant, string summary)
        {
            
            string[] dir = path.Split('\\');
            StringBuilder directory = new StringBuilder();

            for (int i = 0; i < dir.Length; i++)
            {
                if (i < dir.Length - 1)
                {
                    directory.Append(dir[i] + "\\");
                }
            }
            string sigPath = directory.ToString() + "SignificantGenes.csv";
            string summaryPath = directory.ToString() + "Summary.csv";
            File.WriteAllText(sigPath, significant);
            File.WriteAllText(summaryPath, summary);

            ContentTb.Text = "SignificantGenes file saved To:\n\n" + directory.ToString();
            ContentTb.Text += " \n\n\nSummary file saved To:\n\n" + directory.ToString();
        }
    }//end partial window class
}//end genetics namespace