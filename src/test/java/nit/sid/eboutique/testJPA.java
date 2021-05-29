package nit.sid.eboutique;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class testJPA {

	
	@Test
	public void test1() {
		ClassPathXmlApplicationContext app = 
new ClassPathXmlApplicationContext( new String[] {"applicationContext.xml"});
		assertTrue(true);
		
	}void Catch(Exception e){
		assertTrue(e.getMessage(), false);
		
	}

}
