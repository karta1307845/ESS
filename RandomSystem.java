import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class RandomSystem {
	private Country[] countrys;
	private Random rdm = new Random();
	private List<Integer> randomList = new ArrayList<Integer>();
	private int game;

	RandomSystem(Country[] countrys, int game) {
		this.countrys = countrys;
		this.game = game;
	}

	String[] getResult() {
		String[] str = new String[game];
		int size = countrys.length;
		while (randomList.size() < size) {
			int randomNumber = rdm.nextInt(size);
			if (randomList.contains(randomNumber) == false) {
				randomList.add(randomNumber);
			}
		}
		Integer[] randomNumbers = new Integer[size];
		randomList.toArray(randomNumbers);

		int index = 0;
		if (size % 2 == 0) {
			for (int i = 0; i < game; i++) {
				str[i] = countrys[randomNumbers[index]].countryName + " VS "
						+ countrys[randomNumbers[index + 1]].countryName;
				index += 2;
			}
			return str;
		} else {
			for (int i = 0; i < game - 1; i++) {
				str[i] = countrys[randomNumbers[index]].countryName + " VS "
						+ countrys[randomNumbers[index + 1]].countryName;
				index += 2;
			}
			str[game - 1] = countrys[randomNumbers[index]].countryName;
			return str;
		}
	}
}
