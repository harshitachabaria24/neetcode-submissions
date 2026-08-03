class MyHashMap {

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] bucket;
    private int size = 1000;

    public MyHashMap() {
        bucket = new LinkedList[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {

        int index = hash(key);

        if (bucket[index] == null) {
            bucket[index] = new LinkedList<>();
        }

        for (Node node : bucket[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        bucket[index].add(new Node(key, value));
    }

    public int get(int key) {

        int index = hash(key);

        if (bucket[index] == null)
            return -1;

        for (Node node : bucket[index]) {

            if (node.key == key)
                return node.value;
        }

        return -1;
    }

    public void remove(int key) {

        int index = hash(key);

        if (bucket[index] == null)
            return;

        Iterator<Node> it = bucket[index].iterator();

        while (it.hasNext()) {

            if (it.next().key == key) {
                it.remove();
                return;
            }
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */