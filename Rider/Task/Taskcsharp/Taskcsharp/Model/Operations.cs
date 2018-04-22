namespace Taskcsharp.Model
{
    public class Operations
    {
        public static double CalcSumOfNegativeElements(Initializer vector) {
            double sum = 0;

            for (int i = 0; i < vector.size(); i++) {
                if (vector.getElement(i) < 0) {
                    sum += vector.getElement(i);
                }
            }

            return sum;
        }

        private static int GetMaxIndex(Initializer vector){
            int index = 0;
        
            for (int i = 1; i < vector.size(); i++) {
                if (vector.getElement(i) > vector.getElement(index)) {
                    index = i;
                }
            }
        
            return index;
        }
    
    
        private static int GetMinIndex(Initializer vector){
            int index = 0;
        
            for (int i = 1; i < vector.size(); i++) {
                if (vector.getElement(i) < vector.getElement(index)) {
                    index = i;
                }
            }
        
            return index;
        }
    
        public static double CalcMultiplicationElementsBetweenMaxAndMin(Initializer vector) {
            double mult = 1;
        
            int indexMax = GetMaxIndex(vector);
            int indexMin = GetMinIndex(vector);
        
            if (indexMax < indexMin){
                int t = indexMax;
                indexMax = indexMin;
                indexMin = t;
            }
        
            for (int i = indexMin + 1; i < indexMax; i++) {
                mult *= vector.getElement(i);
            }
        
            return mult;
        }
    }
}