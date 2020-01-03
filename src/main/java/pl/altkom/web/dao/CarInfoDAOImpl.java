package pl.altkom.web.dao;

import pl.altkom.web.CarBean;
import pl.altkom.web.Client;

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
					"SELECT id, marka,typ,rok,przebieg,pojemnosc FROM pojazd");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CarBean cb = new CarBean();
				cb.setId(rs.getInt(1));
				cb.setBrand(rs.getString(2));
				cb.setType(rs.getString(3));
				cb.setYear(rs.getInt(4));
				cb.setDistance(rs.getString(5));
				cb.setCapacity(rs.getString(6));
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

	@Override
	public void deleteCarData(int id, DataSource dataSource) throws Exception {
		Connection conn = null;
		try{
			conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM pojazd WHERE id = '"+id+"'");

			pstmt.executeUpdate();
			pstmt.close();
		}
		finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	@Override
	public void editCarData(CarBean car, DataSource dataSource) throws Exception {
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			//id, marka,typ,rok,przebieg,pojemnosc
			conn.createStatement().
					executeUpdate("update pojazd set marka = '" + car.getBrand()+"', typ = '"+
							car.getType()+"', rok = '" + car.getYear() + "' , przebieg = "+car.getDistance()+" , " +
							"pojemnosc = "+ car.getCapacity() +" where id = " + car.getId()+";");
		}
		finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}
}