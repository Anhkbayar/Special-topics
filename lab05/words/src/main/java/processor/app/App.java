package processor.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import processor.app.sorters.AlphabeticalSorter;
import processor.app.sorters.CapitalFirstSorter;
import processor.app.sorters.ReverseAlphabeticalSorter;
import processor.app.sorters.RemoveDuplicate;
/**
 * Parser
 */
public class App {
    public static void main(String[] args) throws IOException{
        if(args.length < 2){
            System.out.println("Usage: <file> <options>");
            System.out.println("Options: -asc -desc -unique -capfirst");
        }

        String filename = args[0];
        String option = args[1];

        List<String> words = Files.readAllLines(Path.of(filename));
        IWordProcessor processor = switch(option){
            case "-asc" -> new AlphabeticalSorter();
            case "-desc" -> new ReverseAlphabeticalSorter();
            case "-unique" -> new RemoveDuplicate();
            case "-capfirst" -> new CapitalFirstSorter();
            default -> throw new IllegalArgumentException("Unknown option: "+ option);
        };

        List<String> result = processor.process(words);

        result.forEach(System.out::println);
        // System.out.println("Hello World!");
    }
}
