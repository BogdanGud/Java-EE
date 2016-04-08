import java.util.*;

public class Tester {

    static long testPopulate(Collection collection, int elementsCount) {
        collection.clear();
        long sum = 0;
        int testCount = 100;
        for (int j = 0; j < testCount; j++) {
            Date start = new Date();
            for (int i = 0; i < elementsCount; i++) {
                collection.add(i);
            }
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
            collection.clear();
        }
        return sum / testCount;
    }

    static long testAddList(List list) {
        long sum = 0;
        int testCount = 100;
        int amountElements = 100;
        int i = 0;
        for (int j = 0; j < testCount; j++) {
            Date start = new Date();
            while (i < amountElements) {
                list.add(i++);
                list.add(0, i++);
                list.add(list.size() / 2, i++);
            }
            i = 0;
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
        }
        list.clear();
        return sum / testCount;

    }

    static long testAddSet(Set set) {
        long sum = 0;
        int testIterationsCount = 100;
        int amountElements = 100;
        int i = 0;
        for (int j = 0; j < testIterationsCount; j++) {
            Date start = new Date();
            while (i < amountElements) {
                set.add(i++);
            }
            i = 0;
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
        }
        set.clear();
        return sum / testIterationsCount;
    }

    static long testGetList(List list) {
        long sum = 0;
        int testCount = 100;
        int amountElements = 100;
        Object temp;
        for (int j = 0; j < testCount; j++) {
            Date start = new Date();
            int i = 0;
            while (i < amountElements) {
                temp = list.get(list.size() - 1);
                i++;
                temp = list.get(list.size() / 2 - 1);
                i++;
                temp = list.get(i);
                i++;
            }
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
        }
        list.clear();
        return sum / testCount;

    }

    static long testGetSet(Set set) {
        long sum = 0;
        int testIterationsCount = 100;
        int amountElements = 100;
        Object temp;
        for (int j = 0; j < testIterationsCount; j++) {
            int i = 0;
            Date start = new Date();
            while (i < amountElements) {
                for (Object elem : set) {
                    temp = elem;
                    i++;
                }
            }
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
        }
        set.clear();
        return sum / testIterationsCount;
    }


    static long testRemove(Collection collection) {
        long sum = 0;
        int testCount = 100;
        int amountElements = 100;
        int i = 0;
        for (int j = 0; j < testCount; j++) {
            i = 0;
            Date start = new Date();
            while (i < amountElements) {
                collection.remove(collection.size() - 1);
                i++;
                collection.remove(collection.size() / 2 - 1);
                i++;
                collection.remove(i++);
            }
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
        }
        collection.clear();
        return sum / testCount;

    }

    static long testContains(Collection collection) {
        long sum = 0;
        int testCount = 100;
        int amountElements = 100;
        int i = 0;
        for (int j = 0; j < testCount; j++) {
            i = 0;
            Date start = new Date();
            while (i < amountElements) {
                collection.contains(100);
                i++;
                collection.contains(collection.size() / 2 - i);
                i++;
            }
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
        }
        collection.clear();
        return sum / testCount;

    }

    static long testListIteratorAdd(List list) {
        long sum = 0;
        int testCount = 100;
        int amountElements = 100;
        long i = 0;
        for (int j = 0; j < testCount; j++) {
            i = 0;
            ListIterator<Long> iterator = list.listIterator();
            Date start = new Date();
            while ((i < amountElements) && iterator.hasNext()) {
                iterator.add(i++);

            }
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
        }

        list.clear();
        return sum / testCount;

    }

    static long testListIteratorRemove(List list) {
        long sum = 0;
        int testCount = 100;
        int amountElements = 100;
        long i = 0;
        for (int j = 0; j < testCount; j++) {
            i = 0;
            ListIterator<Long> iterator = list.listIterator();
            Date start = new Date();
            while ((i < amountElements)) {
                iterator.next();
                iterator.remove();
                i++;
            }
            Date finish = new Date();
            long resultTime = finish.getTime() - start.getTime();
            sum = sum + resultTime;
        }

        list.clear();
        return sum / testCount;

    }

    static void populateCollection(int elementsCount, Collection collection) {
        collection.clear();
        for (int i = 0; i < elementsCount; i++) {
            collection.add(i);
        }

    }
}
