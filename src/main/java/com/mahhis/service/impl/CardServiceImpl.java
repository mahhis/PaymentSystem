package com.mahhis.service.impl;

import com.mahhis.dao.CardDAO;
import com.mahhis.dao.FactoryDAO;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.card.Card;
import com.mahhis.entity.user.User;
import com.mahhis.service.CardService;
import com.mahhis.service.exception.ServiceException;

import java.util.List;

public class CardServiceImpl implements CardService {
    @Override
    public List<Card> findAll(User user) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        CardDAO cardDAO = factoryDAO.getCardDAO();
        List<Card> userCards;
        try {
            userCards =cardDAO.findAll(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return userCards;
    }
}
