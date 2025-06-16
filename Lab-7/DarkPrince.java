public class DarkPrince extends Prince     // An DarkPrince "is-a" Prince
{
    public DarkPrince(String name, int initialHealth, int[] damage, int x, int y, int radius)  // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public DarkPrince(String name, int initialHealth, int[] damage, int radius, Point2D centre)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
    }

    public void attack(Card obj)     // Override the inherited method
    {
        if (!withinRange(obj)) {
            System.out.println("Out of Range");
            return;
        }
        if (!obj.isDead() && !isDead()) {
            obj.takeDamage(getDamage() * 2);
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
