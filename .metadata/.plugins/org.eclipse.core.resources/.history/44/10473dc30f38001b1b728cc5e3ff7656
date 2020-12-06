package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.AccountStatus;
import com.revature.models.AccountType;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class AccountDAO implements IAccountDAO {

	private static final AccountDAO dao = new AccountDAO();
	private static final AccountStatusDAO acstatusdao = new AccountStatusDAO();
	private static final AccountTypeDAO actypedao = new AccountTypeDAO();

	@Override
	public List<Account> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM account;";

			Statement statement = conn.createStatement();

			List<Account> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Account a = new Account();
				a.setAccountId(result.getInt("account_id"));
				a.setBalance(result.getDouble("balance"));
				// a.setStatus(result.getString("status_fk"));
				// a.setType(result.getString("type_fk"));
				a.setUser_fk(result.getInt("user_fk"));

				if (result.getString("status_fk") != null) {
					AccountStatus acstatus = acstatusdao.findById(result.getInt("status_fk"));
					a.setStatus(acstatus);
				}

				if (result.getString("type_fk") != null) {
					AccountType actype = actypedao.findById(result.getInt("type_fk"));
					a.setType(actype);
				}

				list.add(a);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			;
		}
		return null;
	}

	@Override
	public Account findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account WHERE account_id = " + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				Account acnt = new Account();
				acnt.setAccountId(result.getInt("account_id"));
				acnt.setBalance(result.getDouble("balance"));
				// acnt.setStatus(result.getString("status_fk"));
				// acnt.setType(result.getString("type_fk"));
				acnt.setUser_fk(result.getInt("user_fk"));

				if (result.getString("status_fk") != null) {
					AccountStatus acstatus = acstatusdao.findById(result.getInt("status_fk"));
					acnt.setStatus(acstatus);
				}

				if (result.getString("type_fk") != null) {
					AccountType actype = actypedao.findById(result.getInt("type_fk"));
					acnt.setType(actype);
				}

				return acnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> findByStatus(AccountStatus status) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account WHERE account_status = '" + status.getStatus() + "';";

			Statement statement = conn.createStatement();

			List<Account> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Account acnt = new Account();
				acnt.setAccountId(result.getInt("account_id"));
				acnt.setBalance(result.getDouble("balance"));
				acnt.setStatus(status);
				// acnt.setType(result.getString("type_fk"));
				acnt.setUser_fk(result.getInt("user_fk"));

				// if(result.getString("status_fk") != null) {
				// AccountStatus acstatus = acstatusdao.findById(result.getInt("status_fk"));
				// acnt.setStatus(acstatus);
				// }

				if (result.getString("type_fk") != null) {
					AccountType actype = actypedao.findById(result.getInt("type_fk"));
					acnt.setType(actype);
				}

				list.add(acnt);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> findByUser(int user_fk) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account WHERE user_fk = " + user_fk + ";";

			Statement statement = conn.createStatement();

			List<Account> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Account acnt = new Account();
				acnt.setAccountId(result.getInt("account_id"));
				acnt.setBalance(result.getDouble("balance"));
				// acnt.setStatus(status);
				// acnt.setType(result.getString("type_fk"));
				acnt.setUser_fk(user_fk);

				if (result.getString("status_fk") != null) {
					AccountStatus acstatus = acstatusdao.findById(result.getInt("status_fk"));
					acnt.setStatus(acstatus);
				}

				if (result.getString("type_fk") != null) {
					AccountType actype = actypedao.findById(result.getInt("type_fk"));
					acnt.setType(actype);
				}

				list.add(acnt);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			int index = 0;

			String sql = "INSERT INTO account(balance, status_fk, type_fk, user_fk)" + "VALUES(?,?,?,?);";

			PreparedStatement statement = conn.prepareStatement(sql);
			a.getStatus().setStatusId(2);
			a.getStatus().setStatus("Open");
			System.out.println("The status is " + a.getStatus());
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatus().getStatusId());
			statement.setInt(++index, a.getType().getTypeId());
			statement.setInt(++index, a.getUser_fk());

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateAccount(Account a) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			int index = 0;
//			System.out.println(a.getStatus().getStatusId());
//			System.out.println(a.getType().getTypeId());
			String sql = "UPDATE account SET balance = ?, status_fk = ?, type_fk = ?, user_fk = ? WHERE account_id = '"	+ a.getAccountId() + "';";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatus().getStatusId());
			statement.setInt(++index, a.getType().getTypeId());
			statement.setInt(++index, a.getUser_fk());
			
			statement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean withdraw(int accountId, double amount) {
		Account a = dao.findById(accountId);
		double inBank = a.getBalance();
		System.out.println(inBank);
		if(inBank>=amount) {
			a.setBalance(inBank-amount);
			
		}
		else { //inBank< amount => inBank-amount <0, i.e. nothing in bank.
			a.setBalance(0);
		}
		updateAccount(a);
		System.out.println(a.getBalance());
		return true;
	}

	@Override
	public boolean deposit(int accountId, double amount) {
		Account a = dao.findById(accountId);
		double inBank = a.getBalance();
		if(amount>0) {
			a.setBalance(inBank+amount);
			updateAccount(a);
		}
		
		return true;
	}

	@Override
	public boolean transfer(int sourceAccountId, int targetAccountId, double amount) {
		withdraw(sourceAccountId, amount);
		
		deposit(targetAccountId, amount);
		return true;
	}

}
