public class Ongoing {
    
    public enum Keyword { ACID, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, POISON, PSYCHIC,
        RADIANT, THUNDER, DAMAGE, NULL };
    public enum Type { ONGOING, DEFPEN, ATTPEN, ATTBON, DEFBON, BLIND, DAZE, DEAF,
        DOMINATE, IMMOB, MARK, PETRIFY, PRONE, RESTRAIN, SLOW, STUN, WEAK, NULL };
    Keyword key;
    Type type;           
    int mod;
    int dur;
    
    public Ongoing(Keyword keyword, Type effect_type, int modifier, int duration) {
        key = keyword;
        type = effect_type;
        mod = modifier;
        dur = duration;
            
   }
    public boolean equals(Ongoing x) {
        if (x.key == this.key) {
            return true;
        }
        else return false;
    }
    
}