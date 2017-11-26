package br.com.petdelivery.servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import br.com.petdelivery.jdbc.dao.Raca_AnimalDAO;

public class JsonServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {

                String sportsName = request.getParameter("sportsName");
                System.out.println("Entrou no get: " + sportsName);
                String tipo = request.getParameter("id_tipo");
                System.out.println("Entrou no get: " + tipo);
                List<String> list = new ArrayList<String>();
                String json = null;

                if (sportsName.equals("Football")) {
                        list.add("Lionel Messi");
                        list.add("Cristiano Ronaldo");
                        list.add("David Beckham");
                        list.add("Diego Maradona");
                } else if (sportsName.equals("Cricket")) {
                        list.add("Sourav Ganguly");
                        list.add("Sachin Tendulkar");
                        list.add("Lance Klusener");
                        list.add("Michael Bevan");
                } else if (sportsName.equals("Select Sports")) {
                        list.add("Select Player");
                }
                
                JSONArray gson = new JSONArray();
        		gson.put(list);
        		try {
        		    System.err.println(gson.toString(2));		    
        		} catch (JSONException e) {
        		    e.printStackTrace();
        		}
        		
        		response.setContentType("application/json");
        	    response.setCharacterEncoding("UTF-8");

        	    String jsonString = gson.toString();		
        	    response.getWriter().write(jsonString.substring(1, jsonString.length()-1));
        	    /*
                json = new Gson().toJson(list);
                response.setContentType("application/json");
                response.getWriter().write(json);*/
        }
}
