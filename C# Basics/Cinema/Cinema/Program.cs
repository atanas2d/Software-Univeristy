using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cinema
{
    class Program
    {
        static void Main(string[] args)
        {
            string typeOfProjection = Console.ReadLine();
            int rows = Convert.ToInt32(Console.ReadLine());
            int cols = Convert.ToInt32(Console.ReadLine());

            float ticketPrice = 0.0f;

            switch (typeOfProjection) {
                case "Premiere":
                    ticketPrice = 12.0f;                    
                    break;
                case "Normal": 
                    ticketPrice = 7.5f;
                    break;
                case "Discount":
                    ticketPrice = 5.0f;
                    break;
            }

            float incomes = (rows * cols) * ticketPrice;

            Console.WriteLine("{0:F2} leva", incomes);
          
        }
    }
}
