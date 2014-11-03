using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CustomLINQExtensionMethods
{
    class Program
    {
        static void Main(string[] args)
        {
            IEnumerable<int> numbers = new List<int>() { 1, 2, 3, 4, 5 };

            Console.WriteLine(string.Join(", ", numbers.WhereNot<int>(a => a == 4)));

            Console.WriteLine(string.Join(", ", numbers.Repeat<int>(4)));

            IEnumerable<string> myStrings = new List<string>() { "complex", "Matrix212", "tRex", "123", "Neo" };
            IEnumerable<string> suffixes = new List<string>() { "12", "ex" };

            IEnumerable<string> result = myStrings.WhereEndsWith(suffixes);

            Console.WriteLine(string.Join(", ", result));
        }
    }
}
