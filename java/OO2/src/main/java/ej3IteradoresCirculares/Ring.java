package ej3IteradoresCirculares;

public class Ring<T> {

	protected T[] source;
	protected int idx;

	public Ring(T[] src) {
		source = src;
		idx = 0;
	}

	public T next() {
	if (idx>=source.length)
		idx=0;
	return source[idx++];
	}

}