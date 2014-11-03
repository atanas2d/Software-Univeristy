using System;

namespace OOP_HW_ExceptionHandling
{
    class NumbersReader
    {
        public static int ReadNumber(int start, int end)
        {
            int number;
            string input = Console.ReadLine();
            try
            {
                int num = int.Parse(input);
                if (num < start || num > end)
                {
                    string exepctionMessage = string.Format("Number should be in rage {0} - {1}...", start, end);
                    throw new ArgumentOutOfRangeException(exepctionMessage);
                }
                number = num;
            }
            catch (FormatException)
            {
                throw;
            }
            return number;
        }

        public static void EnterNumbers()
        {
            int[] numbers = new int[10];
            int l = numbers.Length;
            int start = 1;
            int end = 100 - l;

            for (int i = 0;  i < l; i++)
            {
                bool isInvalid = false;
                do
                {
                    try
                    {
                        start = ReadNumber(start, end) + 1;                        
                        end++;
                        isInvalid = false;
                    }
                    catch (ArgumentOutOfRangeException e) 
                    {
                        Console.WriteLine(e.ParamName);
                        isInvalid = true;
                    }
                    catch (FormatException)
                    {
                        Console.WriteLine("Invalid number.");
                        isInvalid = true;
                    }
                } while (isInvalid);
            }
        }
    }
}
