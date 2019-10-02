/**
*
*Date 	Aug 13, 2019
*
*	DATE	     AUTHOR	
*----------------------------
*   Aug 13, 2019	     TinhNH9
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

import model.bean.KhachHang;

/**
 * @author TinhNH9
 *
 */
public class KhachHangDAO {
	public static List<KhachHang> getAllKhachHang(){
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			Connection conn= ConnectionUtils.getConnection();
			Statement st= conn.createStatement();
			String sql = " select * from KhachHang ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getString(1));
				kh.setTenKH(rs.getString(2));
				kh.setDiaChi(rs.getString(3));
				kh.setSdt(rs.getString(4));
				kh.setHinhKH(rs.getString(5));
				kh.setGioiTinh(rs.getString(6));
				list.add(kh);	
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
	public static boolean addKhachHang(KhachHang kh) {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = "insert into KhachHang(MaKH,TenKH,DiaChi,SDT,HinhKH,GIoiTinh) values(?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,kh.getMaKH());
			st.setString(2, kh.getTenKH());
			st.setString(3,kh.getDiaChi());
			st.setString(4,kh.getSdt());
			st.setString(5, kh.getHinhKH());
			st.setString(6, kh.getGioiTinh());
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
	public static KhachHang findKhachHangMaKH(String makh) {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = "select MaKH,TenKH,DiaChi,SDT,HinhKH,GIoiTinh from TaiKhoan where MaKH='"+makh+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs!=null) {
				rs.next();
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getString(1));
				kh.setTenKH(rs.getString(2));
				kh.setDiaChi(rs.getString(3));
				kh.setSdt(rs.getString(4));
				kh.setHinhKH(rs.getString(5));
				kh.setGioiTinh(rs.getString(6));
				if(conn!=null)
					conn.close();
				return kh;
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
	public static boolean updateKhachHang(KhachHang kh) {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = String.format("update KhachHang set TenKH='%s',DiaChi='%s',SDT='%s',HinhKH='%s',GIoiTinh='%s' where MaKH='%s'",kh.getTenKH(),kh.getDiaChi(),kh.getSdt(),kh.getHinhKH(),kh.getGioiTinh(),kh.getMaKH());
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
	public static boolean deleteKhachHang(String makh) {
		try {
			Connection conn = ConnectionUtils.getConnection();
			String sql = String.format("delete from KhachHang where MaKH='%s'",makh);
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
