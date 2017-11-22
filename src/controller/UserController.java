package controller;

import Database.StudyDB;
import Database.UserDB;
import java.io.IOException;
import java.net.InetAddress;
import javabeans.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/UserController"})
public class UserController
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    HttpSession session = request.getSession();
    
    String url = "/home.jsp";
    String action = request.getParameter("action");
    if ((action == null) || (action.equals("")) || (action.isEmpty()))
    {
      url = "/home.jsp";
      InetAddress local = InetAddress.getLocalHost();
      Cookie c = new Cookie("host", local.toString());
      Cookie c1 = new Cookie("port", request.getServerPort() + "");
      c.setMaxAge(315360000);
      c1.setMaxAge(315360000);
      response.addCookie(c);
      response.addCookie(c1);
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
        response.setIntHeader("Refresh", 1);
      }
    }
    else
    {
      if (action.equals("login"))
      {
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        if (UserDB.selectUser(email, pwd))
        {
          User user = UserDB.getUser(email);
          String userType = user.getUserType();
          if (userType.equalsIgnoreCase("Participant"))
          {
            session.setAttribute("theUser", user);
            int participants = StudyDB.getParticipants(user.getEmail());
            session.setAttribute("par", Integer.valueOf(participants));
            url = "/main.jsp";
          }
          else if (userType.equalsIgnoreCase("Admin"))
          {
            session.setAttribute("theAdmin", user);
            url = "/admin.jsp";
          }
        }
        else
        {
          request.setAttribute("msg", "Incorrect Username or Password.Please try again.");
          url = "/login.jsp";
        }
      }
      if (action.equals("create"))
      {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String cPassword = request.getParameter("confirm_password");
        if (UserDB.getUser(email) != null)
        {
          request.setAttribute("msg", "The Email id is already registerd");
          request.setAttribute("email", email);
          request.setAttribute("name", name);
          url = "/signup.jsp";
        }
        else if (!password.equals(cPassword))
        {
          request.setAttribute("msg", "Incorrect Passwords dont match.");
          request.setAttribute("email", email);
          request.setAttribute("name", name);
          url = "/signup.jsp";
        }
        else
        {
          User user = new User(name, email, "Participant", password, cPassword, 0, 0, 0);
          int participants = StudyDB.getParticipants(user.getEmail());
          session.setAttribute("par", Integer.valueOf(participants));
          UserDB.addUser(user);
          session.setAttribute("theUser", user);
          url = "/main.jsp";
        }
      }
      if (action.equals("how")) {
        if ((session.getAttribute("theUser") != null) || (session.getAttribute("theAdmin") != null)) {
          url = "/main.jsp";
        } else {
          url = "/how.jsp";
        }
      }
      if (action.equals("about")) {
        if ((session.getAttribute("theUser") != null) || (session.getAttribute("theAdmin") != null)) {
          url = "/aboutl.jsp";
        } else {
          url = "/about.jsp";
        }
      }
      if (action.equals("home")) {
        if ((session.getAttribute("theUser") != null) || (session.getAttribute("theAdmin") != null)) {
          url = "/main.jsp";
        } else {
          url = "/home.jsp";
        }
      }
      if (action.equals("main")) {
        if ((session.getAttribute("theUser") != null) || (session.getAttribute("theAdmin") != null)) {
          url = "/main.jsp";
        } else {
          url = "/login.jsp";
        }
      }
      if (action.equals("logout"))
      {
        if ((session.getAttribute("theUser") != null) || (session.getAttribute("theAdmin") != null)) {
          session.invalidate();
        }
        url = "/home.jsp";
      }
    }
    getServletContext().getRequestDispatcher(url).forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}
