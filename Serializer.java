import java.lang.annotation.*;
import java.lang.reflect.*;

class Serializer {
    public static String serialize(Object o) throws IllegalAccessException {
        Class<?> cls = o.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            if (!f.isAnnotationPresent(Save.class))
                continue;
            if (Modifier.isPrivate(f.getModifiers()))
                f.setAccessible(true);

            sb.append(f.getName() + "=");

            if (f.getType() == int.class)
                sb.append(f.getInt(o));
            else if (f.getType() == String.class)
                sb.append((String) f.get(o));
            else if (f.getType() == long.class)
                sb.append(f.getLong(o));
            
            sb.append(";");
        }
        return sb.toString();
    }
}
