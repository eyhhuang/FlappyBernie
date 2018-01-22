import greenfoot.*;  
import java.awt.Color;
import java.awt.Font;
/**
 * keeps active and aesthetically pleasing score on top left corner
 * 
 * @author Emily Huang 
 * @version 19 - 01 - 17
 */
public class Score extends Actor
{
    public Score()
    {
        GreenfootImage newImage = new GreenfootImage(100,50);
        setImage(newImage);
       
    }
    
    public void setScore(int score)
    {
        GreenfootImage newImage = getImage();
        newImage.clear();
        //set specific background color
        Color lgreen = new Color(131, 188, 91, 160);
        newImage.setColor(lgreen);
        newImage.fill();
        
        //set specific font and text color
        Font f = new Font("Cooper Black", Font.BOLD, 38);
        newImage.setFont(f);      
        newImage.setColor(Color.white);
        
        //refer to score counter from world
        newImage.drawString("" + score, 40, 35);
        setImage(newImage);
    } 
    

}
