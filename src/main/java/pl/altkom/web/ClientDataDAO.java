package pl.altkom;


import pl.altkom.web.Client;

import javax.sql.DataSource;
import java.util.List;

public interface ClientDataDAO {
	
	public void saveClientData(Client client, String dataSource) throws Exception;
	public List readClientsData(DataSource dataSource) throws Exception;
}
