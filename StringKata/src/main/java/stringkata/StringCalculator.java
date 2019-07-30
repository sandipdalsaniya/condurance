package stringkata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class StringCalculator {

	public static int add(String numbers) throws RuntimeException{
		if(numbers==null || numbers.isEmpty())
			return 0;
		String tokens[] = tokenize(numbers);
		int sum=0;
		sum = doSum(tokens, sum);
		return sum;
	}

	private static int doSum(String[] tokens, int sum) throws RuntimeException{
		List<Integer> negatives = new ArrayList<>();
		for(String token:tokens) {
			int number = Integer.parseInt(token);
			if(number<0) {
				negatives.add(number);
				continue;
			}
			sum+= number;
		}
		if(!negatives.isEmpty()) {
			throw new RuntimeException("negatives not allowed:"+StringUtils.collectionToCommaDelimitedString(negatives));
		}
		return sum;
	}

	private static String[] tokenize(String numbers) {
		String regEx = ",|\n";
		if(numbers.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
			m.matches();
			regEx = m.group(1);
			numbers = m.group(2);
		}
		return numbers.split(regEx);
	}	
}
