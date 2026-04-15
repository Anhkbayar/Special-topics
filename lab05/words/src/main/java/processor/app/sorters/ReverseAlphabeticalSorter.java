package processor.app.sorters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import processor.app.IWordProcessor;

public class ReverseAlphabeticalSorter implements IWordProcessor {
  static {
    processor.app.ProcessFactory.register("-reverse", ReverseAlphabeticalSorter::new);
  }

  @Override
  public List<String> process(List<String> words) {
    List<String> sorted = new ArrayList<>(words);
    sorted.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    return sorted;
  }
}
