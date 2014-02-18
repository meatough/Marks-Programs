using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
//using MySql.Data.MySqlClient; 

namespace ConsoleApplication1
{
    class Database
    {
        //string mySqlString = "server=localhost;uid=root;pwd=root;database=KSL;";
        //MySqlConnection conn = new MySqlConnection(mySqlString);
        public List<string> myLinks = new List<string>();
        public void SaveLinks(Dictionary<string, Dictionary<string, string>> myDict)
        {
            using (StreamWriter writer = new StreamWriter("links.txt"))
            {
                foreach (KeyValuePair<string, Dictionary<string, string>> entry in myDict)
                {
                    foreach (string s in entry.Value.Values)
                    {
                        writer.WriteLine(s);
                    }
                } 
            }
        }//end savelinks method
        public void GetLinks()
        {
            string fileName = "links.txt";
            string link;
            using (StreamReader reader = new StreamReader(fileName))
            {
                while ((link = reader.ReadLine()) != null)
                {
                    myLinks.Add(link);
                }
            }
        }
    }//end class
}//end namespace
