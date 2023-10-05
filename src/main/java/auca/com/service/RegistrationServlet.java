package auca.com.service;

import com.auca.models.Student;

import java.util.ArrayList;
import java.util.List;

//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<Student> studentList = new ArrayList<>();
	
	
	
	
    public RegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// retrieve registration form parameters
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        Part filePart = request.getPart("profilePicture");
        
        // validation
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || filePart == null) {
            response.sendRedirect("error.jsp");
            return;
        }
        
        
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] profilePicture = outputStream.toByteArray();
        
        
        // create a new student object 
        Student student = new Student (firstName, lastName, email, profilePicture);
        
        // add the student to the list
        studentList.add(student);
        
        // Redirect to a registration success page or display a success message
        response.sendRedirect("registration_success.jsp");
	}

}
