using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GenericList
{
    class Program
    {
        static void Main(string[] args)
        {
            GenericList<string> myList = new GenericList<string>();

            myList.Add("Nasko");
            myList.Add("Sasho");
            myList.Add("Mirela");

            Console.WriteLine(myList);

        }
    }
}
