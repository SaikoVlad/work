using System.Collections.ObjectModel;

namespace Lab8.cng.Model.Collections.neww.queue
{
    public interface IQueueInterface<T> : ICngCollection<T>
    {
        void Enqueue(T t);
        T Dequeue();
        T Peek();
        int Size();
        bool IsEmpty();
        void AddAll(Collection<T> c);

    }
}