import greenfoot.*;

public class HealthDisplay extends Actor
{
    private int lives; //Leben

    public HealthDisplay(int lives)
    {
        this.lives = lives;
        updateHealth(lives);
    }

    public void updateHealth(int newLives)
    {
        this.lives = newLives;
        GreenfootImage img = new GreenfootImage(180, 30);
        img.setColor(greenfoot.Color.RED);
        img.setFont(new Font("SansSerif", true, false, 24));
        
        // Je nach Anzahl Leben bestimmte Anzahl an Herzen
        String hearts = "";
        for (int i = 0; i < lives; i++)
        {
            hearts += "♥ ";
        }
        img.drawString("Leben: " + hearts, 5, 20); // je nach PC anpassen (bei Windows evtl. "30, 20"), hier von MacOS mit "5, 20" ausgegangen
        setImage(img);
    }
}
