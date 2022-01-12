import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class CrawlerTriviaUtil{
  

      /**
      randomly picks a Trivia question from the question bank and assigns to it some random number of points worth.  
      @return a Question object representing the Trivia question
      **/
      public static Question generateQuestion() throws FileNotFoundException
      {

        File file = new File("trivia_questions.txt");
        Scanner fileReader = new Scanner(file);

        Random rand = new Random();
        int r = rand.nextInt(127202);
        
        String q = "";
        for (int i = 0; i < r; i++){
          q = fileReader.nextLine();
        }
        String[] questionAnswer = q.split("@", 0);
        
        r = rand.nextInt(51) + 50;
        fileReader.close();
        return new Question(questionAnswer[0], questionAnswer[1], r );


      }

      /**
      generates a clone of a CreepyCrawler selected randomly from the given list.
      @param crawlers - an ArrayList of CreepyCrawler objects
      @return a clone of an object from the given list
      **/
      public static CreepyCrawler generateClone(ArrayList<CreepyCrawler> crawlers){
        // FIXME: IMPLEMENT THIS METHOD
        CreepyCrawler man = crawlers.get((int)(Math.random() * crawlers.size()));
        CreepyCrawler crawl = man.clone();
        return crawl;
      }

      /**
      prints the CreepyCrawler objects in the given list
      @param crawlers - the ArrayList to print
      **/
      public static void printCrawlers(ArrayList<CreepyCrawler> crawlers){
          for(CreepyCrawler c : crawlers){
            System.out.println(c);
          }
      }
      
      /**
      finds and returns the CreepyCrawler with the smallest number of hit points in the given list
      @param crawlers - an ArrayList of CreepyCrawler objects
      @return the min element of the list
      **/
      public static CreepyCrawler getMinCrawler(ArrayList<CreepyCrawler> crawlers){
          int index = 0;
          if (crawlers.size() > 1){
            for (int i = 1; i < crawlers.size(); i++)
            {
              if (crawlers.get(i).getHp() < crawlers.get(index).getHp()){
                index = i;
              }
            }
            return crawlers.get(index);
          }
          else{
            return crawlers.get(0);
          }
      }

      

  
}