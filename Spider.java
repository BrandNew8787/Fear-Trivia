import java.util.Random;

/**
This class is a child class of CreepyCrawler and 
represents a Spider with randomly selected String name
**/
public class Spider extends CreepyCrawler
{
  private String name;

  /**
  Initializes a Centipede with random HP in the range 80 - 100
  and randomly generated name.
  **/
  public Spider(){
    super(Spider.generateHP());
    this.name = Spider.generateType() + " Spider";
  }

  public Spider(Spider s){
    super(s);
    this.name = s.name;
  }

  //FIXME: IMPLEMENT THE REST OF THIS CLASS
  public boolean equals (Object o){
    if (this == o){
      return true;
    }
    if (!super.equals(o)){
      return false;
    }
    if (getClass() != o.getClass()){
      return false;
    }
    Spider s = (Spider) o;
    return getHp() == s.getHp();
  }

  public CreepyCrawler clone(){
    return new Spider(this);
  }

  /**
  returns the String representation of this Spider
  **/
  public String toString(){
    
    return String.format("Name: %-20s%-20s%-10s", this.name, super.toString(), "\uD83D\uDD77\n" );
  }

  // returns a random integer in the range 80 - 100
  private static int generateHP(){
    // FIXME: Implement this static helper
    return (int)((Math.random()*30) + 90);

  }

  // returns a randomly selected type of Spider
  private static String generateType(){
    String[] spiderTypes = {"Tarantula", "Wolf", "Jumping", "Grass", "Orb"};
    Random rand = new Random();
    int idx = rand.nextInt(spiderTypes.length);
    return spiderTypes[idx];
  }
}