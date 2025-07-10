import greenfoot.*;

public class GameOverScreen extends Actor
{
    public GameOverScreen(int finalScore)
    {
        GreenfootImage img = new GreenfootImage(600, 800);
        
        // Hintergrund
        img.setColor(greenfoot.Color.BLACK);
        img.fill();
        
        // Schrift
        img.setColor(greenfoot.Color.RED);
        img.setFont(new Font("SansSerif", true, false, 48));
        img.drawString("GAME OVER", 170, 400); //70, 60

        img.setFont(new Font("SansSerif", true, false, 32));
        img.drawString("Final Score: " + finalScore, 200, 450); //100, 110
        setImage(img);
    }
}
