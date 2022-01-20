package com.epam.mahhis.dao.builder;

public class BuilderFactory {

    private static final UserBuilder userBuild = new UserBuilder();
    private static final AccountBuilder accountBuilder = new AccountBuilder();
    private static final TransactionBuilder transactionBuilder = new TransactionBuilder();

    public static UserBuilder getUserBuild(){
        return userBuild;
    }
    public static AccountBuilder getAccountBuilder(){return  accountBuilder;}
    public static TransactionBuilder getTransactionBuilder(){return transactionBuilder;}

}
