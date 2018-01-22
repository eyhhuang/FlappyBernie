import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls movements of game character bernie
 * 
 * @Emily Huang  
 * @16-01-17
 */
public class BernieFlappy extends Actor

{
 
    public BernieFlappy()
    {
        //change size of bernie so he fits on screen
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
    }
    
    //falling speed
    double dy = 0;
    
    //simulated gravitational acceleration
    double g = 0.8;
    
    //how much bernie is boosted up by each space bar
    double UP_BOOST = -5;
    
    /**
     * Act - do whatever the BernieFlappy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        gameOverBound();
        gameOverPipe();
        rotateBernie();
        setLocation( getX(), (int)(getY() + dy));    
        move();      
        fall();
    }    
       private void rotateBernie()
       {
        //bernie changes angles depending on falling speed (dy)
        if(dy >= -6 && dy < 7)
        {
            setRotation(330);
        }
        
        else if(dy >= 7 && dy < 16)
        {
            setRotation(0);
        }
        
        else
        {
            setRotation(30);
        }
    }
    
    private void gameOverPipe()
    {
        //if bernie touches pipe then he dies
        if(getOneIntersectingObject(DollarBarrier.class) != null)
        {
            GameOverPipe gameEnd = new GameOverPipe();
            getWorld().addObject(gameEnd, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    private void gameOverBound()
    {
        //if bernie touches the bottom or top of the screen then he dies
        if (getY() > getWorld().getHeight() || getY() < 0)
        {
            GameOverBound gameOver = new GameOverBound();
            getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    private void move()
    {  //If user presses space bar, bernie moves up        
        if(Greenfoot.isKeyDown("space"))
        {
            dy = UP_BOOST;
        }
    }
    
    private void fall()
    {   //accounnt for gravitational acceleration to increasing falling speed
        dy += g;
    }
}
