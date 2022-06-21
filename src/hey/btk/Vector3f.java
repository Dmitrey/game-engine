package hey.btk;

public class Vector3f {

    private float i; //проекция по базису i
    private float j; //проекция по базису j
    private float k; //проекция по базису k

    public Vector3f() {
    }

    public Vector3f(float i, float j, float k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public float length(){
        return (float) Math.sqrt(i * i + j * j + k * k);
    }

    public Vector3f mult(float x) {
        return new Vector3f(getI() * x, getJ() * x, getK() * x);
    }

    public Vector3f add(Vector3f vec2) {
        return new Vector3f(i + vec2.getI(), j + vec2.getJ(), k + vec2.getK());
    }

    public Vector3f normalize() {
        float length = length();
        setI(i / length);
        setJ(j / length);
        setK(k / length);
        return this;
    }

    public double dot(Vector3f vec2) {
        return i * vec2.getI() + j * vec2.getJ() + k * vec2.getK();
    }

    public Vector3f cross(Vector3f vec2){
        float resI = j* vec2.getK() - k * vec2.getJ();
        float resJ = -i* vec2.getK() + k * vec2.getI();
        float resK = i* vec2.getJ() - j * vec2.getI();
        return new Vector3f(resI,resJ,resK);
    }

//    public Vector3f rotate(double degrees) {
//        double rad = Math.toRadians(degrees);
//        double sin = Math.sin(rad);
//        double cos = Math.cos(rad);
//        return new Vector3f(i * cos - j * sin, i * sin + j * cos);
//    }


    public float getI() {
        return i;
    }

    public void setI(float i) {
        this.i = i;
    }

    public float getJ() {
        return j;
    }

    public void setJ(float j) {
        this.j = j;
    }

    public float getK() {
        return k;
    }

    public void setK(float k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "Vector3f{" +
                "i=" + i +
                ", j=" + j +
                ", k=" + k +
                '}';
    }
}
