package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.console;
import static java.lang.System.out;

/**
 * Created by Bext on 16/02/2017.
 * Examining Class Modifiers and Types
 * Access Modifiers public, private, protected
 * Modifiers requiring Override: abstract
 * Modifiers restricting to one instance: static
 * Modifier prohibiting value modifying: final
 * Modifier forcing strinc floating point behavior: stringfp
 * Annotatations
 * Class.getCanonicalName()
 * Class.getTypeParameters()
 * Class.getGenericInterfaces()
 * Class.getAnnotations()
 * Class.getSuperclass()
 */
public class ClassModTypes {
    public static void main(String[] args){
        try{
            if (args.length == 0) {
                System.out.println("Uso: ClassModTypes nombre_largo_de_la_clase");
                System.exit(1);
            }

            Class<?> c = Class.forName(args[0]);
            out.format("Class:%n %s%n%n", c.getCanonicalName());
            out.format("Modifiers:%n %s%n%n", Modifier.toString(c.getModifiers()));

            out.format("Type Parameters:%n");
            TypeVariable tv[] = c.getTypeParameters();
            if(tv.length != 0){
                for(TypeVariable t : tv)
                    out.format("%s ", t.getName());
                out.format("%n");
            }else{
                out.format(" -- No Type Parameters -- %n%n");
            }

            out.format("Implemented Interfaces:%n");
            Class cinterfaces[] = c.getInterfaces();
            if(cinterfaces.length != 0){
                for (Class interf: cinterfaces)
                    out.format(" %s%n", interf.getCanonicalName());
                out.format("%n");
            }else{
                out.format(" -- No Implemented Interfaces --%n%n");
            }

            out.format("Inheritance Path:%n");
            List<Class> list = new ArrayList<Class>();
            printAncestor(c , list);
            if(list.size() != 0){
                for( Class<?> clas : list)
                    out.format("%s %n", clas.getCanonicalName());
                out.format("%n");
            }else{
                out.format(" -- No Super Classes --%n%n");
            }

            out.format("Annotations:%n");
            Annotation[] ann = c.getAnnotations();
            if(ann.length != 0){
                for( Annotation a: ann)
                    out.format("%s%n",a.toString());
                out.format("%n");
            }else{
                out.format(" -- No Annotations --%n%n");
            }
        } catch( ClassNotFoundException e ) {
            System.err.println(e);
        }
    }

    public static void printAncestor(Class c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null){
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }
}

/*  RUNS
"C:\Program Files\Java\jdk1.8.0_112\bin\java" -Didea.launcher.port=7543 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;C:\Users\Bext\IdeaProjects\Reflection\out\production\Reflection;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain reflection.ClassModTypes java.util.concurrent.ConcurrentNavigableMap
Class:
 java.util.concurrent.ConcurrentNavigableMap

Modifiers:
 public abstract interface

Type Parameters:
K V
Implemented Interfaces:
 java.util.concurrent.ConcurrentMap
 java.util.NavigableMap

Inheritance Path:
 -- No Super Classes --

Annotations:
 -- No Annotations --

"C:\Program Files\Java\jdk1.8.0_112\bin\java" -Didea.launcher.port=7534 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;C:\Users\Bext\IdeaProjects\Reflection\out\production\Reflection;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain reflection.ClassModTypes [Ljava.lang.String;
Class:
 java.lang.String[]

Modifiers:
 public abstract final

Type Parameters:
 -- No Type Parameters --

Implemented Interfaces:
 java.lang.Cloneable
 java.io.Serializable

Inheritance Path:
java.lang.Object

Annotations:
 -- No Annotations --

"C:\Program Files\Java\jdk1.8.0_112\bin\java" -Didea.launcher.port=7539 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;C:\Users\Bext\IdeaProjects\Reflection\out\production\Reflection;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain reflection.ClassModTypes java.io.InterruptedIOException
Class:
 java.io.InterruptedIOException

Modifiers:
 public

Type Parameters:
 -- No Type Parameters --

Implemented Interfaces:
 -- No Implemented Interfaces --

Inheritance Path:
java.io.IOException
java.lang.Exception
java.lang.Throwable
java.lang.Object

Annotations:
 -- No Annotations --

"C:\Program Files\Java\jdk1.8.0_112\bin\java" -Didea.launcher.port=7540 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;C:\Users\Bext\IdeaProjects\Reflection\out\production\Reflection;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain reflection.ClassModTypes java.security.Identity
Class:
 java.security.Identity

Modifiers:
 public abstract

Type Parameters:
 -- No Type Parameters --

Implemented Interfaces:
 java.security.Principal
 java.io.Serializable

Inheritance Path:
java.lang.Object

Annotations:
@java.lang.Deprecated()



 */