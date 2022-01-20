package com.epam.mahhis.entity.transaction;

import java.util.Date;

public class Transaction {

    int idTransaction;
    Date time;
    double transactionAmount;
    String comment;
    String typePaymentSystem;
    double commissionPercentage;
    int targetIdBankAccount;
    int senderIdBankAccount;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTypePaymentSystem() {
        return typePaymentSystem;
    }

    public void setTypePaymentSystem(String typePaymentSystem) {
        this.typePaymentSystem = typePaymentSystem;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public int getTargetIdBankAccount() {
        return targetIdBankAccount;
    }

    public void setTargetIdBankAccount(int targetIdBankAccount) {
        this.targetIdBankAccount = targetIdBankAccount;
    }

    public int getSenderIdBankAccount() {
        return senderIdBankAccount;
    }

    public void setSenderIdBankAccount(int senderIdBankAccount) {
        this.senderIdBankAccount = senderIdBankAccount;
    }
}
