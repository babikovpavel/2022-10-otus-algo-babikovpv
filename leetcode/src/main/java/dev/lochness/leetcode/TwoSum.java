package dev.lochness.leetcode;

// https://leetcode.com/problems/two-sum/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        IntHashTable values = new IntHashTable(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int x1 = nums[i];
            int x2 = target - x1;
            Integer index = values.get(x2);
            if(index != null && index != i) {
                return new int[]{i, index};
            }
            values.put(nums[i], i);
        }
        return new int[0];
    }

    static class IntHashTable {

        private final Bag[] values;

        public IntHashTable(int capacity) {
            values = new Bag[capacity];
        }

        public void put(Integer key, Integer value) {
            put(key, value, values);
        }

        public Integer get(Integer key) {
            int i = Math.abs(key.hashCode() % values.length);
            Bag bag = values[i];
            while (bag != null) {
                if (bag.key.equals(key)) {
                    return bag.value;
                }
                bag = bag.nextElem;
            }
            return null;
        }

        public void put(Integer key, Integer value, Bag[] array) {
            int i = Math.abs(key.hashCode() % array.length);
            Bag bag = array[i];
            if (bag == null) {
                array[i] = new Bag(key, value);
            } else {
                boolean exists;
                do {
                    exists = bag.key.equals(key);
                    if (exists) {
                        bag.value = value;
                        return;
                    }
                    bag = bag.nextElem;
                } while (bag != null);
                Bag newBag = new Bag(key, value);
                newBag.nextElem = array[i];
                array[i] = newBag;
            }
        }

        static class Bag {
            private final Integer key;
            private Integer value;
            private Bag nextElem;

            Bag(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
