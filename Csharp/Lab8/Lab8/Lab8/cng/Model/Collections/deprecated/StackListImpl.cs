using System;
using System.Collections;
using System.Text;

namespace Lab8.cng.Model.Collections.deprecated
{
    public class StackListImpl <TParam> : ICustomCollections<TParam>
    {
        private ArrayList _stackArray = new ArrayList();

        public StackListImpl(){}


        public bool Add(TParam param)
        {
            _stackArray.Add(param);
            return true;
        }

        public TParam Get(int index)
        {
            return (TParam) _stackArray[index];
        }

        public int Size() {
            return _stackArray.Count;
        }

        
        public TParam Pop() {
            object returner = _stackArray[Size() - 1];
            _stackArray.Remove(Size() - 1);
            return (TParam) returner;
        }

        
        public bool IsEmpty() {
            return Size() == 0;
        }

        
        public Object[] CollectionToArray() {
            return _stackArray.ToArray();
        }

        public void SetElement(int index, TParam param)
        {
            _stackArray.Add(param);
        }


        public void SetElement(TParam param) {
            _stackArray.Add(param);
        }


        
        public override bool Equals(Object o) {
            return o != null && this.GetHashCode() == o.GetHashCode() && this.GetType() == o.GetType();
        }

        
        public override int GetHashCode() {
            const int constvar = 31;
            int result = 1;
            result = constvar * result + Size();
            foreach (TParam aStackArray in _stackArray) {
                result = constvar * result + aStackArray.GetHashCode();
            }
            return result;
        }

        
        public override String ToString() {
            StringBuilder sb = new StringBuilder().Append("Stack content:\n");
            foreach (TParam aStackArray in _stackArray) {
                if (aStackArray != null) {
                    sb.Append(aStackArray).Append("\n");
                } else {
                    sb.Append("Object is empty\n");
                }
            }
            return sb.ToString();
        }
    }
}