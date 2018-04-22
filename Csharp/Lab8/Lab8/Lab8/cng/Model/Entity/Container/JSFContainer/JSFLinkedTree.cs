using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Entity.Container.JSFContainer
{
    public class JSFLinkedTree : IJsfTree
    {
        public JSFLinkedTree(Toy []toys)
        {
            foreach (var toy in toys)
            {
                Add(toy);
            }
        }
        
        public JSFLinkedTree(){}

        private LinkedList<Toy> _toys = new LinkedList<Toy>();
        
        public IEnumerator<Toy> GetEnumerator()
        {
            return _toys.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return _toys.GetEnumerator();
        }

        public int GetSizeOfTree()
        {
            return _toys.Count;
        }

        public void Remove(int index)
        {
            Toy[] objects = _toys.ToArray();
            _toys.Remove(objects[index]);
        }

        public void ChangeToy(Toy toy, int index)
        {
            Toy[] objects = _toys.ToArray();
            objects[index] = toy;
            _toys = new LinkedList<Toy>(objects);
        }

        public void Add(Toy toy)
        {
            _toys.AddLast(toy);
        }

        public Toy[] GetMasOfObjects()
        {
            return _toys.ToArray();
        }

        public Toy GetToy(int index)
        {
            return _toys.ToArray()[index];
        }

        public override string ToString()
        {
            StringBuilder stringBuilder = new StringBuilder();
            foreach (var toy in _toys)
            {
                stringBuilder.Append(toy).Append("\n");
            }

            return stringBuilder.ToString();
        }
    }
}