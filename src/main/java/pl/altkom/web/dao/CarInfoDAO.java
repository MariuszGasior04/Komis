package pl.altkom.web.dao;

import pl.altkom.web.CarBean;

import javax.sql.DataSource;
import java.util.List;

public interface CarInfoDAO {

	public void saveCarInfo(CarBean car, DataSource dataSource);
	public List readCarsData(DataSource dataSource) throws Exception;

}
