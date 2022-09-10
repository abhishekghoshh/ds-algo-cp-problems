package problems.linkedlist;

public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> last;

	Node(T data) {
		this.data = data;
		this.next = null;
		last = this;
	}

	Node() {
		this.next = null;
		last = this;
	}

	@SafeVarargs
	Node(T... datas) {
		Node<T> node = this;
		if (datas.length != 0) {
			node.data = datas[0];
			Node<T> newNode = null;
			for (int i = 1; i < datas.length; i++) {
				newNode = new Node<>(datas[i]);
				node.next = newNode;
				node = newNode;
			}
		}
		this.last = node;
	}

	/**
	 * @return T return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return Node<T> return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> next(Node<T> next) {
		this.last.next = next;
		this.last = next.last;
		return this;
	}

	public Node<T> last() {
		return this.last;
	}

	public static <T> Node<T> last(Node<T> node) {
		while (null != node.next) {
			node = node.next;
		}
		return node;
	}

	public int getCount() {
		return count(this);
	}

	public static <T> int count(Node<T> node) {
		if (null == node)
			return 0;
		int count = 0;
		while (node.next != null) {
			node = node.next;
			count++;
		}
		return count;
	}

	@Override
	public String toString() {
		Node<T> node = this;
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		while (null != node) {
			if (null != node.next) {
				sb.append(node.data + ", ");
			}
			if (null == node.next) {
				sb.append(node.data);
			}
			node = node.next;
		}
		sb.append(" ]");
		return sb.toString();
	}

	public void print() {
		print(this);
	}

	public static <T> void print(Node<T> node) {
		System.out.println(node.toString());
	}

	public Node<T> attach(Node<T> head) {
		this.last.next = head;
		this.last = head.last;
		return this;
	}

	public Node<T> cycle(Node<T> head1, Node<T> head2) {
		this.attach(head1).attach(head2).attach(head1);
		return this;
	}
}
