package dev.cross.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.cross.types.Event_Type;
import dev.cross.types.Grade_Type;
import dev.cross.utils.ConnectionUtil;

public class EventDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public Grade_Type getGradeType(Event_Type ev) {
		String sql = "select grade_t from requestsystem.eventtypes where event_t = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ev.toString());
			ResultSet rs = ps.executeQuery();
			Grade_Type grade = null;
			if (rs.next()) {
				String s = rs.getString("grade_t");
				if (s.equals("Grade")) {
					grade = Grade_Type.Grade;
				} else if (s.equals("Presentation")) {
					grade = Grade_Type.Presentation;
				}
				return grade;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public double getPct(Event_Type ev) {
		String sql = "select reimburse_pct from requestsystem.eventtypes where event_t = ?";
		double pct = 0.0;
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ev.toString());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pct = rs.getDouble("reimburse_pct");
				return pct;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pct;
	}
	
	
}