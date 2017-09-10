package be.vdab.repositories;

import be.vdab.enteties.GastenboekEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GastenboekRepository extends AbstractRepository {

	private static final String READ = "SELECT * FROM gastenboek ORDER BY id DESC";
	private static final String INSERT = "INSERT INTO gastenboek (posterid, bericht, plaatstijd) VALUES (?, ?, ?)";
	private static final String SELECT_USER_BY_ID = "SELECT gebruikersnaam FROM users WHERE id = ?";
	private static final String DELETE = "DELETE FROM gastenboek WHERE id IN (";
	private final static Logger LOGGER = Logger.getLogger(GastenboekRepository.class.getName());

	public List<GastenboekEntry> readAll(){
		try(Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(READ)) {
			List<GastenboekEntry> gastenboek = new ArrayList<>();
			for (long vorigeId = 0; resultSet.next();) {
				long id = resultSet.getLong("id");
				if (id != vorigeId) {
					String poster = findUserById(resultSet.getLong("posterid"));
					gastenboek.add(
							new GastenboekEntry(resultSet.getLong("id"),resultSet.getLong("posterid"),
									poster,resultSet.getString("bericht"),resultSet.getDate("plaatstijd")));
					vorigeId = id;
				}
			}
			return gastenboek;
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE,"DB probleem(readAll)",ex);
			throw new RepositoryException(ex);
		}
	}

	public void insert(Long posterid, String bericht, String plaatsTijd){
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
			statement.setLong(1, posterid);
			statement.setString(2, bericht);
			statement.setString(3, plaatsTijd);
			statement.executeUpdate();
			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				resultSet.next();
			}
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, "DB probleem (insert)", ex);
			throw new RepositoryException(ex);
		}
	}

	public void delete(Set<Long> ids) {
		StringBuilder sql = new StringBuilder(DELETE);
		ids.stream().forEach(id -> sql.append("?,"));
		sql.deleteCharAt(sql.length() - 1);
		sql.append(')');
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql.toString())) {
			int index = 1;
			for (long id : ids) {
				statement.setLong(index++, id);
			}
			statement.executeUpdate();
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE,"DB probleem",ex);
			throw new RepositoryException(ex);
		}
	}

	private String findUserById (Long id){
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID)) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getString("gebruikersnaam");
				} else {
					return null;
				}
			}
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE,"DB probleem(findUserById)",ex);
			throw new RepositoryException(ex);
		}
	}
}
