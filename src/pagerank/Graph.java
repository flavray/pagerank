package pagerank;

import pagerank.Vector;

import java.util.ArrayList;

/**
 * Graph class with a (reversed) adjacency lists representations
 */
public class Graph {
    private int mSize;
    private ArrayList<Integer>[] mAdjacency;
    private int[] mOutDegrees;

    /**
     * Creates a new graph
     * @param size the number of vertices in the graph
     */
    public Graph(int size) {
        mSize = size;
        mAdjacency = new ArrayList[mSize];

        for (int i = 0; i < mSize; ++i)
            mAdjacency[i] = new ArrayList<Integer>();

        mOutDegrees = new int[mSize];
    }

    /**
     * Adds a new directed edge to the graph
     * @param source the source of the edge
     * @param destination the destination of the edge
     */
    public void addEdge(int source, int destination) {
        mAdjacency[destination].add(source);
        mOutDegrees[source]++;
    }

    /**
     * Computes the Pagerank for the given graph
     * @param beta    the probability to continue the walk, 1 - beta is the probability to randomly jump to another vertex
     * @param epsilon the value to determine when the vector is stationary
     * @return        the Pagerank vector
     */
    public Vector computePagerank(double beta, double epsilon) {
        Vector r = new Vector(mSize, 1.0 / (double)mSize);
        Vector r_ = new Vector(mSize);

        do {
            r_.copyFrom(r);

            for (int i = 0; i < mSize; ++i) {
                r.set(i, 0.0);

                if (mAdjacency[i].size() > 0) {
                    double sum = 0.0;

                    for (Integer j : mAdjacency[i])
                        sum += r_.get(j) / (double) mOutDegrees[j];

                    sum *= beta;

                    r.set(i, sum);
                }
            }

            double S = r.sum();

            for (int i = 0; i < mSize; ++i)
                r.set(i, r.get(i) + (1.0 - S) / (double)mSize);

        } while (Vector.absMinus(r, r_).sum() > epsilon);

        return r;
    }
}
