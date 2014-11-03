using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CatchTheBits
{
    class Program
    {
        static void Main(string[] args)
        {
            // input n and step:
            int n = Convert.ToInt32(Console.ReadLine());
            int step = Convert.ToInt32(Console.ReadLine());
            // input bytes:
            int[] myBytes = new int[n];
            for (int i = 0; i < n; i++ )
            {
                myBytes[i] = Convert.ToInt32(Console.ReadLine());
            }

            // taking the sequence:
            string bytesSequence = "";
            for (int i = 0; i < myBytes.Length ; i++ )
            {
                string binaryNum = Convert.ToString(myBytes[i],2);
                if (binaryNum.Length < 8) {
                    for (int j = 0; j <= (8 - binaryNum.Length); j++) {
                        binaryNum = '0' + binaryNum;
                    }
                }
                bytesSequence += binaryNum;
            }
            // take result sequence of bits:
            string finalSequence = "";
            int index = 0;
            // preambulate bytesSequence:
            for (int i = 0; i < bytesSequence.Length; i++)
            {
                if (i == (1 + (step*index))) {
                    finalSequence += bytesSequence[i];
                    index++;
                }
            }

            // take the final results:
            List<string> finalBytes = new List<string>();
            int l = finalSequence.Length;

            while (l >= 8) {
                string thisByte = "";
                for (int i = 0; i < 8; i++)
                {
                    thisByte += finalSequence[i];
                }
                finalBytes.Add(thisByte);
                finalSequence = finalSequence.Remove(0, 8);
                l = finalSequence.Length;              
            }
            if (l > 0)
            {
                string lastByte = "";
                for (int i = 0; i < 8; i++)
                {
                    if (i < l) {
                        lastByte += finalSequence[i];
                    }
                    else
                    {
                        lastByte += '0';
                    }
                }
                finalBytes.Add(lastByte);
            }     
            
            // convert binary to decimal:
            foreach(string str in finalBytes) {                
                int decInt = Convert.ToInt32(str, 2);
                Console.WriteLine(decInt);
            }
            
            Console.ReadLine();
        }
    }
}
