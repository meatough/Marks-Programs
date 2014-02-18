using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebSkrapper.App_Code
{
    public class Bot
    {
        private Ksl myKsl;
        private FileManager myManager;
        private WebData myWebData;
        public Bot(WebData myData)
        {
            myKsl = new Ksl();
            myManager = new FileManager();
            this.myWebData = myData;
        }

        public void BotSkrape()
        {

        }
    }
}