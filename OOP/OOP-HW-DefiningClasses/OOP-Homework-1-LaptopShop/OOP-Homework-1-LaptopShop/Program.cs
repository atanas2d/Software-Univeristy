using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OOP_Homework_1_LaptopShop
{
    class Program
    {
        public class Battery
        {
            private string type;
            private float hours;

            public Battery(string type)
            {
                this.Type = type;
            }

            public Battery(string type, float hours)
                : this(type)
            {
                this.Hours = hours;

            }

            public string Type
            {
                get { return this.type; }
                set
                {
                    if (value != null && value.Length == 0)
                    {
                        throw new ArgumentException("Invalid value for battery type!");
                    }
                    else
                    {
                        this.type = value;
                    }                    
                }
            }

            public float Hours
            {
                get { return this.hours; }
                set
                {
                    if (value < 0)
                    {
                        throw new ArgumentException("Battery hours can not be negative");
                    }
                    else
                    {
                        this.hours = value;
                    }                    
                }
            }

            public override string ToString()
            {
                StringBuilder resultStr = new StringBuilder();
                if (this.Type != null)
                {
                    resultStr.AppendLine("battery: " + this.Type);
                }
                if (this.Hours > 0)
                {
                    resultStr.AppendLine("battery life: " + this.Hours + "hours");
                }
                return resultStr.ToString();
            }
        }

        public class Laptop
        {
            private string model;
            private string manufacturer;
            private string processor;
            private string ram;
            private string hdd;
            private string graphicsCard;
            private Battery battery;
            private string screen;
            private decimal price;

            public Laptop(string model, decimal price)
            {
                this.Model = model;
                this.Price = price;
            }

            public Laptop(string model, decimal price, string manufacturer = null, string processor = null, string ram = null, string hdd = null, string graphicsCard = null, Battery battery = null, string screen = null)
                : this(model, price)
            {
                this.Manufacturer = manufacturer;
                this.Processor = processor;
                this.Ram = ram;
                this.HDD = hdd;
                this.GraphicsCard = graphicsCard;
                this.Battery = battery;
                this.Screen = screen;
            }

            public string Model
            {
                get { return this.model; }
                set
                {
                    if (string.IsNullOrEmpty(value))
                    {
                        throw new ArgumentNullException();
                    }
                    else
                    {
                        this.model = value;
                    }
                    
                }
            }

            public string Manufacturer
            {
                get { return this.manufacturer; }
                set
                {
                    if (value != null && value.Length < 1)
                    {
                        throw new ArgumentException("Invalid value for manufacturer!");
                    }
                    else
                    {
                        this.manufacturer = value;
                    }                    
                }
            }
            public string Processor
            {
                get { return this.processor; }
                set
                {
                    if (value != null && value.Length < 1)
                    {
                        throw new ArgumentException("Invalid value for processor!");
                    }
                    else
                    {
                        this.processor = value;
                    }                    
                }
            }
            public string Ram
            {
                get { return this.ram; }
                set
                {
                    if (value != null && value.Length < 1)
                    {
                        throw new ArgumentException("Invalid value for RAM!");
                    }
                    else
                    {
                        this.ram = value;
                    }                    
                }
            }

            public string HDD
            {
                get { return this.hdd; }
                set
                {
                    if (value != null && value.Length < 1)
                    {
                        throw new ArgumentException("Invalid value for HDD!");
                    }
                    else
                    {
                        this.hdd = value;
                    }                    
                }
            }

            public string GraphicsCard
            {
                get { return this.graphicsCard; }
                set
                {
                    if (value != null && value.Length < 1)
                    {
                        throw new ArgumentException("Invalid value for graphics card!");
                    }
                    else
                    {
                        this.graphicsCard = value;
                    }                    
                }
            }

            public Battery Battery
            {
                get { return this.battery; }
                set { this.battery = value; }
            }

            public string Screen
            {
                get { return this.screen; }
                set
                {
                    if (value != null && value.Length < 1)
                    {
                        throw new ArgumentException("Invalid value for screen!");
                    }
                    else
                    {
                        this.screen = value;
                    }                    
                }
            }

            public decimal Price
            {
                get { return this.price; }
                set
                {
                    if (value < 0)
                    {
                        throw new ArgumentException("Price can not be negative!");
                    }
                    else
                    {
                        this.price = value;
                    }                    
                }
            }

            public override string ToString()
            {
                StringBuilder laptopStr = new StringBuilder();
                laptopStr.AppendLine("model: " + this.Model);
                if (this.Manufacturer != null)
                {
                    laptopStr.AppendLine("manufacturer: " + this.Manufacturer);
                }

                if (this.Processor != null)
                {
                    laptopStr.AppendLine("processor: " + this.Processor);
                }

                if (this.Ram != null)
                {
                    laptopStr.AppendLine("RAM: " + this.Ram);
                }

                if (this.HDD != null)
                {
                    laptopStr.AppendLine("HDD: " + this.HDD);
                }

                if (this.Screen != null)
                {
                    laptopStr.AppendLine("screen: " + this.Screen);
                }

                if (this.Battery != null)
                {
                    laptopStr.Append(this.Battery.ToString());
                }

                laptopStr.AppendLine("price: " + this.Price);

                return laptopStr.ToString();
            }
        }
        static void Main(string[] args)
        {
            Battery lion = new Battery("Li-Ion, 8-cells, 4000 mAh");
            Battery nicd = new Battery("Ni-Cd", (float)4.5);
            Laptop laptop1 = new Laptop("Asus Pro Book", (decimal)900.00, "Asus", "Intel Core i5-4210U (2-core, 2.20 - 2.70 GHz, 3MB cache)", "8 GB", "128GB SSD", "Intel HD Graphics 4400", lion, "13.3\" (33.78 cm) – 3200 x 1800 (QHD+), IPS sensor display");
            Laptop laptop2 = new Laptop("Lenovo ThinkPad", (decimal)800.00, "Lenovo");
            Laptop laptop3 = new Laptop("Samsung Pro LapTop", (decimal)750, battery: nicd, processor: "2.2 GHz", ram: "4 GB");

            Console.WriteLine(laptop1.ToString());
            Console.WriteLine();
            Console.WriteLine(laptop2.ToString());
            Console.WriteLine();
            Console.WriteLine(laptop3.ToString());
        }
    }
}
