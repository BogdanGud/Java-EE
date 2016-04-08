import java.util.*;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        TestResult result10K = new TestResult();
        TestResult result100K = new TestResult();
        TestResult result1000K = new TestResult();

        ArrayList<Long> inputArrayList = new ArrayList();
        LinkedList<Long> inputLinkedList = new LinkedList();
        HashSet<Long> inputHashSet = new HashSet();
        TreeSet<Long> inputTreeSet = new TreeSet();

        //for Add
        Tester.populateCollection(10000, inputArrayList);
        Tester.populateCollection(10000, inputLinkedList);
        Tester.populateCollection(10000, inputHashSet);
        Tester.populateCollection(10000, inputTreeSet);
        result10K.arrayListResult.add(Tester.testAddList(inputArrayList));
        result10K.linkedListResult.add(Tester.testAddList(inputLinkedList));
        result10K.hashSetResult.add(Tester.testAddSet(inputHashSet));
        result10K.treeSettResult.add(Tester.testAddSet(inputTreeSet));

        Tester.populateCollection(100000, inputArrayList);
        Tester.populateCollection(100000, inputLinkedList);
        Tester.populateCollection(100000, inputHashSet);
        Tester.populateCollection(100000, inputTreeSet);
        result100K.arrayListResult.add(Tester.testAddList(inputArrayList));
        result100K.linkedListResult.add(Tester.testAddList(inputLinkedList));
        result100K.hashSetResult.add(Tester.testAddSet(inputHashSet));
        result100K.treeSettResult.add(Tester.testAddSet(inputTreeSet));

        Tester.populateCollection(1000000, inputArrayList);
        Tester.populateCollection(1000000, inputLinkedList);
        Tester.populateCollection(1000000, inputHashSet);
        Tester.populateCollection(1000000, inputTreeSet);
        result1000K.arrayListResult.add(Tester.testAddList(inputArrayList));
        result1000K.linkedListResult.add(Tester.testAddList(inputLinkedList));
        result1000K.hashSetResult.add(Tester.testAddSet(inputHashSet));
        result1000K.treeSettResult.add(Tester.testAddSet(inputTreeSet));

        //for Get
        Tester.populateCollection(10000, inputArrayList);
        Tester.populateCollection(10000, inputLinkedList);
        Tester.populateCollection(10000, inputHashSet);
        Tester.populateCollection(10000, inputTreeSet);
        result10K.arrayListResult.add(Tester.testGetList(inputArrayList));
        result10K.linkedListResult.add(Tester.testGetList(inputLinkedList));
        result10K.hashSetResult.add(Tester.testGetSet(inputHashSet));
        result10K.treeSettResult.add(Tester.testGetSet(inputTreeSet));

        Tester.populateCollection(100000, inputArrayList);
        Tester.populateCollection(100000, inputLinkedList);
        Tester.populateCollection(100000, inputHashSet);
        Tester.populateCollection(100000, inputTreeSet);
        result100K.arrayListResult.add(Tester.testGetList(inputArrayList));
        result100K.linkedListResult.add(Tester.testGetList(inputLinkedList));
        result100K.hashSetResult.add(Tester.testGetSet(inputHashSet));
        result100K.treeSettResult.add(Tester.testGetSet(inputTreeSet));

        Tester.populateCollection(1000000, inputArrayList);
        Tester.populateCollection(1000000, inputLinkedList);
        Tester.populateCollection(1000000, inputHashSet);
        Tester.populateCollection(1000000, inputTreeSet);
        result1000K.arrayListResult.add(Tester.testGetList(inputArrayList));
        result1000K.linkedListResult.add(Tester.testGetList(inputLinkedList));
        result1000K.hashSetResult.add(Tester.testGetSet(inputHashSet));
        result1000K.treeSettResult.add(Tester.testGetSet(inputTreeSet));

        //for Remove
        Tester.populateCollection(10000, inputArrayList);
        Tester.populateCollection(10000, inputLinkedList);
        Tester.populateCollection(10000, inputHashSet);
        Tester.populateCollection(10000, inputTreeSet);
        result10K.arrayListResult.add(Tester.testRemove(inputArrayList));
        result10K.linkedListResult.add(Tester.testRemove(inputLinkedList));
        result10K.hashSetResult.add(Tester.testRemove(inputHashSet));
        result10K.treeSettResult.add(Tester.testRemove(inputTreeSet));

        Tester.populateCollection(100000, inputArrayList);
        Tester.populateCollection(100000, inputLinkedList);
        Tester.populateCollection(100000, inputHashSet);
        Tester.populateCollection(100000, inputTreeSet);
        result100K.arrayListResult.add(Tester.testRemove(inputArrayList));
        result100K.linkedListResult.add(Tester.testRemove(inputLinkedList));
        result100K.hashSetResult.add(Tester.testRemove(inputHashSet));
        result100K.treeSettResult.add(Tester.testRemove(inputTreeSet));

        Tester.populateCollection(1000000, inputArrayList);
        Tester.populateCollection(1000000, inputLinkedList);
        Tester.populateCollection(1000000, inputHashSet);
        Tester.populateCollection(1000000, inputTreeSet);
        result1000K.arrayListResult.add(Tester.testRemove(inputArrayList));
        result1000K.linkedListResult.add(Tester.testRemove(inputLinkedList));
        result1000K.hashSetResult.add(Tester.testRemove(inputHashSet));
        result1000K.treeSettResult.add(Tester.testRemove(inputTreeSet));

        //for Contains
        Tester.populateCollection(10000, inputArrayList);
        Tester.populateCollection(10000, inputLinkedList);
        Tester.populateCollection(10000, inputHashSet);
        Tester.populateCollection(10000, inputTreeSet);
        result10K.arrayListResult.add(Tester.testContains(inputArrayList));
        result10K.linkedListResult.add(Tester.testContains(inputLinkedList));
        result10K.hashSetResult.add(Tester.testContains(inputHashSet));
        result10K.treeSettResult.add(Tester.testContains(inputTreeSet));

        Tester.populateCollection(100000, inputArrayList);
        Tester.populateCollection(100000, inputLinkedList);
        Tester.populateCollection(100000, inputHashSet);
        Tester.populateCollection(100000, inputTreeSet);
        result100K.arrayListResult.add(Tester.testContains(inputArrayList));
        result100K.linkedListResult.add(Tester.testContains(inputLinkedList));
        result100K.hashSetResult.add(Tester.testContains(inputHashSet));
        result100K.treeSettResult.add(Tester.testContains(inputTreeSet));

        Tester.populateCollection(1000000, inputArrayList);
        Tester.populateCollection(1000000, inputLinkedList);
        Tester.populateCollection(1000000, inputHashSet);
        Tester.populateCollection(1000000, inputTreeSet);
        result1000K.arrayListResult.add(Tester.testContains(inputArrayList));
        result1000K.linkedListResult.add(Tester.testContains(inputLinkedList));
        result1000K.hashSetResult.add(Tester.testContains(inputHashSet));
        result1000K.treeSettResult.add(Tester.testContains(inputTreeSet));

        //for Populate
        result10K.arrayListResult.add(Tester.testPopulate(inputArrayList, 10000));
        result10K.linkedListResult.add(Tester.testPopulate(inputLinkedList, 10000));
        result10K.hashSetResult.add(Tester.testPopulate(inputHashSet, 10000));
        result10K.treeSettResult.add(Tester.testPopulate(inputTreeSet, 10000));

        result100K.arrayListResult.add(Tester.testPopulate(inputArrayList, 100000));
        result100K.linkedListResult.add(Tester.testPopulate(inputLinkedList, 100000));
        result100K.hashSetResult.add(Tester.testPopulate(inputHashSet, 100000));
        result100K.treeSettResult.add(Tester.testPopulate(inputTreeSet, 100000));

        result1000K.arrayListResult.add(Tester.testPopulate(inputArrayList, 1000000));
        result1000K.linkedListResult.add(Tester.testPopulate(inputLinkedList, 1000000));
        result1000K.hashSetResult.add(Tester.testPopulate(inputHashSet, 1000000));
        result1000K.treeSettResult.add(Tester.testPopulate(inputTreeSet, 1000000));

        //for Iterator.add
        Tester.populateCollection(10000, inputArrayList);
        Tester.populateCollection(10000, inputLinkedList);
        result10K.arrayListResult.add(Tester.testListIteratorAdd(inputArrayList));
        result10K.linkedListResult.add(Tester.testListIteratorAdd(inputLinkedList));

        Tester.populateCollection(100000, inputArrayList);
        Tester.populateCollection(100000, inputLinkedList);
        result100K.arrayListResult.add(Tester.testListIteratorAdd(inputArrayList));
        result100K.linkedListResult.add(Tester.testListIteratorAdd(inputLinkedList));

        Tester.populateCollection(1000000, inputArrayList);
        Tester.populateCollection(1000000, inputLinkedList);
        result1000K.arrayListResult.add(Tester.testListIteratorAdd(inputArrayList));
        result1000K.linkedListResult.add(Tester.testListIteratorAdd(inputLinkedList));


        //for Iterator.remove
        Tester.populateCollection(10000, inputArrayList);
        Tester.populateCollection(10000, inputLinkedList);
        result10K.arrayListResult.add(Tester.testListIteratorRemove(inputArrayList));
        result10K.linkedListResult.add(Tester.testListIteratorRemove(inputLinkedList));

        Tester.populateCollection(100000, inputArrayList);
        Tester.populateCollection(100000, inputLinkedList);
        result100K.arrayListResult.add(Tester.testListIteratorRemove(inputArrayList));
        result100K.linkedListResult.add(Tester.testListIteratorRemove(inputLinkedList));

        Tester.populateCollection(1000000, inputArrayList);
        Tester.populateCollection(1000000, inputLinkedList);
        result1000K.arrayListResult.add(Tester.testListIteratorRemove(inputArrayList));
        result1000K.linkedListResult.add(Tester.testListIteratorRemove(inputLinkedList));


        TestExporter testExporter = new TestExporter();
        testExporter.reportToCsv("test.csv", result10K, result100K, result1000K);
        System.out.println("Calculations finished.");
    }
}
