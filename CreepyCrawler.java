public abstract class CreepyCrawler implements Comparable{

  private int hp;

  /**
  Default constructor.
  Initializes a CreepyCrawler with initial max hit points
  @param maxHP - the maximum number of hit points of this CreepyCrawler
  **/
  public CreepyCrawler(int maxHp){
    this.hp = maxHp;
  }

  /**
  Cloning constructor.
  Initializes a CreepyCrawler by cloning the given CreepyCrawler
  @param c - the target CreepyCrawler, i.e. the one to clone
  **/
  public CreepyCrawler(CreepyCrawler c){
    if(c != null){
      this.hp = c.hp;
    }
  }


  /**
  gets the current HP of this object
  @return the hp as an integer
  **/
  public int getHp(){
    return hp;
  }
  

  /**
  returns the string representation of this CreepyCrawler
  **/
  @Override
  public String toString(){
    return "Hp: " + this.hp;
  }

  /**
  classifies two CreepyCrawler objects to be equal 
  if they have the same number of hit points
  @other - Object to be compared to this CreepyCrawler
  @return true, if other is of the type CreepyCrawler and has the same number of hit points as this CreepyCrawler
  **/
  @Override
  public boolean equals(Object other){
    if(!(other instanceof CreepyCrawler)){
      return false;
    }
    CreepyCrawler otherCrawler = (CreepyCrawler) other;
    return this.hp == otherCrawler.hp;
  }

  /**
  compares this CreepyCrawler to another by means of their hit points
  @param other - Object representing the other CreepyCrawler
  @return a negative number if this CreepyCrawler has less hit points than other, a positive number if this CreepyCrawler has more hit points, 0 if they have the same number of hit points
  **/
  @Override
  public int compareTo(Object other){
    CreepyCrawler otherCrawler = (CreepyCrawler) other;
    if( this.hp < otherCrawler.hp){ return -1; }
    else if ( this.hp > otherCrawler.hp) { return 1; }
    else { return 0;}
  
  }

  /**
  abstract method must be implemented in the subclasses so that they return a clone of this object.
  **/
  public abstract CreepyCrawler clone();
}