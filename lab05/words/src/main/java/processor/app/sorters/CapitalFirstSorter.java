package processor.app.sorters;

import java.util.ArrayList;
import java.util.List;
import processor.app.IWordProcessor;
import processor.app.ProcessFactory;

public class CapitalFirstSorter implements IWordProcessor {
  static {
    ProcessFactory.register("-capfirst", CapitalFirstSorter::new);
  }

  @Override
  public List<String> process(List<String> words) {
    List<String> sorted = new ArrayList<>(words);
    sorted.sort(
        (w1, w2) -> {
          boolean w1Cap = Character.isUpperCase(w1.charAt(0));
          boolean w2Cap = Character.isUpperCase(w2.charAt(0));
          if (w1Cap && !w2Cap) return -1;
          if (!w1Cap && w2Cap) return 1;
          return w1.compareToIgnoreCase(w2);
        });
    return sorted;
  }
}
