import java.util.ArrayList;

public class Character {
    
    private String name;
    private int init;
    private int initbonus;
    private int damage;
    private int maxhp;
    private int temphp;
    private ArrayList<Ongoing> effects;
    private static int numchar = 0;
    private int charindex;
    private boolean is_unconscious;
    private boolean is_dead;
            
    public Character (String nom, int maxhitpoints){
        name = nom;
        init = 0;
        initbonus = 0;
        damage = 0;
        maxhp = maxhitpoints;
        temphp = 0;
        effects = new ArrayList<>();
        charindex = numchar++;
        is_unconscious = false;
        is_dead = false;
    }
    
    // return the current number of characters
    public static int numCharacters() {
        return numchar;
    }
    
    // return this character's serial number
    public int getID(){
        return charindex;
    }
    
    // set initiative
    public void set_init(int value) {
        init = value;
    }
    
    // return initiative
    public int get_init() {
        return init;
    }
    
    // set initiative bonus
    public void set_initbonus(int bonus){
        initbonus = bonus;
    }
    
    // return initiative bonus
    public int get_initbonus() {
        return initbonus;
    }
    
    // randomly determine initiative
    public void roll_init() {
        int roll = (int) Math.floor(Math.random() * 20 + 1);
        init = initbonus + roll;
    }
    
    // set character name
    public void set_name(String appelation){
        name = appelation;
    }
    
    // return character name    
    public String get_name(){
        return name;
    }
    
    public void apply_effect(Ongoing.Keyword key, Ongoing.Type type, int mod, 
            int dur){
        Ongoing new_effect;
        new_effect = new Ongoing(key, type, mod, dur);
        effects.add(new_effect);
    }
    
    public void remove_effect(Ongoing.Keyword key){
        Ongoing x = new Ongoing(key, Ongoing.Type.NULL, 0, 0);
            effects.remove(x);
    }
    
    public Ongoing get_effect(int index) {
        Ongoing effect = effects.get(index);
        return effect;
    }
    
    public int num_effects(){
        return effects.size();
    }
    
    public void set_maxhp(int hp) {
        maxhp = hp;
    }
    
    public int get_maxhp() {
        return maxhp;
    }
    
    public void apply_temphp(int temp) {
        if (temp > temphp){
            temphp = temp;
        }
    }
    
    public int get_temphp() {
        return temphp;
    }
    
    // applies damage to character
    public void apply_damage(int hurty) {
        
        if (temphp > 0) {
            if (temphp < hurty) {
                hurty -= temphp;
                temphp = 0;
            }
            else {
                temphp -= hurty;
                hurty = 0;
            }
        }    
        damage += hurty;
        if (damage >= maxhp) {
            is_unconscious = true;
            if (damage >= (maxhp + (int)(maxhp*.5))) {
                is_unconscious = false;
                is_dead = true;
            }
            }
        if (damage < 0) {
            damage = 0;
        }
    }
    
    // returns current damage
    public int get_damage(){
        return damage;
    }
    
    public boolean get_unc(){
        return is_unconscious;
    }
    
    public boolean get_dead(){
        return is_dead;
    }
}