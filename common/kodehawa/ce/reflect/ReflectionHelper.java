package common.kodehawa.ce.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionHelper {

	public static void setField(Class c, Object o, String s, Object val){
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++){
            if (fields[i].getName().equals(s)){
                System.out.println("Fix relflection usage: Use \""+i+"\" instead of \""+s+"\"!");
                setField(c, o, i,val);
                return;
            }
        }
        System.out.println("Fix relflection usage: No such field: \""+s+"\"!");
    }

    public static void setField(Class c, Object o, int n, Object val){
        try{
            Field f = c.getDeclaredFields()[n];
            f.setAccessible(true);
            Field modifiers = f.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(f, f.getModifiers() & ~Modifier.FINAL);
            f.set(o, val);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }


}
