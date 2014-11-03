using System;

namespace InterestCalculator
{

    class Program
    {
        private static decimal GetSimpleInterest(decimal sumOfMoney, double interest, int years)
        {
            // A = sum * (1 + interest * years)
            decimal simpleInterest = sumOfMoney * (decimal)(1 + (interest * years / 100));
            return simpleInterest;
        }

        private static decimal GetCompoundInterest(decimal sumOfMoney, double interest, int years)
        {
            // A = sum * (1 + interest / n)year * n, n=12
            decimal compoundInterest = sumOfMoney * (decimal)Math.Pow(1 + (interest / 12 / 100), years * 12);
            return compoundInterest;
        }
        static void Main(string[] args)
        {
            InterestCalculator InterestCalcCompound = new InterestCalculator(500m, 5.6, 10, GetCompoundInterest);
            Console.WriteLine("{0:0.0000}", InterestCalcCompound.ResultValue);

            InterestCalculator InterestCalcSimple = new InterestCalculator(2500m, 7.2, 15, GetSimpleInterest);
            Console.WriteLine("{0:0.0000}", InterestCalcSimple.ResultValue);
            
        }
    }
}
