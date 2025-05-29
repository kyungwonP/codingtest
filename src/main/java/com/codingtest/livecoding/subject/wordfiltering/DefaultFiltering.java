package com.codingtest.livecoding.subject.wordfiltering;

public class DefaultFiltering extends AbstractFilteringWord implements Filtering {
    @Override
    public String filter(String line) {
        for (String filterTarget : FILTER_TARGETS) {
            if (line.contains(filterTarget)) {
                line = line.replace(filterTarget, "*".repeat(filterTarget.length()));
            }
        }

        return line;
    }
}
