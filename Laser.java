/*
    Da leider aufgrund eines unerklärlichen Fehlers das Laden von Bildern nicht funktioniert,
    wird für jedes Level passend zum Spaceship ein neuer Laser
    mit einem anderen Bild angesetzt (neues Objekt)
    Hier: Laser 1 im Level 1
*/

import greenfoot.*;

public class Laser extends Actor
{
    private int speed = 12;
    private int damage;

    public Laser(int damage)
    {
        this.damage = damage;
        //setImage("laser1.png");

        getImage().scale(98, 25); // Bildabmaße: 195, 50
    }

    public void act()
    {
        setLocation(getX(), getY() - speed); // Bewegung
        
        // Wenn außerhalb der Welt: Laser entfernen
        if (getY() < 0)
        {
            getWorld().removeObject(this);
            return;
        }

        checkCollision();
    }

    // Kollisionserkennung mit Asteroid
    private void checkCollision()
    {
        Asteroid asteroid = (Asteroid)getOneIntersectingObject(Asteroid.class);
        if (asteroid != null)
        {
            asteroid.takeDamage(damage);
            getWorld().removeObject(this);
        }
    }
}
