package processor.app;

import java.util.List;

public interface IWordProcessor {
    String getKey();
    List<String> process(List<String> words);
}


