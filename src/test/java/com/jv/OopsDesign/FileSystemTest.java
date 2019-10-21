package com.jv.OopsDesign;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.jv.OopsDesign.observer.FileSystem;

@RunWith(JUnit4.class)
public class FileSystemTest {
	
	private FileSystem fileSystem;
	
	@Before
	public void setup() {
		fileSystem = new FileSystem();
	}
	
	@Test
	public void test() {
		fileSystem.mkdir("/opt");
		fileSystem.pwd();   
		fileSystem.mkdir("/opt/deploy");
		fileSystem.pwd();
		fileSystem.mkdir("/opt/deploy/release");
		fileSystem.pwd();
		fileSystem.mkdir("/opt/deploy/development");
		fileSystem.pwd();
	}

}
