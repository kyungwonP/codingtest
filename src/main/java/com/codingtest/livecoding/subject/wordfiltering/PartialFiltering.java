package com.codingtest.livecoding.subject.wordfiltering;

public class PartialFiltering extends AbstractFilteringWord implements Filtering {
    @Override
    public String filter(String line) {
        for (String filterTarget : FILTER_TARGETS) {
            if (line.contains(filterTarget)) {
                line = line.replace(filterTarget, filterTarget.charAt(0) + "*".repeat(filterTarget.length() - 1));
            }
        }

        return line;
    }
}
