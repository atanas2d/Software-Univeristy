using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OOP_Homework_1
{
    public class Person
    {
        private string name;
        private int age;
        private string email;

        public Person(string name, int age, string email)
        {
            this.Age = age;
            this.Email = email;
            this.Name = name;
        }

        public Person(string name, int age) 
            : this(name, age, null) { }

        public int Age
        {
            get { return this.age; }
            set {
                if (value < 1 || value > 100)
                {
                    throw new ArgumentException("Invalid ages!");
                }
                else
                {
                    this.age = value;
                }
            }
        }

        public string Name
        {
            get { return this.name; }
            set {
                    if (string.IsNullOrEmpty(value))
                    {
                        throw new ArgumentException("Invalid name!");
                    } else {
                        this.name = value;
                    }
                }
        }

        public string Email
        {
            get { return this.email; }
            set
            {
                if(value!=null && (value.Length==0 || !value.Contains("@"))) {
                    throw new ArgumentException("Invalid email!");
                } else {
                    this.email = value;
                }
            }
        }

        public override string ToString()
        {
            return string.Format("name: {0}, age:{1}", this.Name, this.Age) + (this.Email==null ? "" :", email:"+this.email);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {

            var Ivan = new Person("Ivan", 45);
            var Mitko = new Person("Mitko", 33, "abv@abv.bg");

            Console.WriteLine(Ivan);
            Console.WriteLine(Mitko);
            Console.ReadLine();
        }
    }
}
