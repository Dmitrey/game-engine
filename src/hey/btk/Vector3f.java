package hey.btk;

public class Vector3f {

    private float x; //проекция по базису i
    private float y; //проекция по базису j
    private float z; //проекция по базису k

    public Vector3f() {
    }

    public Vector3f(float i, float j, float k) {
        this.x = i;
        this.y = j;
        this.z = k;
    }

    public float length(){
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3f mult(float x) {
        return new Vector3f(getX() * x, getY() * x, getZ() * x);
    }

    public Vector3f add(Vector3f vec2) {
        return new Vector3f(x + vec2.getX(), y + vec2.getY(), z + vec2.getZ());
    }

    public Vector3f normalize() {
        float length = length();
        setX(x / length);
        setY(y / length);
        setZ(z / length);
        return this;
    }

    public double dot(Vector3f vec2) {
        return x * vec2.getX() + y * vec2.getY() + z * vec2.getZ();
    }

    public Vector3f cross(Vector3f vec2){
        float resI = y * vec2.getZ() - z * vec2.getY();
        float resJ = -x * vec2.getZ() + z * vec2.getX();
        float resK = x * vec2.getY() - y * vec2.getX();
        return new Vector3f(resI,resJ,resK);
    }

//    public Vector3f rotate(float angle, Vector3f axis) {
//        double rad = Math.toRadians(angle);
//        double sin = Math.sin(rad);
//        double cos = Math.cos(rad);
//        return new Vector3f(i * cos - j * sin, i * sin + j * cos);
//    }

    public Vector3f rotate(float angle, Vector3f axis)
    {
        float sinHalfAngle = (float)Math.sin(Math.toRadians(angle / 2));
        float cosHalfAngle = (float)Math.cos(Math.toRadians(angle / 2));

        float rX = axis.getX() * sinHalfAngle;
        float rY = axis.getY() * sinHalfAngle;
        float rZ = axis.getZ() * sinHalfAngle;
        float rW = cosHalfAngle;

        Quaternion rotation = new Quaternion(rX, rY, rZ, rW);
        Quaternion conjugate = rotation.conjugate();

        Quaternion w = rotation.mul(this).mul(conjugate);

        x = w.getX();
        y = w.getY();
        z = w.getZ();

        return this;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector3f{" +
                "i=" + x +
                ", j=" + y +
                ", k=" + z +
                '}';
    }
}
