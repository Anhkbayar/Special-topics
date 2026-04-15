package processor.app.sorters;

import java.util.List;
import java.util.stream.Collectors;
import processor.app.IWordProcessor;
import processor.app.ProcessFactory;

public class RemoveDuplicate implements IWordProcessor {
  static {
    ProcessFactory.register("-uniq", RemoveDuplicate::new);
  }

  @Override
  public List<String> process(List<String> words) {
    return words.stream().distinct().collect(Collectors.toList());
  }
}
