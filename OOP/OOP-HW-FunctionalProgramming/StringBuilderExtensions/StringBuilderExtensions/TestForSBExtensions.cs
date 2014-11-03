using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringBuilderExtensions
{
    class TestForSBExtensions
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder("My string");

            var numbers = new List<int>() { 1, 2, 4, 5, 6 };

            Console.WriteLine(sb.Substring(3, 6));
            Console.WriteLine(sb.RemoveText("string"));
            Console.WriteLine(sb.AppendAll<int>(numbers));

        }
    }
}
