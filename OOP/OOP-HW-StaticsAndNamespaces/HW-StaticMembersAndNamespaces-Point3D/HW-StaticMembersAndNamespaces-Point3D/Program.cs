using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW_StaticMembersAndNamespaces
{
    class Program
    {
        static void Main(string[] args)
        {
            Point3D p1 = new Point3D(1, 5, -2);
            Console.WriteLine(Point3D.StartPoint);
            Console.WriteLine(p1);
        }
    }
}
