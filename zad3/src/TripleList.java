import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TripleList<T> implements Iterable<T>{

    private T value;
    private TripleList<T> prev;
    private TripleList<T> next;
    private TripleList<T> mid;

    private int count;

    public TripleList(){
        value = null;
        prev = null;
        next = null;
        mid = null;
    }

    public TripleList(T value) {
        this();
        this.value = value;
    }

    public int Count() {
        return count;
    }

    public TripleList<T> PreviousElement(){
        return prev;
    }

    public TripleList<T> MiddleElement(){
        return mid;
    }

    public TripleList<T> NextElement(){
        return next;
    }

    public void add(T value){
        ++count;

        if(this.value == null){
            this.value = value;
        }else if(mid == null){
            mid = new TripleList<>();
            mid.add(value);
            mid.setMiddle(this);
        }else{
            if(next == null)
                next = new TripleList<>();
            next.add(value);
            next.setPrevious(this);
        }
    }

    public void add(TripleList<T> values) {
        for (T value : values.toList()) {
            add(value);
        }
   }


    public void setMiddle(TripleList<T>middle){
        mid = middle;
    }

    public void setPrevious(TripleList<T> previous) {
        prev = previous;
    }

    public T Value(){
        return value;
    }

    public Iterator<T> iterator() {
        return new TripleListIterator();
    }

    public List<T> toList(){
        Iterator<T> iterator = getIterator();
        List<T> ele = new ArrayList<>();
        while(iterator.hasNext()){
            ele.add(iterator.next());
        }
        return ele;
    }

    public Iterator<T> getIterator() {
        return new TripleListIterator();
    }

     private class TripleListIterator implements Iterator<T> {

        private int helper;

        public TripleListIterator() {
            helper = 0;
        }

        public boolean hasNext() {
            if(this.helper < count)
                return true;
            else
                return false;
        }

        public T next() {
            if(this.hasNext()) {
                TripleList<T> curr = TripleList.this;
                for (int i = 0; i < helper; i++) {
                    if (i % 2 == 0) {
                        curr = curr.MiddleElement();
                    } else {
                        curr = curr.MiddleElement().NextElement();
                    }
                }
                helper++;
                return curr.Value();
            }
            throw new NoSuchElementException();
        }
    }
}
