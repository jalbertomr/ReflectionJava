package reflection;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Bext on 16/02/2017.
 * Retrieving Class Object
 */
public class RetrievingClassO {
    private static Class<Integer> integerClass;

    enum E {A, B}

    public static void main(String[] args) {
        Integer numInt = new Integer(0);
        String cadena = new String("este es un string");

        List<Integer> listInteger = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        List<String> listString = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<>();

        Predicate<Integer> predicate = number -> number > 3;
        Function<Integer, Predicate<Integer>> isGreatherThan3 = param -> number -> number > param;

        // Object.getClass();

        Class c = "foo".getClass();
        System.out.println(c);                      //pinta class java.lang.String
        System.out.println(numInt.getClass());      //pinta class java.lang.Integer
        //System.out.println(System.console().getClass());
        //System.out.println( E.getClass());
        byte[] bytes = new byte[1024];
        System.out.println(bytes.getClass());  //  class [B

        long[] longs = new long[2];
        System.out.println(longs.getClass());  //  class [J

        Integer[] arrInt = new Integer[10];
        System.out.println(arrInt.getClass()); //  class [Ljava.lang.Integer;

        String[][] arrarrString = new String[][]{{"11", "12"}, {"21", "22"}};
        System.out.println(arrarrString.getClass());    //class [[Ljava.lang.String;

        System.out.println(listInteger.getClass());    //class java.util.Arrays$ArrayList
        System.out.println(listString.getClass());      //class java.util.ArrayList
        System.out.println(map.getClass());             //class java.util.HashMap


        // .class Syntax

        boolean b;
        // Class c1 = b.getClass(); //  compile time error
        Class cboolean = boolean.class;
        System.out.println(cboolean);   // boolean
        Class cdouble = double.class;
        System.out.println(cdouble);    // double

        System.out.println(int.class);          //int
        System.out.println(int[].class);        //class [I
        System.out.println(int[][].class);      //class [[I
        System.out.println(int[][][].class);    //class [[[I
        System.out.println(char[][].class);     //class [[C
        System.out.println(long[].class);         //class [J
        System.out.println(double[].class);       //class [D

        // Class.forName()

        //Class c =  Class.forName("com.duke.MyLocalServiceProvider");

        try {
            Class cint = Class.forName("int");
            Class cInteger = Class.forName("java.util.Integer");
            Class c2 = Class.forName("[D");
            Class carrarrString = Class.forName("[[java.lang.String");
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }

        //Type Field for Primitive Type Wrappers
        Class cusedwhenprimitiveWrapped = Double.TYPE;   // identical to double.class
        System.out.println(cusedwhenprimitiveWrapped.getClass());  //class java.lang.class

        Class cvoid = Void.TYPE;   // identical to void.class
        System.out.println(cvoid.getClass());  //class java.lang.class

        //Methods that return Classes
        // Class.getSuperClass()
        Class csuperclass = javax.swing.JButton.class.getSuperclass();
        System.out.println(csuperclass);    //javax.swing.AbstractButton

        // Class.getClasses()
        System.out.println("=== getClasses(): return all public clases, interfaces, enums of Character ===");
        Class<?>[] cclasses = Character.class.getClasses();
        //System.out.println(cclasses);     //asi no se obtiene el contenido del array
        Arrays.stream(cclasses).forEach(cc -> System.out.print(cc + "|"));
        System.out.println();

        System.out.println("=== getClasses(): return all public clases, interfaces, enums of JButton ===");
        Class<?>[] cclassesJButton = javax.swing.JButton.class.getClasses();
        Arrays.stream(cclassesJButton).forEach(cjb -> System.out.print(cjb + "|"));
        System.out.println();

        // Class.getDeclaredClasses()
        System.out.println("=== getDelaredClasses(): return all public clases, interfaces, enums of Character ===");
        Class<?>[] cDecclasses = Character.class.getDeclaredClasses();
        //System.out.println(cclasses);     //asi no se obtiene el contenido del array
        Arrays.stream(cDecclasses).forEach(cdc -> System.out.print(cdc + "|"));
        System.out.println();

        // Class.getDeclaringClass()
        // java.lang.reflect.Field.getDeclaringClass()
        // java.lang.reflect.Method.getDeclaringClass()
        // java.lang.reflect.Constructor.getDeclaringClass()
        try {
            Field f = System.class.getField("out");
            Class cb = f.getDeclaringClass();
            System.out.println(cb);            //class java.lang.System  field "out" is declared in class System
        } catch (NoSuchFieldException e) {
            System.err.println(e);
        }

        Class<?> co = o.getClass().getDeclaringClass();  // anonymous class defined by o is null
        System.out.println(co);

        Myinnerclass mic = new Myinnerclass();
        Class<?> cmic = mic.getClass().getDeclaringClass();
        System.out.println("Myinnerclass decrared in: " + cmic);
    }

    //an Anonymous class
    static Object o = new Object() {
        public void m() {
        }
    };

    static class Myinnerclass {
        public Myinnerclass() {
        }
    }
}
