namespace Customer
{
    using System;
    using System.Collections.Generic;

    public class Customer : ICloneable, IComparable<Customer>
    {
        private long id;
        private string firstName;
        private string middleName;
        private string lastName;
        private string paymentAddress;
        private string mobilePhone;
        private string email;
        private IList<Payment> payments;
        private CustomerType type;

        public Customer(
            long id, 
            string firstName, 
            string middleName, 
            string lastName, 
            string paymentAddress, 
            string mobilePhone, 
            string email, 
            IList<Payment> payment, 
            CustomerType type)
        {
            this.Id = id;
            this.FirstName = firstName;
            this.MiddleName = middleName;
            this.LastName = lastName;
            this.PaymentAddress = paymentAddress;
            this.MobilePhone = mobilePhone;
            this.Email = email;
            this.Payments = payment;
            this.Type = type;
        }

        public long Id
        {
            get
            {
                return this.id;
            }

            set
            {
                if (value.ToString().Length != 10)
                {
                    throw new ArgumentException("ID", "ID number should be exact 10 digits long.");
                }

                this.id = value;
            }
        }

        public string FirstName
        {
            get
            {
                return this.firstName;
            }

            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("FirstName", "First name should not be null or empty.");
                }

                this.firstName = value;
            }
        }

        public string MiddleName
        {
            get
            {
                return this.middleName;
            }

            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("MiddleName", "Middle name should not be null or empty.");
                }

                this.middleName = value;
            }
        }

        public string LastName
        {
            get
            {
                return this.lastName;
            }

            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("LastName", "Last name should not be null or empty.");
                }

                this.lastName = value;
            }

        }

        public string PaymentAddress
        {
            get
            {
                return this.paymentAddress;
            }

            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("PaymentAddress", "Payment address should not be null or empty.");
                }

                this.paymentAddress = value;
            }
        }

        public string MobilePhone
        {
            get
            {
                return this.mobilePhone;
            }

            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("MobilePhone", "Mobile phone field should not be null or empty.");
                }

                this.mobilePhone = value;
            }

        }

        public string Email
        {
            get
            {
                return this.email;
            }

            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("Email", "Email field should not be null or empty.");
                }

                this.email = value;
            }
        }

        public IList<Payment> Payments
        {
            get
            {
                return this.payments;
            }

            set
            {
                if (value == null)
                {
                    throw new ArgumentNullException("Payments", "Customer's payments field can not be null.");
                }

                this.payments = value;
            }
        }

        public CustomerType Type
        {
            get
            {
                return this.type;
            }

            set
            {
                this.type = value;
            }
        }

        public override string ToString()
        {
            string customerString = string.Format(
               "ID: {0}, Name: {1} {2}, payments: {3}",
               this.Id,
               this.FirstName,
               this.LastName,
               string.Join(", ", this.Payments));

            return customerString;
        }

        public override int GetHashCode()
        {
            string hashCode = this.FirstName + this.MiddleName + this.LastName + this.Id;
            return hashCode.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            Customer customerToCompare = obj as Customer;

            if (customerToCompare == null)
            {
                throw new ArgumentException("Customer", "The given object cannot be parsed to customer.");
            }

            if (customerToCompare.Id == this.Id)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool operator ==(Customer firstCustomer, Customer secondCustomer)
        {
            return Object.Equals(firstCustomer, secondCustomer);
        }

        public static bool operator !=(Customer firstCustomer, Customer secondCustomer)
        {
            return !Object.Equals(firstCustomer, secondCustomer);
        }

        public object Clone()
        {
            Customer newCustomer = this.MemberwiseClone() as Customer;

            if (newCustomer == null)
            {
                throw new ArgumentException("Customer", "Object to clone cannot be casted to type Custommer.");
            }

            newCustomer.Payments = new List<Payment>(this.Payments.Count);

            foreach (var payment in this.Payments)
            {
                newCustomer.Payments.Add(payment.Clone() as Payment);
            }

            return newCustomer;
        }

        public int CompareTo(Customer otherCustomer)
        {
            string thisFullName = this.FirstName + " " + this.MiddleName + " " + this.LastName;
            string otherFullName = otherCustomer.FirstName + " " + otherCustomer.MiddleName + " " + otherCustomer.LastName;

            if (thisFullName.CompareTo(otherFullName) == 0)
            {
                return this.Id.CompareTo(otherCustomer.Id);
            }

            return thisFullName.CompareTo(otherFullName);
        }

    }
}
