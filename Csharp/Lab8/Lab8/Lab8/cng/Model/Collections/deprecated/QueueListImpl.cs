using System;
using System.Collections;
using System.Text;

namespace Lab8.cng.Model.Collections.deprecated
{
    public class QueueListImpl<TParam> : ICustomCollections<TParam>
    {
        private static ArrayList _queue = new ArrayList();

        public QueueListImpl(){

        }

        public QueueListImpl(TParam []param)
        {
            _queue.AddRange(param);

        }

        public TParam Peek()
        {
            return (TParam) _queue[_queue.Count - 1];
        }

        
        public void Append(TParam obj) {
            _queue.Add(obj);
        }


        public bool Add(TParam param)
        {
            Append(param);
            return true;
        }

        public TParam Get(int index)
        {
            return (TParam) _queue[index];
        }

        public int Size()
        {
            return _queue.Count;
        }

        public bool IsEmpty()
        {
            return _queue[0] == null;
        }

        public object[] CollectionToArray()
        {
            return _queue.ToArray();
        }

        public void SetElement(int index, TParam param)
        {
            _queue.Add(param);
        }


        public TParam PeekFirst()
        {
            return (TParam) _queue[0];
        }

        
        public TParam TakeFirst()
        {
            return (TParam) _queue[0];
        }

        
        public TParam PeekLast()
        {
            return (TParam) _queue[_queue.Count - 1];
        }

        
        public TParam TakeLast()
        {
            return (TParam) _queue[_queue.Count];
        }

        
        public void RemoveLast() {
            _queue.Remove(_queue.Count - 1);
        }


        public override bool Equals(object o)
        {
            return o != null && this.GetHashCode() == o.GetHashCode() && this.GetType() == o.GetType();
        }

        public override int GetHashCode()
        {
            const int constvar = 31;
            int result = 1;
            result = constvar * result + _queue.Count;
            foreach (Object aStackArray in _queue) {
                result = constvar * result + aStackArray.GetHashCode();
            }
            return result;
        }


        public override String ToString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < _queue.Count; i++) {
                sb.Append(_queue[i]).Append("\n");
            }
            return sb.ToString();
        }
    }
}