package speicherverwaltung;

import speicherverwaltung.memoryManager.MemoryManager;
import speicherverwaltung.processManager.ProcessManager;
import speicherverwaltung.processManager.Process;

//import speicherverwaltung.memoryManager.FirstFit; --> since we got the factory method, we dont need to import
// FirstFit
public class TestProgram {

	private static final int physicalMemorySize = 2048;

	private static ProcessManager pm;
	private static MemoryManager mmu;

	/**
	 * Test test-program does not reflect the real interaction between Processes and the memory Manager. However, it can
	 * be used to test different memory management strategies.
	 * 
	 * For simplicity, in this test-program every process receives its own continuous block of memory
	 */
	public static void main(String[] args) {
		//mmu = new FirstFit(physicalMemorySize);
        mmu = MemoryManager.firstFitWithSize(physicalMemorySize);
		pm = new ProcessManager(mmu);

		Process p1 = createProcess("p1", 510);
		Process p2 = createProcess("p2", 120);
		Process p3 = createProcess("p3", 780);
		Process p4 = createProcess("p4", 255);
		Process p5 = createProcess("p5", 110);
		killProcess(p1);
		killProcess(p4);
		Process p6 = createProcess("p6", 80);
		Process p7 = createProcess("p7", 250);
	}

	/**
	 * This function just calls "process.kill()" and produces some nice output
	 */
	private static void killProcess(Process process) {
	    if (process == null) { System.out.println("could not kill process"); return; }
	    String name = process.getName();

	    if (process.kill()) {
	        System.out.println("New Memory Partitioning after killing process: " + name);
	        mmu.printAllProcesses();
			}

		else System.err.println("could not kill process");
	}

	/**
	 * This function just calls "pm.createProcess(name, size)" and produces some nice output
	 */
	private static Process createProcess(String name, int size) {
		Process result;
		result = pm.createProcess(name, size);
		if (null != result) {
			System.out.println("New Memory Partitioning after starting process: " + name + " with size:" + size);
			mmu.printAllProcesses();
		}
		System.out.println();
		return result;
	}
}
