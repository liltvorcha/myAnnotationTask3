import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Save {
}

class Test {
    @Save
    public int a;

    @Save
    private String b;

    public long c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
