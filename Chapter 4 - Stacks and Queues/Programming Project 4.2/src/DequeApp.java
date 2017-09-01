//Written for challenge 4.2 by Manveer Tamber
class Deque {
	int maxSize;
	int arr[];
	int elem;
	int left;
	int right;

	public Deque(int m) {
		maxSize = m;
		arr = new int[maxSize];
		left = 1;
		right = 0;
		elem = 0;
	}

	public boolean insertLeft(int n) {
		if (!isFull()) {
			arr[left] = n;
			left++;
			if (left == maxSize) {
				left = 0;
			}
			elem++;
			return true;
		}
		return false;
	}

	public boolean insertRight(int n) {
		if (!isFull()) {
			arr[right] = n;
			right--;
			elem++;
			if (right == -1) {
				right = maxSize - 1;
			}
			return true;
		}
		return false;
	}

	public int removeLeft() {
		if (!isEmpty()) {
			left--;
			elem--;
			if (left == -1) {
				left = maxSize - 1;
			}
			return arr[left];
		}
		return -1;
	}

	public int removeRight() {
		if (!isEmpty()) {
			right++;
			elem--;
			if (right == maxSize) {
				right = 0;
			}
			return arr[right];
		}
		return -1;
	}

	public int peekLeft() {
		if (!isEmpty()) {
			return arr[left - 1];
		}
		return -1;
	}

	public int peekRight() {
		if (!isEmpty()) {
			return arr[right + 1];
		}
		return -1;
	}

	public boolean isFull() {
		return elem == maxSize;
	}

	public boolean isEmpty() {
		return elem == 0;
	}
}

public class DequeApp {

	public static void main(String[] args) {
		Deque thing = new Deque(100);
		for (int count = 0; count < 100; count++) {
			thing.insertLeft(count);
		}
		for (int count = 0; count < 10; count++) {
			thing.removeRight();
		}
		for (int count = 0; count < 10; count++) {
			thing.insertLeft(count);
		}
		while (!thing.isEmpty()) {
			System.out.print(thing.removeRight() + " ");
		}

	}

}
