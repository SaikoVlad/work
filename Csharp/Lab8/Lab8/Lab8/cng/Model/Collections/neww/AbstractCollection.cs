using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Lab8.cng.Model.Collections.neww
{
    public abstract class AbstractCollection<T> : ICngCollection<T>
    {

        public abstract int Size();

        public bool IsEmpty()
        {
            return Size() == 0;
        }

        public abstract void Add(T t);

        public void AddAll(Collection<T> c)
        {
            foreach (var obj in c)
            {
                Add(obj);
            }
        }

        public bool Contains(T t)
        {
            foreach (var obj in this)
            {
                if (t.Equals(this))
                {
                    return true;
                }
            }

            return false;
        }

        public bool ContainsAll(Collection<T> c)
        {
            foreach (var obj in this)
            {
                if (!Contains(obj))
                {
                    return false;
                }
            }

            return true;
        }

        public object[] ToArray()
        {
            object []objects = new object[Size()];
            IEnumerator enumerator = GetEnumerator();
            int i = 0;
            while (enumerator.MoveNext())
            {
                objects[i++] = enumerator.Current;
            }

            return objects;
        }


        public abstract IEnumerator<T> GetEnumerator();

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}