package swingy.mvc.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemyBuilder
{
    public Enemy buildEnemy(int sizeMap, ArrayList<Enemy> enemies, myHero hero)
    {
        Random rand = new Random();
        Point position = new Point(-1, -1);
        Enemy newEnemy = new Enemy();

        while (position.x == -1)
        {
            position.setLocation(rand.nextInt(sizeMap), rand.nextInt(sizeMap));

            if (position.equals( hero.getPosition() ))
                position.x = -1;

            for (Enemy enemy : enemies)
                if ( enemy.getPosition().equals(position) )
                    position.x = -1;
        }
        newEnemy.setPosition(position);
        this.setSkills(newEnemy, rand, hero.getLevel() << 1 );

        return newEnemy;
    }

    private void    setSkills(Enemy newEnemy, Random rand, int coefficient)
    {
        coefficient = coefficient == 2 ? 1 : coefficient;

        newEnemy.setAttack( (rand.nextInt(10) + 1) * coefficient );
        newEnemy.setDefense( rand.nextInt(5) * coefficient );
        newEnemy.setHp( rand.nextInt(90) + 10 * coefficient );
        newEnemy.setNumImg(rand.nextInt(7));
    }
}