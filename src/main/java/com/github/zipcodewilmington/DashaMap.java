package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap implements HashMapX {
    Node[] arr = new Node[26];

    private int hashFunctionOne(String input){
        if (input.length() > 0){
            return input.toLowerCase().charAt(0) - 97;
        }
        return -1;
    }

    @Override
    public void set(String key, String value) {
        int idx = hashFunctionOne(key);
        Node current = arr[idx];
        if(current == null){
            arr[idx] = new Node(key, value);
            return;
        }
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(new Node(key, value));
    }

    @Override
    public String delete(String key) {
        if(bucketSize(key) < 2){
            arr[hashFunctionOne(key)] = null;
            return ""; //fix later
        }
        Node current = arr[hashFunctionOne(key)].getNext();
        Node prev = arr[hashFunctionOne(key)];
        while(current != null){
            if(current.getKey().equals(key)){
                String val = current.getData();
                prev.setNext(current.getNext());
                return val;
            }
            prev = current;
            current = current.getNext();

        }
        return null;
    }

    @Override
    public String get(String key) {
        int idx = hashFunctionOne(key);
        Node current = arr[idx];
        while(current != null){
            if(current.getKey().equals(key)){
                return current.getData();
            }
            current = current.getNext();
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public long size() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            Node current = arr[i];

            while(current != null){
                count++;
                current = current.getNext();
            }
        }
        return count;
    }

    @Override
    public long bucketSize(String key) {
        long count = 0;
        Node current = arr[hashFunctionOne(key)];

        while(current != null){
            count++;
            current = current.getNext();
        }

        return count;
    } //where is wordlist.txt
}
