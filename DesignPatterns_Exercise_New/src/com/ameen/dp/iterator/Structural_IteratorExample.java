package com.ameen.dp.iterator;

/**
 * Used to access the elements of aggregate object
 * without exposing how it is implemented
 */
public class Structural_IteratorExample {
    public static void main(String[] args) {
        MyCollection myCollection = new CollectionImpl(
                new String[]{"Mohamed", "Ameen", "ullah", "Dhameem", "Nisha", "Safana"});
        MyIterator myIterator = myCollection.getMyIterator();
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }
}


interface MyIterator {
    boolean hasNext();
    Object next();
}

interface MyCollection {
    MyIterator getMyIterator();

}

class CollectionImpl implements MyCollection {

    String inputArr[];

    CollectionImpl(String[] strArray) {
        inputArr = strArray;
    }


    @Override
    public MyIterator getMyIterator() {
        return new Itr();
    }

    private class Itr implements MyIterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < inputArr.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return inputArr[index++];
            }
            return null;
        }
    }
}
