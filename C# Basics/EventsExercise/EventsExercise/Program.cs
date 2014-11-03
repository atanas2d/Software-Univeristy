using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventsExercise
{
    class Program
    {
        static void Main(string[] args)
        {
            var myClock = new Clock();
            Person mike = new Person("Mike");
            Employee ivan = new Employee("Ivan", "DataPrim");
            myClock.WakeUpEvent += mike.WakePerson;
            myClock.WakeUpEvent += ivan.WakePerson;
            myClock.WakeUp();
            Console.ReadLine();
        }
    }

    class Clock
    {         
        public static string getTime() 
        {
            string result = DateTime.Now.ToString("H:mm:ss tt");
            return result;           
        }
        // Declare a delegate for argument free event 
        public event Action WakeUpEvent;
        // Function to trigger the Event
        public void WakeUp()
        {            
            if (WakeUpEvent != null)
            {
                Console.WriteLine("Clock: Wake Up Event is triggered at {0}.", Clock.getTime());
                WakeUpEvent();
            }
            else
            {
                Console.WriteLine("Clock: Wake Up Event is triggered at {0}, but no one is subscribed.", Clock.getTime());
            }
        }
    }
       
    class Person
    {
        // Person properties
        private string name;
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }
        // Person constructor
        public Person(string name)
        {
            this.Name = name;
        }
        public void WakePerson () {
            Console.WriteLine("{0} is awake.", this.Name);
        }
    }

    class Employee : Person
    {
        // Extending Person class
        private string office;
        public string Office
        {
            get
            {
                return office;
            }
            set
            {
                this.office = value + " office";
            }
        }
        public Employee(string name, string office) : base (name)
        {
            this.Office = office;
        }
        public void WakeEmployee() 
        {
            Console.WriteLine("{0} is awake. He is going to {1}.", this.Name, this.Office);
        }
    }
}
