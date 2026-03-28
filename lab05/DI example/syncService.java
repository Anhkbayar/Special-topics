class syncService{
    //Muu jishee
    private PostgreSQLDatabase db =  new PostgreSQLDatabase();

    public void syncData(String data){
        db.save(data);
    }
}