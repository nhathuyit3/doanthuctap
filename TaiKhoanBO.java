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
package model.bo;

import java.util.List;

import model.bean.TaiKhoan;
import model.dao.TaiKhoanDAO;

/**
 * @author TinhNH9
 *
 */
public class TaiKhoanBO {
	public static List<TaiKhoan> getAllTaiKhoan(){
		return TaiKhoanDAO.getAllTaiKhoan();
	}
	public static boolean addTaiKhoan(TaiKhoan tk) {
		TaiKhoan taikhoan = TaiKhoanDAO.findTaiKhoanMatk(tk.getMaTK());
		if(taikhoan!=null)
			return false;
		else{
			if(TaiKhoanDAO.addTaiKhoan(tk))
			return true;
		}
		return false;
	}
	public static boolean updateTaiKhoan(TaiKhoan tk) {
		return TaiKhoanDAO.updateTaiKhoan(tk);
	}
	public static TaiKhoan findTaiKHoanMatk(String matk) {
		return TaiKhoanDAO.findTaiKhoanMatk(matk);
	}
	public static boolean deleteTaiKhoan(String matk) {
		return TaiKhoanDAO.deleteTaiKhoan(matk);
	}
}
