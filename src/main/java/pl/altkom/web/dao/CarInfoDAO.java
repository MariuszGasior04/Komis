package pl.altkom.web.dao;

import pl.altkom.web.CarBean;
import pl.altkom.web.Client;

import javax.sql.DataSource;
import java.util.List;

public interface CarInfoDAO {

	public void saveCarInfo(CarBean car, DataSource dataSource);
	public List readCarsData(DataSource dataSource) throws Exception;
	public void deleteCarData(int id, DataSource dataSource) throws Exception;
	public void editCarData(CarBean car, DataSource dataSource) throws Exception;
}
