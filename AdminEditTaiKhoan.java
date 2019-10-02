package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiKhoan;
import model.bo.TaiKhoanBO;

/**
 * Servlet implementation class AdminEditTaiKhoan
 */
@WebServlet("/adminchinhsuataikhoan")
public class AdminEditTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditTaiKhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TaiKhoan tk = TaiKhoanBO.findTaiKHoanMatk(request.getParameter("matk"));
		request.setAttribute("matk", tk.getMaTK());
		request.setAttribute("tentk", tk.getTaiKhoan());
		request.setAttribute("matkhau", tk.getMatKhau());
		request.setAttribute("mail", tk.getMail());
		request.setAttribute("maquyen", tk.getMaQ());
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/chinhsuataikhoan.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaiKhoan tk = new TaiKhoan();
		tk.setMaTK(request.getParameter("matk"));
		tk.setTaiKhoan(request.getParameter("tentk"));
		tk.setMatKhau(request.getParameter("matkhau"));
		tk.setMail(request.getParameter("mail"));
		tk.setMaQ(request.getParameter("maquyen"));
		if(TaiKhoanBO.updateTaiKhoan(tk)){
			request.setAttribute("message","Cập nhật dữ liệu thành công");
		}
		else {
			request.setAttribute("message", "Thao tác không thành công");
			request.setAttribute("matk", request.getParameter("matk"));
			request.setAttribute("tentk", request.getParameter("tentk"));
			request.setAttribute("matkhau", request.getParameter("matkhau"));
			request.setAttribute("mail", request.getParameter("mail"));
			request.setAttribute("maquyen", request.getParameter("maquyen"));
		}
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/chinhsuataikhoan.jsp");
		rd.forward(request, response);
	}

}
