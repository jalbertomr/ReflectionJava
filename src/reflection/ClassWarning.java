package reflection;

import java.lang.reflect.Method;

/**
 * Created by Bext on 17/02/2017.
 *
 * Compiler Warning: "Note: ... uses unchecked or unsafe operations"
 *
 * Class<?> c = warn.getClass();
 */
public class ClassWarning {
    void m(){
        try{
            Class c = ClassWarning.class;
            //Class<?> c = warn.getClass();
            //@SuppressWarnings("unchecked")
            Method m = c.getMethod("m");
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassWarning cl = new ClassWarning();
        cl.m();
    }
}
