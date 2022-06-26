package com.mahhis.dao.impl;

import com.mahhis.dao.TransactionDAO;
import com.mahhis.dao.builder.BuilderFactory;
import com.mahhis.dao.database.ConnectionPool;
import com.mahhis.dao.database.ConnectionPoolException;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.transaction.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO{

	private static ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final String FIND_TRANSACTION_BY_ID = "SELECT * FROM `transaction` WHERE idTransaction = ?";
	private static final String FIND_TRANSACTION_BY_AMOUNT = "SELECT * FROM `transaction` WHERE transactionAmount = ?";
	private static final String CREATE_NEW_TRANSACTION = "INSERT transaction(cardNumberSender, cardValidityDate, CVV, amount, bankNameSender, senderCountry, cardNumberGetter, bankNameGetter, getterCountry) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE_TRANSACTION = "DELETE FROM `transaction` WHERE idTransaction = ?";


	@Override
	public void createTransaction(Transaction transaction) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = CREATE_NEW_TRANSACTION;

		try {
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, transaction.getCardNumberSender());
			statement.setString(2, transaction.getCardValidityDate());
			statement.setShort(3, transaction.getCVV());
			statement.setDouble(4, transaction.getSum());
			statement.setString(5, transaction.getBankNameSender());
			statement.setString(6, transaction.getSenderCountry());

			statement.setLong(7, transaction.getCardNumberGetter());
			statement.setString(8, transaction.getBankNameGetter());
			statement.setString(9, transaction.getGetterCountry());
			statement.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.setAutoCommit(true);
				connectionPool.closeConnection(connection, statement);
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public Transaction findById(int idTransaction) throws DAOException {
		Transaction transaction = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = FIND_TRANSACTION_BY_ID;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idTransaction);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				transaction = BuilderFactory.getTransactionBuilder().buildTransaction(resultSet);
			} else {
				transaction = new Transaction();
			}

		} catch (ConnectionPoolException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connectionPool.closeConnection(connection, statement);
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
		}
		return transaction;
	}

	@Override
	public List<Transaction> findByAmount(double amountMoney) {
		List<Transaction> transactionsByAmount = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = FIND_TRANSACTION_BY_AMOUNT;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, amountMoney);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				transactionsByAmount.add(BuilderFactory.getTransactionBuilder().buildTransaction(resultSet));
			}

		} catch (ConnectionPoolException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connectionPool.closeConnection(connection, statement);
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
		}
		return transactionsByAmount;
	}


	@Override
	public void deleteTransaction(Transaction transaction) throws DAOException {
			Connection connection = null;
			PreparedStatement statement = null;
			String sql = DELETE_TRANSACTION;
			try {
				connection = connectionPool.takeConnection();
				statement = connection.prepareStatement(sql);
				statement.setInt(1, transaction.getIdTransaction());
				statement.executeUpdate();
				connection.commit();
			} catch (ConnectionPoolException | SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					connectionPool.closeConnection(connection, statement);
				} catch (ConnectionPoolException e) {
					e.printStackTrace();
				}
			}

	}

}
	
