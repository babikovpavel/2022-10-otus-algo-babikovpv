package dev.lochness.sorts;

import java.util.Collections;
import java.util.Vector;

public class BucketSort implements Sort {

    @Override
    public void sort(int[] source) {
        if (source.length <= 1)
            return;

        int max = ArrayUtils.max(source);
        int size = source.length;

        Vector<Integer>[] buckets = new Vector[size];

        for (int i = 0; i < size; i++) {
            int bucketIdx = (source[i] * size) / (max + 1);
            if (buckets[bucketIdx] == null) {
                buckets[bucketIdx] = new Vector<>();
            }
            Vector<Integer> bucket = buckets[bucketIdx];
            bucket.add(source[i]);
        }

        int k = 0;
        for (int i = 0; i < size; i++) {
            if (buckets[i] != null) {
                if(buckets[i].size() > 1) {
                    Collections.sort(buckets[i]);
                }
                for (int j = 0; j < buckets[i].size(); j++) {
                    source[k] = buckets[i].get(j);
                    k++;
                }
            }
        }
    }
}
