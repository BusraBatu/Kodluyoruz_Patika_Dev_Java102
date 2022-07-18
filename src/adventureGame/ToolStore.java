package adventureGame;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    public boolean onLocation() {
        System.out.println("****** Welcome to The Tool Store! *******");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1.Weapon");
            System.out.println("2.Armor");
            System.out.println("3.Exit");
            System.out.print("Your Choice: ");
            int selectCase = scan.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid value, try again: ");
                selectCase = scan.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printArmor() {
        System.out.println("*****Armors******");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getID() + " - " + a.getName() + " < Price: " + a.getPrice() + "<, Armor: " + a.getBlock() + " > ");
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyArmor() {
        System.out.println("Select a armor: ");
        int selectArmorID = scan.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Invalid value, try again: ");
            selectArmorID = scan.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Insufficient Balance");
                } else {
                    System.out.println(selectedArmor.getName() + " bought");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your Balance: " + this.getPlayer().getMoney());
                    // System.out.println("Previous weapon: "+this.getPlayer().getInv().getWeapon().getName());
                    this.getPlayer().getInv().setArmor(selectedArmor);
                    // System.out.println("New weapon: "+this.getPlayer().getInv().getWeapon().getName());
                }
            }
        }

    }

    public void printWeapon() {
        System.out.println("*** Weapons ***");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getID() + "-" + w.getName() + "<Price: " + w.getPrice() + ", Damage: " + w.getDamage() + ">");
        }
        System.out.println("0-Exit");
    }


    public void buyWeapon() {
        System.out.print("Select a weapon: ");
        int selectWeaponID = scan.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid value, try again: ");
            selectWeaponID = scan.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Insufficient Balance");
            } else {
                System.out.println(selectedWeapon.getName() + " bought");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your Balance: " + this.getPlayer().getMoney());
                // System.out.println("Previous weapon: "+this.getPlayer().getInv().getWeapon().getName());
                this.getPlayer().getInv().setWeapon(selectedWeapon);
                System.out.println("New weapon: " + this.getPlayer().getInv().getWeapon().getName());
            }

        }
    }
}
