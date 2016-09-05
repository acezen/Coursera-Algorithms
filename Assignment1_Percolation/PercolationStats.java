import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
/**
 * Created by CtheSky on 2016/9/5.
 */
public class PercolationStats {
    private int t;
    private double[] results;
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

    public PercolationStats(int n, int trials) {
        // perform trials independent experiments on an n-by-n grid
        if (n <= 0) throw new IllegalArgumentException("n <= 0");
        if (trials <= 0)  throw new IllegalArgumentException("trails <= 0");

        t = trials;
        results = new double[trials];
        double size = n * n;
        for (int tried = 0; tried < trials; tried++) {
            int count = 0;
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int i = 1 + StdRandom.uniform(n);
                int j = 1 + StdRandom.uniform(n);
                if (!perc.isOpen(i, j)) {
                    perc.open(i, j);
                    count++;
                }
            }
            results[tried] = count / size;
        }

        mean = StdStats.mean(results);
        stddev = StdStats.stddev(results);
        confidenceLo = mean - 1.96 * stddev / Math.sqrt(t);
        confidenceHi = mean + 1.96 * stddev / Math.sqrt(t);
    }

    public double mean() {
        // sample mean of percolation threshold
        return mean;
    }

    public double stddev() {
        // sample standard deviation of percolation threshold
        return stddev;
    }

    public double confidenceLo() {
        // low  endpoint of 95% confidence interval
        return confidenceLo;
    }

    public double confidenceHi() {
        // high endpoint of 95% confidence interval
        return confidenceHi;
    }

    public static void main(String[] args) {
        
    }
}
