import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manages objects in Flappy Bernie
 * 
 * @author Emily Huang
 * @version 19 - 01 - 17
 */
public class BernieWorld extends World
{
   int PIPE_SPACING = 175;
   int dollarCounter = 0;
   int bernieCounter = 0;
   int score = 0;
   int FIRST_DOLLAR = 230;
   Score scoreObj = null;
    /**
     * Constructor for objects of class BernieWorld.
     * 
     */
    public BernieWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 2x2 pixels.
        super(600, 400, 2, false);
        
        //Set display order / layer order of objects 
        setPaintOrder(Score.class, GameOverPipe.class, GameOverBound.class, BernieFlappy.class, DollarBarrier.class);
        
        //add bernie character and set location
        BernieFlappy bernie = new BernieFlappy();
        addObject(bernie, 100, getHeight()/2);
        
        //add score counter
        scoreObj = new Score();
        scoreObj.setScore(0);
        addObject(scoreObj,40, 25);
        
        //add background description
        Instructions instructions = new Instructions();
        addObject(instructions, getWidth()/2, getHeight()/2);
        
        //add background music
              
        
    }
    
    public void act()
    {   
        //keep track of when to make new pipes
        dollarCounter++;
        if(dollarCounter %100 == 0)
        {
            makePipe();
            
        }
        
        if(dollarCounter >= FIRST_DOLLAR)
        {
            if(bernieCounter %100 == 0)
            {
                score++;
                Greenfoot.playSound("Ding Sound Effect.mp3");
                scoreObj.setScore(score);
            }
            bernieCounter++;
        }
    }
    
    private void makePipe()
    {
            //create bottom dollar pipe and randomize length
            DollarBarrier dollarb = new DollarBarrier();           
            GreenfootImage imageb = dollarb.getImage();   
            addObject(dollarb, getWidth(), getHeight() + imageb.getWidth()/2 + Greenfoot.getRandomNumber(dollarb.getImage().getWidth()*7/10)); 
            
            //create top dollar pipe while keeping distance between top and bottom the same
           DollarBarrier dollart = new DollarBarrier();            
           GreenfootImage imaget = dollart.getImage();
           addObject(dollart, dollarb.getX(), dollarb.getY() - imageb.getHeight()/2 - PIPE_SPACING); 
        
    }
    
}
