namespace Lab8.cng.Model.Collections.neww
{
    public class Link<T>
    {
        private T _element;
        private Link<T> _nextNode, _prevNode;

        public Link(T value, Link<T> prev, Link<T> next) {
            _element = value;
            _nextNode = next;
            _prevNode = prev;
        }

        public T Element
        {
            get => _element;
            set => _element = value;
        }

        public Link<T> NextNode
        {
            get => _nextNode;
            set => _nextNode = value;
        }

        public Link<T> PrevNode
        {
            get => _prevNode;
            set => _prevNode = value;
        }
    }
}