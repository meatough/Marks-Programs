using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2530_Final
{
    class Numbers
    {
        private List<int> numbers;

        public Numbers(List<int> numbers)
        {
            this.numbers = numbers;
        }

        // A)  Create an inumerator called DoubleElements.
        //     It should return the double of each element in list numbers 
        public IEnumerable<double> DoubleElements()
        {
            foreach (int n in numbers)
            {
                yield return n * 2;
            }
        }
        
        // B)  Create an iterator called ReverseNumbers
        //     It should return all the elements of the list numbers in reverse order
        public IEnumerable<double> ReverseNumbers()
        {
            for (int i = numbers.Count-1; i >= 0; i--)
            {
                yield return numbers[i];
            }
        }

        // C)  Create an iterator called ThirdElements. 
        //     It should return every third element of list numbers
        public IEnumerable<double> ThirdElements()
        {
            for (int i = 0; i < numbers.Count; i++)
            {
                if (i % 3 == 2)
                {
                    yield return numbers[i];
                }
            }
        }

    }
}
