package javabeans;

import java.io.Serializable;

public class User
  implements Serializable
{
  private String name;
  private String email;
  private String userType;
  private String password;
  private String confirmPassword;
  private int numCoins;
  private int numPostedStudies;
  private int numParticipation;
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getConfirmPassword()
  {
    return this.confirmPassword;
  }
  
  public void setConfirmPassword(String confirmPassword)
  {
    this.confirmPassword = confirmPassword;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getUserType()
  {
    return this.userType;
  }
  
  public void setUserType(String userType)
  {
    this.userType = userType;
  }
  
  public int getNumCoins()
  {
    return this.numCoins;
  }
  
  public void setNumCoins(int numCoins)
  {
    this.numCoins = numCoins;
  }
  
  public int getNumPostedStudies()
  {
    return this.numPostedStudies;
  }
  
  public void setNumPostedStudies(int numPostedStudies)
  {
    this.numPostedStudies = numPostedStudies;
  }
  
  public int getNumParticipation()
  {
    return this.numParticipation;
  }
  
  public void setNumParticipation(int numParticipation)
  {
    this.numParticipation = numParticipation;
  }
  
  public User() {}
  
  public User(String name, String email, String userType, String password, String confirmPassword, int numCoins, int numPostedStudies, int numParticipation)
  {
    this.name = name;
    this.email = email;
    this.userType = userType;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.numCoins = numCoins;
    this.numPostedStudies = numPostedStudies;
    this.numParticipation = numParticipation;
  }
  
  public User(String name, String email, String userType)
  {
    this.name = name;
    this.email = email;
    this.userType = userType;
  }
  
  public String toString()
  {
    return "User [name=" + this.name + ", email=" + this.email + ", userType=" + this.userType + ", numCoins=" + this.numCoins + ", numPostedStudies=" + this.numPostedStudies + ", numParticipation=" + this.numParticipation + "]";
  }
}
