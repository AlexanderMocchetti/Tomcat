package com.example.tomcattest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "loginChecker", value = "/login-checker")
public class LoginChecker extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email, password;
        email = req.getParameter("email");
        password = req.getParameter("password");
        String message;
        if (isValidLogin(email, password)) {
            message = "Valid login";
        } else {
            message = "Invalid login";
        }
        resp.sendRedirect("login.jsp?message=" + java.net.URLEncoder.encode(message, StandardCharsets.UTF_8));
    }

    private boolean isValidLogin(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/alexandermocchetti/form.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parameters = line.split(",");
                String fileEmail = parameters[2];
                String filePassword = parameters[3];
                if (email.equals(fileEmail) && password.equals(filePassword))
                    return true;
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
