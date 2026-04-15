package processor.app;

import java.util.ServiceLoader;

public class ProcessFactory {
    public static IWordProcessor getProcessor(String key){
        return ServiceLoader.load(IWordProcessor.class)
        .stream()
        .map(ServiceLoader.Provider::get)
        .filter(p -> p.getKey().equals(key))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown option: " + key));
    }
}
