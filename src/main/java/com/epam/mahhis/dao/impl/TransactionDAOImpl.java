package com.epam.mahhis.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.epam.mahhis.dao.TransactionDAO;
import com.epam.mahhis.entity.transaction.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

	@Override
	public Transaction findById(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findByAmount(double amountMoney) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findByDate(Date fromTime, Date toTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}
	
}