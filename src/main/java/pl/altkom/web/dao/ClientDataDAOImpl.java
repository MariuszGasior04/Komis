package pl.altkom.web.dao;

import pl.altkom.web.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ClientDataDAOImpl implements ClientDataDAO {

	public void saveClientData(Client cl, DataSource dataSource) throws Exception {

        Connection con = null;
        
        try {
	        con = dataSource.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(
	        "INSERT INTO klient(id,imie,nazwisko,region,wiek,mezczyzna) values (?,?,?,?,?,?)");
	
	        int m = (cl.getSex().equals("male") ? 1 : 0);
	        pstmt.setInt(1, generateId());
	        pstmt.setString(2, cl.getFirstName());
	        pstmt.setString(3, cl.getLastName());
	        pstmt.setString(4, cl.getRegion());
	        pstmt.setInt(5, cl.getAge());
	        pstmt.setInt(6, m);
	        
	        pstmt.executeUpdate();
	        pstmt.close();
        } finally {
        	if (con != null) {
        		con.close();
        	}
        }
	}

	@Override
	public void deleteClientData(String firstName, String lastName, DataSource dataSource) throws Exception {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM klient WHERE imie = '"+firstName+"' AND nazwisko = '"+lastName+"' ");

			pstmt.executeUpdate();
			pstmt.close();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}


	@Override
	public List readClientsData(DataSource dataSource) throws Exception {

		Connection conn = null;
		List clients = new ArrayList();

		try {
			conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT id, imie, nazwisko, region, wiek, mezczyzna FROM klient");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Client cl = new Client();
				cl.setId(rs.getInt(1));
				cl.setFirstName(rs.getString(2));
				cl.setLastName(rs.getString(3));
				cl.setRegion(rs.getString(4));
				cl.setAge(rs.getInt(5));
				if(rs.getInt(6) == 1){
					cl.setSex("male");
				}else{
					cl.setSex("female");
				}
				clients.add(cl);
			}

			rs.close();
			pstmt.close();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return clients;
	}

	@Override
	public void deleteClientData(int id, DataSource dataSource) throws Exception {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM klient WHERE id = '"+id+"'");

			pstmt.executeUpdate();
			pstmt.close();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}


}
