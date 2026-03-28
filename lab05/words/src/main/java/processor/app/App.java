package processor.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import processor.app.sorters.AlphabeticalSorter;
import processor.app.sorters.CapitalFirstSorter;
import processor.app.sorters.RemoveDuplicate;
import processor.app.sorters.ReverseAlphabeticalSorter;

/** Parser */
public class App {
  public static void main(String[] args) throws IOException {
    if (args.length < 1) {
      System.out.println("Usage: <options>");
      System.out.println("Options: -asc -desc -unique -capfirst");
    }

    String option = args[0];

    List<String> words;
    try (InputStream in = App.class.getResourceAsStream("/words.txt")) {
      if (in == null) throw new IOException("words.txt not found");
      words = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.toList());
    }

    IWordProcessor processor =
        switch (option) {
          case "-asc" -> new AlphabeticalSorter();
          case "-desc" -> new ReverseAlphabeticalSorter();
          case "-unique" -> new RemoveDuplicate();
          case "-capfirst" -> new CapitalFirstSorter();
          default -> throw new IllegalArgumentException("Unknown option: " + option);
        };

    List<String> result = processor.process(words);

    result.forEach(System.out::println);
    // System.out.println("Hello World!");
  }
}
