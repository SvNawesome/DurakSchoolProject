package cardImages;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class ImageStorage {
	public static Image card_back_image = new Image("cardImages/card_back.png", 101, 145, false, false);

	public static Image hearts6 = new Image("cardImages/hearts6.png", 101, 145, false, false);
	public static Image hearts7 = new Image("cardImages/hearts7.png", 101, 145, false, false);
	public static Image hearts8 = new Image("cardImages/hearts8.png", 101, 145, false, false);
	public static Image hearts9 = new Image("cardImages/hearts9.png", 101, 145, false, false);
	public static Image hearts10 = new Image("cardImages/hearts10.png", 101, 145, false, false);
	public static Image hearts11 = new Image("cardImages/hearts11.png", 101, 145, false, false);
	public static Image hearts12 = new Image("cardImages/hearts12.png", 101, 145, false, false);
	public static Image hearts13 = new Image("cardImages/hearts13.png", 101, 145, false, false);
	public static Image hearts14 = new Image("cardImages/hearts14.png", 101, 145, false, false);
	
	public static Image diamonds6 = new Image("cardImages/diamonds6.png", 101, 145, false, false);
	public static Image diamonds7 = new Image("cardImages/diamonds7.png", 101, 145, false, false);
	public static Image diamonds8 = new Image("cardImages/diamonds8.png", 101, 145, false, false);
	public static Image diamonds9 = new Image("cardImages/diamonds9.png", 101, 145, false, false);
	public static Image diamonds10 = new Image("cardImages/diamonds10.png", 101, 145, false, false);
	public static Image diamonds11 = new Image("cardImages/diamonds11.png", 101, 145, false, false);
	public static Image diamonds12 = new Image("cardImages/diamonds12.png", 101, 145, false, false);
	public static Image diamonds13 = new Image("cardImages/diamonds13.png", 101, 145, false, false);
	public static Image diamonds14 = new Image("cardImages/diamonds14.png", 101, 145, false, false);
	
	public static Image spades6 = new Image("cardImages/spades6.png", 101, 145, false, false);
	public static Image spades7 = new Image("cardImages/spades7.png", 101, 145, false, false);
	public static Image spades8 = new Image("cardImages/spades8.png", 101, 145, false, false);
	public static Image spades9 = new Image("cardImages/spades9.png", 101, 145, false, false);
	public static Image spades10 = new Image("cardImages/spades10.png", 101, 145, false, false);
	public static Image spades11 = new Image("cardImages/spades11.png", 101, 145, false, false);
	public static Image spades12 = new Image("cardImages/spades12.png", 101, 145, false, false);
	public static Image spades13 = new Image("cardImages/spades13.png", 101, 145, false, false);
	public static Image spades14 = new Image("cardImages/spades14.png", 101, 145, false, false);
	
	public static Image clubs6 = new Image("cardImages/clubs6.png", 101, 145, false, false);
	public static Image clubs7 = new Image("cardImages/clubs7.png", 101, 145, false, false);
	public static Image clubs8 = new Image("cardImages/clubs8.png", 101, 145, false, false);
	public static Image clubs9 = new Image("cardImages/clubs9.png", 101, 145, false, false);
	public static Image clubs10 = new Image("cardImages/clubs10.png", 101, 145, false, false);
	public static Image clubs11 = new Image("cardImages/clubs11.png", 101, 145, false, false);
	public static Image clubs12 = new Image("cardImages/clubs12.png", 101, 145, false, false);
	public static Image clubs13 = new Image("cardImages/clubs13.png", 101, 145, false, false);
	public static Image clubs14 = new Image("cardImages/clubs14.png", 101, 145, false, false);
	

	public static HashMap<String, Image> card_face_Images ;


	public static  Map<String, Image> getInstance() {
		if (card_face_Images==null) {
		card_face_Images=new HashMap<String, Image>();
		card_face_Images.put("hearts6", hearts6);
		card_face_Images.put("hearts7", hearts7);
		card_face_Images.put("hearts8", hearts8);
		card_face_Images.put("hearts9", hearts9);
		card_face_Images.put("hearts10", hearts10);
		card_face_Images.put("hearts11", hearts11);
		card_face_Images.put("hearts12", hearts12);
		card_face_Images.put("hearts13", hearts13);
		card_face_Images.put("hearts14", hearts14);

		card_face_Images.put("diamonds6", diamonds6);
		card_face_Images.put("diamonds7", diamonds7);
		card_face_Images.put("diamonds8", diamonds8);
		card_face_Images.put("diamonds9", diamonds9);
		card_face_Images.put("diamonds10", diamonds10);
		card_face_Images.put("diamonds11", diamonds11);
		card_face_Images.put("diamonds12", diamonds12);
		card_face_Images.put("diamonds13", diamonds13);
		card_face_Images.put("diamonds14", diamonds14);

		card_face_Images.put("spades6", spades6);
		card_face_Images.put("spades7", spades7);
		card_face_Images.put("spades8", spades8);
		card_face_Images.put("spades9", spades9);
		card_face_Images.put("spades10", spades10);
		card_face_Images.put("spades11", spades11);
		card_face_Images.put("spades12", spades12);
		card_face_Images.put("spades13", spades13);
		card_face_Images.put("spades14", spades14);
		
		card_face_Images.put("clubs6", clubs6);
		card_face_Images.put("clubs7", clubs7);
		card_face_Images.put("clubs8", clubs8);
		card_face_Images.put("clubs9", clubs9);
		card_face_Images.put("clubs10", clubs10);
		card_face_Images.put("clubs11", clubs11);
		card_face_Images.put("clubs12", clubs12);
		card_face_Images.put("clubs13", clubs13);
		card_face_Images.put("clubs14", clubs14);
		}
		return card_face_Images;
	}
		
		
	
		
	   
}
