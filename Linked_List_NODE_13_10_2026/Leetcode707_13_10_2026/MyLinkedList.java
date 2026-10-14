 class MyLinkedList {
        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node head;
        private int size;

        public MyLinkedList() {
            this.head = new Node(0);
            this.size = 0;
        }

        public int get(int index) {
            Node curr = head;
            if(index < 0 || index > size) {
                return -1;
            }
            for(int i=0; i< index ; i++) {
                curr = curr.next;
            }
            return curr.data;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void addAtTail(int val) {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            Node newNode = new Node(val);
            curr.next = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            Node curr = head;
            if(index ==0) {
                addAtHead(val);
            }
            if(index<0|| index > size) {
                throw new IllegalArgumentException("Loi nhap lieu");
            }
            for(int i=0; i< index; i++) {
                curr = curr.next;
            }
            Node newNode = new Node(val);
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if(index ==0) {
                head = head.next;
                size--;
            }
            if(index < 0 || index > size) {
                throw new IllegalArgumentException("Loi nhap lieu");
            }

            Node curr = head;
            for(int i=0; i<size -1;i++) {
                curr = curr.next;
            }
            curr = curr.next.next;
        }
    }