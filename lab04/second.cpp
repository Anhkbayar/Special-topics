void processTransaction(BankAccount acct, int){
    Person *who;
    Money amt;

    amt.setValue(123.45);
    acct.setBalance(amt);
    who = acct.getOwner();
    markWorkflow(who->name(), SET_BALANCE);
}