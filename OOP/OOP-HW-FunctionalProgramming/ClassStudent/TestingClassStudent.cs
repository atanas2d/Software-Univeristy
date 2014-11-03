using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassStudent
{
    class TestingClassStudent
    {
        static void Main(string[] args)
        {
            List<Student> students = new List<Student>();

            students.Add(new Student(
                "Ivan",
                "Petrov",
                24,
               100014,
                "+359888456123",
                "abv@dir.bg",                  
                new List<int>() { 2, 3, 4, 4, 6, 5, 6, 6 },
                1));

            students.Add(new Student(
                "Asen",
                "Petrov",
                33,
                100015,
                "+359888456123",
                "uimora@abv.bg",
                new List<int>() { 3, 3, 5, 4, 5, 5, 3, 4 },
                2));

            students.Add(new Student(
                "Nasko",
                "Carq",
                23,
                100016,
                "+35928456123",
                "gorica@abv.bg",
                new List<int>() { 5, 2, 5, 5, 6, 5, 6, 6 },
                2));

            students.Add(new Student(
                "Samuil",
                "Zubrachev",
                23,
            100017,
                "+359888456123",
                "plovdiv@dir.bg",
                new List<int>() { 5, 5, 5, 2, 6, 2, 6, 6 },
                3));

            students.Add(new Student(
                "Kondio",
                "Sokolov",
                23,
                100018,
                "+359888456123",
                "varna@dir.bg",
                new List<int>() { 2, 3, 3, 3, 3, 4, 5, 5 },
                3));

            students.Add(new Student(
                "Rupart",
                "Minjov",
                23,
                100019,
                "+359888456123",
                "siencex@dir.bg",
                new List<int>() { 5, 5, 3, 5, 4, 5, 5, 5 },
                1));

            Console.WriteLine("\nTESTING RESULTS: \n\n");
            // Print all students from group number 2. Use a LINQ query. Order the students by FirstName.       
            var studentsFromGroup2 = from student in students
                                     where student.GroupNumber == 2
                                     orderby student.FirstName
                                     select student;
            Console.WriteLine("Students from group 2 ordered by first name property: ");
            foreach (var item in studentsFromGroup2)
            {
                Console.WriteLine(item.ToString());
            }

            // Print all students whose first name is before their last name alphabetically         
            var studentsWithFNameBeforeLName = from student in students
                                               where student.FirstName.CompareTo(student.LastName) < 0
                                               select student;
            Console.WriteLine("\nStudents whose first name is before their last name alphabetically: ");
            foreach (Student student in studentsWithFNameBeforeLName)
            {
                Console.WriteLine(student.ToString());
            }

            /* Write a LINQ query that finds the first name and last name of all students with
             * age between 18 and 24. The query should return only the first name, last name and age.*/
            var studentsByAge_18_24 = from student in students
                                      where student.Age >= 18 && student.Age <= 24
                                      select new { student.FirstName, student.LastName, student.Age };
                

            Console.WriteLine("\nStudents with age between 18 and 24 years: ");
            foreach (var student in studentsByAge_18_24)
            {
                Console.WriteLine("{0} {1}, age: {2}", student.FirstName, student.LastName, student.Age);
            }

            /* Using the extension methods OrderBy() and ThenBy() with lambda expressions
             * sort the students by first name and last name in descending order. Rewrite the same with LINQ query syntax.*/
            var sortedStudentsExt = students.OrderByDescending(student => student.FirstName).ThenByDescending(student => student.LastName);

            var sortedStudentsLINQ = from student in students
                                     orderby student.FirstName descending, student.LastName descending
                                     select student;

            Console.WriteLine("\nStudents sorted descending by names: ");
            foreach (var student in sortedStudentsExt)
            {
                Console.WriteLine(student.ToString());
            }

            // Print all students that have email @abv.bg. Use LINQ.
            var studentsWithAbvMail = from student in students
                                    where student.Email.Contains("@abv.bg")
                                    select student;

            Console.WriteLine("\nStudents with email in abv.bg: ");
            foreach (var student in studentsWithAbvMail)
            {
                Console.WriteLine(student.ToString());
            }

            // Print all students with phones in Sofia (starting with 02 / +3592 / +359 2). Use LINQ.
            var studentsWithSofiaPhones = from student in students
                                        where student.Phone.StartsWith("02") ||
                                        student.Phone.StartsWith("+3592") ||
                                        student.Phone.StartsWith("+359 2")
                                        select student;

            Console.WriteLine("\nStudents with phone in Sofia: ");
            foreach (var student in studentsWithSofiaPhones)
            {
                Console.WriteLine(student.ToString());
            }

            /* Print all students that have at least one mark Excellent (6).
             * Using LINQ first select them into a new anonymous class that holds { FullName + Marks}.*/
            var excellentStudents = from student in students
                            where student.Marks.Contains(6)
                            select new { Fullname = student.FirstName + " " + student.LastName, Marks = student.Marks };

            Console.WriteLine("\nStudents with excellent marks: ");
            foreach (var student in excellentStudents)
            {
                Console.WriteLine("{0} {{ {1} }}", student.Fullname, string.Join(", ", student.Marks));
            }

            /* Write a similar program to the previous one to extract the students 
             * with exactly two marks "2". Use extension methods.*/
            var twoTwosStudents = students.Where(student => student.Marks.Where(m => m == 2).Count() == 2);

            Console.WriteLine("\nStudents with exactly two marks 2: ");
            foreach (var student in twoTwosStudents)
            {
                Console.WriteLine(student.ToString());
            }

            /* Extract and print the Marks of the students that enrolled in 2014 
             * (the students from 2014 have 14 as their 5-th and 6-th digit in the FacultyNumber).*/
            var enrolled2014 = from student in students
                               where student.FacultyNumber.ToString().EndsWith("14")
                               select student;

            Console.WriteLine("\nStudents enrolled in 2014: ");
            foreach (var student in enrolled2014)
            {
                Console.WriteLine(student.ToString());
            }
        }
    }
}
