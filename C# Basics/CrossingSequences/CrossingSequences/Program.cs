using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CrossingSequences
{
    class Program
    {
        static void Main(string[] args)
        {
            // input data:
            int n1 = Convert.ToInt32(Console.ReadLine());
            int n2 = Convert.ToInt32(Console.ReadLine());
            int n3 = Convert.ToInt32(Console.ReadLine());
            int firstN = Convert.ToInt32(Console.ReadLine());
            int step = Convert.ToInt32(Console.ReadLine());

            // creating a list of Tribunacci sequence up to 1 000 000
            List<int> tribNums = new List<int>();
            tribNums.Add(n1);
            tribNums.Add(n2);
            tribNums.Add(n3);
            int tribNumsLentght = 3;
            while (n3 <= 1000000)
            {
                tribNumsLentght++;
                int temp = n3;
                n3 = n1 + n2 + n3;
                n1 = n2;
                n2 = temp;
                tribNums.Add(n3);
            }

            // creating a list of number spiral sequence up to 1 000 000
            List<int> spiralNums = new List<int>();            

            int value = firstN;
            string direction = "right";
            int matrixSide = 0;
            int counter = 0;
            bool jackPot = false;
            int index = 0;

            while (value <= 1000000) {                
                
                // find spiralNums
                if (counter < matrixSide)
                {                    
                    value += step;
                    counter++;
                }
                else
                {
                    // compare to tribNums list : 
                    if (tribNums[index] == value)
                    {
                        jackPot = true;
                        Console.WriteLine(value);
                        break;
                    }
                    while ((value > tribNums[index]) && (index < tribNumsLentght))
                    {
                        index++;
                    }


                    switch (direction)
                    {
                        case "right":                            
                            spiralNums.Add(value);
                            direction = "down";                            
                            break;
                        case "down":                          
                            spiralNums.Add(value);
                            direction = "left";
                            matrixSide++;
                            break;
                        case "left":                            
                            spiralNums.Add(value);
                            direction = "up";
                            break;
                        case "up":                            
                            spiralNums.Add(value);
                            direction = "right";
                            matrixSide++;
                            break;
                    }
                    counter = 0;
               
                }
              

            }           

            if (!jackPot)
            {
                Console.WriteLine("No");
            }                
        }
    }
}
