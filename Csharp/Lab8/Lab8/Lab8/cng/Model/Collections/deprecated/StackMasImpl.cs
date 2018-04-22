using System;
using System.Text;

namespace Lab8.cng.Model.Collections.deprecated
{
    public class StackMasImpl<TParam> : ICustomCollections<TParam>
    {
        private Object[] _stackArray = new Object[1];

        public StackMasImpl()
        {
        }

        public int Size()
        {
            return _stackArray.Length;
        }


        public void AddEl(TParam element)
        {
            try
            {
                int index = _stackArray.Length;
                Object[] temp = new Object[_stackArray.Length + 1];
                for (int i = 0; i < _stackArray.Length; i++)
                {
                    if (i < index)
                    {
                        temp[i] = _stackArray[i];
                    }
                    else
                    {
                        temp[i + 1] = _stackArray[i];
                    }
                }

                temp[index] = element;
                _stackArray = temp;
            }
            catch (NullReferenceException e)
            {
                _stackArray = new Object[1];
                _stackArray[0] = element;
            }
        }


        public TParam Push(TParam element)
        {
            try
            {
                Object[] temp = new Object[_stackArray.Length + 1];
                for (int i = 0; i < _stackArray.Length; i++)
                {
                    temp[i] = _stackArray[i];
                }

                temp[_stackArray.Length] = element;
                _stackArray = temp;
            }
            catch (NullReferenceException e)
            {
                _stackArray = new Object[1];
                _stackArray[0] = element;
            }

            return element;
        }


        public void SetElement(int index, TParam param)
        {
            _stackArray[index] = param;
        }


        public TParam Get(int index)
        {
            return (TParam) _stackArray[index];
        }


        public TParam Pop()
        {
            TParam ret = (TParam) _stackArray[_stackArray.Length - 1];
            try
            {
                Object[] temp = new Object[_stackArray.Length - 1];
                for (int i = 0; i < _stackArray.Length - 1; i++)
                {
                    temp[i] = _stackArray[i];
                }

                _stackArray = temp;
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }

            return ret;
        }


        public bool IsEmpty()
        {
            return Size() == 0;
        }


        public bool Add(TParam param)
        {
            Push(param);
            return true;
        }

        public Object[] CollectionToArray()
        {
            return _stackArray;
        }


        public override bool Equals(Object o)
        {
            return o != null && this.GetHashCode() == o.GetHashCode() && this.GetType() == o.GetType();
        }


        public override int GetHashCode()
        {
            const int constvar = 31;
            int result = 1;
            result = constvar * result + Size();
            foreach (Object aStackArray in _stackArray)
            {
                result = constvar * result + aStackArray.GetHashCode();
            }

            return result;
        }


        public override String ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("Stack content:\n");
            for (int i = 0; i < _stackArray.Length; i++)
            {
                sb.Append(_stackArray[i]).Append("\n");
            }

            return sb.ToString();
        }
    }
}