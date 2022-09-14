package util;

public class LinkedListNode<T> {
	public enum ToStringApproach {
		SIMPLE, WITH_LAST, WITH_RANDOM, WITH_BOTTOM;
	}

	public static ToStringApproach TO_STRING_APPROACH = ToStringApproach.SIMPLE;
	public T data;
	public LinkedListNode<T> next;
	public LinkedListNode<T> random;
	public LinkedListNode<T> last;
	public LinkedListNode<T> bottom;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
		last = this;
	}

	public LinkedListNode() {
		this.next = null;
		last = this;
	}

	@SafeVarargs
	public LinkedListNode(T... datas) {
		LinkedListNode<T> node = this;
		if (datas.length != 0) {
			node.data = datas[0];
			LinkedListNode<T> newNode = null;
			for (int i = 1; i < datas.length; i++) {
				newNode = new LinkedListNode<>(datas[i]);
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
	 * @return LinkedListNode<T> return the next
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public LinkedListNode<T> next(LinkedListNode<T> next) {
		this.last.next = next;
		this.last = next.last;
		return this;
	}

	public LinkedListNode<T> last() {
		return this.last;
	}

	public static <T> LinkedListNode<T> last(LinkedListNode<T> node) {
		while (null != node.next) {
			node = node.next;
		}
		return node;
	}

	public int getCount() {
		return count(this);
	}

	public static <T> int count(LinkedListNode<T> node) {
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
		LinkedListNode<T> node = this;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		this.TO_STRING_APPROACH = null != this.TO_STRING_APPROACH ? this.TO_STRING_APPROACH : ToStringApproach.SIMPLE;
		switch (this.TO_STRING_APPROACH) {
		case SIMPLE:
			while (null != node) {
				sb.append(node.data);
				node = node.next;
				if (null != node) {
					sb.append(",");
				}
			}
			break;
		case WITH_LAST:
			while (null != node) {
				sb.append(node.data);
				if (null != node.next) {
					sb.append(",");
				}
				if (last == node) {
					if (sb.charAt(sb.length() - 1) == ',') {
						sb.deleteCharAt(sb.length() - 1);
					}
					break;
				}
				node = node.next;
			}
			break;
		case WITH_RANDOM:
			while (null != node) {
				sb.append("{").append("\"data\":").append(node.data).append(",").append("\"random\":")
						.append(null != node.random ? node.random.data : "null").append("}");
				if (null != node.next) {
					sb.append(",");
				}
				node = node.next;
			}
			break;
		case WITH_BOTTOM:
			while (null != node) {
				sb.append("[").append(node.data);
				LinkedListNode<T> bottom = node.bottom;
				while (null != bottom) {
					sb.append(",").append(bottom.data);
					bottom = bottom.bottom;
				}
				sb.append("]");
				node = node.next;
				if (null != node) {
					sb.append(",");
				}
			}
			break;
		default:
			while (null != node) {
				sb.append(node.data);
				node = node.next;
				if (null != node) {
					sb.append(",");
				}
			}
			break;
		}
		sb.append("]");
		return sb.toString();
	}

	public void print() {
		print(this);
	}

	public static <T> void print(LinkedListNode<T> node) {
		System.out.println(node.toString());
	}

	public LinkedListNode<T> attach(LinkedListNode<T> head) {
		this.last.next = head;
		this.last = head.last;
		return this;
	}

	public LinkedListNode<T> cycle(LinkedListNode<T> head1, LinkedListNode<T> head2) {
		this.attach(head1).attach(head2).attach(head1);
		return this;
	}

	@SuppressWarnings("unchecked")
	public LinkedListNode<T> bottom(T... items) {
		LinkedListNode<T> node = this, current;
		if (null != items && items.length > 0) {
			for (T item : items) {
				current = new LinkedListNode<>(item);
				node.bottom = current;
				node = current;
			}
		}
		return this;
	}
}
