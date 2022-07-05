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

    private double x; //проекция по базису i
    private double y; //проекция по базису j

    public Vector2f() {
    }

    public Vector2f(double i, double j) {
        this.x = i;
        this.y = j;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2f mult(double x) {
        return new Vector2f(getX() * x, getY() * x);
    }

    public Vector2f add(Vector2f vec2) {
        return new Vector2f(x + vec2.getX(), y + vec2.getY());
    }

    public Vector2f normalize() {
        double length = length();
        setX(x / length);
        setY(y / length);
        return this;
    }

    public double dot(Vector2f vec2) {
        return x * vec2.getX() + y * vec2.getY();
    }

    public Vector2f rotate(double degrees) {
        double rad = Math.toRadians(degrees);
        double sin = Math.sin(rad);
        double cos = Math.cos(rad);
        return new Vector2f(x * cos - y * sin, x * sin + y * cos);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
