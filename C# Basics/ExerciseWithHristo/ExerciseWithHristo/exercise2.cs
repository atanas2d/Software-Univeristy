using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseWithHristo
{
    class exercise2
    {
        public static void myFunc2() {
            int a = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine(a*a + 3);
        }

        public static void exercise10()
        {
            int a = 2;
            for (int i = 0; i < 100; i++ )
            {
                Console.Write(a + "; ");
                if (a > 0) {
                    a++;
                }
                else
                {
                    a--;
                }
                a = -a;
            }
        }
    }
}
