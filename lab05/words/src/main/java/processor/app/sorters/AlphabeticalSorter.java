package processor.app.sorters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import processor.app.IWordProcessor;

public class AlphabeticalSorter implements IWordProcessor {
  @Override
  public String getKey() {
    return "-asc";
  }

  @Override
  public List<String> process(List<String> words) {
    List<String> sorted = new ArrayList<>(words);
    Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);
    return sorted;
  }
}
