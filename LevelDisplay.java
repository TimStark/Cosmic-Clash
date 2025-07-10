import greenfoot.*;

public class LevelDisplay extends Actor
{
    private int level;

    public LevelDisplay(int level)
    {
        this.level = level;
        updateLevel(level);
    }

    // Levelupdate
    public void updateLevel(int newLevel)
    {
        this.level = newLevel;
        GreenfootImage img = new GreenfootImage(150, 30);
        img.setColor(new greenfoot.Color(93, 226, 231));
        img.setFont(new Font("SansSerif", true, false, 24));
        img.drawString("Level: " + level, 30, 20);
        setImage(img);
    }
}
