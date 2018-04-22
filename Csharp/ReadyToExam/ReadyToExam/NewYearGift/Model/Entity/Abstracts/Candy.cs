using System;
using System.Text;

namespace ReadyToExam.NewYearGift.Model.Abstracts
{
    public class Candy
    {
        
        private double _weight;
        private string _creator;
        private double _price;

        public Candy(double weight, string creator, double price)
        {
            this._weight = weight;
            this._creator = creator;
            this._price = price;
        }

        public double Weight
        {
            get => _weight;
            set => _weight = value;
        }

        public string Creator
        {
            get => _creator;
            set => _creator = value;
        }

        public double Price
        {
            get => _price;
            set => _price = value;
        }

        public override bool Equals(object obj)
        {
            if (obj == null || this.GetType().Name == obj.GetType().Name)
            {
                return true;
            }
            return false;
        }

        public override string ToString()
        {
            return new StringBuilder().Append("Params:\nWeight = " + _weight + "\nCreator = " + _creator + "\nPrice = " + _price).ToString();
        }
        
    }
}