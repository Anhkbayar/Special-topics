public class PostgreSQLRepository implements DataRepository {
  public void save(String data) {
    System.out.println("Saving to Postgre" + data);
  }
}

public class SQLiteRepository implements DataRepository {
  public void save(String data) {
    System.out.println("Saving to local" + data);
  }
}
