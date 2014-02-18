/***************************************************************
 * Intermiadiate Programming in c#
 * Console ReadCsvFile Program
 * Programmer: Mark Eatough
 * Course: CSIS 2530 
 * Created October 30, 2013
 *  
 * This program uses linq to querry data after importing it from a 
 * csv file and parsing it out to an object called daily values
 ****************************************************************/

using System;
using System.IO;
using System.Collections.Generic;

namespace ReadCsvFile
{
    struct DailyValues
    {
        public DateTime Date { get; private set; }
        public decimal Open { get; private set; }
        public decimal High { get; private set; }
        public decimal Low { get; private set; }
        public decimal Close { get; private set; }
        public decimal Volume { get; private set; }
        public decimal AdjClose { get; private set; }

        public DailyValues(DateTime date, decimal open, decimal high, decimal low, 
            decimal close, decimal volume, decimal adjClose) : this()
        {            
            Date = date;
            Open = open;
            High = high;
            Low = low;
            Close = close;
            Volume = volume;
            AdjClose = adjClose;
        }

        public override string ToString()
        {
           return string.Format("O:{0} / H:{1} / L:{2} / C:{3} / V:{4} / AC:{5} / {6:d}",
                   Open, High, Low, Close, Volume, AdjClose, Date);
        }

        // reads stock values from csv file into a List
        public static List<DailyValues> GetStockValues(string filePath)
        {
           List<DailyValues> values = new List<DailyValues>();

           // TODO: add the data from the csv file
           string stocks;
           using (StreamReader reader = new StreamReader(filePath))
           {
               string[] csvRow = null;
               int rowNum = 0;
               while ((stocks = reader.ReadLine()) != null)
               { 
                   if (rowNum > 0)
                   {
                       csvRow = stocks.Split(',');
                       DateTime date = Convert.ToDateTime(csvRow.GetValue(0));
                       decimal open = System.Convert.ToDecimal(csvRow.GetValue(1));
                       decimal high = System.Convert.ToDecimal(csvRow.GetValue(2));
                       decimal low = System.Convert.ToDecimal(csvRow.GetValue(3));
                       decimal close = System.Convert.ToDecimal(csvRow.GetValue(4));
                       decimal volume = System.Convert.ToDecimal(csvRow.GetValue(5));
                       decimal adjClose = System.Convert.ToDecimal(csvRow.GetValue(6));
                       //Console.WriteLine(date);
                       DailyValues dv = new DailyValues(date, open, high, low, close, volume, adjClose);
                       values.Add(dv);
                       csvRow = null;
                   }
                   rowNum++;
               }
           }
           return values;
        }
    }
}
