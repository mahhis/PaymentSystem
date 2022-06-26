package com.mahhis.service;

import com.mahhis.entity.card.Card;
import com.mahhis.entity.user.User;
import com.mahhis.service.exception.ServiceException;

import java.util.List;

public interface CardService {

    List<Card> findAll(User user) throws ServiceException;
}
