import greenfoot.*;

public class Asteroid extends Actor
{
    private int size; // Größe, in dieser Version aber nicht benutzt
    private int speed; // Geschwindigkeit
    private int directionX; //Richtung

    public Asteroid(int size, int speed)
    {
        this.size = size;
        this.speed = speed;

        //setImage("asteroid.png");
        getImage().scale(62, 62); // Verkleinern auf passende Größe
        
        directionX = Greenfoot.getRandomNumber(3) - 1; // seitliche Bewegung
    }

    public void act()
    {
        setLocation(getX() + directionX, getY() + speed); // Bewegung

        if (getY() > getWorld().getHeight() - 40)
        {
            SpaceWorld world = (SpaceWorld)getWorld();
            world.loseLife();
            getWorld().removeObject(this);
            return;
        }

        // Weltgrenzen seitlich beachten (bei Bewegung)
        if (getX() <= 20 || getX() >= getWorld().getWidth() - 20)
        {
            directionX = -directionX;
        }
    }

    // bei Treffen mit Laser: Score erhöhen und Asteroid entfernen
    public void takeDamage(int dmg)
    {
        SpaceWorld world = (SpaceWorld)getWorld();
        world.addScore(1); // Immer score++ pro Treffer
        getWorld().removeObject(this); // Asteroid sofort zerstören
    }
}
