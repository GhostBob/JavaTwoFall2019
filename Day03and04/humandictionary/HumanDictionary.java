package humandictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class HumanDictionary implements Serializable {

    private static final long serialVersionUID = 1337L;

    private String title;
    private TreeMap<String, List<String>> dictionary;

    public static void main(String[] args) {
        HumanDictionary dict = giveMeSampleDictionary();
        System.out.println("\n ** Today's Word of the Day ** ");
        dict.printRandomDefinition();
        System.out.println("\n\n");
        dict.printAllDefinitionsWithTitle();
        dict.serializeToFile("dict.srlz");
        
        dict = null;
        
        dict = HumanDictionary.deserializeFromFile("dict.srlz");
        System.out.println("\n*** After serial and deserialization ***\n");
        System.out.println(dict);
        dict.printDefinition("woot");
        dict.printDefinition("cow");
    }

    public static HumanDictionary giveMeSampleDictionary() {
        HumanDictionary dict = new HumanDictionary("My Silly Dictionary");
        dict.addDefinition("woot", "an awesome word");
        dict.addDefinition("scoot", "a word that rhymes with woot");
        dict.addDefinition("scoot", "to move something across the ground");
        dict.addDefinition("bird", "a ex-dinosaur that can usual fly.");
        dict.addDefinition("barn", "something people try to shoot the broad side of");
        dict.addDefinition("dog", "a good boi");
        dict.addDefinition("cat", "a usually furry little psychopath");
        dict.addDefinition("weasel", "someone who isn't very trustworthy");
        dict.addDefinition("integer", "a whole number");
        dict.addDefinition("double", "a decimal point number");
        dict.addDefinition("string", "bigger than a thread, smaller than a rope");
        dict.addDefinition("string", "in Java, an object that holds text");
        dict.addDefinition("set", "in Java, a collection of unique objects");
        dict.addDefinition("list", "in Java, a linear collection of objects");
        dict.addDefinition("list", "a bunch of things, ordered sequentially");
        dict.addDefinition("bacon", "the worlds greatest food");
        dict.addDefinition("fish", "a creature that swims, has gills, and usually scales");
        dict.addDefinition("string", "a set of things tied or threaded together on a thin cord");
        dict.addDefinition("string", "to hang (something) so that it stretches in a long line");
        dict.addDefinition("string", "to fit a string or strings to (a musical instrument, racket, bow)");
        return dict;
    }

    public HumanDictionary(String title) {
        this.title = title;
        this.dictionary = new TreeMap();
    }

    public void addDefinition(String word, String definition) {
        //1) Get the existing definitions for the word, if any.
        List<String> definitions = this.dictionary.getOrDefault(word, new ArrayList());
//        List<String> definitions = this.dictionary.get(word);
//        if (definitions == null)
//            definitions = new ArrayList();
        
        // 2) Add my new definition
        definitions.add(definition);
        
        // 3) Put that in the dictionary (again, maybe)
        this.dictionary.put(word, definitions);
    }

    public void printDefinition(String word) {
        List<String> definitions = this.dictionary.get(word);
        System.out.println(word + ":");
        if (definitions == null) {
            System.out.println("  * NOT FOUND\n");
            return;
        }

        for (String definition : definitions) {
            System.out.println("  * " + definition);
        }
        System.out.println("");
    }

    public void printRandomDefinition() {
        // 1) Get an array of keys, and figure out how big it is.
        Object[] keys = this.dictionary.keySet().toArray();
        int size = keys.length;
        
        // 2) Pick a random number between 0 and the size of the array
        Random random = new Random();
        int randKey = random.nextInt(size);
        
        // 3) Get the object at that location, cast it to a String
        String randKeyString = (String) keys[randKey];
        
        // 4) Print the definition for that String
        printDefinition(randKeyString);
    }

    public void printAllDefinitions() {
        Set<String> keys = this.dictionary.keySet();
        for (String s : keys) {
            printDefinition(s);
        }
    }
    
    public void printAllDefinitionsWithTitle() {
        String output = "----- " + this.getTitle() + " -----";
        printDashes(output.length());
        System.out.println(output);
        printDashes(output.length());
        
        this.printAllDefinitions();
    }
    
    private void printDashes(int dashes) {
        for (int i=0; i<dashes; ++i) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public void serializeToFile(String filename) {
        try {
            FileOutputStream f = new FileOutputStream(new File(filename));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
            o.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static HumanDictionary deserializeFromFile(String filename) {
        HumanDictionary dict = null;
        try {
            FileInputStream f = new FileInputStream(new File(filename));
            ObjectInputStream o = new ObjectInputStream(f);
            Object obj = o.readObject();
            o.close();
            if (obj instanceof HumanDictionary) {
                dict = (HumanDictionary) obj;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return dict;
    }

    @Override
    public String toString() {
        int size = this.dictionary.keySet().size();
        return this.title + ", a dictionary with " + size + " definitions.";
    }

    // ** STANDARD GETTERS AND SETTERS **
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
