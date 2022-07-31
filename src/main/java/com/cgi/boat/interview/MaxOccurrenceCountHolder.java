package com.cgi.boat.interview;

class MaxOccurrenceCountHolder {

    private int[] maxOccurrenceCounts;

    MaxOccurrenceCountHolder(int capacity) {
        this.maxOccurrenceCounts = new int[capacity];
    }

    void compareAndSet(int occurrenceCount) {
        if (occurrenceCount > maxOccurrenceCounts[0]) {
            int indexToRewrite = 0;
            for (; indexToRewrite < maxOccurrenceCounts.length; indexToRewrite++) {
                if (occurrenceCount <= maxOccurrenceCounts[indexToRewrite]) {
                    if (occurrenceCount == maxOccurrenceCounts[indexToRewrite]) {
                        return;
                    }
                    break;
                }
            }
            indexToRewrite--;
            if (indexToRewrite >= 0)
                System.arraycopy(maxOccurrenceCounts, 1, maxOccurrenceCounts, 0, indexToRewrite);
            maxOccurrenceCounts[indexToRewrite] = occurrenceCount;
        }
    }

    boolean isIsMaxOccuranceCount(int occurrenceCount) {
        return occurrenceCount >= maxOccurrenceCounts[0];
    }

}
