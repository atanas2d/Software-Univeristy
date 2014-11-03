using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedListNode
{
    public class LinkedList
    {
        List<Node> lstNodes;

        public Node Last
        {
            get
            {
                return lstNodes.Count > 0 ? lstNodes[lstNodes.Count - 1] : null;
            }
        }

        public LinkedList()
        {
            lstNodes = new List<Node>();
        }

        public Node AddNode(object value)
        {
            Node newNode = new Node(value);

            newNode.Next = null;
            newNode.Prev = lstNodes.Count > 0 ? lstNodes[lstNodes.Count - 1] : null;

            if (newNode.Prev != null)
            {
                newNode.Prev.Next = newNode;
            }

            lstNodes.Add(newNode);

            return newNode;
        }
    }
}
