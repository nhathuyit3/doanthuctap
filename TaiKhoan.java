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
package model.bean;

/**
 * @author TinhNH9
 *
 */
public class TaiKhoan {
	private String maTK;
	private String taiKhoan;
	private String matKhau;
	private String mail;
	private String maQ;
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMaQ() {
		return maQ;
	}
	public void setMaQ(String maQ) {
		this.maQ = maQ;
	}
	
	/**
	 * 
	 */
	public TaiKhoan(String matk,String taikhoan, String matkhau, String mail, String maq) {
		this.maTK = matk;
		this.taiKhoan = taikhoan;
		this.matKhau = matkhau;
		this.mail = mail;
		this.maQ = maq;
	}
	/**
	 * 
	 */
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}
}
