using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Lab8.cng.Model.Collections.neww.queue
{
    public class LinkedQueue<T> : AbstractCollection<T>, IQueueInterface<T>
    {
        private Link<T> _front, _end;
        private int _sizeOfQueue;

        public LinkedQueue()
        {
            _front = null;
            _end = null;
            _sizeOfQueue = 0;
        }

        public LinkedQueue(T[] ts)
        {
            _front = null;
            _end = null;
            _sizeOfQueue = 0;
            AddAll(new Collection<T>(ts));
        }

        public void Enqueue(T t)
        {
            if (_sizeOfQueue == 0)
            {
                _front = new Link<T>(t, null, null);
                _end = _front;
            }
            else
            {
                _end.NextNode = new Link<T>(t, _end, null);
                _end = _end.NextNode;
            }

            _sizeOfQueue++;
        }

        public T Dequeue()
        {
            Link<T> rm = _front;
            if (_sizeOfQueue == 0)
            {
                return default(T);
            }
            else
            {
                _front = _front.NextNode;
            }

            _sizeOfQueue--;
            return rm.Element;
        }

        public T Peek()
        {
            return _sizeOfQueue == 0 ? default(T) : _end.Element;
        }

        public override int Size()
        {
            return _sizeOfQueue;
        }

        public override void Add(T t)
        {
            Enqueue(t);
        }

        public override IEnumerator<T> GetEnumerator()
        {
            LinkedQueue<T> linkedQueue = this;
            while (!linkedQueue.IsEmpty())
            {
                yield return linkedQueue.Dequeue();
            }
        }
        
        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
        
        public override int GetHashCode()
        {
            const int hashconst = 31;
            int result = 1;
            foreach (object o in this)
            {
                result += result * hashconst + o.GetHashCode();
            }

            return result;
        }

        public override bool Equals(Object obj)
        {
            return this.GetHashCode() == obj.GetHashCode() && obj.GetType() == typeof(LinkedQueue<T>);
        }
    }
}