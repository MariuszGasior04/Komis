package pl.altkom.web.dao;

import pl.altkom.web.CarBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class CarInfoDAOImpl implements CarInfoDAO {

	public void saveCarInfo(CarBean car, DataSource dataSource) {

		try {
	        Connection conn = null;
        
	        try {
		        conn = dataSource.getConnection();
	
		        PreparedStatement pstmt = conn.prepareStatement(
		        "INSERT INTO pojazd(id,marka,typ,rok,przebieg,pojemnosc) VALUES (?,?,?,?,?,?)");
		
		        pstmt.setInt(1, generateId());
		        pstmt.setString(2, car.getBrand());
		        pstmt.setString(3, car.getType());
		        pstmt.setInt(4, car.getYear());
		        pstmt.setString(5, car.getDistance());
		        pstmt.setString(6, car.getCapacity());
		        
		        pstmt.executeUpdate();
		        pstmt.close();
	        } finally {
	        	if (conn != null) {
	        		conn.close();
	        	}
	        }
		} catch (Exception e ) {
        	System.out.println("Błąd przy zapisie danych: " + e);
        }
	}

	@Override
	public List readCarsData(DataSource dataSource) throws Exception {
		Connection conn = null;
		List cars = new ArrayList();

		try {
			conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT marka,typ,rok,przebieg,pojemnosc FROM pojazd");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CarBean cb = new CarBean();
				cb.setBrand(rs.getString(1));
				cb.setType(rs.getString(2));
				cb.setYear(rs.getInt(3));
				cb.setDistance(rs.getString(4));
				cb.setCapacity(rs.getString(5));
				cars.add(cb);
			}

			rs.close();
			pstmt.close();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return cars;
	}

	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}
}