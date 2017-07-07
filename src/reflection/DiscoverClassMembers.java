package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import static java.lang.System.out;
import static reflection.DiscoverClassMembers.ClassMember.CONSTRUCTOR;

/**
 * Created by Bext on 17/02/2017.
 */
public class DiscoverClassMembers {

    enum ClassMember { CONSTRUCTOR, FIELD, METHOD, CLASS, ALL}
    public static void main(String[] args) {
        try{
            if(args.length == 0){
                out.println("Uso: DiscoverClassMembers class_name [CONSTRUCTOR | FIELD | METHOD | CLASS | ALL]");
                System.exit(1);
            }

            Class<?> c = Class.forName(args[0]);

            out.format("Class:%n %s%n%n",c.getCanonicalName());

            Package p = c.getPackage();
            out.format("package:%n %s%n%n", p != null ? p.getName() : "-- No package --");

            for(int i = 1 ; i < args.length; i++){
                switch (ClassMember.valueOf(args[i])){
                    case CONSTRUCTOR:
                        printMembers(c.getConstructors(),"Constructors");
                        printMembers(c.getDeclaredConstructors(),"Declared Costructors");
                        break;
                    case FIELD:
                        printMembers(c.getFields(),"Fields");
                        printMembers(c.getDeclaredFields(),"Declared Fields");
                        break;
                    case METHOD:
                        printMembers(c.getMethods(),"Methods");
                        printMembers(c.getDeclaredMethods(), "Declared Methods");
                        break;
                    case CLASS:
                        printClasses(c);
                        break;
                    case ALL:
                        printMembers(c.getConstructors(),"Constructors");
                        printMembers(c.getFields(),"Fields");
                        printMembers(c.getMethods(),"Methods");
                        printClasses(c);
                        break;
                    default:
                        assert false;
                }
            }

        }catch(ClassNotFoundException x){
            x.printStackTrace();
        }

    }

    public static void printMembers(Member[] mbrs, String s) {
        out.format("%s:%n", s);
        for(Member m: mbrs){
            if (m instanceof Constructor)
                out.format("%s%n", ((Constructor) m).toGenericString());
            else if (m instanceof Field) {
                out.format("%s%n", ((Field) m).toGenericString());
              //  out.format("  -- declared in: %s%n", m.getDeclaringClass());
            } else if ( m instanceof Method)
                out.format("%s%n", ((Method) m).toGenericString());
        }
        if (mbrs.length == 0)
            out.format(" -- No %s%n", s);
        out.format("%n");
    }

    public static void printClasses(Class<?> c){
        out.format("Classes:%n");
        Class[] cls = c.getClasses();
        for( Class cl : cls)
            out.format("  %s%n", cl.toGenericString());
        if (cls.length == 0)
            out.format(" -- No Classes --%n");
        out.format("%n");
    }
}

/*
"C:\Program Files\Java\jdk1.8.0_112\bin\java" -Didea.launcher.port=7536 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;C:\Users\Bext\IdeaProjects\Reflection\out\production\Reflection;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain reflection.DiscoverClassMembers java.lang.ClassCastException CONSTRUCTOR
Class:
 java.lang.ClassCastException

package:
 java.lang

Constructor:
public java.lang.ClassCastException()
public java.lang.ClassCastException(java.lang.String)

"C:\Program Files\Java\jdk1.8.0_112\bin\java" -Didea.launcher.port=7537 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;C:\Users\Bext\IdeaProjects\Reflection\out\production\Reflection;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain reflection.DiscoverClassMembers java.nio.channels.ReadableByteChannel METHOD
Class:
 java.nio.channels.ReadableByteChannel

package:
 java.nio.channels

Methods:
public abstract int java.nio.channels.ReadableByteChannel.read(java.nio.ByteBuffer) throws java.io.IOException
public abstract void java.nio.channels.Channel.close() throws java.io.IOException
public abstract boolean java.nio.channels.Channel.isOpen()


 */