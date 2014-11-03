using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassStudent
{
    class Student
    {
        public string FirstName { get; private set; }
        public string LastName { get; set; }
        public uint Age { get; private set; }
        public uint FacultyNumber { get; private set; }
        public string Phone { get; set; }
        public string Email { get; set; }
        public IList<int> Marks { get; set; }
        public uint GroupNumber { get; set; }

        public Student(
            string firstName,
            string lastName,
            uint age,
            uint facultyNumber,
            string phone,
            string email,
            IList<int> marks,
            uint groupNumber
            )
        {
            this.FirstName = firstName;
            this.LastName = lastName;
            this.Age = age;
            this.FacultyNumber = facultyNumber;
            this.Phone = phone;
            this.Email = email;

            if (marks == null)
            {
                this.Marks = new List<int>();
            }
            else
            {
                this.Marks = marks;
            }

            this.GroupNumber = groupNumber;
        }

        public override string ToString()
        {
            string marks = string.Join(", ", this.Marks as IEnumerable<int>);
            return string.Format(
                "{0} {1}, fac number: {2}, group: {3}, groupName: {8}, age: {4}, phone: {5}, email: {6}, marks:{{ {7} }}",
                this.FirstName,
                this.LastName,
                this.FacultyNumber,
                this.GroupNumber,
                this.Age,
                this.Phone,
                this.Email,
                marks,
                this.GroupNumber);
        }
                
    }
}
