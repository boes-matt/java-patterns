package com.boes.patterns.type;

public interface ListType {
	ListType cons(Object value);
	void remove(Object o);
	void substitute(Object n, Object o);
	int occurs(Object a);
	String toString();
}
