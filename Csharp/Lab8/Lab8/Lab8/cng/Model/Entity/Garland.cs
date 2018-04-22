using System;
using System.Text;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Entity
{
    public class Garland : Toy
    {
        private double _length;
        private int _countOfElemets;
        private string _element;

        public Garland() {
        }

        public Garland(double price, double weight, double size, double length, int countOfElemets, string element) : base(price, weight, size) {
            this._length = length;
            this._countOfElemets = countOfElemets;
            this._element = element;
        }

        public double GetLength() {
            return _length;
        }

        public void SetLength(double length) {
            this._length = length;
        }

        public int GetCountOfElemets() {
            return _countOfElemets;
        }

        public void SetCountOfElemets(int countOfElemets) {
            this._countOfElemets = countOfElemets;
        }

        public String GetElement() {
            return _element;
        }

        public void SetElement(String element) {
            this._element = element;
        }

        
        public override string ToString() {
            return new StringBuilder().Append("\nGarland " + base.ToString() + "\n\tLength: " + _length + "\n\tCount of elements: " + _countOfElemets + "\n\tElement: " + _element).ToString();//length,countofelem,elem
        }
    }
}