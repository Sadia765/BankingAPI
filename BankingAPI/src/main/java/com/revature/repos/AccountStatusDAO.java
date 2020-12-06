package main.java.com.revature.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.com.revature.models.AccountStatus;
import main.java.com.revature.util.ConnectionUtil;

public class AccountStatusDAO implements IAccountStatusDAO {

	@Override
	public AccountStatus findById(int statusId) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account_status WHERE status_id = '" + statusId + "';";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if(result.next()) {
				AccountStatus astatus = new AccountStatus();
				astatus.setStatusId(statusId);
				astatus.setStatus(result.getString("a_status"));

				return astatus;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
