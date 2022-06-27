package com.mahhis.entity.order;

import com.mahhis.dao.FactoryDAO;
import com.mahhis.dao.OrderDAO;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.user.User;
import com.mahhis.service.FactoryService;
import com.mahhis.service.OrderService;
import com.mahhis.service.exception.ServiceException;

import java.util.*;

public class OrderPool {

    private static OrderPool instance;

    public static Map<String, Map<String, Map<Long, Double>>> pool = new LinkedHashMap<>();

    public static OrderPool getInstance() {

        if (instance == null) {
            synchronized (OrderPool.class) {
                instance = new OrderPool();
                try {
                    FactoryDAO factoryDAO = FactoryDAO.getInstance();
                    OrderDAO orderDAO = factoryDAO.getOrderDAO();
                    List<Order> allOrder = orderDAO.findAll();

                    Map<Long, Double> cardNumber__sum1 = new HashMap<>();

                    Map<String, Map<Long, Double>> bank__cardNumber1 = new HashMap<>();
                    bank__cardNumber1.put("AlfaBank", cardNumber__sum1);
                    bank__cardNumber1.put("SberBank", cardNumber__sum1);
                    bank__cardNumber1.put("VTB", cardNumber__sum1);
                    pool.put("Belarus", bank__cardNumber1);

                    Map<Long, Double> cardNumber__sum = new HashMap<>();

                    Map<String, Map<Long, Double>> bank__cardNumber = new HashMap<>();
                    bank__cardNumber.put("JPMorgan", cardNumber__sum);
                    bank__cardNumber.put("CityGroupBank", cardNumber__sum);
                    bank__cardNumber.put("BankOfAmerica", cardNumber__sum);
                    pool.put("USA", bank__cardNumber);

                    for (int i = 0; i < allOrder.size(); i++) {
                        Order order = allOrder.get(i);
                        Map<String, Map<Long, Double>> bank__cardNumber3 = pool.get(order.getGetterCountry());
                        Map<Long, Double> cardNumber__sum3 = bank__cardNumber3.get(order.getBankNameGetter());
                        cardNumber__sum3.put(order.getCardNumberGetter(), order.getSumToComplete());
                    }

                } catch (DAOException e) {
                    e.printStackTrace();

                }
            }
        }

        return instance;
    }
    public void remove(String countryName, String bankName, Long cardNumber){
        OrderService orderService = FactoryService.getInstance().getOrderService();

        Map<String, Map<Long, Double>> bank__cardNumber = pool.get(countryName);
        Map<Long, Double> cardNumber__sum = bank__cardNumber.get(bankName);
        cardNumber__sum.remove(cardNumber);
        User user;
        try {
            Order order = orderService.findByCardNumberGetter(cardNumber);
            order.setComplete(true);
            order.setSumToComplete(0.0);
            orderService.updateOrder(order);
            user = order.getUser();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    public void update(String countryName, String bankName, Long cardNumber, Double tmpSum){
        OrderService orderService = FactoryService.getInstance().getOrderService();

        Map<String, Map<Long, Double>> bank__cardNumber = pool.get(countryName);
        Map<Long, Double> cardNumber__sum = bank__cardNumber.get(bankName);
        double t = cardNumber__sum.get(cardNumber)-tmpSum;
        cardNumber__sum.put(cardNumber, t);
        try {
            Order order = orderService.findByCardNumberGetter(cardNumber);
            order.setSumToComplete(t);
            orderService.updateOrder(order);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    public void registerOrderInPool(Order order){
        OrderService orderService = FactoryService.getInstance().getOrderService();

        if(pool.get(order.getGetterCountry()).get(order.getBankNameGetter()).containsKey(order.getCardNumberGetter())){
            Double tempSum = pool.get(order.getGetterCountry()).get(order.getBankNameGetter()).get(order.getCardNumberGetter());
            Map<String, Map<Long, Double>> bank__cardNumber = pool.get(order.getGetterCountry());
            Map<Long, Double> cardNumber__sum = bank__cardNumber.get(order.getBankNameGetter());
            double t = order.getSumToComplete()+tempSum;
            cardNumber__sum.put(order.getCardNumberGetter(), t);
            try {
                order.setSumToComplete(t);
                orderService.updateOrder(order);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }else {
            Map<String, Map<Long, Double>> bank__cardNumber = pool.get(order.getGetterCountry());
            Map<Long, Double> cardNumber__sum = bank__cardNumber.get(order.getBankNameGetter());
            cardNumber__sum.put(order.getCardNumberGetter(), order.getSumToComplete());
            try {
                orderService.createOrder(order);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
    }
}