public class Assassin {
    private String name;
    private int skillLevel;

    public Assassin(String name, int skillLevel){
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public String getName(){
        return name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String toString(){
        return this.name + "(" + this.skillLevel + ")";
    }
}
