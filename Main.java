public class Main {
    public static void main(String[] args) throws Exception {
        Test t = new Test();
        t.setA(7);
        t.setB("HELLO");

        String res = Serializer.serialize(t);
        System.out.println("Serialized: " + res);

        
        Test deserialized = Deserializer.deserialize(res, Test.class);
        System.out.println("Deserialized: " + deserialized.getA() + " , " + deserialized.getB() + " , " + deserialized.getC());
    }
}
