package searching;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class HashLinearProbing<Key, Value> {
	private int N;
	private int M;
	private Key[] keys;
	private Value[] vals;
	protected int lgM;
	
	private static final int[] primes = {
			 1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
	            32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
	            8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
	            536870909, 1073741789, 2147483647
	};
	
	
	HashLinearProbing(int M) {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	
		this.M = M;
	}

	public HashLinearProbing() {
		this.M = 16;
		keys = (Key[]) new Object[16];
		vals = (Value[]) new Object[16];
		
		lgM = (int) (Math.log(M) / Math.log(2));
	}

	private int hash(Key key) {
		int t = key.hashCode() & 0x7fffffff ;
		if (M < 26)
			t = t % primes[lgM + 5];
		return t % M;
	}

	public void put(Key key, Value value) {
		if (N >= M / 2)
			resize(2 * M);
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key)) {
				vals[i] = value;
				return;
			}
		keys[i] = key;
		vals[i] = value;
		N++;

	}

	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key))
				return vals[i];
		return null;
	}

	public void delete(Key key) {
		if (!contains(key))
			return;
		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % M;
		keys[i] = null;
		vals[i] = null;
		i = (i + 1) % M;
		while (keys[i] != null) {
			Key keyToRedo = keys[i];
			Value valtoRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo, valtoRedo);
			i = (i + 1) % M;

		}
		N--;
		if (N > 0 && N == M / 8)
			resize(M / 2);

	}

	public void resize(int u) {
		HashLinearProbing<Key, Value> t = new HashLinearProbing<Key, Value>(u);
		for (int i = 0; i < M; i++)
			if (keys[i] != null)
				t.put(keys[i], vals[i]);

		keys = t.keys;
		vals = t.vals;
		M = t.M;

	}

	public boolean contains(Key key) {
		int i = 0;
		for (i = 0; i < N; i++) {
			if (keys[i].equals(key))
				return true;
		}
		return false;
	}

	public Iterable<Key> allkeys() {
		List<Key> itkeys = new ArrayList<Key>() ;
		for(int v = 0; v < M ; v++ ) {
			if(keys[v] != null) {
				itkeys.add(keys[v]);
			}
		}

		return itkeys;
	}
}