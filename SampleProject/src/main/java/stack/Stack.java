package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {
	
	private List<Object> objects = new ArrayList<>();
	
	void push(Object object) {
		objects.add(object);
	}
	
	Object pop() {
		if(objects.isEmpty())
			throw new EmptyStackException();
		
		return objects.remove(objects.size()-1);
	}
}

