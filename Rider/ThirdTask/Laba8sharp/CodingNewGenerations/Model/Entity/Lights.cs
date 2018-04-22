using System.Text;
using Laba8sharp.CodingNewGenerations.Model.Abstracts;

namespace Laba8sharp.CodingNewGenerations.Model.Entity
{
    public class Lights : Toy
    {
        private int lifeTime;
        private int usualTemp;
        private int colorfulTemperature;
        
        public Lights()
        {
        }

        public Lights(double price, double weight, double size, int lifeTime, int usualTemp, int colorfulTemperature) : base(price, weight, size)
        {
            this.lifeTime = lifeTime;
            this.usualTemp = usualTemp;
            this.colorfulTemperature = colorfulTemperature;
        }
        
        public int GetLifeTime() {
            return lifeTime;
        }

        public void SetLifeTime(int lifeTime) {
            this.lifeTime = lifeTime;
        }

        public int GetUsualTemp() {
            return usualTemp;
        }

        public void SetUsualTemp(int usualTemp) {
            this.usualTemp = usualTemp;
        }

        public int GetColorfulTemperature() {
            return colorfulTemperature;
        }

        public void SetColorfulTemperature(int colorfulTemperature) {
            this.colorfulTemperature = colorfulTemperature;
        }

        public override string ToString()
        {
            return new StringBuilder().Append("\nLights "+ base.ToString() +
                                              "\n\tLife time: " + lifeTime +
                                              "\n\tUsual temp: " + usualTemp +
                                              "\n\tColorful temperature: " + colorfulTemperature).ToString();
        }
        
    }
}