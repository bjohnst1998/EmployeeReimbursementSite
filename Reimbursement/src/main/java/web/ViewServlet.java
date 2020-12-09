package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.BreakStatement;

import model.User;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = req.getSession();
		User u = (User)ses.getAttribute("user");
		System.out.println("URI: " +req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/Reimbursement/view/all":
			if(u.getUserRole().getId() ==2)
			{
				ReimbursementController.viewAll(req, resp);
			}

			break;
		case "/Reimbursement/view/current":
		ReimbursementController.viewCurrent(req, resp);
		break;
		
		case "/Reimbursement/view/user":
			if(u.getUserRole().getId() ==2)
			{
				ReimbursementController.viewUser(req, resp);
			}			
			break;
		case"/Reimbursement/view/approve":
			if(u.getUserRole().getId()==2)
			{
				ReimbursementController.approveReim(req, resp);
			}
			break;
		case"/Reimbursement/view/deny":
			if(u.getUserRole().getId()==2)
			{
				ReimbursementController.denyReim(req, resp);
			}
			break;
		case "/Reimbursement/view/update":
			ReimbursementController.updateProfile(req,resp);
			break;
		case "/Reimbursement/view/allEmp":
			ReimbursementController.viewAllEmployees(req, resp);
			break;
		case "/Reimbursement/view/currentEmp":
			ReimbursementController.viewCurrentEmployee(req, resp);
			break;
		case "/Reimbursement/view/userEmp":
			ReimbursementController.viewUserEmployee(req, resp);
			break;
		default:
			break;
		}
	}

}
