package processor.app;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProcessFactory {
    private static final  Map<String, Supplier<IWordProcessor>> registry = new HashMap<>();

    public static void register(String key, Supplier<IWordProcessor> supplier) {
        registry.put(key, supplier);
        System.out.print("registering "+ key);
    }

    public static IWordProcessor getProcessor(String key){
        Supplier<IWordProcessor> supplier = registry.get(key);
        if(supplier == null){
            throw new IllegalArgumentException("Unknown option: "+ key);
        }

        return supplier.get();
    }
}
