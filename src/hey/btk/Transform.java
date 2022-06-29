package hey.btk;

public class Transform {

    private Vector3f translation;
    private Vector3f rotation;
    private Vector3f scale;

    public Transform() {
        this.translation = new Vector3f(0,0,0);
        this.rotation = new Vector3f(0,0,0);
        this.scale = new Vector3f(1,1,1);
    }

    public Matrix4f getTransformation(){
        Matrix4f translationMatrix4f = new Matrix4f().initTranslation(translation.getI(), translation.getJ(), translation.getK());
        Matrix4f rotationMatrix4f = new Matrix4f().initRotation(rotation.getI(), rotation.getJ(), rotation.getK());
        Matrix4f scaleMatrix4f = new Matrix4f().initScaling(scale.getI(), scale.getJ(), scale.getK());
        return translationMatrix4f.mult(rotationMatrix4f.mult(scaleMatrix4f));
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }

    public void setTranslation(float x, float y, float z) {
        this.translation = new Vector3f(x,y,z);
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public void setRotation(float x, float y, float z) {
        this.rotation = new Vector3f(x,y,z);
    }

    public Vector3f getScale() {
        return scale;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    public void setScale(float x, float y, float z) {
        this.scale = new Vector3f(x,y,z);
    }
}
