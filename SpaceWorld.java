import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SpaceWorld extends World
{
    private Actor ship;  // nur eine Variable für das aktive Schiff
    private int score = 0;
    private int lives = 3;
    private int level = 1;

    private ScoreDisplay scoreDisplay;
    private HealthDisplay healthDisplay;
    private LevelDisplay levelDisplay;

    private int asteroidSpawnCounter = 0;

    public SpaceWorld()
    {    
        super(600, 800, 1, false);
        //setBackground("spacebackground.png"); //leider unlösbarer Fehler bei Image-Import
        ship = new Spaceship();
        addObject(ship, getWidth() / 2, getHeight() - 50);

        scoreDisplay = new ScoreDisplay(score);
        healthDisplay = new HealthDisplay(lives);
        levelDisplay = new LevelDisplay(level);

        addObject(scoreDisplay, 320, 20);
        addObject(healthDisplay, 95, 25); // je nach PC evtl. anpassen (hier MacOS mit "95, 25", bei Windows evtl. Änderung auf "70, 25" nötig)
        addObject(levelDisplay, getWidth() - 70, 23);
    }

    public void act() 
    {
        asteroidSpawnCounter++;
        int spawnRate = Math.max(20, 50 - level * 6);
        if (asteroidSpawnCounter >= spawnRate) 
        {
            spawnAsteroid();
            asteroidSpawnCounter = 0;
        }
    }

    public void spawnAsteroid()
    {
        int x = Greenfoot.getRandomNumber(getWidth() - 40) + 20; // Rand vermeiden
        int size = Greenfoot.getRandomNumber(3) + 1; // 1 bis 3
        int speed = Greenfoot.getRandomNumber(3) + 3 + level / 2;
        Asteroid asteroid = new Asteroid(size, speed);
        addObject(asteroid, x, 0);
    }

    public void addScore(int points)
    {
        score += points;
        scoreDisplay.updateScore(score);
        checkLevelUp();
    }

    public void loseLife()
    {
        lives--;
        healthDisplay.updateHealth(lives);
        if (lives <= 0)
        {
            gameOver();
        }
    }

    private void checkLevelUp()
    {
        int newLevel = 1 + score / 100;
        if (newLevel > level)
        {
            level = newLevel;
            levelDisplay.updateLevel(level);
    
            int x = ship.getX();
            int y = ship.getY();
            removeObject(ship); // altes Schiff entfernen
    
            // Nur wechseln, wenn es ein bekanntes Level-Schiff gibt
            if (level == 2) {
                ship = new Spaceship_level2();
            } else if (level == 3) {
                ship = new Spaceship_level3();
            } else {
                // kein Schiff-Wechsel → verwende altes Schiff weiter
                ship = new Spaceship_level3(); // oder was auch immer zuletzt war
            }
    
            addObject(ship, x, y);
        }
    }

    // Gibt je nach aktuellem Level den passenden Laser zurück
    public Actor createLaser(int damage)
    {
        if (level == 2) {
            return new Laser_level2(damage);
        } else if (level == 3) {
            return new Laser_level3(damage);
        } else if (level > 3) {
            // kein weiterer Laser implementiert --> benutzt den letzten bekannten
            return new Laser_level3(damage);
        } else {
            return new Laser(damage); // Standard-Laser (Level 1)
        }
    }

    private void gameOver()
    {
        addObject(new GameOverScreen(score), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
}
