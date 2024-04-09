package com.example.tomcattest;

import java.io.*;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "formChecker", value = "/form-checker")
public class FormChecker extends HttpServlet {
    private PrintWriter pw;
    @Override
    public void init() throws ServletException {
        try {
            pw = new PrintWriter(new FileWriter("form.csv", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] strings : parameters.values()) {
            String string = strings[0];
            stringBuilder.append(string);
            stringBuilder.append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        pw.println(stringBuilder);
        pw.flush();
        resp.sendRedirect("/");
    }
}
