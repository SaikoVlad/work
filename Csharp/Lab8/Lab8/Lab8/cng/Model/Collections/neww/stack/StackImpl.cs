using System;
using System.Collections.Generic;
using System.Text;

namespace Lab8.cng.Model.Collections.neww.stack
{
    public class StackImpl<T> : AbstractCollection<T>, IStackInterface<T>
    {
       
        private object[] _stack = new object[4];
        private int _sizeVar;
        private int _stackArraySize = 4;

        public StackImpl()
        {
        }

        public StackImpl(T[] ts)
        {
            foreach (T t in ts)
            {
                Push(t);
            }
        }


        public override int Size()
        {
            return _sizeVar;
        }

        public override void Add(T t)
        {
            Push(t);
        }

        public void Push(T t)
        {
            if (_sizeVar == _stackArraySize - 1)
            {
                Resize(_stackArraySize * 2);
            }

            _stack[_sizeVar++] = t;
        }


        public T Peek()
        {
            return (T) _stack[_sizeVar - 1];
        }


        public T Pop()
        {
            T t = (T) _stack[_sizeVar - 1];
            _stack[_sizeVar--] = null;
            return t;
        }


        //iterator
        public override IEnumerator<T> GetEnumerator()
        {
            for (int i = 0; i < _sizeVar; i++)
            {
                yield return (T) _stack[i];
            }
        }
        //iterator


        public override int GetHashCode()
        {
            const int hashconst = 31;
            int result = 1;
            foreach (object o in this._stack)
            {
                result += result * hashconst + o.GetHashCode();
            }

            return result;
        }

       
        public bool Equals(object obj)
        {
            return this.GetHashCode() == obj.GetHashCode() && obj.GetType() == this.GetType();
        }


        public string ToString()
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
            _stackArraySize = newLength;
            Object[] newArray = new Object[newLength];
            for (int i = 0; i < _sizeVar; i++)
            {
                newArray[i] = _stack[i];
            }

            _stack = newArray;
        }


        
    }
}