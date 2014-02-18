using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoInterface
{
    class Point : Imovable
    {
        public int X { get; private set; }
        public int Y { get; private set; }

        public Point(int xCoord, int yCoord) //: this()
        {
            X = xCoord;
            Y = yCoord;
        }


        public override string ToString()
        {
            return string.Format("({0}, {1})", X, Y);
        }
        public void Move()
        {
            X++;
        }
    }
}
