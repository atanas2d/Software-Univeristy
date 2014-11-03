using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CustomLINQExtensionMethods
{
    public static class LINQ_Extensions
    {
        public static IEnumerable<T> WhereNot<T>(this IEnumerable<T> collection, Func<T, bool> predicate)
        {
            return collection.Where(a => !predicate(a));
        }

        public static IEnumerable<T> Repeat<T>(this IEnumerable<T> collection, int count)
        {
            List<T> list = collection.ToList();
            for (int i = 0; i < count - 1; i++)
            {
                list.AddRange(collection);
            }

            return list as IEnumerable<T>;
        }

        public static IEnumerable<string> WhereEndsWith(this IEnumerable<string> collection, IEnumerable<string> suffixes)
        {
            List<string> resultList = new List<string>();
            foreach(string item in collection) {
                foreach (string suffix in suffixes)
                {
                    if (item.EndsWith(suffix))
                    {
                        resultList.Add(item);
                    }
                }
            }
            return resultList as IEnumerable<string>;
        }
    }
}
