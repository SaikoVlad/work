namespace Taskcsharp.Model
{
    public class Initializer
    {
        private double[] vector;

        public Initializer(double [] vector) {
            this.vector = vector;
        }

    
        public int size(){
            return vector.Length;
        }

        public double getElement(int index)
        {
            if (index >= 0 && index < vector.Length)
            {
                return vector[index];
            }
            else
            {
                return 0.0;
            }
        }
    
        
        
        
        public override string ToString() {
            string outer = "";
            for (int i = 0; i < vector.Length; i++) {
                outer += (vector[i] + "\t");
            }

            return  outer;
        }
    }
}