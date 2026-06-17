class LRUCache {

    private Node head;
    private Node tail;
    private int capacity;
    private int current;
    private HashMap<Integer, Node> hm = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.current = 0;
    }
    
    public int get(int key) {

        StringBuilder sb = new StringBuilder();
        sb.append("get ").append(key).append(" --> ");
        Node cur = head;
        int c = 0;
        while (cur != null) {
            sb.append("k").append(cur.getKey()).append(" v").append(cur.getValue()).append(", ");
            cur = cur.getNext();
            c++;
            if (c > capacity) {
                sb.append("BREAK");
                break;
            }
        }
        System.out.println(sb.toString());


        if (!hm.containsKey(key)) return -1;

        Node n = hm.get(key);
        if (n == tail) return n.getValue();



        Node tmp = n.getPrev();

        if (n == head) {
            n.getNext().setPrev(null);
            head = n.getNext();
            n.setNext(null);
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }

        else {
            tmp.setNext(n.getNext());
            n.getNext().setPrev(tmp);
            n.setPrev(tail);
            tail.setNext(n);
            n.setNext(null);
            tail = n;
        }

        return n.getValue();
    }
    
    public void put(int key, int value) {

        System.out.println("put k" + key + " v" + value);
        if (head == null) {
            head = tail = new Node(value, key);
            hm.put(key, head);
            current++;
        }

        else if (hm.containsKey(key)) {
            Node cur = hm.get(key);
            cur.setValue(value);
            Node tmp = cur.getPrev();

            if (cur == tail) {
                return;
            }

            else if (cur == head) {
                cur.getNext().setPrev(null);
                head = cur.getNext();
                cur.setNext(null);
                tail.setNext(cur);
                cur.setPrev(tail);
                tail = cur;
            }

            else {
                tmp.setNext(cur.getNext());
                cur.getNext().setPrev(tmp);
                cur.setPrev(tail);
                tail.setNext(cur);
                cur.setNext(null);
                tail = cur;
            }
        }

        else {
            Node n = new Node(value, key);
            hm.put(key, n);
            if (current < capacity) {
                n.setPrev(tail);
                tail.setNext(n);
                tail = n;
                current++;
            }
            else {
                Node h = head.getNext();
                hm.remove(head.getKey());
                if (h != null) {
                    h.setPrev(null);
                    head = h;
                    tail.setNext(n);
                    n.setPrev(tail);
                    tail = n;
                }
                else {
                    head = tail = n;
                }
            }
        }
    }
}

class Node {

    private Node prev;
    private Node next;
    private int value;
    private int key;

    public Node(int value, int key){
        this.value = value;
        this.key = key;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public int getValue() {
        return this.value;
    }

    public int getKey() {
        return this.key;
    }
}
