public class WizardFireball extends Fireball    // A Fireball with an Wizard, both can attack separately.
// If the Fireball dies, the Wizard also dies
{
    private Wizard Wizard;  // An WizardFireball "has-a" Wizard

    public WizardFireball(String name, int initialHealth, int[] damage, int x, int y, int radius, Wizard Wizard)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.Wizard = Wizard;
    }
    public WizardFireball(String name, int initialHealth, int[] damage, int radius, Point2D centre, Wizard Wizard)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.Wizard = Wizard;
    }

    public Wizard getWizard()
    {
        return Wizard;
    }

    public boolean isWizardDead()   // The Wizard dies if the Fireball dies
    {
        return isDead() || Wizard.isDead();
    }

    public void WizardAttack(Card obj)     // The Wizard attacks another Card
    {
        Wizard.attack(obj);
    }

    public void attack(Card obj)     // Attack another Card, should not attack other WizardFireballs.
    {
        if (obj instanceof WizardFireball) {
            System.out.println("Attack Failed");
            return;
        }
        if (!withinRange(obj)) {
            System.out.println("Out of Range");
            return;
        }
        if (!obj.isDead() && !isDead()) {
            obj.takeDamage(getDamage());
            numAttacks++;
            if (numAttacks % 4 == 0) {
                incLevel();
            }
        }
        else {
            System.out.println("Attack Failed");
        }
    }
}
