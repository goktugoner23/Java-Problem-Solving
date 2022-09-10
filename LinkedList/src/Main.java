public class Main {
    public static void main(String[] args) {
        SimpleLinked list = new SimpleLinked();
        System.out.println(list.printList());
        list.addNode(1);
        list.addNode(5);
        list.addNode(12);
        System.out.println(list.printList());
        list.deleteNode(2);
        list.deleteNode(5);
        System.out.println(list.printList());
        list.deleteNode(1);
        list.deleteNode(12);
        System.out.println(list.printList());
        list.deleteNode(123);

        System.out.println("DOUBLE LINKED");
        DoubleLinked list2 = new DoubleLinked();
        //System.out.println(list2.printList());
        list2.addNode(1);
        list2.addNode(3);
        list2.addNode(4);
        list2.deleteNode(4);
        list2.deleteNode(1);
        list2.deleteNode(3);
        list2.deleteNode(234);
        System.out.println(list2.printList());

        System.out.println("ADD AFTER TEST");
        DoubleLinked list3 = new DoubleLinked();
        list3.addNode(7);
        list3.addNode(43);
        list3.addNode(82);
        list3.addNode(17);
        list3.addNode(28);
        System.out.println(list3.printList());
        list3.addAfter(32, 12);
        System.out.println(list3.printList());
        list3.addAfter(12, 78);
        System.out.println(list3.printList());
        list3.addAfter(12, 53);
        System.out.println(list3.printList());
        list3.deleteNode(17);
        list3.addAfter(82,18);
        System.out.println(list3.printList());
        list3.clearAll();
        System.out.println(list3.printList());
        list3.addAfter(2,3);
        System.out.println(list3.printList());
        System.out.println(list3.divisionByEleven());
        list3.addNode(3);
        System.out.println(list3.printList());
        System.out.println(list3.divisionByEleven());

        //arayıp index verecek
        //listeye digitler eklenecek 11 e bölünüyor mu diye bakacaz
    }
}

