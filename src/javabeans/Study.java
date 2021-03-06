package javabeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Study
  implements Serializable
{
  private String studyName;
  private String studyCode;
  private Timestamp dateCreated;
  private String email;
  private String question;
  private int requestedParticipants;
  private int numOfParticipants;
  private String description;
  private String status;
  private String answerType;
  private List answers;
  private String imageURL;
  
  public Study(String studyName, String email, String question, int requestedParticipants, int numOfParticipants, String description, List answers, String studyCode, String status)
  {
    this.studyName = studyName;
    this.email = email;
    this.question = question;
    this.requestedParticipants = requestedParticipants;
    this.numOfParticipants = numOfParticipants;
    this.description = description;
    this.answers = answers;
    this.studyCode = studyCode;
    this.status = status;
  }
  
  public String getStudyName()
  {
    return this.studyName;
  }
  
  public void setStudyName(String studyName)
  {
    this.studyName = studyName;
  }
  
  public void setImageURL(String imageURL)
  {
    this.imageURL = imageURL;
  }
  
  public String getStudyCode()
  {
    return this.studyCode;
  }
  
  public void setStudyCode(String studyCode)
  {
    this.studyCode = studyCode;
  }
  
  public Timestamp getDateCreated()
  {
    return this.dateCreated;
  }
  
  public void setDateCreated(Timestamp dateCreated)
  {
    this.dateCreated = dateCreated;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getQuestion()
  {
    return this.question;
  }
  
  public void setQuestion(String question)
  {
    this.question = question;
  }
  
  public int getRequestedParticipants()
  {
    return this.requestedParticipants;
  }
  
  public void setRequestedParticipants(int requestedParticipants)
  {
    this.requestedParticipants = requestedParticipants;
  }
  
  public int getNumOfParticipants()
  {
    return this.numOfParticipants;
  }
  
  public void setNumOfParticipants(int numOfParticipants)
  {
    this.numOfParticipants = numOfParticipants;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getAnswerType()
  {
    return this.answerType;
  }
  
  public void setAnswerType(String answerType)
  {
    this.answerType = answerType;
  }
  
  public List getAnswers()
  {
    return this.answers;
  }
  
  public void setAnswers(List answers)
  {
    this.answers = answers;
  }
  
  public Study(String studyName, String studyCode, Timestamp dateCreated, String email, String question, int requestedParticipants, int numOfParticipants, String description, String status, String answerType, List answers)
  {
    this.studyName = studyName;
    this.studyCode = studyCode;
    this.dateCreated = dateCreated;
    this.email = email;
    this.question = question;
    this.requestedParticipants = requestedParticipants;
    this.numOfParticipants = numOfParticipants;
    this.description = description;
    this.status = status;
    this.answerType = answerType;
    this.answers = answers;
  }
  
  public Study() {}
  
  public String toString()
  {
    return "Study [studyName=" + this.studyName + ", studyCode=" + this.studyCode + ", dateCreated=" + this.dateCreated + ", email=" + this.email + ", question=" + this.question + ", requestedParticipants=" + this.requestedParticipants + ", numOfParticipants=" + this.numOfParticipants + ", description=" + this.description + ", status=" + this.status + ", answerType=" + this.answerType + ", answers=" + this.answers + "]";
  }
  
  public String getImageURL()
  {
    if (getStudyCode().startsWith("XY")) {
      return "images/computer.jpg";
    }
    if (getStudyCode().startsWith("X")) {
      return "images/computer.jpg";
    }
    return "images/mind.jpg";
  }
  
  public void getAverage() {}
  
  public void getMinimum() {}
  
  public void getMaximum() {}
  
  public void getSD() {}
}
