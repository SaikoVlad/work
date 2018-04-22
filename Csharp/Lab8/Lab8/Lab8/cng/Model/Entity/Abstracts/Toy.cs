using System;
using System.Text;

namespace Lab8.cng.Model.Entity.Abstracts
{
    public class Toy : IComparable<Toy>
    {

        private double _price;
        private double _weight;
        private double _size;

        public Toy() {
        }

        public Toy(double price, double weight, double size) {
            this._price = price;
            this._weight = weight;
            this._size = size;
        }

        public double GetPrice() {
            return _price;
        }

        public void SetPrice(double price) {
            this._price = price;
        }

        public double GetWeight() {
            return _weight;
        }

        public void SetWeight(double weight) {
            this._weight = weight;
        }

        public double GetSize() {
            return _size;
        }

        public void SetSize(double size) {
            this._size = size;
        }


        public override int GetHashCode()
        {
            const int hashconst = 31;
            int result = 1;
            result = hashconst * result + (int)_price;
            result = hashconst * result + (int)_weight;
            result = hashconst * result + (int)_size;
            return result;
        }


        public override bool Equals(object obj)
        {
            if (obj != null && obj.GetType() == this.GetType() && obj.GetHashCode() == this.GetHashCode()){
                return true;
            }else{
                return false;
            }
        }

        
        public override String ToString() {
            return new StringBuilder().Append("Params:\n\tPrice: ").Append(_price).Append("\n\tSize: ").Append(_size).Append("\n\tWeight: ").Append(_weight).ToString();//price,size,weight
        }

        public int CompareTo(Toy obj)
        {
            return (int) (this.GetPrice() - obj.GetPrice());
        }
    }
}