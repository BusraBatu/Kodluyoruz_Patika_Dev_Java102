package adventureGame;

public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory(){
        this.weapon= new Weapon("Punch",-1,0,0);
        this.armor= new Armor(-1, "Rag",0,0);
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
// private boolean water;
  // private boolean food;
  // private boolean firewood;
  // private String weaponName;
  // private String armorName;
  // private int weaponDamage;
  // private int armorDefence;
}
