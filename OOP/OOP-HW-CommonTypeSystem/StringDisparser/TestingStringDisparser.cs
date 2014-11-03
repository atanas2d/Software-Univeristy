using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringDisperserApp
{
    class TestingStringDisparser
    {
        static void Main(string[] args)
        {
            StringDisperser stringDisperser = new StringDisperser("gosho", "pesho", "tanio");
            StringDisperser stringDisperserCopy = (StringDisperser)stringDisperser.Clone();
            stringDisperserCopy.TotalString.Append("petko");
            foreach (var ch in stringDisperser)
            {
                Console.Write(ch + " ");
            }

            Console.WriteLine();
            foreach (var ch in stringDisperserCopy)
            {
                Console.Write(ch + " ");
            }

            Console.ReadLine();
        }
    }
}
