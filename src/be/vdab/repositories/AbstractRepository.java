package be.vdab.repositories;

import javax.sql.DataSource;

public class AbstractRepository {

	public final static String JNDI_NAME = "jdbc/frituurfrida";
	protected DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
