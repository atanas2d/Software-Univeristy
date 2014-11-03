using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntroToCSharp.Chapter_1
{
    class AgePlus10
    {
        public static void AgeCalc()
        {
            int ages = 0;
            Console.Write("How old are you:");
            ages = Convert.ToInt32(Console.ReadLine()) + 10;
            Console.WriteLine("After 10 years your about to be " + ages + " years old.");
        }
    }
}
