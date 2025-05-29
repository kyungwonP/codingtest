package com.codingtest.livecoding.subject.wordfiltering;

public class WordFilteringService {

    private final Filtering filtering;

    public WordFilteringService(Filtering filtering) {
        this.filtering = filtering;
    }

    public static void main(String[] args) {
        String[] testCases = {"you are so bad", "I'm not bad", "you are very ugly"};
        FilterPolicy type = FilterPolicy.DEFAULT;

        WordFilteringService wordFilteringService = new WordFilteringService(FilteringFactory.setFilteringType(type));

        for (String testCase : testCases) {
            System.out.println(wordFilteringService.filtering.filter(testCase));
        }
    }
}
