package processor.app.sorters;

import processor.app.IWordProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabeticalSorter implements IWordProcessor{
    @Override
    public List<String> process(List<String> words){
        List<String> sorted = new ArrayList<>(words);
        Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);
        return sorted;
    }
}
