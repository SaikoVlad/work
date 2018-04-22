using System.Text;
using Laba8sharp.CodingNewGenerations.Model.Abstracts;

namespace Laba8sharp.CodingNewGenerations.Model.Entity.Container
{
    public class Tree
    {
        private Toy[] toysMass;

        public Tree()
        {
        }

        public Tree(Toy[] toysMass)
        {
            this.toysMass = toysMass;
        }

        public void ChangeToy(Toy newToy, int index){
            toysMass[index] = newToy;
        }
        
        public Toy[] GetToysMass()
        {
            return toysMass;
        }

        public int GetSize()
        {
            return toysMass.Length;
        }

        public Toy GetToy(int index)
        {
            return toysMass[index];
        }

        public void SetToy(Toy newToy, int index)
        {
            
            Toy[] temp = new Toy[toysMass.Length + 1];
            for (int i = 0; i < toysMass.Length; i++)
            {
                if (i < index)
                {
                    temp[i] = toysMass[i];
                }
                else
                {
                    temp[i + 1] = toysMass[i];
                }
            }
            temp[index] = newToy;
            toysMass = temp;
        }

        public double GetPrice(int index)
        {
            return toysMass[index].GetPrice();
        }

        public void Add(Toy newToy)
        {
            int index = toysMass.Length;
            Toy[] temp = new Toy[toysMass.Length + 1];
            for (int i = 0; i < toysMass.Length; i++)
            {
                if (i < index)
                {
                    temp[i] = toysMass[i];
                }
                else
                {
                    temp[i + 1] = toysMass[i];
                }
            }
            temp[index] = newToy;
            toysMass = temp;
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            foreach (Toy toysMas in this.toysMass)
            {
                sb.Append(toysMas.ToString()).Append("\n");
            }
            return sb.ToString();
        }
    }
}