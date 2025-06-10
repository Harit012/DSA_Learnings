// Create a node
function createNode(value) {
  return {
    value,
    next: null
  };
}

// Create a linked list object with some methods
function createLinkedList() {
  return {
    head: null,

    append(value) {
      const newNode = createNode(value);
      if (!this.head) {
        this.head = newNode;
        return;
      }
      let current = this.head;
      while (current.next) {
        current = current.next;
      }
      current.next = newNode;
    },

    print() {
      let current = this.head;
      const values = [];
      while (current) {
        values.push(current.value);
        current = current.next;
      }
      console.log(values.join(" -> "));
    }
  };
}

// Usage
const list = createLinkedList();
list.append(1);
list.append(2);
list.append(3);
list.print(); // Output: 1 -> 2 -> 3
console.log('list: ', JSON.stringify(list,null,2));
