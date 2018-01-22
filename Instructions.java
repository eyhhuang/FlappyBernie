import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write Brief description of game on background
 * 
 * @author Emily Huang 
 * @version 15 - 01 - 17
 */
public class Instructions extends Actor
{
    public Instructions()
    {
        //set font colour and size and text
        Color lgreen = new Color(131, 188, 91, 160);
        setImage(new GreenfootImage("Help Bernie Save The World! Press SPACE to boost" , 55, Color.white, lgreen));
    }
}
