namespace Customer
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Threading.Tasks;

    public class Payment : ICloneable
    {
        private string productName;
        private decimal price;

        public Payment(string productName, decimal price)
        {
            this.ProductName = productName;
            this.Price = price;
        }

        public string ProductName
        {
            get
            {
                return this.productName;
            }

            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("ProductName", "Product name should not be empty or null.");
                }

                this.productName = value;
            }

        }

        public decimal Price
        {
            get
            {
                return this.price;
            }

            set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("Price", "Price should be positive number.");
                }

                this.price = value;
            }
        }

        public object Clone()
        {
            Payment newPaymentObject = this.MemberwiseClone() as Payment;

            if (newPaymentObject == null)
            {
                throw new ArgumentNullException("Cloned object cannot be casted to type Payment!");
            }

            return newPaymentObject;
        }

        public override string ToString()
        {
            return string.Format("{0} - {1}",this.ProductName, this.Price);
        }
    }
}
