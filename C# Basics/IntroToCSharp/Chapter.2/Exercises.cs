using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter._2
{
    class Exr
    {
        public static void Exr1()
        {
            // Exr1:
            sbyte miniMinus = -115;
            ushort shorty = 52130;
            int inty = 4825932;
            byte bity = 97;
            short shortMinus = -10000;
            short anotherShorty = 10000;
            byte bity2 = 224;
            int inty2 = 970700000;
            byte bity3 = 112;
            sbyte bityMinus = -4;
            int intyMinus = -1000000;
            long longy = 123456789123456789;

            // Exr2: 
            double letsTryDouble = 3456.091124875956542151256683467D;
            float letsTryFloat = 3456.091124875956542151256683467F;
            decimal letsTryDecimal = 3456.091124875956542151256683467M;
            Console.WriteLine(letsTryDouble);
            Console.WriteLine(letsTryFloat);
            Console.WriteLine(letsTryDecimal);
        }

        public static void Exr3()
        {
            decimal a = 1.123552345M;
            decimal b = 1.123552345M;

            char comparision;
            if (a > b)
            {
                comparision = '>';
            }
            else if (a == b)
            {
                comparision = '=';
            }
            else
            {
                comparision = '<';
            }

            Console.WriteLine("{0} {1} {2}", a, comparision, b);
        }

        public static void Exr4()
        {
            int hexadecimalInt = 0x100;
            Console.WriteLine(hexadecimalInt);
        }

        public static void Exr5()
        {
            char char72 = (char)72;
            Console.WriteLine(char72);

            //exr6:
            bool isMale = true;
        }

        public static void Exr7()
        {
            string hello = "Hello";
            string world = "World";
            object helloWorld = hello + " " + world;
            Console.WriteLine(helloWorld);

            // Exr8:
            string castedString = (string)helloWorld;
            Console.WriteLine(castedString);
        }

        public static void Exr9()
        {
            string firstString = "The \"use\" of quatations couse difficulties.";
            string secondString = @"The ""use"" of quatations cause
                                    difficulties";

            Console.WriteLine("{0} \n {1}", firstString, secondString);

            char hm = '\u00A9';
            Console.WriteLine(hm);
        }

    }
}
