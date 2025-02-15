public class PrimeSieveI64 extends PrimeSieveBase{
	private static final int SHIFT_SIZE = 6;
	private static final int SHIFT_SIZE_ADD = SHIFT_SIZE + 1;// one more because we don't store even numbers
	private static final int SIZE = 1 << SHIFT_SIZE;
	
	// bitset of odd numbers, zero means its a prime
	private final long[] dataSet;
	
	public PrimeSieveI64(int sieveSize) {
		super(sieveSize);
		dataSet = new long[((sieveSize + 1) >> 1) / SIZE + 1];
	}

	public boolean getBit(int index) {
		// index >> 1 because of not storing even numbers
		return (dataSet[index >> SHIFT_SIZE_ADD] & (1l << (index >> 1))) == 0;
	}

	public void clearBit(int index) {
		dataSet[index >> SHIFT_SIZE_ADD] = dataSet[index >> SHIFT_SIZE_ADD] | (1l << (index >> 1));
	}
	
	public static void main(String[] args) throws InterruptedException {
		PrimeSieveBase.run(() -> new PrimeSieveI64(1000000), args);
	}
}
