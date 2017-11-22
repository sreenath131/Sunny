package Database;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.User;

public class UserDB
{
  public static boolean selectUser(String email, String pwd)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement pstatement = null;
    
    System.out.println(email);
    System.out.println(pwd);
    String query = "select * FROM user WHERE username = ? and password = ?";
    try
    {
      pstatement = connection.prepareStatement(query);
      pstatement.setString(1, email);
      pstatement.setString(2, pwd);
      ResultSet rs = pstatement.executeQuery();
      if (rs.next()) {
        return true;
      }
    }
    catch (SQLException e)
    {
      System.out.println(e);
      return false;
    }
    finally
    {
      DBUtil.closePreparedStatement(pstatement);
      pool.freeConnection(connection);
    }
    return false;
  }
  
  public static User getUser(String email)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query = "SELECT * from user WHERE username = ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      rs = ps.executeQuery();
      if (rs.next())
      {
        User user = new User();
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("username"));
        user.setUserType(rs.getString("type"));
        user.setNumPostedStudies(rs.getInt("studies"));
        user.setNumParticipation(rs.getInt("participation"));
        user.setNumCoins(rs.getInt("coins"));
        return user;
      }
    }
    catch (SQLException e)
    {
      User localUser1;
      System.out.println(e);
      return null;
    }
    finally
    {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
    return null;
  }
  
  public static List<User> getUsers()
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<User> users = new ArrayList();
    String query = "SELECT * from user ";
    try
    {
      ps = connection.prepareStatement(query);
      rs = ps.executeQuery();
      while (rs.next())
      {
        User user = new User();
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("username"));
        user.setUserType(rs.getString("type"));
        user.setNumPostedStudies(rs.getInt("studies"));
        user.setNumParticipation(rs.getInt("participation"));
        user.setNumCoins(rs.getInt("coins"));
        users.add(user);
      }
    }
    catch (SQLException e)
    {
      System.out.println(e);
      return null;
    }
    finally
    {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
    return users;
  }
  
  public static int addUser(User user)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement pstatement = null;
    System.out.print("yes gets here");
    String query = "INSERT INTO user (username, password, type, studies, participation, coins, name) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try
    {
      pstatement = connection.prepareStatement(query);
      pstatement.setString(1, user.getEmail());
      pstatement.setString(2, user.getPassword());
      pstatement.setString(3, user.getUserType());
      pstatement.setInt(4, user.getNumPostedStudies());
      pstatement.setInt(5, user.getNumParticipation());
      pstatement.setInt(6, user.getNumCoins());
      pstatement.setString(7, user.getName());
      return pstatement.executeUpdate();
    }
    catch (SQLException e)
    {
      System.out.println(e);
      return 0;
    }
    finally
    {
      DBUtil.closePreparedStatement(pstatement);
      pool.freeConnection(connection);
    }
  }
  
  public static void updateUserParticipation(String email, int participationNumber)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement pstatement = null;
    System.out.println("update the user here with email");
    System.out.println(email);
    System.out.println(participationNumber);
    String query = "UPDATE user SET Participation = ? WHERE username = ? ";
    try
    {
      pstatement = connection.prepareStatement(query);
      pstatement.setInt(1, participationNumber);
      pstatement.setString(2, email);
      pstatement.executeUpdate();
    }
    catch (SQLException e)
    {
      System.out.println(e);
    }
    finally
    {
      DBUtil.closePreparedStatement(pstatement);
      pool.freeConnection(connection);
    }
  }
  
  public static void updateUserCoins(String email, int numcoins)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement pstatement = null;
    System.out.println(email);
    System.out.println(numcoins);
    String query = "UPDATE user SET coins = ? WHERE username = ? ";
    try
    {
      pstatement = connection.prepareStatement(query);
      pstatement.setInt(1, numcoins);
      pstatement.setString(2, email);
      pstatement.executeUpdate();
    }
    catch (SQLException e)
    {
      System.out.println(e);
    }
    finally
    {
      DBUtil.closePreparedStatement(pstatement);
      pool.freeConnection(connection);
    }
  }
}
