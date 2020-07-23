package com.revature.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.AccountType;
import com.revature.util.ConnectionUtil;

public class AccountTypeDAO implements IAccountTypeDAO {

	@Override
	public AccountType findById(int typeId) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account_type WHERE type_id = '" + typeId + "';";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if(result.next()) {
				AccountType atype = new AccountType();
				atype.setType(result.getString("a_type"));

				return atype;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
