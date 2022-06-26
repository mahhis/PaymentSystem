package com.mahhis.dao;

import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.card.Card;
import com.mahhis.entity.user.User;

import java.util.List;

public interface CardDAO {

    Card findByID(int idAccount) throws DAOException;
    Card findByNumberAccount(String numberAccount) throws DAOException;
    List<Card> findAll(User user) throws DAOException;
    void createAccount(Card account) throws DAOException;
    void deleteAccount(Card account) throws DAOException;
}
