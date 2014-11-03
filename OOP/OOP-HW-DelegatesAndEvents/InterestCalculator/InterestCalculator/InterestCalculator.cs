namespace InterestCalculator {
    
using System;
using System.Runtime.Remoting.Messaging;

    public class InterestCalculator
    {
        private decimal sumOfMoney;
        private double interest;
        private int years;
        private decimal resultValue;

        public delegate decimal CalculateInterest(decimal moneySum, double interest, int years);

        public InterestCalculator(decimal sumOfMoney, double interest, int years, CalculateInterest interestDelegate)
        {
            this.Money = sumOfMoney;
            this.Interest = interest;
            this.Years = years;
            this.ResultValue = interestDelegate(sumOfMoney, interest, years);
        }

        public decimal Money
        {
            get { return this.sumOfMoney; }
            set { this.sumOfMoney = value; }
        }

        public double Interest
        {
            get
            {
                return this.interest;
            }

            set
            {
                if (value < 0)
                {
                    throw new FormatException("Interest can not be negative!");
                }

                this.interest = value;
            }
        }

        public int Years
        {
            get
            {
                return this.years;
            }

            set
            {
                if (value < 0)
                {
                    throw new FormatException("Period can not be negative!");
                }

                this.years = value;
            }
        }

        public decimal ResultValue
        {
            get { return this.resultValue; }
            private set { this.resultValue = value; }
        }
    }
}

