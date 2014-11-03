using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter._2
{
    class Examples
    {
        public static void Exr()
        {
            sbyte chunky = SByte.MinValue;
            Console.WriteLine("Min sbyte value is {0}.",chunky);
            short shorty = Int16.MaxValue;
            Console.WriteLine("Max short value is {0}.", shorty);
            ushort unsignedShorty = UInt16.MaxValue;
            Console.WriteLine("Max unsigned short (ushort) value is {0}", unsignedShorty);

            Console.ReadKey();
        }
        

    }
}
