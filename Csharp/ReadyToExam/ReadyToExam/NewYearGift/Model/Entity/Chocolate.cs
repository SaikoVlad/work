using System.Text;
using ReadyToExam.NewYearGift.Model.Abstracts;

namespace ReadyToExam.NewYearGift.Model.Entity
{
    public class Chocolate : Candy
    {
        private string _type;
        private bool _withFilling;
        private string _form;

        public Chocolate(double weight, string creator, double price, string type, bool withFilling, string form) : base(weight, creator, price)
        {
            _type = type;
            _withFilling = withFilling;
            _form = form;
        }

        public string Type
        {
            get => _type;
            set => _type = value;
        }

        public bool WithFilling
        {
            get => _withFilling;
            set => _withFilling = value;
        }

        public string Form
        {
            get => _form;
            set => _form = value;
        }

        public override string ToString()
        {
            return new StringBuilder().Append("Chocolate " + base.ToString() + "\nType = " + _type +
                                              "\nWith Filling or not? - " + _withFilling + "\nForm = " + _form)
                .ToString();
        }
    }
}