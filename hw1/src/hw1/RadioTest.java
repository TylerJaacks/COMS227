package hw1;

public class RadioTest {
	
	public static void main(String[] args) {
		
		Radio r = new Radio(100, 200, 5);

		// try out the volume controls

		System.out.println(r.getVolume()); // expected 0.0

		r.volumeUp();

		r.volumeUp();

		System.out.println(r.getVolume()); // expected 0.32

		r.volumeDown();

		r.volumeDown();

		r.volumeDown();

		System.out.println(r.getVolume()); // expected 0.0

		// setting stations

		System.out.println(r.getStationNumber()); // expected 0

		r.setStationNumber(4);

		System.out.println(r.getStationNumber()); // expected 4

		r.stationUp();

		r.stationUp();

		System.out.println(r.getStationNumber()); // expected 1

		r.stationDown();

		System.out.println(r.getStationNumber()); // expected 0

		// frequency calculations

		System.out.println(r.getFrequency()); // expected 110.0

		r.setStationFromFrequency(162.0);

		System.out.println(r.getStationNumber()); // expected 3

		System.out.println(r.getFrequency()); // expected 170.0
	}
}