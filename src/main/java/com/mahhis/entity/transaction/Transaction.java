package com.mahhis.entity.transaction;

import java.util.Map;

public class Transaction {

    private int idTransaction;

    private long cardNumberSender;
    private String cardValidityDate;
    private short CVV;
    private double sum;
    private String bankNameSender;
    private String senderCountry;

    private long cardNumberGetter;
    private String bankNameGetter;
    private String getterCountry;
    public Map<Long, Double> listSender;

    public Transaction() {}

    public Transaction(long cardNumberSender, String cardValidityDate, String senderCountry, short CVV, double sum, String bankNameSender, long cardNumberGetter, String bankNameGetter, String getterCountry) {
        this.cardNumberSender = cardNumberSender;
        this.cardValidityDate = cardValidityDate;
        this.senderCountry = senderCountry;
        this.CVV = CVV;
        this.sum = sum;
        this.bankNameSender = bankNameSender;
        this.cardNumberGetter = cardNumberGetter;
        this.bankNameGetter = bankNameGetter;
        this.getterCountry = getterCountry;
    }


    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public long getCardNumberSender() {
        return cardNumberSender;
    }

    public void setCardNumberSender(long cardNumberSender) {
        this.cardNumberSender = cardNumberSender;
    }

    public String getCardValidityDate() {
        return cardValidityDate;
    }

    public void setCardValidityDate(String cardValidityDate) {
        this.cardValidityDate = cardValidityDate;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public short getCVV() {
        return CVV;
    }

    public void setCVV(short CVV) {
        this.CVV = CVV;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getBankNameSender() {
        return bankNameSender;
    }

    public void setBankNameSender(String bankNameSender) {
        this.bankNameSender = bankNameSender;
    }

    public long getCardNumberGetter() {
        return cardNumberGetter;
    }

    public void setCardNumberGetter(long cardNumberGetter) {
        this.cardNumberGetter = cardNumberGetter;
    }

    public String getBankNameGetter() {
        return bankNameGetter;
    }

    public void setBankNameGetter(String bankNameGetter) {
        this.bankNameGetter = bankNameGetter;
    }

    public String getGetterCountry() {
        return getterCountry;
    }

    public void setGetterCountry(String getterCountry) {
        this.getterCountry = getterCountry;
    }
}
