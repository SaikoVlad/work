using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Lab8.cng.Model.Collections.neww
{
    public interface ICngCollection<T> : IEnumerable<T>
    {
        int Size();
        bool IsEmpty();
        void Add(T t);
        void AddAll(Collection<T> c);
        bool Contains(T t);
        bool ContainsAll(Collection<T> c);
        object[] ToArray();
    }
}