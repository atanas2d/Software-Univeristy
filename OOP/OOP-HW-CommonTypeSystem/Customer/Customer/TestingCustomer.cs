namespace Customer
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Threading.Tasks;

    class TestingCustomer
    {
        static void Main(string[] args)
        {
            Customer pesho = new Customer(
               1234567890,
               "Petar",
               "Ivanov",
               "Petrov",
               "BG12321235",
               "0884565250",
               "pesho@dir.bg",
               new List<Payment>() { new Payment("Cosmo disk", 124.29m) },
               CustomerType.Diamond);

            Customer misho = new Customer(
                1023456789,
                "Mihail",
                "Ivanov",
                "Mihailov",
                "BG12321235",
                "0884565253",
                "misho@dir.bg",               
                new List<Payment>() { new Payment("Cosmo disk", 124.29m), new Payment("magnitni nakolenki", 45.68m) },
                CustomerType.Golden);

            Customer gosho = new Customer(
                1203456789,
                "Georgi",
                "Borisov",
                "Georgiev",
                "BG12321235",
                "0884565252",
                "goshko@dir.bg",               
                new List<Payment>() { new Payment("magnitni nakolenki", 45.68m) },
                CustomerType.Regular);

            Customer goshoCopy = gosho;
            gosho.FirstName = "Genka";
            Console.WriteLine(gosho);
            Console.WriteLine(goshoCopy);
            Console.WriteLine(goshoCopy == gosho);
            Console.WriteLine(gosho.Equals(goshoCopy));
            Console.WriteLine(Object.ReferenceEquals(gosho, goshoCopy));

            goshoCopy = (Customer)gosho.Clone();
            goshoCopy.FirstName = "Gosho";
            goshoCopy.Payments.Add(new Payment("soleti", 2.03m));
            Console.WriteLine(gosho);
            Console.WriteLine(goshoCopy);
            Console.WriteLine(goshoCopy == gosho);
            Console.WriteLine(gosho.Equals(goshoCopy));
            Console.WriteLine(Object.ReferenceEquals(gosho, goshoCopy));
        }
    }
}
