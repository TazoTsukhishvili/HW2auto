import java.util.Arrays;

abstract class VowelCounter {
    public abstract int countVowel(String input);
}

class VowelCounterImpl extends VowelCounter {
    @Override
    public int countVowel(String input) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char ch : input.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}

interface ReplaceA {
    String replaceSymbolA(String input);
}

interface ReplaceB {
    String replaceSymbolB(String input);
}

class ReplaceSymbols implements ReplaceA, ReplaceB {
    @Override
    public String replaceSymbolA(String input) {
        return input.toLowerCase().replace('a', 'z');
    }

    @Override
    public String replaceSymbolB(String input) {
        return input.toLowerCase().replace('b', 'w');
    }
}


public class Main {
    public static void main(String[] args) {

        VowelCounter vowelCounter = new VowelCounterImpl();
        String testString1 = "Palpatin says : I am the senate";
        int vowelCount = vowelCounter.countVowel(testString1);
        System.out.println("სტრინგი \"" + testString1 + "\" შეიცავს " + vowelCount + " ხმოვანს");

        ReplaceSymbols replacer = new ReplaceSymbols();
        String replaceAResult = replacer.replaceSymbolA("Pain Itself");
        String replaceBResult = replacer.replaceSymbolB("But in Latin sounds better (Dolorem Ipsum)");
        System.out.println("replaceSymbolA შედეგი: " + replaceAResult);
        System.out.println("replaceSymbolB შედეგი: " + replaceBResult);

        int[] arr = {18, -3, 5, -7, 6, 89, 13, 0, -89, -79, -33, 91, 61, -49};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("დალაგებული მასივი: " + Arrays.toString(arr));
    }
}