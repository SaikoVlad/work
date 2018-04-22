using System.Text;
using ReadyToExam.NewYearGift.Model.Abstracts;

namespace ReadyToExam.NewYearGift.Model.Entity
{
    public class Lollipop : Candy
    {
        private double _diameter;
        private string _taste;

        public Lollipop(double weight, string creator, double price, double diameter, string taste) : base(weight, creator, price)
        {
            _diameter = diameter;
            _taste = taste;
        }

        public double Diameter
        {
            get => _diameter;
            set => _diameter = value;
        }

        public string Taste
        {
            get => _taste;
            set => _taste = value;
        }
        
        public override string ToString()
        {
            return new StringBuilder().Append("Lolipop " + base.ToString() + "\nDiameter = " + _diameter + "\nTaste = " + _taste).ToString();
        }
    }
}