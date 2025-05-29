package com.codingtest.livecoding.subject.wordfiltering;

public class RemoveFiltering extends AbstractFilteringWord implements Filtering {
    @Override
    public String filter(String line) {
        for (String filterTarget : FILTER_TARGETS) {
            if (line.contains(filterTarget)) {
                line = line.replace(filterTarget, "");
            }
        }

        return line;
    }
}
