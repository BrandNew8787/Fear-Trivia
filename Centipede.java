import java.util.Random;
/**
This class is a child class of CreepyCrawler and 
represents a Centipede with given String name "Centipede"
**/
public class Centipede extends CreepyCrawler
{

  private String name;

  /**
  Initializes a Centipede with random HP in the range 90 - 120
  and name "Centipede"
  **/
  public Centipede(){
    super(Centipede.generateHP());
    this.name = "Centipede";
  }
 
  public Centipede(Centipede c){
    super(c);
    this.name = c.name;
  }
 
  @Override
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
    Centipede c = (Centipede) o;
    return getHp() == c.getHp();
  }

  @Override
  public CreepyCrawler clone(){
    return new Centipede(this);
  }

  public String toString(){
    return String.format("Name: %-20s%-20s%-10s", this.name, super.toString(), "\uD83D\uDC1B\n" );
  }

  // returns a random integer in the range 90 - 120
  private static int generateHP(){
    // FIXME: Implement this static helper
    return (int)((Math.random()*30) + 90);

  }
  
}