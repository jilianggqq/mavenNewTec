package edu.gqq.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class RetainBestCache_linkedin<K, T extends Rankable> {

	private Map<K, T> cache;
	private TreeMap<Long, Set<K>> rankingOfObject;
	private DataSource<K, T> dataSource;
	private int maxSizeOfCache;

	/* Constructor with a data source (assumed to be slow) and a cache size */
	public RetainBestCache_linkedin(DataSource<K, T> ds, int entriesToRetain) {
		// Implementation here
		cache = new HashMap<>();
		rankingOfObject = new TreeMap<>();
		dataSource = ds;
		maxSizeOfCache = entriesToRetain;
	}

	/*
	 * Gets some data. If possible, retrieves it from cache to be fast. If the
	 * data is not cached, retrieves it from the data source. If the cache is
	 * full, attempt to cache the returned data, evicting the T with lowest rank
	 * among the ones that it has available. more info on 1point3acres.com If
	 * there is a tie, the cache may choose any T with lowest rank to evict.
	 */
	public T get(K key) {
		// Implementation here.
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		return fetchDataFromDs(key);
	}

	private T fetchDataFromDs(K key) {
		if (cache.size() >= maxSizeOfCache) {
			evictElement();
		}
		T object = dataSource.get(key);
		cache.put(key, object);
		long rankOfObject = object.getRank();
		if (!rankingOfObject.containsKey(rankOfObject)) {
			rankingOfObject.put(rankOfObject, new HashSet<>());
		}
		rankingOfObject.get(rankOfObject).add(key);
		return object;
	}

	private void evictElement() {
		// Entry<Long, Set<K>> entry = rankingOfObject.topEntry();
		Entry<Long, Set<K>> entry = rankingOfObject.firstEntry();
		K key = entry.getValue().iterator().next();
		entry.getValue().remove(key);
		cache.remove(key);
		if (entry.getValue().size() == 0) {
			rankingOfObject.remove(entry.getKey());
		}
	}
}

// What if rank is defined as number of reads of element in cache?
// LRU
// Let's assume that rank can change dynamicly. It is not immutable, but it is
// not LRU. We do not know how it is changed

/*
 * . From 1point 3acres bbs For reference, here are the Rankable and DataSource
 * interfaces. You do not need to implement them, and should not make
 * assumptions about their implementations.
 */

interface Rankable {
	/**
	 * Returns the Rank of this object, using some algorithm and potentially the
	 * internal state of the Rankable.
	 */
	long getRank();
}

interface DataSource<K, T extends Rankable> {
	T get(K key);
}