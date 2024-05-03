import java.lang.reflect.*;

public class Deserializer {
    public static <T> T deserialize(String s, Class<T> cls) throws ClassNotFoundException, IllegalAccessException,
            NoSuchFieldException, InstantiationException {
        T res = cls.newInstance();
        String[] pairs = s.split(";");

        for (String p : pairs) {
            String[] nv = p.split("=");
            if (nv.length != 2)
                throw new InvalidAlgorithmParameterException(s);

            String name = nv[0];
            String value = nv[1];
            Field f = cls.getDeclaredField(name);
            if (Modifier.isPrivate(f.getModifiers()))
                f.setAccessible(true);

            if (f.isAnnotationPresent(Save.class)) {
                if (f.getType() == int.class) {
                    f.setInt(res, Integer.parseInt(value));
                } else if (f.getType() == String.class) {
                    f.set(res, value);
                } else if (f.getType() == long.class) {
                    f.setLong(res, Long.parseLong(value));
                }
            }
        }
        return res;
    }
}
