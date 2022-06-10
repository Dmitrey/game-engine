package hey.btk;

public class Vector2f {
    /*todo
    1 mult with number
    2 normalization
    3 vectors sum
    4 dot (скалярное умножение)
    5 cross (векторное умножнение)
    6 rotate
    7 add vector
     */

    private double i; //проекция по базису i
    private double j; //проекция по базису j

    public Vector2f() {
    }

    public Vector2f(double i, double j) {
        this.i = i;
        this.j = j;
    }

    public double length() {
        return Math.sqrt(i * i + j * j);
    }

    public Vector2f mult(double x) {
        return new Vector2f(getI() * x, getJ() * x);
    }

    public Vector2f add(Vector2f vec2) {
        return new Vector2f(i + vec2.getI(), j + vec2.getJ());
    }

    public Vector2f normalize() {
        double length = length();
        setI(i / length);
        setJ(j / length);
        return this;
    }

    public double dot(Vector2f vec2) {
        return i * vec2.getI() + j * vec2.getJ();
    }

    public Vector2f rotate(double degrees) {
        double rad = Math.toRadians(degrees);
        double sin = Math.sin(rad);
        double cos = Math.cos(rad);
        return new Vector2f(i * cos - j * sin, i * sin + j * cos);
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }

}
