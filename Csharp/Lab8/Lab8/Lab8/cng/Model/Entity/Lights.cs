using System.Text;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Entity
{
    public class Lights : Toy
    {
        private int _lifeTime;
        private int _usualTemp;
        private int _colorfulTemperature;

        public Lights() {

        }

        public Lights(double price, double weight, double size, int lifeTime, int usualTemp, int colorfulTemperature) : base(price, weight, size){
            
            this._lifeTime = lifeTime;
            this._usualTemp = usualTemp;
            this._colorfulTemperature = colorfulTemperature;
        }



        public int GetLifeTime() {
            return _lifeTime;
        }

        public void SetLifeTime(int lifeTime) {
            this._lifeTime = lifeTime;
        }

        public int GetUsualTemp() {
            return _usualTemp;
        }

        public void SetUsualTemp(int usualTemp) {
            this._usualTemp = usualTemp;
        }

        public int GetColorfulTemperature() {
            return _colorfulTemperature;
        }

        public void SetColorfulTemperature(int colorfulTemperature) {
            this._colorfulTemperature = colorfulTemperature;
        }

        
        public override string ToString() {
            return new StringBuilder().Append("\nLights "+ base.ToString() +
                                              "\n\tLife time: " + _lifeTime +
                                              "\n\tUsual temp: " + _usualTemp +
                                              "\n\tColorful temperature: " + _colorfulTemperature).ToString();
        }
    }
}