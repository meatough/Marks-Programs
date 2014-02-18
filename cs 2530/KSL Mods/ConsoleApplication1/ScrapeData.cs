using System;
using System.Net;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class ScrapeData
    {
        public string scrapeFromLink(string kslUrl, int interval)
        {
            //Console.Clear();
            Console.WriteLine(kslUrl);
            StreamReader theSourceCode = getSource(kslUrl);
            using (theSourceCode)
            {
                string message = "";
                string finalMessage = "";
                while (!theSourceCode.EndOfStream)
                {
                    string line = theSourceCode.ReadLine().ToString();
                    if (line.Contains("listlink") && !line.Contains("more..."))
                    {
                        string item = ItemName(line);
                        string link = newLink(line, kslUrl);
                        item += link;
                        message += item;
                    }//end if statement
                    if (line.Contains("$") && line.Contains("priceCents"))
                    {
                        string cost = Cost(line);
                        message += cost;
                    }
                    if (line.Contains("adDays"))
                    {
                        string post = PostTime(line, interval);
                        if (post == "")
                        {
                            break;
                        }
                        message += post;
                        finalMessage += message;
                        message = "";
                    }
                }//end while interval
                if (finalMessage == "")
                {
                    Console.WriteLine("Message is: {0}", finalMessage);
                }
                return finalMessage;
            }
        }//end scrape from link method

        private string PostTime(string s, int interval)
        {
            int start = s.IndexOf("\"");
            string time = s.Substring(start);
            int timeStart = time.IndexOf(">");
            string tempTime = time.Substring(timeStart + 1);
            int endTime = tempTime.IndexOf("<");
            string finalTime = tempTime.Substring(0, endTime);
            DateTime current = DateTime.Now;
            DateTime post;
            string myTime = "";
            int elapsed;
            int hr = 60;
            int day = 60 * 24;
            elapsed = timeValue(finalTime);
            if (finalTime.Contains("Min"))
            {
                if (elapsed > interval)
                {
                    return "";
                }
                post = current.Subtract(new TimeSpan(0, elapsed, 0));
                myTime = post.ToString("MM/dd/yyyy: hh:mm tt");
            }
            if (finalTime.Contains("Hr"))
            {
                if (elapsed * hr >= interval)
                {
                    return "";
                }
                //elapsed = timeValue(finalTime);
                post = current.Subtract(new TimeSpan(elapsed, 0, 0));
                myTime = post.ToString("MM/dd/yyyy: hh" + ":00" + " tt");
            }
            if (finalTime.Contains("Days"))
            {
                //Console.WriteLine(elapsed);
                //Console.WriteLine(interval);
                if (elapsed * day >= interval)
                {
                    return "";
                }
                post = current.Subtract(new TimeSpan(timeValue(finalTime), 0, 0, 0));
                myTime = post.ToString("MM/dd/yyyy");
            }

            return myTime + "\n";
        }

        private int timeValue(string t)
        {
            string timeValue = t.Substring(0, t.IndexOf(" "));
            int m = Convert.ToInt32(timeValue);
            return m;
        }

        private string ItemName(string s)
        {
            int startPos = s.IndexOf(">");
            string temp = s.Substring(startPos + 1);
            int endPos = temp.IndexOf("<");
            string item = temp.Substring(0, endPos);
            return item;
        }
        private string newLink(string s, string url)
        {
            int linkStart1 = s.IndexOf("f");
            string linkTemp1 = s.Substring(linkStart1 + 1);
            int linkStart2 = linkTemp1.IndexOf("\"");
            string linkTemp2 = linkTemp1.Substring(linkStart2 + 1);
            int linkEnd = linkTemp2.IndexOf("\"");
            string linkAdd = linkTemp2.Substring(0, linkEnd);
            int urlPos = url.IndexOf("?");
            string newLink = url.Substring(0, urlPos);
            newLink += linkAdd;
            return newLink;
        }
        private string Cost(string s)
        {
            int dollarStart = s.IndexOf(">");
            string dollarTemp = s.Substring(dollarStart + 1);
            int dollarEnd = dollarTemp.IndexOf("<");
            string dollars = dollarTemp.Substring(0, dollarEnd);
            int centStart = dollarTemp.IndexOf(">");
            string centTemp = dollarTemp.Substring(centStart + 1);
            int centEnd = centTemp.IndexOf("<");
            string cents = centTemp.Substring(0, centEnd);
            return "\n" + dollars + "." + cents;
        }

        public StreamReader getSource(string url)
        {
            HttpWebRequest myCall = (HttpWebRequest)WebRequest.Create(url);
            HttpWebResponse theResponse = (HttpWebResponse)myCall.GetResponse();
            StreamReader source = new StreamReader(theResponse.GetResponseStream());
            return source;
        }
    }//end class
}//end namespace
