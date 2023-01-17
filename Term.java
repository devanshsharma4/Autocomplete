import java.util.Arrays;
import java.util.Comparator;
 
public class Term implements Comparable<Term> {
 
    private final String query; // query
    private final long weight; // weight
 
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null || weight < 0) throw new IllegalArgumentException();
        this.query = query;
        this.weight = weight;
    }
 
    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new WeightCompare();
    }
 
    private static class WeightCompare implements Comparator<Term> {
        public int compare(Term a, Term b) {
            if (a.weight - b.weight < 0) return 1; // a.weight is less
            if (a.weight - b.weight > 0) return -1; // a.weight is greater
            else return 0; // weights are equal
        }
    }
 
 
    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) throw new IllegalArgumentException();
        return new PrefixCompare(r);
    }
 
 
    private static class PrefixCompare implements Comparator<Term> {
        private int r; // number of characters used to compare queries
 
        // initializes r
        public PrefixCompare(int r) {
            this.r = r;
        }
 
        public int compare(Term a, Term b) {
            String first = a.query;
            String second = b.query;
 
            for (int i = 0; i < r; i++) {
                if (first.length() == i)
                    if (second.length() == i)
                        return 0;
                    else return -1;
 
                if (second.length() == i) return 1;
 
                if (first.charAt(i) < second.charAt(i))
                    return -1;
                if (first.charAt(i) > second.charAt(i))
                    return 1;
            }
            return 0;
        }
    }
 
    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }
 
    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight + "\t" + query;
    }
 
    // unit testing (required)
    public static void main(String[] args) {
        Term test1 = new Term("dog", 3);
        Term test2 = new Term("cats", 4);
        Term test3 = new Term("penguin", 5);
        Term test4 = new Term("monkey", 2);
        Term test5 = new Term("dogcatcher", 4);
 
        Term[] terms = new Term[] { test1, test2, test3, test4, test5 };
 
        System.out.println("Test2's query is bigger than test1's query; "
                                   + "should print -1");
        System.out.println(test2.compareTo(test1));
 
        System.out.println("Sort by lexicographic order");
        Arrays.sort(terms);
        for (int i = 0; i < terms.length; i++)
            System.out.println(terms[i].toString());
 
        System.out.println("Sort by prefix order, r = 3");
        System.out.println("'dog' and 'dogcatcher' should be equal");
        Arrays.sort(terms, byPrefixOrder(3));
        for (int i = 0; i < terms.length; i++)
            System.out.println(terms[i].toString());
 
        System.out.println("Sort by reverse weight order");
        Arrays.sort(terms, byReverseWeightOrder());
        for (int i = 0; i < terms.length; i++)
            System.out.println(terms[i].toString());
 
        Term a = new Term("dodge", 3);
        Term b = new Term("dogss", 4);
        Term c = new Term("dobby", 5);
        Term d = new Term("doggy", 2);
        Term e = new Term("domestic", 4);
 
        System.out.println("sort new array by prefix order, r = 3");
        Term[] terms2 = new Term[] { a, b, c, d, e };
        Arrays.sort(terms2, byPrefixOrder(3));
        for (int i = 0; i < terms2.length; i++)
            System.out.println(terms2[i].toString());
 
        System.out.println("sort new array by prefix order, r = 4");
        Arrays.sort(terms2, byPrefixOrder(4));
        for (int i = 0; i < terms2.length; i++)
            System.out.println(terms2[i].toString());
    }
 
}