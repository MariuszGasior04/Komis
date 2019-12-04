package pl.altkom.web;

import javax.sql.DataSource;
import java.util.List;

public interface ClientDataDAO {
	
	public void saveClientData(Client client, String dataSource) throws Exception;
	public void deleteClientData(String firstName, String lastName, DataSource dataSource) throws Exception;
	public List readClientsData(DataSource dataSource) throws Exception;
}
