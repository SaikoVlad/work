using System;

namespace Lab8.cng.Model.Collections.deprecated
{
    public interface ICustomCollections<TParam>
    {
        bool Add(TParam param);
        TParam Get(int index);
        int Size();
        bool IsEmpty();
        Object[] CollectionToArray();
        void SetElement(int index, TParam param);

    }
}