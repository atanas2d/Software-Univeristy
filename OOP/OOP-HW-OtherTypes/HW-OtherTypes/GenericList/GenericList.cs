using System;
using System.Text;

namespace GenericList
{
    [Version(1.5)]
    public class GenericList<T> where T : IComparable<T>
    {
        // Storage for list elements
        private T[] storage;

        // Next index:
        private int nextIndex = 0;

        // Simple constructor
        public GenericList()
        {
            this.storage = new T[16];
        }

        // Return count of elements
        public int Count
        {
            get { return this.nextIndex; }
        }

        // Adding element
        public void Add(T element)
        {
            if (this.nextIndex > this.storage.Length - 1)
            {
                ExtendStorage();
            }

            this.storage[this.nextIndex] = element;
            this.nextIndex++;
        }

        // string representation of the list
        public override string ToString()
        {
            if (this.Count == 0)
            {
                return "";
            }

            var resultString = new StringBuilder("");

            for (int i = 0; i < this.Count - 1; i++)
            {
                resultString.Append(this.storage[i] + ", ");
            }

            resultString.Append(this.storage[this.Count - 1]);

            return resultString.ToString();
        }

        // accessing elements
        public T this[int index]
        {
            get
            {
                if (index < 0 || index > this.Count - 1)
                {
                    throw new IndexOutOfRangeException("Index was outside the bounds of the list.");
                }

                return this.storage[index];
            }

            set
            {
                if (index < 0 || index > this.Count - 1)
                {
                    throw new IndexOutOfRangeException("Index was outside the bounds of the list.");
                }

                this.storage[index] = value;
            }
        }

        // removing elements by index
        public void RemoveByIndex(int index)
        {
            try
            {
                if (index < this.Count - 1)
                {
                    for (int i = index; i < this.Count - 1; i++)
                    {
                        this.storage[i] = this.storage[i + 1];
                    }

                    this.nextIndex--;
                }
                else if (index == this.Count - 1)
                {
                    this.nextIndex--;
                }
                else
                {
                    throw new IndexOutOfRangeException();
                }
            }
            catch (IndexOutOfRangeException)
            {
                throw new IndexOutOfRangeException("Index was outside the bounds of the list.");
            }
        }

        // insert elements
        public void Insert(int index, T value)
        {
            try
            {
                if (index > this.Count)
                {
                    throw new IndexOutOfRangeException();
                }

                this.Add(this.storage[Count - 1]);

                for (int i = this.Count - 1; i >= index; i--)
                {
                    this.storage[i + 1] = this.storage[i];
                }

                this.storage[index] = value;
            }
            catch (IndexOutOfRangeException)
            {
                throw new IndexOutOfRangeException("Index was outside the bounds of the list.");
            }
        }

        // clearing list
        public void RemoveAll()
        {
            this.storage = new T[16];
            this.nextIndex = 0;
        }

        // finding element by index
        public int GetIndexByValue(T value, int startIndex = 0)
        {
            int valueIndex = -1;

            try
            {
                for (int i = startIndex; i < this.Count; i++)
                {
                    if (this.storage[i].Equals(value))
                    {
                        valueIndex = i;
                        break;
                    }
                }
            }
            catch (IndexOutOfRangeException)
            {
                throw new IndexOutOfRangeException("Index was outside the bounds of the list.");
            }

            return valueIndex;
        }

        // checking if the list contain a value
        public bool IsContain(T value)
        {
            return this.GetIndexByValue(value) >= 0;
        }
        
        public T Max()
        {
            var max = this.storage[0];

            for (int i = 1; i < this.Count; i++)
            {
                if (max.CompareTo(this.storage[i]) < 0)
                {
                    max = this.storage[i];
                }
            }

            return max;
        }

        public T Min()
        {
            var min = this.storage[0];

            for (int i = 1; i < this.Count; i++)
            {
                if (min.CompareTo(this.storage[i]) > 0)
                {
                    min = this.storage[i];
                }
            }

            return min;
        }

        // auto-grow functionality integration:
        private void ExtendStorage()
        {
            int newCapacity = this.storage.Length * 2;
            var newArray = new T[newCapacity];

            for (int i = 0; i < this.Count; i++)
            {
                newArray[i] = this.storage[i];
            }

            this.storage = newArray;
        }
    }
}
