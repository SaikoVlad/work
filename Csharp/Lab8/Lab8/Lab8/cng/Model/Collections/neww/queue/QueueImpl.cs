using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace Lab8.cng.Model.Collections.neww.queue
{
    public class QueueImpl<T> : AbstractCollection<T>, IQueueInterface<T>
    {
        private object[] _queue = new object[4];
        private int _sizeVar;
        private int _queueArraySize = 4;


        public QueueImpl()
        {
        }

        public QueueImpl(T[] ts)
        {
            foreach (T t in ts)
            {
                Enqueue(t);
            }
        }

        public void Enqueue(T t)
        {
            if (_sizeVar == _queueArraySize - 1)
            {
                Resize(_queueArraySize * 2);
            }

            _queue[_sizeVar++] = t;
        }


        public T Dequeue()
        {
            T t = (T) _queue[0];
            object[] objects = new object[_queue.Length - 1];
            for (int i = 0; i < _queue.Length - 1; i++)
            {
                objects[i] = _queue[i + 1];
            }
            _queue = objects;
            _sizeVar--;
            return t;
        }


        public T Peek()
        {
            return (T) _queue[0];
        }


        public override int Size()
        {
            return _sizeVar;
        }

        public override void Add(T t)
        {
            Enqueue(t);
        }


        public override int GetHashCode()
        {
            const int hashconst = 31;
            int result = 1;
            for (int i = 0; i < _sizeVar; i++)
            {
                result += result * hashconst + _queue[i].GetHashCode();
            }

            return result;
        }

        //iterator
        public override IEnumerator<T> GetEnumerator()
        {
            for (int i = 0; i < _sizeVar; i++)
            {
                yield return (T) _queue[i];
            }
        }
        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
        //iterator

        public override bool Equals(Object obj)
        {
            return this.GetHashCode() == obj.GetHashCode() && obj.GetHashCode() == this.GetHashCode();
        }


        public override String ToString()
        {
            StringBuilder sb = new StringBuilder().Append("Content\n");
            for (int i = 0; i < _sizeVar; i++)
            {
                sb.Append(i).Append("\n");
            }

            return sb.ToString();
        }

        


        //PRIVATE METHODS

        private void Resize(int newLength)
        {
            _queueArraySize = newLength;
            object[] newArray = new object[newLength];
            for (int i = 0; i < _sizeVar; i++)
            {
                newArray[i] = _queue[i];
            }
            _queue = newArray;
        }
    }
}