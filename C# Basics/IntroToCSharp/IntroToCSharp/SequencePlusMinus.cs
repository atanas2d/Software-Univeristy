using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntroToCSharp.Chapter_1
{
    class SequencePlusMinus
    {
        public static void SequencePrint()
        {
            int number = 2;
            for (int i = 0; i < 100; i++)
            {
                Console.Write(number + ", ");
                if (number > 0)
                {
                    number++;
                    number = -number;
                }
                else
                {
                    number--;
                    number = -number;
                }
                
                
            }
        }          
    }
}
