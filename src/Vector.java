

/**
 * Mathematical vector implementation, using `double` for coordinates
 * No size verification when performing operations, assuming vectors are coherent
 */
public class Vector {
    private int mSize;
    private double[] mContent;

    /**
     * Creates a new vector
     * @param size the dimension of the vector
     */
    public Vector(int size) {
        mSize = size;
        mContent = new double[mSize];
    }

    /**
     * Returns the value of the i-th coordinate of the vector
     * @param i the index of the coordinate
     * @return  the i-th coordinate
     */
    public double get(int i) {
        return mContent[i];
    }

    /**
     * Sets the i-th coordinate of the vector
     * @param i     the index of the coordinate
     * @param value the new i-th coordinate
     */
    public void set(int i, double value) {
        mContent[i] = value;
    }

    /**
     * Returns the size of the vector
     * @return the size of the vector
     */
    public int size() {
        return mSize;
    }

    /**
     * Sums all coordinates of the vector
     * @return the sum of all coordinates
     */
    public double sum() {
        double s = 0.0;

        for (int i = 0; i < mSize; ++i)
            s += mContent[i];

        return s;
    }

    /**
     * Copies the content of vector `a` to the vector
     * @param a the vector to be copied
     */
    public void copyFrom(Vector a) {
        for (int i = 0; i < mSize; ++i)
            mContent[i] = a.get(i);
    }

    /**
     * Returns a new vector `v`, from two input vector, compute the distance between each coordinate
     * v[i] = |a[i] - b[i]|
     * @param a first input vector
     * @param b second input vector
     * @return  |a - b|
     */
    public static Vector absMinus(Vector a, Vector b) {
        Vector v = new Vector(a.size());

        for (int i = 0; i < a.size(); ++i)
            v.set(i, Math.abs(a.get(i) - b.get(i)));

        return v;
    }

    /**
     * Returns a vector of a given size, assigning the same value to every coordinate
     * @param size  the size of the to-be-created vector
     * @param value the value to be assigned to every coordinate
     * @return      the vector [value] * size
     */
    public static Vector fromValue(int size, double value) {
        Vector v = new Vector(size);

        for (int i = 0; i < size; ++i)
            v.set(i, value);

        return v;
    }

    @Override
    public String toString() {
        String result = "[";

        if (mSize > 0)
            result += mContent[0] + "";

        for (int i = 1; i < mSize; ++i)
            result += " " + mContent[i];

        result += "]";

        return result;
    }
}
