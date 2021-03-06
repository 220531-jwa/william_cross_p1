package dev.cross.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.cross.models.User;
import dev.cross.utils.ConnectionUtil;

public class UserDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public User createUser(User u) {
		String sql = "insert into requestsystem.users values (default, ?, ?, ?, ?, ?, ?) returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPass());
			ps.setBoolean(5, u.isManager());
			ps.setFloat(6, u.getReimburseUsed());
			ps.setInt(7, u.getNotif());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("id"));
			} else {
				u = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public User getUserByUsername(String username) {
		String sql = "select * from requestsystem.users where username = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new User(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("pass"),
						rs.getBoolean("manager"),
						rs.getInt("reimburse_used"),
						rs.getInt("notif")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserById(int id) {
		String sql = "select * from requestsystem.users where employee_id = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new User(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("pass"),
						rs.getBoolean("manager"),
						rs.getFloat("reimburse_used"),
						rs.getInt("notif")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean modifyUserNotif(User newUser) {
		String sql = "update requestSystem.users set (notif)" + "= (?) where employee_id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newUser.getNotif());
			ps.setInt(2, newUser.getId());
			
			if (ps.executeUpdate() == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}