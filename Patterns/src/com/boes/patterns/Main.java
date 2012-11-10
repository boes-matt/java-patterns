package com.boes.patterns;

import com.boes.patterns.type.ListType;
import com.boes.patterns.type.NodeType;

import com.boes.patterns.structure.List;
import com.boes.patterns.structure.Node;
import com.boes.patterns.structure.Empty;

import com.boes.patterns.visitor.StringVisitor;
import com.boes.patterns.visitor.RemoveVisitor;
import com.boes.patterns.visitor.SubstituteVisitor;
import com.boes.patterns.visitor.OccursVisitor;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Main extends TestCase {

	public void testNodeType() {
		NodeType root = new Node(1, new Node(2, new Node(3, new Empty())));
		String list = (String) root.accept(new StringVisitor());
		Assert.assertEquals("(1, (2, (3, ())))", list);
		System.out.println(list);
		
		root = (NodeType) root.accept(new SubstituteVisitor(3, 2));
		Assert.assertEquals("(1, (3, (3, ())))", root.accept(new StringVisitor()));
		System.out.println(root.accept(new StringVisitor()));
		
		Assert.assertEquals(2, root.accept(new OccursVisitor(3)));
		System.out.println("3 is in the list " + root.accept(new OccursVisitor(3)) + " times.");
		
		root = (NodeType) root.accept(new SubstituteVisitor(2, 3));
		Assert.assertEquals("(1, (2, (2, ())))", root.accept(new StringVisitor()));
		System.out.println(root.accept(new StringVisitor()));
		
		root = (NodeType) root.accept(new RemoveVisitor(2));
		Assert.assertEquals("(1, ())", root.accept(new StringVisitor()));
		System.out.println(root.accept(new StringVisitor()));
		
		Assert.assertEquals(0, root.accept(new OccursVisitor(3)));
		System.out.println("3 is in the list " + root.accept(new OccursVisitor(3)) + " times.");
		
		System.out.println();
	}
	
	public void testListType() {
		ListType list = new List();
		list.cons(3).cons(2).cons(1);
		Assert.assertEquals("(1, (2, (3, ())))", list.toString());
		System.out.println(list);
		
		list.substitute(3, 2);
		Assert.assertEquals("(1, (3, (3, ())))", list.toString());
		System.out.println(list);
		
		Assert.assertEquals(2, list.occurs(3));
		System.out.println("3 is in the list " + list.occurs(3) + " times.");
		
		list.substitute(2, 3);
		Assert.assertEquals("(1, (2, (2, ())))", list.toString());
		System.out.println(list);
		
		list.remove(2);
		Assert.assertEquals("(1, ())", list.toString());
		System.out.println(list);
		
		Assert.assertEquals(0, list.occurs(3));
		System.out.println("3 is in the list " + list.occurs(3) + " times.");
		
		System.out.println();
	}
	
}
