using System;
using System.Text;
using Lab8.cng.Model.Collections.deprecated;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Entity.Container
{
    public class SmartTree
    {
        private ICustomCollections <Toy> _toysMass = null;
        private static SmartTree _tree = null;

        public SmartTree() {

        }

        public SmartTree(ICustomCollections<Toy> collections){
            _toysMass = collections;
        }

        public static SmartTree GetInstance(ICustomCollections<Toy> collections){
            return new SmartTree(collections);
        }


        public Toy[] GetToysMass() {    
            return (Toy[]) _toysMass.CollectionToArray();
        }

        public int GetSize(){
            return _toysMass.Size();
        }

        public Toy GetToy(int index){
            return _toysMass.Get(index);
        }
        //priceTree
        public void ChangeToy(Toy newToy, int index){
            _toysMass.SetElement(index,newToy);
        }

        public void SetToy(Toy newToy, int index){
            _toysMass.SetElement(index,newToy);
        }

        public double GetPrice(int index){
            return _toysMass.Get(index).GetPrice();
        }

        public void Add(Toy []newToys) {
            foreach (Toy newToy in newToys){
                _toysMass.Add(newToy);
            }
        }

        
        public override int GetHashCode() {
            int hashconst = 31;
            int result = 1;
            result = hashconst * result + GetSize();
            foreach (Object obj in _toysMass.CollectionToArray()){
                result = hashconst * result + obj.GetHashCode();
            }
            return result;
        }

        
        public bool Equals(Object obj) {
            return (obj != null && this.GetHashCode() == obj.GetHashCode() && obj.GetType() == this.GetType());
        }

        
        public override String ToString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < _toysMass.Size(); i++) {
                sb.Append(_toysMass.Get(i)).Append("\n");
            }
            return sb.ToString();
        }
    }
}