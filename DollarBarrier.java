import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  dollar bill barrier 
 * 
 * @author Emily Huang
 * @version 19 - 01 - 17
 */
public class DollarBarrier extends Actor 
{
    public DollarBarrier()
    {
        //change size of actor
        GreenfootImage image = getImage();
        image.scale(image.getWidth()*2/3, image.getHeight()*2/3);
        setImage(image);
    }
    int PIPE_SPEED = -3;
             

    public void act() 
    {
        // allows dollar to move to the back of the screen
        
        setLocation(getX()+ PIPE_SPEED, getY());
        
    }  
}
