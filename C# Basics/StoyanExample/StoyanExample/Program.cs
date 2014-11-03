using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StoyanExample
{
    class Program
    {
        static void Main(string[] args)
        {
            Person Stoyan = new Person();
            Stoyan.name = "Stoyan";
            Stoyan.ages = 30;

        }
    }
    class Person
    {
        public string name;
        public int ages;
    }


}
