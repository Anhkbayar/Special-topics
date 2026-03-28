package processor.app.sorters;

import java.util.List;
import java.util.stream.Collectors;

import processor.app.IWordProcessor;

public class RemoveDuplicate implements IWordProcessor{
    @Override
    public List<String> process(List<String> words){
        return words.stream().distinct().collect(Collectors.toList());
    }
}
