using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OOP_HW_ExceptionHandling
{
    class SquareRootFinder
    {
        public static void SquareRoot()
        {
            string input = Console.ReadLine();

            try
            {
                int num = int.Parse(input);
                if (num < 0)
                {
                    throw new ArithmeticException();
                }

                double squareRoot = Math.Sqrt(num);
                Console.WriteLine("Result is: " + squareRoot);
            } 
            catch (FormatException) 
            {
                Console.WriteLine("Invalid number.");
            } 
            finally 
            {
                Console.WriteLine("Good bye");
            }
        }
    }
}
