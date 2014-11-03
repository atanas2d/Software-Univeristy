using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SchoolSystem
{
    class Discipline : IDetail
    {
        private string name;
        private uint numberOfLectures;
        private IList<Student> students = new List<Student>();
        private string details;

        public Discipline(string name, uint numberOfLectures, string details = null)
        {
            this.Name = name;
            this.NumberOfLectures = numberOfLectures;
            this.Details = details;
        }

        public Discipline(string name, uint numberOfLectures, IList<Student> students, string details = null)
            : this(name, numberOfLectures, details)
        {
            this.students = students;
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
                    throw new ArgumentNullException("Name", "Name of the discipline cannot be null or empty.");
                }

                this.name = value;               
            }
        }

        public uint NumberOfLectures 
        {
            get
            {
                return this.numberOfLectures;
            }

            set
            {
                this.numberOfLectures = value;
            }
        }

        public string Details
        {
            get
            {
                return this.details;
            }

            set
            {
                this.details = value;
            }
        }

        public void AddStudent(Student student)
        {
            this.students.Add(student);
        }

        public override string ToString()
        {
            return string.Format("Discipline: " + this.Name + "; Numbers of lectures: " + this.NumberOfLectures + "\n " +
                string.Join(",", this.students.Select(s => s.ToString() + "\n"));
        }
    }
}
