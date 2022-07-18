package adventureGame;

public class Armor {

    private int ID;
    private String name;
    private int block;
    private int price;

    public Armor(int ID, String name, int block, int price) {
        this.ID = ID;
        this.name = name;
        this.block = block;
        this.price = price;
    }
    public static Armor[] armors(){
        Armor[] armorList= new Armor[3];
        armorList[0]= new Armor(1, "Light", 1, 15);
        armorList[1]= new Armor(2, "Medium", 3, 25);
        armorList[2]= new Armor(3, "Light", 5, 40);
        return armorList;
    }
    public static Armor getArmorObjByID(int ID){

        for(Armor a: Armor.armors()){
            if(a.getID()== ID){
                return a;
            }
        }
        return null;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
