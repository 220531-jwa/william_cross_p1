package dev.cross.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.cross.models.Request;
import dev.cross.models.RequestManagerView;
import dev.cross.types.Approve_Type;
import dev.cross.types.Event_Type;
import dev.cross.utils.ConnectionUtil;

public class RequestDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public Request createRequest(Request r) {
		String sql = "insert into requestSystem.requests "
				+ "(request_id, employee, event_t, description, grade, approval, start_date, end_date, total_value, reimburse_amount, exceeds_funds, expected_funds, manager_notif, employee_notif) values "
				+ "(default, ?, ?::event_type, ?, ?, ?::approve_type, ?, ?, ?, ?, ?, ?, ?, ?) returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getEmployee_id());
			ps.setString(2, r.getEvent_t().toString());
			ps.setString(3, r.getDescription());
			ps.setString(4, r.getGrade());
			ps.setString(5, r.getApproval().toString());
			ps.setDate(6, r.getStartDate());
			ps.setDate(7, r.getEndDate());
			ps.setDouble(8, r.getTotalValue());
			ps.setDouble(9, r.getMoney());
			ps.setBoolean(10, r.isExceedsFunds());
			ps.setDouble(11, r.getExpected_funds());
			ps.setBoolean(12, r.isManagerNotif());
			ps.setBoolean(13, r.isEmployeeNotif());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r.setId(rs.getInt("request_id"));
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
				
				r = (new Request(
						rs.getInt("request_id"), 
						rs.getInt("employee"),
						eT,
						rs.getString("description"),
						rs.getString("grade"),
						aT,
						rs.getDate("start_date"),
						rs.getDate("end_date"),
						rs.getDouble("total_value"),
						rs.getDouble("reimburse_amount"),
						rs.getDouble("expected_funds"),
						rs.getBoolean("manager_notif"),
						rs.getBoolean("employee_notif"),
						rs.getBoolean("exceeds_funds")
						));
			} else {
				r = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public RequestManagerView getRequestManager(int id) {
		String sql = "select * from requestSystem.requests, requestsystem.users where employee = employee_id and request_id = ?";
		RequestManagerView r = null;
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
				
				r = (new RequestManagerView(
						rs.getInt("request_id"), 
						rs.getInt("employee"),
						eT,
						rs.getString("description"),
						rs.getString("grade"),
						aT,
						rs.getDate("start_date"),
						rs.getDate("end_date"),
						rs.getDouble("total_value"),
						rs.getDouble("reimburse_amount"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getDouble("expected_funds"),
						rs.getBoolean("manager_notif"),
						rs.getBoolean("employee_notif"),
						rs.getBoolean("exceeds_funds")
						));
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
				
				r.add(new Request(
						rs.getInt("request_id"), 
						rs.getInt("employee"),
						eT,
						rs.getString("description"),
						rs.getString("grade"),
						aT,
						rs.getDate("start_date"),
						rs.getDate("end_date"),
						rs.getDouble("total_value"),
						rs.getDouble("reimburse_amount"),
						rs.getDouble("expected_funds"),
						rs.getBoolean("manager_notif"),
						rs.getBoolean("employee_notif"),
						rs.getBoolean("exceeds_funds")
						));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
		
	public List<RequestManagerView> getRequestList() {
		String sql = "select * from requestsystem.requests, requestsystem.users where employee = employee_id and approval = 'Pending' order by request_id;";
		ArrayList<RequestManagerView> r = new ArrayList<>();
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
				
				r.add(new RequestManagerView(
						rs.getInt("request_id"), 
						rs.getInt("employee"),
						eT,
						rs.getString("description"),
						rs.getString("grade"),
						aT,
						rs.getDate("start_date"),
						rs.getDate("end_date"),
						rs.getDouble("total_value"),
						rs.getDouble("reimburse_amount"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getDouble("expected_funds"),
						rs.getBoolean("manager_notif"),
						rs.getBoolean("employee_notif"),
						rs.getBoolean("exceeds_funds")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public boolean modifyRequest(Request update) {
		String sql = "update requestSystem.requests set (reimburse_amount, approval, grade, exceeds_funds, manager_notif, employee_notif)" + "= (?, ?::approve_type, ?) where request_id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, update.getMoney());
			ps.setString(2, update.getApproval().toString());
			ps.setString(3, update.getGrade());
			ps.setBoolean(4, update.isExceedsFunds());
			ps.setBoolean(5, update.isManagerNotif());
			ps.setBoolean(6, update.isEmployeeNotif());
			ps.setInt(7, update.getId());
			
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