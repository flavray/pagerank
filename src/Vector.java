

/**
 * Mathematical vector implementation, using `double` for coordinates
 * No size verification when performing operations, assuming vectors are coherent
 */

import java.util.ArrayList;

public class Vector extends ArrayList<Double> {
    /**
     * Creates a new vector
     * @param size the size/dimension of the to-be-created vector
     */
    public Vector(int size) {
        super(size);

        // Initial value for the vector
        for (int i = 0; i < size; ++i)
            add(0.0);
    }

    /**
     * Creates a new vector with a given value
     * @param size  the size of the to-be-created vector
     * @param value the value to be assigned to every coordinate
     */
    public Vector(int size, double value) {
        super(size);

        for (int i = 0; i < size; ++i)
            add(value);
    }

    /**
     * Sums all coordinates of the vector
     * @return the sum of all coordinates
     */
    public double sum() {
        double s = 0.0;

        for (int i = 0; i < size(); ++i)
            s += get(i);

        return s;
    }

    /**
     * Copies the content of vector `a` to the vector
     * @param a the vector to be copied
     */
    public void copyFrom(Vector a) {
        for (int i = 0; i < size(); ++i)
            set(i, a.get(i));
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

    @Override
    public String toString() {
        String result = "[";

        if (size() > 0)
            result += get(0) + "";

        for (int i = 1; i < size(); ++i)
            result += " " + get(i);

        result += "]";

        return result;
    }
}
