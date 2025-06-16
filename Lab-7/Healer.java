public class Healer extends Card      // For a healer, the damage array will have negative values
{
    private int numHeals;     // Number of heals done by the healer
    public Healer(String name, int initialHealth, int[] damage, int x, int y, int radius)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public Healer(String name, int initialHealth, int[] damage, int radius, Point2D centre)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
    }
    public void heal(Card obj)     // A healer should heal only an Wizard(Keep in mind that an IceWizard is also an Wizard)
    {
        /* Following the PDF and healing everything except Fireballs and Healers, not just Wizards */
        if (obj instanceof Fireball || obj instanceof Healer) {
            System.out.println("Heal Failed");
            return;
        }
        if (!withinRange(obj)) {
            System.out.println("Out of Range");
            return;
        }
        if (!obj.isDead() && !isDead()) {
            obj.takeDamage(getDamage());
            numHeals++;
            if (numHeals % 3 == 0) {
                incLevel();
            }
        }
        else {
            System.out.println("Heal Failed");
        }
    }
}
