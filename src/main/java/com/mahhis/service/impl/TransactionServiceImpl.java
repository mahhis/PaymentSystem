package com.mahhis.service.impl;

import com.mahhis.controller.constants.APILinks;
import com.mahhis.dao.TransactionDAO;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.dao.impl.TransactionDAOImpl;
import com.mahhis.entity.order.Order;
import com.mahhis.entity.order.OrderPool;
import com.mahhis.entity.transaction.Transaction;
import com.mahhis.entity.user.User;
import com.mahhis.service.TransactionService;
import com.mahhis.service.exception.ServiceException;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;




public class TransactionServiceImpl implements TransactionService {

    private static OrderPool orderPool = OrderPool.getInstance();
    @Override
    public void transferMoney(Transaction transaction) throws ServiceException {
        TransactionDAO transactionDAO = new TransactionDAOImpl();
        try {
            transactionDAO.createTransaction(transaction);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void registerOrder(User user, long cardNumberGetter, double sum, String bankNameGetter, String getterCountry) throws ServiceException {
        Order order = new Order(user, false, cardNumberGetter, sum, bankNameGetter, getterCountry);
        orderPool.registerOrderInPool(order);
    }

    @Override
    public void choiceDirectTranslationAndTransfer(Transaction transaction) throws ServiceException {

        Map<Long, Double> tmpVal = orderPool.pool.get(transaction.getSenderCountry()).get(transaction.getBankNameSender());
        Iterator<Long> it = tmpVal.keySet().iterator();
        while (it.hasNext() && transaction.getSum() > 0) {
            Long m = it.next();
            long tmpCardNumberGetter = m;
            double tmpSum =  tmpVal.get(m);
            if (tmpSum == transaction.getSum()) {
                transferMoneyViaBankAPI(transaction.getCardNumberSender(), transaction.getCardValidityDate(),transaction.getCVV(),transaction.getSum(), transaction.getBankNameGetter(), tmpCardNumberGetter);
                orderPool.remove(transaction.getSenderCountry(), transaction.getBankNameSender(), tmpCardNumberGetter);
                double tmp = transaction.getSum() - tmpSum;
                transaction.setSum(tmp);
            } else if (tmpSum > transaction.getSum()) {
                transferMoneyViaBankAPI(transaction.getCardNumberSender(), transaction.getCardValidityDate(),transaction.getCVV(),transaction.getSum(), transaction.getBankNameGetter(), tmpCardNumberGetter);
                orderPool.update(transaction.getSenderCountry(), transaction.getBankNameSender(), tmpCardNumberGetter, transaction.getSum());
                double tmp = transaction.getSum()-tmpSum;
                transaction.setSum(tmp);
            } else if (tmpSum < transaction.getSum()) {
                double tmp = transaction.getSum() - tmpSum;
                transaction.setSum(tmp);
                transferMoneyViaBankAPI(transaction.getCardNumberSender(), transaction.getCardValidityDate(),transaction.getCVV(),tmpSum, transaction.getBankNameGetter(), tmpCardNumberGetter);
                orderPool.remove(transaction.getSenderCountry(), transaction.getBankNameSender(), tmpCardNumberGetter);
            }
        }
    }

    @Override
    public boolean transferMoneyViaBankAPI(long cardNumberSender, String cardValidityDate, short CVV, Double sum, String bankName, long cardNumberGetter) throws ServiceException {
        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream os = null;


        APILinks apiLinks = new APILinks();

       /* try {
            Map<String, String> postarray = new HashMap<>();

            postarray.put("cardNumberSender", String.valueOf(cardNumberSender));
            postarray.put("cardValidityDate", cardValidityDate);
            postarray.put("CVV", String.valueOf(CVV));
            postarray.put("sum", String.valueOf(sum));
            postarray.put("cardNumberGetter", String.valueOf(cardNumberGetter));

            byte[] out = postarray.toString().getBytes();


            url = new URL(apiLinks.getAPILink(bankName));
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();

            try {
                os = httpURLConnection.getOutputStream();
                os.write(out);
            } catch (Exception e) {
                System.err.print(e.getMessage());
            }

            if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()) {
                return true;
            } else {
                return false;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }*/

        return true;
    }
}
