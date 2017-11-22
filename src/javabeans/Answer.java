package javabeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Answer
  implements Serializable
{
  private String studyCode;
  private String quesId;
  private String email;
  private String choice;
  private Timestamp submissionDate;
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getQuesId()
  {
    return this.quesId;
  }
  
  public void setQuesId(String quesId)
  {
    this.quesId = quesId;
  }
  
  public String getStudyCode()
  {
    return this.studyCode;
  }
  
  public void setStudyCode(String studyCode)
  {
    this.studyCode = studyCode;
  }
  
  public String getChoice()
  {
    return this.choice;
  }
  
  public void setChoice(String choice)
  {
    this.choice = choice;
  }
  
  public Date getSubmissionDate()
  {
    return this.submissionDate;
  }
  
  public void setSubmissionDate(Timestamp submissionDate)
  {
    this.submissionDate = submissionDate;
  }
  
  public Answer(String studyCode, String email, Timestamp submissionDate, String choice, String quesId)
  {
    this.studyCode = studyCode;
    this.email = email;
    this.choice = choice;
    this.submissionDate = submissionDate;
    this.quesId = quesId;
  }
  
  public Answer() {}
}
