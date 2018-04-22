namespace Lab8.cng.Model.Collections.neww.stack
{
    public interface IStackInterface<T>
    {
        void Push(T t);
        T Pop();
        T Peek();
        int Size();
        bool IsEmpty();
    }
}