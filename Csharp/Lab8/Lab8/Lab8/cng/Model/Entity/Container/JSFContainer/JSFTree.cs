using System.Collections.Generic;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Entity.Container.JSFContainer
{
    public interface IJsfTree : IEnumerable<Toy>
    {
        int GetSizeOfTree();
        void Remove(int index);
        void ChangeToy(Toy toy, int index);
        void Add(Toy toy);
        Toy[] GetMasOfObjects();
        Toy GetToy(int index);
    }
}