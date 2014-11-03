using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentClass
{
    class Student
    {
        private int age;
        private string name;

        public Student(string name, int age)
        {
            this.age = age;
            this.name = name;
        }

        public int Age
        {
            get
            {
                return this.age;
            }
            set
            {
                if (value < 1)
                {
                    throw new ArgumentOutOfRangeException("Ages","Age property should be positive integer number.");
                }
                this.OnPropertyChanged(new PropertyChangedEventArgs<string>("Age", this.Age.ToString(), value.ToString()));
                this.age = value;

            }
        }

        public string Name
        {
            get
            {
                return this.name;
            }
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("Name", "Student's name should be valid.");
                }
                this.OnPropertyChanged(new PropertyChangedEventArgs<string>("Name", this.Name, value));
                this.name = value;
            }
        }

        public event EventHandler<PropertyChangedEventArgs<string>> PropertyChanged;

        protected virtual void OnPropertyChanged(PropertyChangedEventArgs<string> e)
        {
            if (this.PropertyChanged != null)
            {
                this.PropertyChanged(this, e);
            }
         }
    }
}
