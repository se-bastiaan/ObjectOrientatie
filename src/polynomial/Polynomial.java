package polynomial;

import java.util.*;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Sjaak Smetsers
 * @date 10-03-2015
 */
public class Polynomial {

    /**
     * A polynomial is a sequence of terms here kept in an List
     */
    List<Term> terms;

    /**
     * A constructor for creating the zero Polynomial zero is presented as an
     * empty list of terms and not as a single term with 0 as a coefficient
     */
    public Polynomial() {
        terms = new ArrayList<>();
    }

    /**
     * A Constructor creating a polynomial from the argument string.
     *
     * @param s a String representing a list of terms which is converted to a
     *          scanner and passed to scanTerm for reading each individual term
     */
    public Polynomial(String s) {
        terms = new ArrayList<>();
        Scanner scan = new Scanner(s);

        for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
            terms.add(t);
        }

        sortAndCheckTerms();
    }

    /**
     * The copy constructor for making a deep copy
     *
     * @param p the copied polynomial
     */
    public Polynomial(Polynomial p) {
        terms = new ArrayList<>(p.terms.size());
        for (Term t : p.terms) {
            terms.add(new Term(t));
        }
        sortAndCheckTerms();
    }

    /**
     * Sort all terms by exponent and remove 0 coeffs
     */
    private void sortAndCheckTerms() {
        Collections.sort(terms, new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                if (o1.getExp() < o2.getExp()) {
                    return -1;
                } else if (o1.getExp() == o2.getExp()) {
                    return 0;
                }
                return 1;
            }
        });

        ListIterator<Term> lit = terms.listIterator();
        while (lit.hasNext()) {
            Term t = lit.next();
            if (t.getCoef() == 0) {
                lit.remove();
            }
        }
    }

    /**
     * A straightforward conversion of a Polynomial into a string based on the
     * toString for terms
     *
     * @return a readable string representation of this
     */
    @Override
    public String toString() {
        ListIterator<Term> lita = terms.listIterator(terms.size());
        StringBuilder stringBuilder = new StringBuilder();
        while (lita.hasPrevious()) {
            Term item = lita.previous();
            if(item.getCoef() != 0) {
                stringBuilder.append(item);
            } else {
                if(stringBuilder.length() > 3)
                    stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
            }

            if (lita.hasPrevious()) {
                stringBuilder.append(" + ");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Add {@link polynomial.Polynomial} b to this {@link polynomial.Polynomial}
     * @param b {@link polynomial.Polynomial}
     * @return this {@link polynomial.Polynomial}
     */
    public Polynomial plus(Polynomial b) {
        sortAndCheckTerms();
        b.sortAndCheckTerms();

        if(terms.size() <= 0) {
            terms = new ArrayList<>(b.terms.size());
            for (Term t : b.terms) {
                terms.add(new Term(t));
            }
        } else {
            ListIterator<Term> lita = terms.listIterator(), litb = b.terms.listIterator();
            while (lita.hasNext() && litb.hasNext()) {
                Term ta = lita.next(), tb = litb.next();
                if (ta.getExp() == tb.getExp()) {
                    ta.plus(tb);
                } else if (ta.getExp() > tb.getExp()) {
                    lita.set(new Term(tb));
                    lita.add(ta);
                    if (lita.hasPrevious()) {
                        lita.previous();
                    }
                } else if (ta.getExp() < tb.getExp()) {
                    if (!lita.hasNext()) {
                        lita.add(new Term(tb));
                    } else {
                        litb.previous();
                    }
                }
            }
        }

        sortAndCheckTerms();
        return this;
    }

    /**
     * Subtract {@link polynomial.Polynomial} b from this {@link polynomial.Polynomial}
     * @param b {@link polynomial.Polynomial}
     * @return this {@link polynomial.Polynomial}
     */
    public Polynomial minus(Polynomial b) {
        sortAndCheckTerms();
        b.sortAndCheckTerms();

        if(terms.size() <= 0) {
            terms = new ArrayList<>(b.terms.size());
            for (Term t : b.terms) {
                terms.add(new Term(t));
            }
        } else {
            ListIterator<Term> lita = terms.listIterator(), litb = b.terms.listIterator();
            while (lita.hasNext() && litb.hasNext()) {
                Term ta = lita.next(), tb = litb.next();
                tb = new Term(-tb.getCoef(), tb.getExp()); // make negative

                if (tb.getCoef() == 0) {
                    // Do nothing when coef is 0
                } else if (ta.getExp() == tb.getExp()) {
                    ta.plus(tb);
                    if (ta.getCoef() == 0) {
                        lita.remove();
                    }
                } else if (ta.getExp() > tb.getExp()) {
                    lita.set(new Term(tb));
                    lita.add(ta);
                    if (lita.hasPrevious()) {
                        lita.previous();
                    }
                } else if (ta.getExp() < tb.getExp()) {
                    if (!lita.hasNext()) {
                        lita.add(new Term(tb));
                    } else {
                        litb.previous();
                    }
                }
            }
        }

        sortAndCheckTerms();
        return this;
    }

    /**
     * Multiply {@link polynomial.Polynomial} b with this {@link polynomial.Polynomial}
     * @param b {@link polynomial.Polynomial}
     * @return this {@link polynomial.Polynomial}
     */
    public Polynomial times(Polynomial b) {
        ArrayList<Term> newTerms = new ArrayList<>();
        for (Term tb : b.terms) {
            for(Term ta : terms) {
                Term t = new Term(ta);
                t.times(tb);
                newTerms.add(t);
            }
        }
        terms = newTerms;

        sortAndCheckTerms();

        ListIterator<Term> lit = terms.listIterator();
        while (lit.hasNext()) {
            int prev = -1;
            if(lit.hasPrevious())
                prev = lit.previousIndex();
            Term t = lit.next();

            if (t.getCoef() == 0) {
                lit.remove();
            }

            if(prev > -1 && terms.get(prev).getExp() == t.getExp()) {
                t.plus(terms.get(prev));
                lit.remove();
                lit.previous();
                lit.set(t);
            }
        }

        sortAndCheckTerms();

        return this;
    }

    // Not sure if this is correct
    /**
     * Divide this {@link polynomial.Polynomial} by {@link polynomial.Polynomial} b
     * @param b {@link polynomial.Polynomial}
     * @return this {@link polynomial.Polynomial}
     */
    public Polynomial divide(Polynomial b) {
        int maxDegree = b.getDegree();

        if(maxDegree == 0) {
            System.err.println("Polynomial divide by zero error");
            return this;
        }

        Polynomial remainder = new Polynomial(this);
        for (int i = this.getDegree(); i >= maxDegree; i--) {
            Polynomial p;
            if(remainder.terms.size() <= i) {
                p = new Polynomial("0 " + (i - maxDegree));
            } else {
                p = new Polynomial(remainder.terms.get(i).getCoef() + " " + (i - maxDegree));
            }
            remainder = minus(new Polynomial(b).times(p));
        }

        return this;
    }

    /**
     * Apply the given integer to the polynomial
     * @param x An integer
     * @return The value of the polynomial when we apply the given X
     */
    public int apply(int x) {
        int value = 0;
        for(Term t : terms) {
            value += t.getCoef() * Math.pow(x, t.getExp());
        }
        return value;
    }

    /**
     * Test if this {@link polynomial.Polynomial} is equal to the provided object
     * @param object {@link Object}
     * @return {@code true} if equal, {@code false} if not
     */
    @Override
    public boolean equals(Object object) {
        if (object != null && getClass() == object.getClass()) {
            Polynomial b = (Polynomial) object;
            if (terms.size() == b.terms.size()) {
                ListIterator<Term> lita = terms.listIterator(), litb = b.terms.listIterator();
                while (lita.hasNext() && litb.hasNext()) {
                    Term ta = lita.next(), tb = litb.next();
                    // Return false if not equal, continue if equal
                    if (!ta.equals(tb)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Get maximum degree of poly
     * @return Degree
     */
    private int getDegree() {
        sortAndCheckTerms();
        return terms.get(terms.size() - 1).getExp();
    }

}
