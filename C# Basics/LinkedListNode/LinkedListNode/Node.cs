using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedListNode
{
    public class Node
    {
        public Node(object value)
        {
            this.Value = value;
        }

        public object Value { get; private set; }
        public Node Next { get; internal set; }
        public Node Prev { get; internal set; }

    }
}
