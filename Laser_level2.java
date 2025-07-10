/*
    Da leider aufgrund eines unerklärlichen Fehlers das Laden von Bildern nicht funktioniert,
    wird für jedes Level passend zum Spaceship ein neuer Laser
    mit einem anderen Bild angesetzt (neues Objekt)
    Hier: Laser 2 im Level 2
*/

import greenfoot.*;

public class Laser_level2 extends Actor
{
    private int speed = 12;
    private int damage;

    public Laser_level2(int damage)
    {
        this.damage = damage;
        //setImage("laser2.png");

        getImage().scale(110, 27); // andere Größe für Level 2
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
