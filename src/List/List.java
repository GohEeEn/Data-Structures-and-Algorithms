package List;

import Common.Position;

public interface List<T> extends Iterable<T>{
    int size();
    boolean isEmpty();
    Position<T> first();
    Position<T> last();
    Position<T> prev(Position<T> p);
    Position<T> next(Position<T> p);
    Position<T> insertFirst(T e);
    Position<T> insertLast(T e);
    Position<T> insertBefore(Position<T> p, T e);
    Position<T> insertAfter(Position<T> p, T e);
    T replace(Position<T> p, T e);
    T remove(Position<T> p);
}
