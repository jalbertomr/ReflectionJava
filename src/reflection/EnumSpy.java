package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by Bext on 23/02/2017.
 */
public class EnumSpy {
    public static final String fmt = " %11s: %s %s%n";

    public static void main(String[] args) {
    try{
        Class<?> c = Class.forName(args[0]);
        if (!c.isEnum()){
            out.format("%s is not an enum type%n");
            return;
        }
        out.format("Class: %s%n", c);

        Field[] flds = c.getDeclaredFields();
        List<Field> cst = new ArrayList<Field>(); //enum constatnts
        List<Field> mbr = new ArrayList<Field>(); //member fields
        for (Field f: flds){
            if (f.isEnumConstant())
                cst.add(f);
            else
                mbr.add(f);
            if (!cst.isEmpty())
                print(cst, "Constant");
            if (!mbr.isEmpty())
                print(mbr, "Field");

            Constructor[] ctors = c.getDeclaredConstructors();
            for( Constructor ctor: ctors){
                out.format(fmt, "Constructor", ctor.toGenericString(), synthetic(ctor));
            }

            Method[] mths = c.getDeclaredMethods();
            for (Method m : mths){
                out.format(fmt, "Methods", m.toGenericString());
                synthetic(m);
            }
        }

    }catch (ClassNotFoundException ex){
        ex.printStackTrace();
    }
    }

    public static void print(List<Field> lst, String s) {
        for (Field f: lst){
            out.format(fmt, s, f.toGenericString(), synthetic(f));
        }
    }

    public static String synthetic( Member m) {
        return (m.isSynthetic() ? "[ synthetic ]" : "");
    }
}
