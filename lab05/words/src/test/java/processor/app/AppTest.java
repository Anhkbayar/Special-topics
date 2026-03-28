package processor.app;

import processor.app.sorters.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AppTest {

  @Test
  void testAlphabeticalSort() {
    List<String> words = Arrays.asList("banana", "Apple", "orange");
    AlphabeticalSorter sort = new AlphabeticalSorter();
    List<String> result = sort.process(words);
    assertEquals("Apple", result.get(0));
    assertEquals("banana", result.get(1));
    assertEquals("orange", result.get(2));
  }

  @Test
  void testCapitalSort(){
    List<String> words = Arrays.asList("apple", "bold", "Ankle");
    CapitalFirstSorter sort = new CapitalFirstSorter();
    List<String> result = sort.process(words);
    assertEquals("Ankle", result.get(0));
    assertEquals("apple", result.get(1));
    assertEquals("bold", result.get(2));
  }

  @Test
  void ReverseAlphabeticalSorter(){
    List<String> words = Arrays.asList("array", "high", "zebra");
    ReverseAlphabeticalSorter sort = new ReverseAlphabeticalSorter();
    List<String> result = sort.process(words);
    assertEquals("zebra", result.get(0));
    assertEquals("high", result.get(1));
    assertEquals("array", result.get(2));
  }

  @Test
  void testRemoveDuplicates() {
    List<String> words = Arrays.asList("apple", "apple", "banana");
    RemoveDuplicate processor = new RemoveDuplicate();
    List<String> result = processor.process(words);
    assertEquals(2, result.size());
  }
}
