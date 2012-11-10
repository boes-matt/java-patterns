package com.boes.patterns.structure;

import com.boes.patterns.type.ListType;
import com.boes.patterns.type.NodeType;

import com.boes.patterns.visitor.RemoveVisitor;
import com.boes.patterns.visitor.StringVisitor;
import com.boes.patterns.visitor.SubstituteVisitor;
import com.boes.patterns.visitor.OccursVisitor;

public class List implements ListType {

	NodeType list;
	
	public List() {
		list = new Empty();
	}
	
	@Override
	public ListType cons(Object value) {
		list = new Node(value, list);
		return this;
	}
	
	@Override
	public void remove(Object o) {
		list = (NodeType) list.accept(new RemoveVisitor(o));
	}

	@Override
	public void substitute(Object n, Object o) {
		list = (NodeType) list.accept(new SubstituteVisitor(n, o));
	}

	@Override
	public int occurs(Object a) {
		return (Integer) list.accept(new OccursVisitor(a));
	}
	
	@Override
	public String toString() {
		return (String) list.accept(new StringVisitor());
	}

}
