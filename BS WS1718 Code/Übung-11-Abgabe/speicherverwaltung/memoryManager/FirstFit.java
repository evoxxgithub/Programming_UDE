package speicherverwaltung.memoryManager;

import java.util.HashMap;
import speicherverwaltung.processManager.Process;

public class FirstFit extends MemoryManager {

    private final boolean[] memoryCells;
    private final HashMap<Process, Integer> processIdMemoryMap;
    private final String TAB = "\t";
    private final String NEWLINE = "\n";

    public FirstFit(int size) {
        super(size);
        this.memoryCells = new boolean[size];
        this.processIdMemoryMap = new HashMap<>();
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean allocateMemory(Process process) {
        int allocationSize = process.getSize();
        try {
            int startIndex = getStartOfFirstFit(allocationSize);
            this.processIdMemoryMap.put(process, startIndex);
            for (int i = 0; i < allocationSize; i++) {
                this.memoryCells[startIndex + i] = true;
            }
        } catch (NullPointerException e) {
            System.err.println("Looped through whole memory without finding enough free space - failed to allocate");
            return false;
        }
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void freeMemory(Process process) {
        int startindex = this.processIdMemoryMap.get(process);
        this.freeCellsFrom(startindex, startindex+process.getSize());
        // TODO Auto-generated method stub

    }

    private void freeCellsFrom(int index_a, int index_b){ // a inclusive, b exclusive
        for (int i = index_a; i < index_b; i++) {
            this.memoryCells[i] = false;
        }
    }

    @Override
    public void printAllProcesses() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id \tName \tSize \tstart \tEndPos\n");
        for(Process p : this.processIdMemoryMap.keySet()) {
            sb.append(p.toString());
            sb.append(TAB);
            sb.append(this.processIdMemoryMap.get(p));
            sb.append(TAB);
            sb.append(this.processIdMemoryMap.get(p)+p.getSize()-1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private int getStartOfFirstFit(int allocationSize) {

        int currentCellPointer = 0;
        while(true) {
            int lastFreeCell = this.getLastFreeCell(currentCellPointer);
            if (lastFreeCell-currentCellPointer >= allocationSize) return currentCellPointer;
            else currentCellPointer = getNextFreeCellAfter(lastFreeCell);
        }
    }

    private int getNextFreeCellAfter(int lastFreeCell) {
        int nextFreeCell = lastFreeCell;
        while(this.memoryCells[++nextFreeCell]) {
        }
        return nextFreeCell;
    }


    private int getLastFreeCell(int currentCellPointer) {
        while(!this.memoryCells[currentCellPointer++] && currentCellPointer < this.getMemorySize()){
        }
        return --currentCellPointer;
    }

}
