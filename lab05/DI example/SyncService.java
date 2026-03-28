public class SyncService{
    private final DataRepository repository;

    public SyncService(DataRepository repository){
        this.repository = repository;
    }

    public void process(String data){
        repository.save(data);
    }
}