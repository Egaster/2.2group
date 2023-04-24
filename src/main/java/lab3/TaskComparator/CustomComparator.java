package lab3.TaskComparator;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@FunctionalInterface
public interface CustomComparator<T> extends Comparator<T> {

    int compare(T o1, T o2);

    // Метод для создания экземпляра CustomComparator на основе функции извлечения ключа
    static <T, U extends Comparable<? super U>> CustomComparator<T> comparing(
            Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (o1, o2) -> keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
    }

    default CustomComparator<T> reversed() {
        return (o1, o2) -> compare(o2, o1);
    }

    default <U extends Comparable<? super U>> CustomComparator<T> thenComparing(
            Function<? super T, ? extends U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (o1, o2) -> {
            int cmp = compare(o1, o2);
            if (cmp != 0) {
                return cmp;
            } else {
                U u1 = keyExtractor.apply(o1);
                U u2 = keyExtractor.apply(o2);
                return u1.compareTo(u2);
            }
        };
    }

    default <U> CustomComparator<T> thenComparing(
            Function<T, U> keyExtractor, CustomComparator<U> cmp) {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(cmp);
        return (o1, o2) -> {
            int cmp1 = compare(o1, o2);
            if (cmp1 != 0) {
                return cmp1;
            } else {
                U u1 = keyExtractor.apply(o1);
                U u2 = keyExtractor.apply(o2);
                return cmp.compare(u1, u2);
            }
        };
    }

    default CustomComparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (o1, o2) -> {
            int cmp = compare(o1, o2);
            if (cmp != 0) {
                return cmp;
            } else {
                int u1 = keyExtractor.applyAsInt(o1);
                int u2 = keyExtractor.applyAsInt(o2);
                return Integer.compare(u1, u2);
            }
        };
    }

    default CustomComparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (o1, o2) -> {
            int cmp = compare(o1, o2);
            if (cmp != 0) {
                return cmp;
            } else {
                long u1 = keyExtractor.applyAsLong(o1);
                long u2 = keyExtractor.applyAsLong(o2);
                return Long.compare(u1, u2);
            }
        };
    }

    default CustomComparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (o1, o2) -> {
            int cmp = compare(o1, o2);
            if (cmp != 0) {
                return cmp;
            } else {
                double u1 = keyExtractor.applyAsDouble(o1);
                double u2 = keyExtractor.applyAsDouble(o2);
                return Double.compare(u1, u2);
            }
        };
    }

    static <T extends Comparable<? super T>> CustomComparator<T> naturalOrder() {
        return (o1, o2) -> o1.compareTo(o2);
    }

    static <T extends Comparable<? super T>> CustomComparator<T> reverseOrder() {
        return (o1, o2) -> o2.compareTo(o1);
    }
}
