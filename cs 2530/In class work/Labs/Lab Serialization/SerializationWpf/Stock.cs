using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CS2530.SerializationWpf
{
    [Serializable]
    public class Stock
    {
        public string Name { get; set; }
        public string Symbol { get; set; }
        public DateTime Ipo { get; set; }
        public decimal Value { get; set; }

        public Stock()
        {
        }

        public Stock(string name, string symbol, DateTime initialPublicOffering, decimal val)
        {
            Name = name;
            Symbol = symbol;
            Ipo = initialPublicOffering;
            Value = val;
        }
    }
}
