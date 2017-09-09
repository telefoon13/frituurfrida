package be.vdab.repositories;

import be.vdab.enteties.User;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository extends AbstractRepository {

	private static final String LOGIN = "SELECT * FROM users WHERE gebruikersnaam = ?";
	private final static Logger LOGGER = Logger.getLogger(UserRepository.class.getName());

	public User login(String gebruikersnaam){
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement statement = connection.prepareStatement(LOGIN)) {
			statement.setString(1, gebruikersnaam);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new User(resultSet.getLong("id"), resultSet.getString("gebruikersnaam"), resultSet.getString("email"),
							resultSet.getString("pass"), resultSet.getString("lastIP"),
							resultSet.getDate("laatsteLogin"));
				} else {
					return null;
				}
			}

		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE,"DB probleem",ex);
			throw new RepositoryException(ex);
		}
	}
}
