public class Wizard extends Card   // An Wizard "is-a" Card
{
    protected int numAttacks;     // Number of attacks done by the Wizard
    public Wizard(String name, int initialHealth, int[] damage, int x, int y, int radius)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public Wizard(String name, int initialHealth, int[] damage, int radius, Point2D centre)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
    }
    
    public void attack(Card obj)     // Attack another Card
    {
        if (!withinRange(obj)) {
            System.out.println("Out of Range");
            return;
        }
        if (!obj.isDead() && !isDead()) {
            obj.takeDamage(getDamage());
            numAttacks++;
            if (numAttacks % 2 == 0) {
                incLevel();
            }
        }
        else {
            System.out.println("Attack Failed");
        }
    }
}