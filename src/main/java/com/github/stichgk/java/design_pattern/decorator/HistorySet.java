package com.github.stichgk.java.design_pattern.decorator;

import java.util.*;

public class HistorySet<T> implements Set<T> {

    private HashSet<T> delagate;
    private ArrayList<T> removedSet = new ArrayList<>();

    public HistorySet(HashSet<T> delagate) {
        this.delagate = delagate;
    }

    @Override
    public int size() {
        return delagate.size();
    }

    @Override
    public boolean isEmpty() {
        return delagate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delagate.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return delagate.iterator();
    }

    @Override
    public Object[] toArray() {
        return delagate.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return delagate.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return delagate.add(t);
    }

    @Override
    public boolean remove(Object o) {
        if (delagate.contains(o)) {
            removedSet.add((T) o);
            return delagate.remove(o);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return delagate.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return delagate.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return delagate.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;

        if (size() > c.size()) {
            for (Iterator<?> i = c.iterator(); i.hasNext(); ) {
                Object removedElement = i.next();
                if (contains(removedElement)) {
                    removedSet.add((T) removedElement);
                }
                modified |= remove(removedElement);
            }
        } else {
            for (Iterator<?> i = iterator(); i.hasNext(); ) {
                Object removedElement = i.next();
                if (c.contains(removedElement)) {
                    i.remove();
                    modified = true;
                    removedSet.add((T) removedElement);
                }
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        removedSet.addAll(delagate);
        delagate.clear();
    }

    @Override
    public String toString() {
        return "HistorySet{" +
                "currentSet=" + delagate +
                ", removedSet=" + removedSet +
                '}';
    }
}
