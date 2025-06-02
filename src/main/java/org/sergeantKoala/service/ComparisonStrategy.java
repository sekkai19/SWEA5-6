package org.sergeantKoala.service;

public interface ComparisonStrategy<T> {
    T extractComparable(String url);

    boolean isSame(T lastValue, T currentValue);

}
