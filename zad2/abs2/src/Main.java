
public class Main
{
    public static void main(String[] args) {
        TripleList<Integer> tripleList = new TripleList<>();
        int b=2,d=4;
        tripleList.add(1);
        tripleList.add(b);
        tripleList.add(3);
        tripleList.add(d);

        for(Integer i: tripleList){
            System.out.println(i);
        }
    }
}
