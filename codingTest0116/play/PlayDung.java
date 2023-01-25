package play;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;

import javax.imageio.ImageIO;

//param을 img x
//return을 img / 검색이미지
public class PlayDung {

	public static void main(String[] args) {
		Long now = System.currentTimeMillis();
		Timestamp timeStamp = new Timestamp(now);

		IDungMessageReceiver dungMessageeceiver = DungFactory.getDunggMessageReceiver(DungType.BANANA);
		String msg = dungMessageeceiver.getMessage(now);
		System.out.println(msg);
		test();
	}

	public static void test() {
		String IMAGE_URL = "https://blog.kakaocdn.net/dn/VIxFi/btqZqqf3QFS/n2otuLtHQo8TQVOwMAmmbk/img.png";

		try {
			// if you want to get png or jpg ... you can do it
			URL url = new URL(IMAGE_URL);
			// String extension = IMAGE_URL.substring(IMAGE_URL.indexOf('.') + 1);
			String extension = IMAGE_URL.substring(IMAGE_URL.lastIndexOf(".") + 1); // 확장자
			String fileName = "test"; // 이미지 이름

			BufferedImage image = ImageIO.read(url);

			File file = new File("/Users/soos/Desktop/downImage/" + fileName + "." + extension);
			if(!file.exists()) { // 해당 경로의 폴더가 존재하지 않을 경우
				file.mkdirs(); // 해당 경로의 폴더 생성
			}

			ImageIO.write(image, extension, file);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
