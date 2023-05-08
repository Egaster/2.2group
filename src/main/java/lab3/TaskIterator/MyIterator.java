package lab3.TaskIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class MyIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator;

    private MyIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public static <T> MyIterator<T> fromIterator(Iterator<T> iterator) {
        return new MyIterator<>(iterator);
    }

    public MyIterator<T> filter(Predicate<T> predicate) {
        return new MyIterator<>(new Iterator<>() {
            private T next;

            @Override
            public boolean hasNext() {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (predicate.test(next)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                if (next == null && !hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = next;
                next = null;
                return result;
            }
        });
    }

    public MyIterator<T> reduce(BiFunction<T, T, T> func) {
        return new MyIterator<>(new Iterator<>() {
            private T next;

            @Override
            public boolean hasNext() {
                if (next == null && iterator.hasNext()) {
                    next = iterator.next();
                }
                return iterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = next;
                next = null;
                if (iterator.hasNext()) {
                    T nextItem = iterator.next();
                    result = func.apply(result, nextItem);
                }
                return result;
            }
        });
    }

    public MyIterator<T> union(MyIterator<T> other) {
        return new MyIterator<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext() || other.iterator.hasNext();
            }

            @Override
            public T next() {
                if (iterator.hasNext()) {
                    return iterator.next();
                } else if (other.iterator.hasNext()) {
                    return other.iterator.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
        });
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        return iterator.next();
    }
}

