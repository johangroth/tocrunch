package uk.org.linuxgrotto.tocrunch.connect;

import org.springframework.util.MultiValueMap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jgroth on 26/05/16.
 */
class EmptyMultiValueMap<K, V> implements MultiValueMap<K, V> {
    private static final MultiValueMap<Object, Object> INSTANCE = new EmptyMultiValueMap<>();

    @SuppressWarnings("unchecked")
    public static <K, V> MultiValueMap<K, V> instance() {
        return (MultiValueMap<K, V>) INSTANCE;
    }

    private EmptyMultiValueMap() {
    }

    private final Map<K, List<V>> targetMap = Collections.emptyMap();

    public void add(K key, V value) {
        throw new UnsupportedOperationException("This empty MultiValueMap is not modifiable");
    }

    public V getFirst(K key) {
        return null;
    }

    public void set(K key, V value) {
        throw new UnsupportedOperationException("This empty MultiValueMap is not modifiable");
    }

    public void setAll(Map<K, V> values) {
        throw new UnsupportedOperationException("This empty MultiValueMap is not modifiable");
    }

    public Map<K, V> toSingleValueMap() {
        return Collections.emptyMap();
    }

    // Map implementation

    public int size() {
        return this.targetMap.size();
    }

    public boolean isEmpty() {
        return this.targetMap.isEmpty();
    }

    public boolean containsKey(Object key) {
        return this.targetMap.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.targetMap.containsValue(value);
    }

    public List<V> get(Object key) {
        return this.targetMap.get(key);
    }

    public List<V> put(K key, List<V> value) {
        return this.targetMap.put(key, value);
    }

    public List<V> remove(Object key) {
        return this.targetMap.remove(key);
    }

    public void putAll(Map<? extends K, ? extends List<V>> m) {
        this.targetMap.putAll(m);
    }

    public void clear() {
        this.targetMap.clear();
    }

    public Set<K> keySet() {
        return this.targetMap.keySet();
    }

    public Collection<List<V>> values() {
        return this.targetMap.values();
    }

    public Set<Entry<K, List<V>>> entrySet() {
        return this.targetMap.entrySet();
    }


    @Override
    public boolean equals(Object obj) {
        return this.targetMap.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.targetMap.hashCode();
    }

    @Override
    public String toString() {
        return this.targetMap.toString();
    }


}
