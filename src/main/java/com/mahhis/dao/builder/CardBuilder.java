package com.mahhis.dao.builder;

import com.mahhis.entity.card.Card;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardBuilder {
    public Card buildCard(ResultSet resultSet) throws SQLException {
        Card card = new Card();
        build(card, resultSet);
        return card;
    }

    private void build(Card card, ResultSet resultSet) throws SQLException {

        card.setIdCard(resultSet.getInt("idCard"));
        card.setCardNumber(resultSet.getLong("cardNumber"));
        card.setCvv(resultSet.getShort("CVV"));
        card.setBankName(resultSet.getString("bankName"));
        card.setCountryName(resultSet.getString("countryName"));
    }
}
