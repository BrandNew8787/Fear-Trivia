public class Question{

  private String question;
  private String answer;
  private int pointsWorth;
  private String response;
  private boolean isCorrect;
  
  /**
  Initializes a Question with given question statement, answer, and points worth.
  **/
  public Question(String question, String answer, int pointsWorth){
    this.question = question;
    this.answer = answer;
    this.pointsWorth = pointsWorth;
    this.response = "Not responded";
    this.isCorrect = false;
  }

  /**
  checks to see if a response is correct. If the response is correct,
  the number of points this Question is worth will be returned.  
  Otherwise, 0 will be returned
  @param response - the response to be checked, as a String
  @return a positive integer if the response is correct, 0 otherwise.
  **/
  public int checkResponse(String response){
      this.response = response;
      if( this.answer.equalsIgnoreCase(response)) //You can change this line to be: response.contains(this.answer)
      {
        this.isCorrect = true;
        return this.pointsWorth;
      }
      else{
        return 0;
      }
  } 

  /**
  gets the correct answer to this Question
  @return the correct answer as a String
  **/
  public String getAnswer(){
    return this.answer;
  }

  /**
  Displays the String representation of this Question 
  **/
  public void displayQuestion(){
    System.out.println(this.question);
  }

  /**
  returns the String representation of this Question, which includes the statement, the response, the correct answer, and the points earned
  **/
  public String toString(){
    String questionStr = "\n===============================================\n";
    questionStr += "Q: " + this.question;
    questionStr += "\nYour response: " + this.response;
    questionStr += "\nCorrect answer: " + this.answer;
    if(isCorrect){
      questionStr += "\nEarned pts.: " + this.pointsWorth + "/" + this.pointsWorth;
    }
    else{
      questionStr += "\nEarned pts.: 0/" + this.pointsWorth;
    }
    return questionStr;
  }

}