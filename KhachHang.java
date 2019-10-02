/**
*
*Date 	Aug 12, 2019
*
*	DATE	     AUTHOR	
*----------------------------
*   Aug 12, 2019	     TinhNH9
*/

/**
 * 
 */
package model.bean;

/**
 * @author TinhNH9
 *
 */
public class KhachHang {
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String sdt;
	private String hinhKH;
	private String gioiTinh;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getHinhKH() {
		return hinhKH;
	}
	public void setHinhKH(String hinhKH) {
		this.hinhKH = hinhKH;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	/**
	 * 
	 */
	public KhachHang(String makh,String ten, String diachi, String sdt, String hinh, String gioitinh) {
		// TODO Auto-generated constructor stub
		this.maKH = makh;
		this.tenKH = ten;
		this.diaChi = diachi;
		this.sdt = sdt;
		this.hinhKH = hinh;
		this.gioiTinh = gioitinh;
	}
	/**
	 * 
	 */
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
}
