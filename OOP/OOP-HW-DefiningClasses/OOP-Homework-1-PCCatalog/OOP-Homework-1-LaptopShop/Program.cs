using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace OOP_Homework_1_LaptopShop
{
    class Computer
    {
        private string name;
        private IList<Component> components;
        //private decimal price;

        public Computer(string name)
        {
            this.Name = name;
            this.Components = new List<Component>();
        }

        public Computer(string name, IList<Component> components)
            : this(name)
        {
            this.Components = components;
        }

        public string Name
        {
            get { return this.name; }
            set { this.name = value; }
        }

        public IList<Component> Components
        {
            get { return this.components; }
            set
            {
                if (null == value) { 
                    throw new ArgumentNullException("Computer components can not be null!");
                }
                else
                {
                    this.components = value;
                }                
            }

        }

        public decimal Price
        {
            get { return this.Components.Sum(a => a.Price); }
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();

            sb.AppendFormat("Name: {0}\nPrice: {1:C}\nComponents:\n", this.Name, this.Price);

            foreach (Component component in this.Components)
            {
                sb.AppendLine(component.ToString());
            }

            return sb.ToString();
        }

    }

    public abstract class Component
    {
        private string name;
        private string details;
        private decimal price;

        public Component(string name, decimal price, string details = null)
        {
            this.Name = name;
            this.Details = details;
            this.Price = price;
        }

        public string Name
        {
            get { return this.name; }
            set {
                if (null == value) { 
                    throw new ArgumentNullException("Component name can not be null");
                }
                else
                {
                    this.name = value;
                }
            }
        }

        public string Details
        {
            get { return this.details; }
            set { this.details = value; }
        }

        public decimal Price
        {
            get { return this.price; }
            set {
                if (value < 0)
                {
                    throw new ArgumentException("Component price can not be negative!");
                }
                else
                {
                    this.price = value;
                }
                
            }
        }

        public override string ToString()
        {
            string compToString = string.Format("Name:{0}, Price: {1:C}", this.Name, this.Price);
            if (null != this.Details)
            {
                compToString += string.Format(", Details: {0}", this.Details);
            }
            return compToString;
        }
    }

    class GraphicCard : Component
    {
        public GraphicCard(string name, decimal price, string details = null)
            : base(name, price, details) { }
    }

    class Motherboard : Component
    {
        public Motherboard(string name, decimal price, string details = null)
            : base(name, price, details) { }
    }

    class Processor : Component
    {
        public Processor(string name, decimal price, string details = null)
            : base(name, price, details)
        {

        }
    }


    class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;

            Thread.CurrentThread.CurrentUICulture = new CultureInfo("bg-BG");

            Component mcardVLC = new Motherboard("AMD-MB", (decimal)190.00);
            Component vcardRadeon = new GraphicCard("Radeon", (decimal)100.00, "first quality GC");
            Component vcardGeForce = new GraphicCard("GeForce", (decimal)133.15, "Old school GC");

            Component procIntel = new Processor("Intel", (decimal)366.00, "Best processors");
            Component procAMD = new Processor("AMD", (decimal)410.00, "One of the best processors");

            Computer compAMDRadeon = new Computer("TopComp", new List<Component>() { mcardVLC, vcardRadeon, procAMD });
            Computer compIntelGeForce = new Computer("CompPlus");
            compIntelGeForce.Components.Add(vcardGeForce);
            compIntelGeForce.Components.Add(mcardVLC);

            List<Computer> computers = new List<Computer>() { compAMDRadeon, compIntelGeForce };

            computers.OrderBy(c => c.Price).ToList().ForEach(c => Console.WriteLine(c.ToString()));            
        }
    }
}
