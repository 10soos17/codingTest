package play;

public class DungFactory {

	public static IDungMessageReceiver getDunggMessageReceiver(DungType dung) {
		IDungMessageReceiver dungMessageReceiver = null;

		switch (dung) {
		
		case BANANA:
			dungMessageReceiver = new HSDungMessageReceiver();
			break;
		case DONGRAMI:
			dungMessageReceiver = new SSDungMessageReceiver();
			break;
		default:
			throw new RuntimeException("No type");
		}

		return dungMessageReceiver;
	}

}
