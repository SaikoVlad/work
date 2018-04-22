using System;
using System.Text;
using ReadyToExam.NewYearGift.Model.Abstracts;

namespace ReadyToExam.NewYearGift.Model.Entity.Container
{
    public class Gift
    {
        private Candy[] _candiesMass;

        public Gift()
        {
            
        }

        public Gift(Candy newCandy)
        {
            _candiesMass = new Candy[1];
            _candiesMass[0] = newCandy;
        }
        
        public Gift(Candy[] candiesMas)
        {
            _candiesMass = candiesMas;
        }
        
        public int GetSize(){
            return _candiesMass.Length;
        }

        public Candy GetCandy(int index){
            return _candiesMass[index];
        }

        public void ChangeCandy(Candy newCandy, int index){
            _candiesMass[index] = newCandy;
        }

        public void SetCandy(Candy newCandy, int index){
            Candy[] temp = new Candy[_candiesMass.Length + 1];
            for (int i = 0; i < _candiesMass.Length; i++) {
                if (i < index) {
                    temp[i] = _candiesMass[i];
                } else {
                    temp[i + 1] = _candiesMass[i];
                }
            }
            temp[index] = newCandy;
            _candiesMass = temp;
        }

        public void Add(Candy newCandy) {
            try{
                int index = _candiesMass.Length;
                Candy[] temp = new Candy[_candiesMass.Length + 1];
                for (int i = 0; i < _candiesMass.Length; i++) {
                    if (i < index) {
                        temp[i] = _candiesMass[i];
                    } else {
                        temp[i + 1] = _candiesMass[i];
                    }
                }
                temp[index] = newCandy;
                _candiesMass = temp;
            } catch (NullReferenceException){
                _candiesMass = new Candy[1];
                _candiesMass[0] = newCandy;
            }
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            foreach (Candy candy in _candiesMass)
            {
                sb.Append(candy + "\n\n");
            }
            return sb.ToString();
        }
    }
}