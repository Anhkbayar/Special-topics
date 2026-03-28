package processor.app.sorters;

import processor.app.IWordProcessor;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ReverseAlphabeticalSorter implements IWordProcessor{
    @Override
    public List<String> process(List<String> words){
        List<String> sorted = new ArrayList<>(words);
        sorted.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        return sorted;
    }
}
