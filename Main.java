import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;

class Main {

  public static Scanner in = new Scanner(System.in);


  
  public static void main(String[] args) throws FileNotFoundException
  {
      int points = 0;
      String play;

      ArrayList<CreepyCrawler> crawlers = new ArrayList<CreepyCrawler>();
      ArrayList<Question> answeredQuestions = new ArrayList<Question>();
      crawlers.add(new Spider());
      crawlers.add(new Centipede());
      crawlers.add(new Spider());
      crawlers.add(new Centipede());
      System.out.println("You have been placed in a coffin with the following creepy crawlers:");

      CrawlerTriviaUtil.printCrawlers(crawlers);

      System.out.println("The only way to escape the coffin is if you earn enough hit points to kill each crawler.  \nAnswer the trivia questions to earn a random number of points but BEWARE! \nIf you answer incorrectly, a crawler will clone!");


      System.out.println();

      do{
        System.out.println("\n===================================================");
        System.out.println("Question: ");
        Question q;
        
        do{
          q = CrawlerTriviaUtil.generateQuestion();
        }while(answeredQuestions.contains(q));
        
        q.displayQuestion();

        System.out.print("\nYour answer: ");
        String response = in.nextLine().trim();
        int answer = q.checkResponse(response);
        if(answer != 0){
          System.out.println("That's correct! You recieved " + answer + " points!");
          points += answer;
          answeredQuestions.remove(q);
          if(CrawlerTriviaUtil.getMinCrawler(crawlers).getHp() < points){
            points -= CrawlerTriviaUtil.getMinCrawler(crawlers).getHp();
            System.out.println("You earned enough points to kill a crawler. You killed a crawler!!!");
            crawlers.remove(CrawlerTriviaUtil.getMinCrawler(crawlers)); 
            CrawlerTriviaUtil.printCrawlers(crawlers);
          }
        }
        else{
          System.out.println("OOF! Your answer was wrong! A crawler has multiplied!");
          crawlers.add(CrawlerTriviaUtil.generateClone(crawlers));
          CrawlerTriviaUtil.printCrawlers(crawlers);
        }
        if (crawlers.size() == 0){
          System.out.println("All of the crawlers are dead... You Win!!!");
          break;
        }
        System.out.print("\nKeep playing? Y/N: ");
        play = in.nextLine().trim();
      }while(!play.equalsIgnoreCase("N") && crawlers.size() != 0);



  }
}