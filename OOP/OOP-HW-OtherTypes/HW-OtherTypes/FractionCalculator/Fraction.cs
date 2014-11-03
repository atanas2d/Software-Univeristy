using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FractionCalculator
{
    public struct Fraction
    {
        private long numerator;
        private long denominator;

        public long Numerator
        {
            get
            {
                return this.numerator;
            }
            set
            {
                this.numerator = value;
            }
        }

        public long Denominator
        {
            get
            {
                return this.denominator;
            }
            set
            {
                if (value == 0)
                {
                    throw new ArithmeticException("Denominator cannot be zero.");
                }

                if (value < 0)
                {
                    value *= -1;
                    this.Numerator *= -1;
                }
               
                this.denominator = value;
                
            }
        }

        public Fraction(long nominator, long denominator) : this() {
            this.Numerator = nominator;
            this.Denominator = denominator;
            this.Gdc();
        }

        public void Gdc()
        {
            long a = this.Numerator;
            long b = this.Denominator;
            while (b != 0)
            {
                long t = b;
                b = a % b;
                a = t;              
            }

            this.Numerator = this.Numerator / a;
            this.Denominator = this.Denominator / a;
        }

        public static Fraction operator +(Fraction a, Fraction b)
        {
            checked
            {
                long resultNumerator = a.Numerator * b.Denominator + b.Numerator * a.Denominator;
                long resultDenominator = a.Denominator * b.Denominator;
                return new Fraction(resultNumerator, resultDenominator);
            }
        }

        public static Fraction operator -(Fraction a, Fraction b)
        {
            checked
            {
                long resultNumerator = a.Numerator * b.Denominator - b.Numerator * a.Denominator;
                long resultDenominator = a.Denominator * b.Denominator;
                return new Fraction(resultNumerator, resultDenominator);
            }
        }

        public override string ToString()
        {
            return ((double)this.Numerator / this.Denominator).ToString();
        }
       
    }
}
