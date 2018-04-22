using System.Text;
using Laba8sharp.CodingNewGenerations.Model.Abstracts;

namespace Laba8sharp.CodingNewGenerations.Model.Entity
{
    public class Garland : Toy
    {
        private double length;
        private int countOfElemets;
        private string element;

        public Garland()
        {
        }

        public Garland(double price, double weight, double size, double length, int countOfElemets, string element) : base(price, weight, size)
        {
            this.length = length;
            this.countOfElemets = countOfElemets;
            this.element = element;
        }
        
        public double GetLength() {
            return length;
        }

        public void SetLength(double length) {
            this.length = length;
        }

        public int GetCountOfElemets() {
            return countOfElemets;
        }

        public void SetCountOfElemets(int countOfElemets) {
            this.countOfElemets = countOfElemets;
        }

        public string GetElement() {
            return element;
        }

        public void SetElement(string element) {
            this.element = element;
        }
        
        public override string ToString()
        {
            return new StringBuilder().Append("\nGarland " + base.ToString() + "\n\tLength: " + length + "\n\tCount of elements: " + countOfElemets + "\n\tElement: " + element).ToString();//length,countofelem,elem
        }
        
    }
}