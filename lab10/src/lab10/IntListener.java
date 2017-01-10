package lab10;

public class IntListener {
    public static void main(String[] args) {

        IntListSorted list = new IntListSorted();

        list.add(5);
        list.add(4);
        list.add(3);

        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println("Min: " + list.getMinimum());
        System.out.println("Max: " + list.getMaximum());
    }
}