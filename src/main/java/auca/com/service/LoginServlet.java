package auca.com.service;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform authentication and validation
        boolean isAuthenticated = authenticateUser(username, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            response.sendRedirect("admission-form.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

	// Implement user authentication logic (e.g., database lookup)
	private boolean authenticateUser(String username, String password) {
	    List<StudentCredentials> validCredentialsList = getValidStudentCredentials();

	    // Check if the entered username and password match any valid credentials
	    for (StudentCredentials credentials : validCredentialsList) {
	        if (credentials.getUsername().equals(username) && credentials.getPassword().equals(password)) {
	            return true; 
	        }
	    }

	    return false;
	}

	// Define a class to represent student credentials (username and password)
	class StudentCredentials {
	    private String username;
	    private String password;

	    public StudentCredentials(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }
	}

	// Simulate a list of valid student credentials (replace with database query)
	private List<StudentCredentials> getValidStudentCredentials() {
	    List<StudentCredentials> validCredentialsList = new ArrayList<>();
	    validCredentialsList.add(new StudentCredentials("demoUser", "demoPassword"));
	    validCredentialsList.add(new StudentCredentials("johnDoe", "secret123"));

	    return validCredentialsList;
	}


}
