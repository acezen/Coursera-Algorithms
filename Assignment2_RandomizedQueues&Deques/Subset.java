import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by CtheSky on 2016/9/7.
 */
public class Subset {
    public static void main(String[] args) {
        int k = Integer.valueOf(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        String[] inputs = StdIn.readAllStrings();
        for (int i = 0; i < inputs.length; i++)
            rq.enqueue(inputs[i]);
        for (int i = 0; i < k; i++)
            StdOut.println(rq.dequeue());
    }
}
