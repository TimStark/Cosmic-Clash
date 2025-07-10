/*
    Da leider aufgrund eines unerklärlichen Fehlers das Laden von Bildern nicht funktioniert,
    wird für jedes Level ein neues Spaceship mit einem anderen Bild angesetzt (neues Objekt)
    Hier: Spaceship im Level 3
*/

import greenfoot.*;

public class Spaceship_level3 extends Actor
{
    private int speed = 7;
    private int shootCooldown = 0;
    private int shootInterval = 20; // Shoot-Intervall noch schneller
    private int level = 3;
    private int laserCount = 3;
    private int damage = 3; // in dieser Version nicht unterstützt
    //GreenfootImage image3 = new GreenfootImage("spaceship_level3.png");

    public Spaceship_level3()
    {
        //setImage(image3);
        getImage().scale(165, 90);
    }

    // Bewegung und Schuss mit Lasern
    public void act()
    {
        moveShip();
        shootCooldown--;
        if (shootCooldown <= 0)
        {
            shootLasers();
            shootCooldown = shootInterval;
        }
    }

    // Bewegung
    private void moveShip()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            if (getX() > 30)
                setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            if (getX() < getWorld().getWidth() - 30)
                setLocation(getX() + speed, getY());
        }
    }

    // Laserschüsse
    private void shootLasers()
    {
        int startX = getX();
        int startY = getY() - 40;
        SpaceWorld spaceWorld = (SpaceWorld) getWorld();
    
        spaceWorld.addObject(spaceWorld.createLaser(damage), startX, startY);
    }
}
