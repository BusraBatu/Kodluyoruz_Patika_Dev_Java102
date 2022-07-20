package homework_WritingListClass;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        System.out.println("List Status : " + (list.isEmpty() ? "Empty" : "Full"));
        list.add(80);
        list.add(100);
        list.add(40);
        list.add(70);
        list.add(50);
        list.add(20);
        list.add(60);


        System.out.println("List Status : " + (list.isEmpty() ? "Empty" : "Full"));

        // Returns the first index found
        System.out.println("Index : " + list.indexOf(40));

        //Returns -1 if not found
        System.out.println("Index :" + list.indexOf(1000));

        //Returns the last index found
        System.out.println("Index : " + list.lastIndexOf(50));

        //Returns the list as an Object[] array.
        Object[] array = list.toArray();
        System.out.println("First element of Object array :" + array[0]);

        //Created a sublist of list data type
        MyList<Integer> subList = list.sublist(4, 6);
        System.out.println(subList.toString());

        //Queried if the value is in the list
        System.out.println("Value 60 in my list : " + list.contains(60));
        System.out.println("Value 780 in my list : " + list.contains(780));

        //Empties the list completely and reverts it to its default size
        list.clear();
        System.out.println(list.toString());
    }
}

