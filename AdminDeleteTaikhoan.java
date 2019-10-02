package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.bean.TaiKhoan;
import model.bo.TaiKhoanBO;


/**
 * Servlet implementation class AdminDeleteTaikhoan
 */
@WebServlet("/adminxoataikhoan")
public class AdminDeleteTaikhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteTaikhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONParser parse = new JSONParser();
		JSONArray list = new JSONArray();
		try {
			JSONObject t = (JSONObject) parse.parse(request.getParameter("matk"));
			System.out.println(t.get("MatKhau").toString());
			if(TaiKhoanBO.deleteTaiKhoan(t.get("MaTK").toString().trim())) {
				List <TaiKhoan> listtk = TaiKhoanBO.getAllTaiKhoan();
			    for(TaiKhoan item:listtk) {
				 JSONObject obj = new JSONObject();
		         obj.put("MaTK",item.getMaTK());
		         obj.put("TaiKhoan",item.getTaiKhoan());
		         obj.put("MatKhau", item.getMatKhau());
		         obj.put("Mail",item.getMail());
		         obj.put("MaQ",item.getMaQ());
		         list.add(obj);
			    }
			} else list=null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list=null;
		}
        PrintWriter out = response.getWriter();
        out.print(list);
//		doGet(request, response);
	}

}
