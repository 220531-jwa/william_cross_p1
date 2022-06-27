package dev.cross.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.cross.models.Request;
import dev.cross.types.Approve_Type;
import dev.cross.types.Event_Type;
import dev.cross.utils.ConnectionUtil;

public class RequestDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public Request createRequest(Request r) {
		String sql = "insert into requestSystem.requests values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getEmployee_id());
			ps.setString(2, r.getEvent_t().toString());
			ps.setString(3, r.getDescription());
			ps.setFloat(4, r.getMoney());
			ps.setString(5, r.getGrade());
			ps.setString(6, r.getApproval().toString());
			ps.setDate(7, r.getStartDate());
			ps.setDate(8, r.getEndDate());
			ps.setFloat(9, r.getTotalValue());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r.setId(rs.getInt("id"));
			} else {
				r = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public Request getRequest(int id) {
		String sql = "select * from requestSystem.requests where request_id = ?";
		Request r = null;
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  id);;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String e = rs.getString("event_t");
				Event_Type eT = null;
				switch(e) {
				case "University_Course": 
					eT = Event_Type.University_Course;
					break;
				case "Seminar": 
					eT = Event_Type.Seminar;
					break;
				case "Certification": 
					eT = Event_Type.Certification;
					break;
				case "Certification_Preparation_Class": 
					eT = Event_Type.Certification_Preparation_Class;
					break;
				case "Tehnical_Training": 
					eT = Event_Type.Tehnical_Training;
					break;
				case "Other": 
					eT = Event_Type.Other;
					break;
					
				}
				
				String a = rs.getString("approval");
				Approve_Type aT = null;
				switch(a) {
				case "Accepted":
					aT = Approve_Type.Accepted;
					break;
				case "Pending":
					aT = Approve_Type.Pending;
					break;
				case "Rejected":
					aT = Approve_Type.Rejected;
					break;
				}
				
				r = new Request(rs.getInt("request_id"), rs.getInt("employee"), eT, rs.getString("description"), rs.getFloat("emburse_request"), rs.getString("grade"), aT, rs.getDate("start_date"), rs.getDate("end_date"), rs.getFloat("total_value"));
			} else {
				r = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	
	public List<Request> getRequestListByEmployee(int employeeId) {
		String sql = "select * from requestSystem.requests where employee = ?";
		ArrayList<Request> r = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String e = rs.getString("event_t");
				Event_Type eT = null;
				switch(e) {
				case "University_Course": 
					eT = Event_Type.University_Course;
					break;
				case "Seminar": 
					eT = Event_Type.Seminar;
					break;
				case "Certification": 
					eT = Event_Type.Certification;
					break;
				case "Certification_Preparation_Class": 
					eT = Event_Type.Certification_Preparation_Class;
					break;
				case "Tehnical_Training": 
					eT = Event_Type.Tehnical_Training;
					break;
				case "Other": 
					eT = Event_Type.Other;
					break;
					
				}
				
				String a = rs.getString("approval");
				Approve_Type aT = null;
				switch(a) {
				case "Accepted":
					aT = Approve_Type.Accepted;
					break;
				case "Pending":
					aT = Approve_Type.Pending;
					break;
				case "Rejected":
					aT = Approve_Type.Rejected;
					break;
				}
				
				r.add(new Request(rs.getInt("request_id"), rs.getInt("employee"), eT, rs.getString("description"), rs.getFloat("emburse_request"), rs.getString("grade"), aT, rs.getDate("start_date"), rs.getDate("end_date"), rs.getFloat("total_value")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
		
	public List<Request> getRequestList() {
		String sql = "select * from requestSystem.requests";
		ArrayList<Request> r = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String e = rs.getString("event_t");
				Event_Type eT = null;
				switch(e) {
				case "University_Course": 
					eT = Event_Type.University_Course;
					break;
				case "Seminar": 
					eT = Event_Type.Seminar;
					break;
				case "Certification": 
					eT = Event_Type.Certification;
					break;
				case "Certification_Preparation_Class": 
					eT = Event_Type.Certification_Preparation_Class;
					break;
				case "Tehnical_Training": 
					eT = Event_Type.Tehnical_Training;
					break;
				case "Other": 
					eT = Event_Type.Other;
					break;
					
				}
				
				String a = rs.getString("approval");
				Approve_Type aT = null;
				switch(a) {
				case "Accepted":
					aT = Approve_Type.Accepted;
					break;
				case "Pending":
					aT = Approve_Type.Pending;
					break;
				case "Rejected":
					aT = Approve_Type.Rejected;
					break;
				}
				
				r.add(new Request(rs.getInt("request_id"), rs.getInt("employee"), eT, rs.getString("description"), rs.getFloat("emburse_request"), rs.getString("grade"), aT, rs.getDate("start_date"), rs.getDate("end_date"), rs.getFloat("total_value")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public boolean modifyRequest(Request update) {
		String sql = "update requestSystem.requests set (emburse_request, approval, grade)" + "= (?, ?, ?) where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, update.getMoney());
			ps.setString(2, update.getApproval().toString());
			ps.setString(3, update.getGrade());
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