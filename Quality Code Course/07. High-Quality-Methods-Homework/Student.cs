using System;

namespace Methods
{
    class Student
    {
        private string firstName;
        private string lastName;
        private string otherInfo;

        public Student()
        {

        }

        public Student(string firstName, string lastName)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
        }

        public Student(string firstName, string lastName, string otherInfo) 
            : this(firstName, lastName)
        {
            this.OtherInfo = otherInfo;
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

        public string LastName {
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
        public string OtherInfo { 
            get 
            {
                return this.otherInfo;
            }
            set 
            {
                DateTime date;
                
                if (value.Length > 10 || DateTime.TryParse(value.Substring(value.Length - 10), out date))
                {
                    this.otherInfo = value;
                }
                else
                {
                    throw new ArgumentException("OtherInfo","Last 10 chars of Other Info cannot be parsed to DateTime.");
                }
            } 
        }

        public bool IsOlderThan(Student other)
        {
            if (this.OtherInfo == null || other.OtherInfo == null)
            {
                throw new ArgumentException("DateInfo", "One of the students do not contain info about his birth date");
            }

            DateTime firstDate =
                DateTime.Parse(this.OtherInfo.Substring(this.OtherInfo.Length - 10));
            DateTime secondDate =
                DateTime.Parse(other.OtherInfo.Substring(other.OtherInfo.Length - 10));
            return firstDate > secondDate;
        }
    }
}
