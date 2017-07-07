package reflection;

/**
 * Created by Bext on 22/02/2017.
 */
public class ClassTrouble {
    static class Cls {
        private Cls() {}
    }

    public static void main(String[] args) {
        Cls cl = new Cls();
        System.out.println(cl.getClass().getName());
        try{
            Class<?> c = Class.forName("reflection.ClassTrouble$Cls");
            c.newInstance();
        }catch (InstantiationException x){
            x.printStackTrace();
        }catch (IllegalAccessException x){
            x.printStackTrace();
        }catch (ClassNotFoundException x){
            x.printStackTrace();
        }
    }
}
/*"C:\Program Files\Java\jdk1.8.0_112\bin\java" -Didea.launcher.port=7540 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;C:\Users\Bext\IdeaProjects\Reflection\out\production\Reflection;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2016.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain reflection.ClassTrouble
reflection.ClassTrouble$Cls
java.lang.IllegalAccessException: Class reflection.ClassTrouble can not access a member of class reflection.ClassTrouble$Cls with modifiers "private"
	at sun.reflect.Reflection.ensureMemberAccess(Reflection.java:102)
	at java.lang.Class.newInstance(Class.java:436)
	at reflection.ClassTrouble.main(ClassTrouble.java:16)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
*/