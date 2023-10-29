package play;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class HSDungMessageReceiver implements IDungMessageReceiver {

	@Override
	public void makeImage() {
		String IMAGE_URL = "https://www.google.com/favicon.ico";

		try {
			// if you want to get png or jpg ... you can do it
			URL url = new URL(IMAGE_URL);
			String extension = IMAGE_URL.substring(IMAGE_URL.indexOf('.') + 1);

			BufferedImage image = ImageIO.read(url);
			File file = new File("test.ico");

			ImageIO.write(image, extension, file);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	@Override
	public String getMessage(long timestamp) {
		// [타임 스탬프 값을 다시 날짜 및 시간 데이터로 변환 실시]
		Date date = new Date(timestamp); // [타임 스탬프 값 문자열 형 변환]
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss"); // [Date 형식으로 변경 : 24 시간 포맷 형태]
		String time = String.valueOf(sdf.format(date));

		return time + ": IM PHS";
	}

}
