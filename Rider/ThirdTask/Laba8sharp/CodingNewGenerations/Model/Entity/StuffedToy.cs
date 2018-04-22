using System.Text;
using Laba8sharp.CodingNewGenerations.Model.Abstracts;

namespace Laba8sharp.CodingNewGenerations.Model.Entity
{
    public class StuffedToy : Toy
    {
        private string person;
        private string gender;//male or female
        private int ageLimit;

        public StuffedToy()
        {
            
        }
        
        public StuffedToy(double price, double weight, double size, string person, string gender, int ageLimit) : base(price, weight, size)
        {
            this.person = person;
            this.gender = gender;
            this.ageLimit = ageLimit;
        }
        
        public string GetPerson() {
            return person;
        }

        public void SetPerson(string person) {
            this.person = person;
        }

        public string GetGender() {
            return gender;
        }

        public void SetGender(string gender) {
            this.gender = gender;
        }

        public int GetAgeLimit() {
            return ageLimit;
        }

        public void SetAgeLimit(int ageLimit) {
            this.ageLimit = ageLimit;
        }

        public override string ToString() {
            return new StringBuilder().Append("\nStuffed Toys " + base.ToString() + "\n\tPerson: " + person + "\n\tGender: " + gender + "\n\tAge limit: " + ageLimit).ToString();
        }
        
    }
}