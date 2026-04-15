package processor.app.sorters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import processor.app.IWordProcessor;
import processor.app.ProcessFactory;

public class AlphabeticalSorter implements IWordProcessor {
  static {
    ProcessFactory.register("-asc", AlphabeticalSorter::new);
  }

  @Override
  public List<String> process(List<String> words) {
    List<String> sorted = new ArrayList<>(words);
    Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);
    return sorted;
  }
}
