package pl.altkom.web;

import javax.sql.DataSource;
import java.util.List;

public interface CarInfoDAO {

	public void saveCarInfo(CarBean car, DataSource dataSource);
	public List readCarsData(DataSource dataSource) throws Exception;

}
