package utils;

public class TestPerformance {
	
	private static long begin;
	
	private static long end;
	
	public static long getBegin() {
		begin = System.currentTimeMillis();
		return begin;
	}
	
	public static long getEnd() {
		end = System.currentTimeMillis();
		return end;
	}
	
	public static String getUsedTimeMillons(long begin,long end) {
		return Math.abs((end - begin))+"ms";
	}
	
	public static long getMemory() {
		return Runtime.getRuntime().freeMemory();
	}
	
	public static String usedMemory(long beginM,long endM) {
		return Math.abs(beginM-endM)+"MB";
	}
}
