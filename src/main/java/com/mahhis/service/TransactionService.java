package com.mahhis.service;

import com.mahhis.entity.transaction.Transaction;
import com.mahhis.entity.user.User;
import com.mahhis.service.exception.ServiceException;

public interface TransactionService {
   void transferMoney(Transaction transaction) throws ServiceException;
   void registerOrder(User user, long cardNumberGetter, double sum, String bankNameGetter, String getterCountry) throws ServiceException;
   void choiceDirectTranslationAndTransfer(Transaction transaction) throws ServiceException;
   boolean transferMoneyViaBankAPI(long cardNumberSender, String cardValidityDate, short CVV, Double sum, String bankName, long cardNumberGetter) throws ServiceException;
}
