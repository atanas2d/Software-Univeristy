using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewHouse
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = Convert.ToInt32(Console.ReadLine());
            string currentLine = "";
            // print the roof:
            int oddsInN = n/2 + 1;
            for (int i = 1; i <= oddsInN; i++)
            {
                // ptint line:
                for (int j = 1; j <= n; j++)
                {
                    if (j <= (oddsInN - i) ) {
                        currentLine += '-';
                    } else if (j >= oddsInN + i) {
                        currentLine += '-';
                    }
                    else
                    {
                        currentLine += '*';
                    }
                }
                Console.WriteLine(currentLine);
                currentLine = "";
            }
            // print the floors:
            for (int i = 1; i <= n; i++ )
            {
                currentLine += '|';
                for (int j = 0; j < n - 2; j++ )
                {
                    currentLine += '*';
                }
                currentLine += '|';
                Console.WriteLine(currentLine);
                currentLine = "";
            }

        }
    }
}
