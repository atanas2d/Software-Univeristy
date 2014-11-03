namespace SchoolSystem
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Threading.Tasks;

    public class Student : People
    {
        private uint uniqueClassNumber;

        public Student(string name, uint uniqeClassNumber)
            : base(name)
        {
            this.UniqueClassNumber = uniqueClassNumber;
        }

        public Student(string name, uint uniqueClassNumber, string detail)
            : this(name, uniqueClassNumber)
        {
            this.Detail = detail;
        }

        public uint UniqueClassNumber
        {
            get
            {
                return this.uniqueClassNumber;
            }

            set
            {
                this.uniqueClassNumber = value;
            }
        }

        public override string ToString()
        {
            StringBuilder result = new StringBuilder();
            result.Append(base.ToString() + ", No: " + this.uniqueClassNumber);
            if (!string.IsNullOrEmpty(this.Detail))
            {
                result.Append(", Details: " + this.Detail);
            }
            return result.ToString();
        }
    }
}
