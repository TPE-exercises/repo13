import static org.junit.Assert.*;

import org.junit.Test;

import myutil.*;


public class TestExc {

	@Test(expected = OverflowException.class)
	public void overflowTestForStackArr() throws OverflowException {
		ADT stackArr = new StackArray(5);
		for (int i = 1; i <= 11; i++) {
			stackArr.push(i);
		}
	}

	@Test
	public void overflowTestForQueueArr() throws OverflowException {
		ADT queueArr = new QueueArray(5);
		for (int i = 1; i <= 11; i++) {
			queueArr.push(i);
		}
	}

	@Test(expected = OverflowException.class)
	public void overflowTestForStackLinkedList() throws OverflowException {
		ADT stackList = new StackLinkedList(5);
		for (int i = 1; i <= 11; i++) {
			stackList.push(i);
		}
	}

	@Test(expected = OverflowException.class)
	public void overflowTestForQueueLinkedList() throws OverflowException {
		ADT queueList = new QueueLinkedList(5);
		for (int i = 1; i <= 11; i++) {
			queueList.push(i);
		}
	}
	
	
	@Test
	public void isEmptyTest() throws OverflowException{
		ADT stackArr = new StackArray(5);
		ADT queueArr = new QueueArray(5);
		ADT stackList = new StackLinkedList(5);
		ADT queueList = new QueueLinkedList(5);
		
		assertEquals(true, stackArr.isEmpty());
		assertEquals(true, queueArr.isEmpty());
		assertEquals(true, stackList.isEmpty());
		assertEquals(true, queueList.isEmpty());
		
		
		
		stackArr.push(1);
		queueArr.push(1);
		stackList.push(1);
		queueList.push(1);
		
		assertEquals(false, stackArr.isEmpty());
		assertEquals(false, queueArr.isEmpty());
		assertEquals(false, stackList.isEmpty());
		assertEquals(false, queueList.isEmpty());
	}

	
	
	@Test
	public void frontTest() throws OverflowException{
		ADT stackArr = new StackArray(5);
		ADT queueArr = new QueueArray(5);
		ADT stackList = new StackLinkedList(5);
		ADT queueList = new QueueLinkedList(5);
		
		for (int i = 1; i <= 10; i++) {
			stackArr.push(i);
		}
		for (int i = 1; i <= 10; i++) {
			queueArr.push(i);
		}
		for (int i = 1; i <= 10; i++) {
			stackList.push(i);
		}
		for (int i = 1; i <= 10; i++) {
			queueList.push(i);
		}
		
		assertEquals(10, stackArr.front());
		assertEquals(1, queueArr.front());
		assertEquals(10, stackList.front());
		assertEquals(1, queueList.front());
		
		
		
	}
	
	
	@Test
	public void sizeTest() throws OverflowException{
		ADT stackArr = new StackArray(5);
		ADT queueArr = new QueueArray(5);
		ADT stackList = new StackLinkedList(5);
		ADT queueList = new QueueLinkedList(5);
		
		for(int i = 1; i <= 10; i++){
			stackArr.push(i);
		}
		
		for(int i = 1; i <= 10; i++){
			queueArr.push(i);
		}
		
		for(int i = 1; i <= 10; i++){
			stackList.push(i);
		}
		
		for(int i = 1; i <= 10; i++){
			queueList.push(i);
		}
		
		
		assertEquals(10, stackArr.size());
		assertEquals(10, queueArr.size());
		assertEquals(10, stackList.size());
		assertEquals(10, queueList.size());
	}
	
	@Test(expected = UnderflowException.class)
	public void underflowTestForStackArr() throws UnderflowException{
		ADT stackArr = new StackArray(5);
		stackArr.pop();
	}
	
	@Test(expected = UnderflowException.class)
	public void underflowTestForQueueArr() throws UnderflowException{
		ADT queueArr = new QueueArray(5);
		queueArr.pop();
	}
	
	@Test(expected = UnderflowException.class)
	public void underflowTestForStackLinkedList() throws UnderflowException{
		ADT stackList = new StackLinkedList(5);
		stackList.pop();
	}
	
	@Test(expected = UnderflowException.class)
	public void underflowTestForQueueLinkedList() throws UnderflowException{
		ADT queueList = new QueueLinkedList(5);
		queueList.pop();
	}
}
