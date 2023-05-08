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
            private T nextObject;  //next object in the iteration
            private boolean nextObjectSet = false; //check if next object has been calculated

            private boolean setNextObject() {
                while (iterator.hasNext()) {
                    final T object = iterator.next();
                    if (predicate.test(object)) {
                        nextObject = object;
                        nextObjectSet = true;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public boolean hasNext() {
                return nextObjectSet || setNextObject();
            }

            @Override
            public T next() {
                if (!nextObjectSet && !setNextObject()) {
                    throw new NoSuchElementException();
                }
                nextObjectSet = false;
                return nextObject;
            }
        });
    }

    public MyIterator<T> reduce(BiFunction<T, T, T> func) {
        return new MyIterator<>(new Iterator<>() {
            private T nextObject;  //next object in the iteration
            private boolean nextObjectSet = false; //check if next object has been calculated

            private boolean setNextObject() {
                if (iterator.hasNext()) {
                    final T object1 = iterator.next();
                    if (iterator.hasNext()) {  //if object1 is not last in collection
                        final T object2 = iterator.next();
                        nextObject = func.apply(object1, object2);
                    }
                    else { //object1 is last in collection
                        nextObject = func.apply(object1, object1);
                    }
                    nextObjectSet = true;
                    return true;
                }

                return false;
            }

            @Override
            public boolean hasNext() {
                return nextObjectSet || setNextObject();
            }

            @Override
            public T next() {
                if (!nextObjectSet && !setNextObject()) {
                    throw new NoSuchElementException();
                }
                nextObjectSet = false;
                return nextObject;
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

