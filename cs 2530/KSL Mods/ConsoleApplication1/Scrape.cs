using System;
using System.Net;
using System.IO;
using System.Threading;
using System.Collections.Generic;

namespace ConsoleApplication1
{
    class Scrape
    {
        private string url = "http://www.ksl.com/index.php?nid=13";
        public Dictionary<string, Dictionary<string, string>> myDict = new Dictionary<string, Dictionary<string, string>>();

        public void GetSourceCode()
        {
            Console.WriteLine(url);
            StreamReader theSourceCode = HTTPRequest(url);
            Dictionary<string, string> subCategory = new Dictionary<string, string>();
            string cat = "";
            string linkAdd = "";
            //Boolean foundLastCat = false;
            while (!theSourceCode.EndOfStream)// && foundLastCat == false)
            {
                string line = theSourceCode.ReadLine().ToString();
                //adds categories/subcategories to dictionary
                if (line.Contains("Services is now powered by"))
                {
                    myDict.Add(cat, subCategory);
                    //foundLastCat = true;
                    break;
                }
                linkAdd = GetLinks(line, linkAdd);
                if (line.Contains("category=") && line.Contains("/a"))
                {
                    cat = Category(line, subCategory, cat);
                    subCategory = new Dictionary<string, string>();
                }
                //add to subCategory list
                AddSubCategory(line, subCategory, linkAdd);
            }
            //Console.CursorVisible = true;
            //Console.WriteLine();
        }
        //method to get the links
        private string GetLinks(string line, string linkAdd)
        {
            string addLink = "";
            if (line.Contains("a href"))
            {
                int startPos = line.IndexOf("\"");
                string temp = line.Substring(startPos + 1);
                int endPos = temp.IndexOf("\"");
                addLink = temp.Substring(0, endPos);
                return addLink;
            }
            return linkAdd;
        }//end GetLinks method

        //create give category object new value
        private string Category(string s, Dictionary<string, string> l, string c)
        {
            if (l.Count > 0)
            {
                myDict.Add(c, l);
            }
            int startPos = s.IndexOf(">");
            string temp = s.Substring(startPos + 1);
            int endPos = temp.IndexOf("<");
            string newCat = temp.Substring(0, endPos);
            return newCat;
        }

        //add subcategory to list
        private void AddSubCategory(string s, Dictionary<string, string> l, string addLink)
        {
            if (s.Contains("categorySubsItemTitle") && !addLink.Contains("sale"))
            {
                //get the link
                string link = url;
                link = editURL(link, addLink);
                //get the subcategory
                int startPos = s.IndexOf(">");
                string temp = s.Substring(startPos + 1);
                int endPos = temp.IndexOf("<");
                string subCat = temp.Substring(0, endPos);
                if (subCat[0] == ' ')
                {
                    subCat = subCat.Substring(1);
                }
                l.Add(subCat, link);
            }
        }

        private string editURL(string link, string ext)
        {
            int urlPos = link.IndexOf("?");
            link = link.Substring(0, urlPos);
            link += ext;
            return link;
        }

        private StreamReader HTTPRequest(string url)
        {

            HttpWebRequest myCall = (HttpWebRequest)WebRequest.Create(url);
            HttpWebResponse theResponse = (HttpWebResponse)myCall.GetResponse();
            StreamReader source = new StreamReader(theResponse.GetResponseStream());
            return source;
        }
    }//end scrape class
}//end namespace
