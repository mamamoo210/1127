package test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RegisterDBA { 
	private String url;
	private String user;
	private String pwd;
	
	public RegisterDBA() { 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			 user = "scott";
			 pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	void infoInsert(RegisterBean bean) { 
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "INSERT INTO FRIEND VALUES(FRIEND_SEQ.nextval , ? , ? , ? ,?)";
			ps = con.prepareStatement(sql); 
			
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getBirth());
			ps.setString(3, bean.getPhone());
			ps.setString(4, bean.getAddr());
			ps.executeQuery(); //sql ½ÇÇà
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(ps!=null)ps.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	} 
	
	ArrayList<RegisterBean> infoSee() { 
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<RegisterBean> arr1 = new ArrayList<RegisterBean>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM FRIEND";
			st = con.createStatement();
			rs = st.executeQuery(sql); 
			
			while(rs.next()) { 
				RegisterBean bean = new RegisterBean();
				bean.setNum(rs.getInt("NUM"));
				bean.setName(rs.getString("NAME"));
				bean.setBirth(rs.getString("BIRTH"));
				bean.setPhone(rs.getString("PHONE"));
				bean.setAddr(rs.getString("ADDR"));
				
				arr1.add(bean); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return arr1;
	}
	
	
	ArrayList<RegisterBean> friendSearch(String str, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<RegisterBean> arr = new ArrayList<RegisterBean>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM FRIEND WHERE " + str + " LIKE '%" + word +"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				RegisterBean bean = new RegisterBean();
				bean.setNum(rs.getInt("NUM"));
				bean.setName(rs.getString("NAME"));
				bean.setBirth(rs.getString("BIRTH"));
				bean.setPhone(rs.getString("PHONE"));
				bean.setAddr(rs.getString("ADDR"));
				arr.add(bean);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return arr;
	}

}
