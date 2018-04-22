using Lab8.cng.Model.Entity.Abstracts;
using Lab8.cng.Model.Entity.Container.JSFContainer;

namespace Lab8.cng.Model.Logic
{
    public class Search
    {
        public static Toy FindToy(IJsfTree tree, SearchParam param, double paramValue)
        {
            foreach (var toy in tree)
            {
                if (param == SearchParam.PRICE)
                {
                    if (paramValue == toy.GetPrice())
                    {
                        return toy;
                    }
                }
                else if (param == SearchParam.SIZE)
                {
                    if (paramValue == toy.GetSize())
                    {
                        return toy;
                    }
                }
                else
                {
                    if (paramValue == toy.GetWeight())
                    {
                        return toy;
                    }
                }
            }

            return null;
        }
    }
}