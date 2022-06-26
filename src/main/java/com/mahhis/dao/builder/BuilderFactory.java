package com.mahhis.dao.builder;

public class BuilderFactory {

    private static final UserBuilder userBuild = new UserBuilder();
    private static final CardBuilder cardBuilder = new CardBuilder();
    private static final TransactionBuilder transactionBuilder = new TransactionBuilder();
    private static final OrderBuilder orderBuilder = new OrderBuilder();

    public static UserBuilder getUserBuild(){
        return userBuild;
    }
    public static OrderBuilder getOrderBuilder(){
        return orderBuilder;
    }
    public static CardBuilder getCardBuilder(){return  cardBuilder;}
    public static TransactionBuilder getTransactionBuilder(){return transactionBuilder;}

}
