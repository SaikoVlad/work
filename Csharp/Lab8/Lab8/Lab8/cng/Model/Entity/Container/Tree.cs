using System;
using System.Text;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Entity.Container
{
    public class Tree
    {
        private Toy[] _toysMass;
        private static Tree _tree = null;

        public static Tree GetInstanceOfTree(ToyType toySType)
        {
            if (null == _tree)
            {
                _tree = new Tree();
                if (toySType==ToyType.Garland)
                {
                    _tree.Add(new Garland());
                }
                else if (toySType==ToyType.Lights)
                {
                    _tree.Add(new Lights());
                }
                else if (toySType==ToyType.Stuffedtoys)
                {
                    _tree.Add(new StuffedToys());
                }
            }

            return _tree;
        }

        private Tree()
        {
        }

        private Tree(Toy []toys)
        {
            //mass
            this._toysMass = toys;
        }


        public Toy[] GetToysMass()
        {
            return _toysMass;
        }

        public int GetSize()
        {
            return _toysMass.Length;
        }

        public Toy GetToy(int index)
        {
            return _toysMass[index];
        }

//priceTree
        public void ChangeToy(Toy newToy, int index)
        {
            _toysMass[index] = newToy;
        }

        public void SetToy(Toy newToy, int index)
        {
            Toy[] temp = new Toy[_toysMass.Length + 1];
            for (int i = 0; i < _toysMass.Length; i++)
            {
                if (i < index)
                {
                    temp[i] = _toysMass[i];
                }
                else
                {
                    temp[i + 1] = _toysMass[i];
                }
            }

            temp[index] = newToy;
            _toysMass = temp;
        }

        public double GetPrice(int index)
        {
            return _toysMass[index].GetPrice();
        }

        public void Add(Toy newToy)
        {
            try
            {
                int index = _toysMass.Length;
                Toy[] temp = new Toy[_toysMass.Length + 1];
                for (int i = 0; i < _toysMass.Length; i++)
                {
                    if (i < index)
                    {
                        temp[i] = _toysMass[i];
                    }
                    else
                    {
                        temp[i + 1] = _toysMass[i];
                    }
                }

                temp[index] = newToy;
                _toysMass = temp;
            }
            catch (Exception)
            {
                _toysMass = new Toy[1];
                _toysMass[0] = newToy;
            }
        }

        

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            foreach (Toy toy in _toysMass) {
                sb.Append(toy).Append("\n");
            }
            return sb.ToString();
        }
    }

    public enum ToyType
    {
         Garland, Lights, Stuffedtoys   
    }
    
}