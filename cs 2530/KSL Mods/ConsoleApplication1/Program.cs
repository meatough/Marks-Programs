using System;
using System.Net;
using System.IO;
using System.Threading;
using System.Collections.Generic;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            ScrapeData info = new ScrapeData();
            Scrape scraper = new Scrape();
            Database data = new Database();
            data.GetLinks();
            int interval = 5 * 60 * 24;
            int i = 1;
            foreach (string s in data.myLinks)
            {
                info.scrapeFromLink(s, interval);
                Console.WriteLine(i);
                i++;
            }
            /*scraper.GetSourceCode();
            data.SaveLinks(scraper.myDict);
            int i = 0;
            foreach (KeyValuePair<string, Dictionary<string, string>> entry in scraper.myDict)
            {
                Console.WriteLine("{0}", entry.Key);
                foreach (string s in entry.Value.Values)
                {
                    Console.WriteLine("\t{0}", s);
                    i++;
                }
            }
            Console.WriteLine(i);*/
        }//end main method
    }//end class
}//end namespace