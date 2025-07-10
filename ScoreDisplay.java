import greenfoot.*;

public class ScoreDisplay extends Actor
{
    private int score;

    public ScoreDisplay(int score)
    {
        this.score = score;
        updateScore(score);
    }

    // Update des Scores
    public void updateScore(int newScore)
    {
        score = newScore;
        GreenfootImage img = new GreenfootImage(150, 30);
        img.setColor(greenfoot.Color.WHITE); //weiße Schrift
        img.setFont(new Font("SansSerif", true, false, 24)); // Fett, nicht kursiv
        img.drawString("Score: " + score, 0, 24);
        setImage(img);
    }
}
