using System.Text;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Entity
{
    public class StuffedToys : Toy
    {
        private string _person;
        private string _gender;
        private int _ageLimit;

        public StuffedToys() {
        }

        public StuffedToys(double price, double weight, double size, string person, string gender, int ageLimit) : base(price, weight, size){

            
            this._person = person;
            this._gender = gender;
            this._ageLimit = ageLimit;
        }

        public string GetPerson() {
            return _person;
        }

        public void SetPerson(string person) {
            this._person = person;
        }

        public string GetGender() {
            return _gender;
        }

        public void SetGender(string gender) {
            this._gender = gender;
        }

        public int GetAgeLimit() {
            return _ageLimit;
        }

        public void SetAgeLimit(int ageLimit) {
            this._ageLimit = ageLimit;
        }

        
        public override string ToString() {
            return new StringBuilder().Append("\nStuffed Toys " + base.ToString() + "\n\tPerson: " + _person + "\n\tGender: " + _gender + "\n\tAge limit: " + _ageLimit).ToString();
        }
    }
}