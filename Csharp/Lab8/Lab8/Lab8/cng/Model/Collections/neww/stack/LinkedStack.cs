using System.Collections.Generic;

namespace Lab8.cng.Model.Collections.neww.stack
{
    public class LinkedStack<T> : AbstractCollection<T>, IStackInterface<T>
    {
        
        private Link<T> _front, _end;

        private int _size;

        public LinkedStack() {
            _front = null;
            _end = null;
            _size = 0;
        }

        public LinkedStack(T []ts){
            _front = null;
            _end = null;
            _size = 0;
            foreach (T t in ts){
                Add(t);
            }
        }

        public override int Size()
        {
            return _size;
        }

        public override void Add(T t)
        {
            Push(t);
        }

        public override IEnumerator<T> GetEnumerator()
        {
            LinkedStack<T> stack = this;
            while (!stack.IsEmpty())
            {
                yield return stack.Pop();
            }
        }

        public T Peek(){
            return _end.Element;
        }
        
        public void Push(T t) {
            if (_size == 0) {
                _front = new Link<T>(t, null, null);
                _end = _front;
            } else {
                _end.NextNode = new Link<T>(t, _end, null);
                _end = _end.NextNode;
            }
            _size++;
        }
        
        public T Pop() {
            Link<T> rm = _end;
            if (_size == 0) {
                return default(T);
            } else if (_size == 1) {
                _front = null;
            } else {
                _end = _end.PrevNode;
                _end.PrevNode = null;
            }
            _size--;
            return rm.Element;
        }
        
        public override int GetHashCode() {
            const int hashconst = 31;
            int result = 1;
            foreach (object o in this) {
                result += result * hashconst + o.GetHashCode();
            }
            return result;
        }
        
    }
}