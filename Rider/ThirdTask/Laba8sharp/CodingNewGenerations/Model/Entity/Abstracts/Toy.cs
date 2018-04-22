using System.Text;

namespace Laba8sharp.CodingNewGenerations.Model.Abstracts
{
    public class Toy
    {
        private double price;
        private double weight;
        private double size;

        public Toy()
        {
        }

        public Toy(double price, double weight, double size)
        {
            this.price = price;
            this.weight = weight;
            this.size = size;
        }

        public double GetPrice()
        {
            return price;
        }

        public void SetPrice(double price)
        {
            this.price = price;
        }

        public double GetWeight()
        {
            return weight;
        }


        public void SetWeight(double weight)
        {
            this.weight = weight;
        }

        public double GetSize()
        {
            return size;
        }

        public void SetSize(double size)
        {
            this.size = size;
        }

        public override string ToString()
        {
            return new StringBuilder().Append("Params:\n\tPrice: " + price + "\n\tSize: " + size + "\n\tWeight: " + weight).ToString();//price,size,weight
        }
    }
}