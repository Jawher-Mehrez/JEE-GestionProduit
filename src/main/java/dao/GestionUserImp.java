package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionUserImp implements IGestionUser {
	
	Connection connection = ConnectionBD.getConnection();

	@Override
	public String verification(User u) {
		// TODO Auto-generated method stub
		String v="";
		try {
			PreparedStatement ps=connection.prepareStatement("select * from User where login=? and password=?");
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPassword());
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				v=rs.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return v;
	}

	@Override
	public void registration(User u) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO User (username,login,password) VALUES (?,?,?)");
			    ps.setString(1, u.getUsername());
			    ps.setString(1, u.getLogin());
			    ps.setString(1, u.getPassword());
			  
			    ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
