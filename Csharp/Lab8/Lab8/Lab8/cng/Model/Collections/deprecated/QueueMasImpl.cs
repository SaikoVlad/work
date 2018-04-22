using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace Lab8.cng.Model.Collections.deprecated
{
    public class QueueMasImpl<TParam> : Queue<TParam>, ICustomCollections<TParam>
    {
        private Object[] _queue = new Object[0];

        public QueueMasImpl()
        {
        }


        public TParam Get(int index)
        {
            return (TParam) _queue[index];
        }


        public int Size()
        {
            return _queue.Length;
        }

        public bool IsEmpty()
        {
            return _queue[0] == null;
        }

        public bool Contains(Object o)
        {
            foreach (Object p in _queue)
            {
                if (p.Equals(o))
                {
                    return true;
                }
            }

            return false;
        }


        public Object[] ToArray()
        {
            return _queue;
        }

        

        public Object[] CollectionToArray()
        {
            return _queue;
        }

        

        public void SetElement(int index, TParam param)
        {
            _queue[index] = param;
        }

        
        public bool Add(TParam param)
        {
            try
            {
                Object[] temp = new Object[_queue.Length + 1];
                for (int i = 0; i < _queue.Length; i++)
                {
                    temp[i] = _queue[i];
                }

                temp[_queue.Length] = param;
                _queue = temp;
            }
            catch (NullReferenceException e)
            {
                _queue = new Object[1];
                _queue[0] = param;
            }

            return true;
        }

        public bool Remove(Object o)
        {
            for (int i = 0; i < _queue.Length; i++)
            {
                if (_queue[i].Equals(o))
                {
                    DeleteByIndex(i);
                    return true;
                }
            }

            return false;
        }

        public bool ContainsAll(Collection<TParam> c)
        {
            int eq = 0;
            for (int i = 0; i < _queue.Length; i++)
            {
                foreach (Object obj in c){
                    if (obj.Equals(_queue[i]))
                    {
                        eq++;
                    }
                }
            }

            return eq == c.Count;
        }

       
        public bool AddAll(Collection<TParam> c) {
            foreach (Object o in c){
                Add((TParam) o);
            }
            return true;
        }
        

        public bool RemoveAll(Collection<Object> c)
        {
            bool isDeleted = false;
            foreach (Object collection in c){
                for (int i = 0; i < _queue.Length; i++)
                {
                    if (collection.Equals(_queue[i]))
                    {
                        DeleteByIndex(i);
                        isDeleted = true;
                    }
                }
            }
            return isDeleted;
        }

        

        public bool RetainAll(Collection<Object> c)
        {
            QueueMasImpl<TParam> temp = new QueueMasImpl<TParam>();
            bool ok = true;
            foreach (Object obj in c){
                for (int i = 0; i < _queue.Length; i++)
                {
                    if (obj.Equals(_queue))
                    {
                        temp.Add((TParam) _queue[i]);
                    }
                    else
                    {
                        ok = false;
                    }
                }
            }
            _queue = temp.CollectionToArray();
            return ok;
        }

        

        public void Clear()
        {
            _queue = null;
        }

        

        public bool Offer(TParam param)
        {
            return Add(param);
        }

        

        public TParam Remove()
        {
            if (_queue == null)
            {
                throw new Exception("Collection is empty!");
            }

            Object o = _queue[0];
            DeleteByIndex(0);
            return (TParam) o;
        }


        public object Poll()
        {
            if (_queue == null)
            {
                return null;
            }

            Object o =_queue[0];
            DeleteByIndex(0);
            return (TParam) o;
        }

        public TParam Element()
        {
            if (_queue != null)
            {
                return (TParam) _queue[0];
            }

            throw new Exception("Collection is empty!");
        }

        

        public object Peek()
        {
            if (_queue != null)
            {
                return (TParam) _queue[0];
            }

            return null;
        }

        public override int GetHashCode()
        {
            const int constvar = 31;
            int result = 1;
            result = constvar * result + Size();
            foreach (Object aStackArray in _queue) {
                result = constvar * result + aStackArray.GetHashCode();
            }
            return result;
        }

       

        public override bool Equals(Object o)
        {
            return o != null && this.GetHashCode() == o.GetHashCode() && this.GetType() == o.GetType();
        }

        public void DeleteByIndex(int index)
        {
            Object[] objects = new Object[_queue.Length - 1];
            Array.Copy(_queue, 0, objects, 0, index);
            Array.Copy(_queue, index + 1, objects, index, _queue.Length - index - 1);
            _queue = objects;
        }

        

        public override String ToString()
        {
            StringBuilder stringBuilder = new StringBuilder();
            foreach (Object aQueue in _queue) {
                stringBuilder.Append("\n").Append(aQueue.ToString());
            }
            return stringBuilder.ToString();
        }
    }
}