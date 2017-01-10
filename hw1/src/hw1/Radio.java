package hw1;

// Volume Limit
public class Radio {
	// Constants
	public static final double VOLUME_INCREMENT = 0.16;
	
	// Class Variables
	private double minFrequency;
	private double maxFrequency;
	private double stationFrequency;
	private double volume;
	private int numStations;
	private int currentStation;
	private int interval;
	
	/**
	 * Constructs a Radio object.
	 * @param givenMinFrequency The minimum frequency in the frequency range.
	 * @param givenMaxFrequency The maximum frequency in the frequency range.
	 * @param givenNumStations The number of stations per given frequency range.
	 */
	public Radio(double givenMinFrequency, double givenMaxFrequency, int givenNumStations) {
		minFrequency = givenMinFrequency;
		maxFrequency = givenMaxFrequency;
		numStations = givenNumStations;
		
		interval = (int) ((maxFrequency - minFrequency) / numStations);
		
		volume = 0;
		currentStation = 0;
	}
	
	/**
	 * Gets the frequency of a given station.
	 * @return Returns the frequency of the current station.
	 */
	public double getFrequency() {
		stationFrequency = ((currentStation * interval + (interval / 2)) + minFrequency);
		
		return stationFrequency;
	}
	
	/**
	 * Gets the station number of the current station.
	 * @return Returns the current station.
	 */
	public int getStationNumber() {
		return currentStation;
	}
	
	/**
	 * Get the current volume.
	 * @return Returns the current volume.
	 */
	public double getVolume() {
		return volume;
	}
	
	/**
	 * Sets the station number.
	 * @param stationNumber The station number you wish to set.
	 */
	public void setStationNumber(int stationNumber) {
		if (stationNumber < 0) {
			currentStation = 0;
		} else if (stationNumber > numStations) {
			stationNumber = numStations;
		} else if (stationNumber == numStations) {
			currentStation = numStations - 1;
		} else {
			currentStation = stationNumber;
		}	
	}
	
	/**
	 * Sets the current station based on a given frequency.
	 * @param frequency Frequency that you wish to set.
	 */
	public void setStationFromFrequency(double frequency) {
		currentStation = (int) Math.round((frequency - (interval / 2) - minFrequency) / interval);
	}
	
	/**
	 * Changes the station in a downward direction.
	 */
	public void stationDown() {
		if (currentStation <= 0) {
			currentStation = numStations;
			currentStation--;
		} else if (currentStation > 0) {
			currentStation--;
		}
	}
	
	/**
	 * Changes the station in a upward direction.
	 */
	public void stationUp() {
		if (currentStation == (numStations - 1)) {
			currentStation = 0;
		} else if(currentStation < numStations) {
			currentStation++;
		}
	}
	
	/**
	 * Decreases the volume by 0.16.
	 */
	public void volumeDown() {
		volume = volume - VOLUME_INCREMENT;
		volume = Math.max(volume, 0.0);
	}
	
	/**
	 * Increases the volume by 0.16.
	 */
	public void volumeUp() {
		volume = volume + VOLUME_INCREMENT;
		volume = Math.min(volume, 1.0);
	}
}