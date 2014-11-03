using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Illuminati
{
    class Program
    {
        static void Main(string[] args)
        {
            string iMessage = Console.ReadLine();
     
            int l = iMessage.Length;
            int counter = 0;
            long sum = 0;
            for (int i = 0; i < l; i++)
            {
                switch (iMessage[i])
                {
                    case 'a':
                    case 'A':
                        sum += 65;
                        counter++;
                        break;    
                    case 'e': 
                    case 'E':
                        sum += 69;
                        counter++;
                        break;
                    case 'i':
                    case 'I':
                        sum += 73;
                        counter++;
                        break;
                    case 'o':
                    case 'O':
                        sum += 79;
                        counter++;
                        break;
                    case 'u':
                    case 'U':
                        sum += 85;
                        counter++;
                        break;
                }
            }

            Console.WriteLine(counter);
            Console.WriteLine(sum);
        }
    }
}
