using System.Collections;
using System.Collections.Generic;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Entity.Container.JSFContainer
{
    public class JSFArrayTree : IJsfTree
    {
        
        private ArrayList _toys = new ArrayList();
        
        public IEnumerator<Toy> GetEnumerator()
        {
            return (IEnumerator<Toy>) _toys.GetEnumerator();
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
            _toys.RemoveAt(index);
        }

        public void ChangeToy(Toy toy, int index)
        {
            _toys.RemoveAt(index);
            _toys.Insert(index,toy);
        }

        public void Add(Toy toy)
        {
            _toys.Add(toy);
        }

        public Toy[] GetMasOfObjects()
        {
            return (Toy[]) _toys.ToArray();
        }

        public Toy GetToy(int index)
        {
            return (Toy) _toys.GetRange(index, 1).ToArray()[0];
        }
    }
}