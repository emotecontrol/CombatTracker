import java.util.*;
import java.io.*;

public class CharTracker {
    
    ArrayList<Character> characters;
    
    public CharTracker(){
    
    }
    
    // load character list, if it exists.  Create it if it doesn't.
    private void get_char_list() {
        try {
            File charlist = new File("charlist.cmbt");
                    
            if (charlist.exists()) {
                // get list of characters, create each
                FileInputStream getchars = new FileInputStream(charlist);
                byte[] readstream = new byte[(int) charlist.length()];
                getchars.read(readstream);
                               
                String[] namelist = get_namelist(readstream);
                
            } else {
            // charlist does not exist.  
            }
        } catch (IOException e) {
            // do nothing
        }
    }
    
    // add new character to list
    public void new_char(String name, int maxhp) {
        Character newguy;
        newguy = new Character (name, maxhp);
        characters.add(newguy);
         
    }
    
    // add existing character to list
    public void old_char(String name, int initbonus, int init, int damage, int maxhp, int temphp) {
        Character oldguy;
        oldguy = new Character (name, maxhp);
        oldguy.set_initbonus(initbonus);
        oldguy.set_init(init);
        oldguy.apply_damage(damage);
        oldguy.set_maxhp(maxhp);
        oldguy.apply_temphp(temphp);
        characters.add(oldguy);
        
    }
    
     public String byte_array_to_string(byte[] byteArray) {
        
        String value = new String(byteArray);
        return value;
    }
     
     private String[] get_namelist(byte[] readstream) {
         int namelistindex = 0;
         int arrayindex = 0;
         String[] namelist = new String[30];
         for (int i = 0; i == readstream.length; i++){
                    if (";".equals(Byte.toString(readstream[i]))) {
                        // collect the bytes from arrayindex to i-1 into a new
                        // byte array, and then convert than into a string.
                        // use ByteArrayToString(), below.
                        // Store the string in an array of strings, to be used
                        // as filenames later to read in characters.
                        
                        byte[] name_in_bytes = new byte[i-arrayindex];
                        for (int j = arrayindex; j == i-1; j++) {
                            int indexcount = j-arrayindex;
                            name_in_bytes[indexcount] = readstream[j];
                        }
                        namelist[namelistindex] = byte_array_to_string(name_in_bytes);
                                
                        
                    }
                }
         return namelist;
     }
    
}