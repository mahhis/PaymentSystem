package com.mahhis.entity.card;

public class Card {

    private int idCard;
    private long cardNumber;
    private String cardValidityDate;
    private short cvv;
    private String bankName;
    private String countryName;

    private int idUser;

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardValidityDate() {
        return cardValidityDate;
    }

    public void setCardValidityDate(String cardValidityDate) {
        this.cardValidityDate = cardValidityDate;
    }

    public short getCvv() {
        return cvv;
    }

    public void setCvv(short cvv) {
        this.cvv = cvv;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
