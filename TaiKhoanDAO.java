/**
*
*Date 	Aug 6, 2019
*
*	DATE	     AUTHOR	
*----------------------------
*   Aug 6, 2019	     TinhNH9
*/

/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.TaiKhoan;

/**
 * @author TinhNH9
 *
 */
public class TaiKhoanDAO {
	public static List<TaiKhoan> getAllTaiKhoan() {
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			Connection conn= ConnectionUtils.getConnection();
			Statement st= conn.createStatement();
			String sql = " select * from TaiKhoan ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				TaiKhoan tk = new TaiKhoan();
				tk.setMaTK(rs.getString(1));
				tk.setTaiKhoan(rs.getString(2));
				tk.setMatKhau(rs.getString(3));
				tk.setMail(rs.getString(4));
				tk.setMaQ(rs.getString(5));
				list.add(tk);	
			}
			ConnectionUtils.closeQuietly(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static boolean addTaiKhoan(TaiKhoan tk) {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = "insert into TaiKhoan(MaTK,TaiKhoan,MatKhau,Mail,MaQ) values(?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tk.getMaTK());
			st.setString(2, tk.getTaiKhoan());
			st.setString(3, tk.getMatKhau());
			st.setString(4, tk.getMail());
			st.setString(5, tk.getMaQ());
			int rs = st.executeUpdate();
			if(conn!=null)
				ConnectionUtils.closeQuietly(conn);
			if(rs!=0)
				return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static TaiKhoan findTaiKhoanMatk(String matk) {
		
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = "select MaTK,TaiKhoan,MatKhau,Mail,MaQ from TaiKhoan where MaTK='"+matk+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs!=null) {
				rs.next();
				TaiKhoan taikhoan = new TaiKhoan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				if(conn!=null)
					conn.close();
				return taikhoan;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean updateTaiKhoan(TaiKhoan tk) {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = String.format("update TaiKhoan set TaiKhoan='%s',MatKhau='%s',Mail='%s',MaQ='%s' where MaTK='%s'",tk.getTaiKhoan(),tk.getMatKhau(),tk.getMail(),tk.getMaQ(),tk.getMaTK());
			Statement st = conn.createStatement();
			int rs = st.executeUpdate(sql);
			ConnectionUtils.closeQuietly(conn);
			if(rs==1) return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean deleteTaiKhoan(String matk) {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = String.format("delete from TaiKhoan where MaTK='%s'",matk);
			Statement st = conn.createStatement();
			int rs = st.executeUpdate(sql);
			ConnectionUtils.closeQuietly(conn);
			if(rs==1) return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
