package com.mahhis.entity.order;

import com.mahhis.entity.user.User;

public class Order {

    private int idOrder;
    private User user;
    private boolean complete;

    private long cardNumberGetter;
    private double sumToComplete;
    private String getterCountry;
    private String bankNameGetter;



    public Order() {}

    public Order(User user, boolean complete, long cardNumberGetter, double sumToComplete, String bankNameGetter, String getterCountry) {
        this.user = user;
        this.complete=complete;
        this.cardNumberGetter = cardNumberGetter;
        this.sumToComplete = sumToComplete;
        this.bankNameGetter = bankNameGetter;
        this.getterCountry = getterCountry;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCardNumberGetter() {
        return cardNumberGetter;
    }

    public void setCardNumberGetter(long cardNumberGetter) {
        this.cardNumberGetter = cardNumberGetter;
    }

    public double getSumToComplete() {
        return sumToComplete;
    }

    public void setSumToComplete(double sumToComplete) {
        this.sumToComplete = sumToComplete;
    }

    public String getGetterCountry() {
        return getterCountry;
    }

    public void setGetterCountry(String getterCountry) {
        this.getterCountry = getterCountry;
    }

    public String getBankNameGetter() {
        return bankNameGetter;
    }

    public void setBankNameGetter(String bankNameGetter) {
        this.bankNameGetter = bankNameGetter;
    }
}
