package linkedlist;

public class DesignLinkedList {

	public static void main(String[] args) {
	}

	static class MyLinkedList {

		final class List {
			public int val;
			public List next;

			public List(int val) {
				this.val = val;
			}
		}

		private List head = null;
		private List last = null;
		int n = 0;

		public MyLinkedList() {

		}

		public int get(int index) {
			List current = head;
			while (index > 0) {
				current = current.next;
				index--;
			}
			return current.val;
		}

		public void addAtHead(int val) {
			List current = new List(val);
			n++;
			if (head == null) {
				head = current;
				last = head;
			} else {
				current.next = head;
				head = current;
			}
		}

		public void addAtTail(int val) {
			List current = new List(val);
			n++;
			if (head == null) {
				head = current;
				last = head;
			} else {
				last.next = current;
				last = last.next;
			}
		}

		public void addAtIndex(int index, int val) {
			if (index == 0) {
				addAtHead(val);
			} else if (index == n - 1) {
				addAtTail(val);
			} else {
				List parent = head;
				List temp = new List(val);
				n++;
				while (index > 1) {
					index--;
					parent = parent.next;
				}
				List next = parent.next;
				parent.next = temp;
				temp.next = next;
			}
		}

		public void deleteAtIndex(int index) {
			if (index == 0) {
				head = head.next;
			} else {
				List parent = head;
				while (index > 1) {
					index--;
					parent = parent.next;
				}
				parent.next = parent.next.next;
			}
			n--;
		}
	}

}
