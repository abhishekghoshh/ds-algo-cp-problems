package problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Problem link : 
 * https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
 * */
public class CountOfAnagrams {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();// TODO check it later aditya verma
		type5();// TODO check it later
	}

	// TODO check it later
	private static void type5() {
		String s = "mforxxorfxdofr";
		String p = "for";
		List<Integer> ret = new ArrayList<>();
		if (s.length() < p.length())
			return;
		int[] pFreq = new int[26];
		for (var c : p.toCharArray()) {
			++pFreq[c - 'a'];
		}
		int i = 0;
		int sIdx = 0;
		int required = p.length();
		char[] S = s.toCharArray();
		for (var c : S) {
			if (--pFreq[c - 'a'] >= 0)
				--required;
			while (required == 0) {
				if (i - sIdx + 1 == p.length())
					ret.add(sIdx);
				if (++pFreq[S[sIdx++] - 'a'] > 0)
					++required;
			}
			++i;
		}
		System.out.println(ret.size());
		System.out.println(ret);
	}

	// sliding window
	// if the text size is n then time complexity is O(n)
	// Space complexity is O(sizeof(pattern))
	// so in previous approach we were checking the frequency array on each window
	// we can do better
	// we can use a counter to check
	// TODO
	private static void type4() {
		String text = "gvdzvbswujtwzpvqbogzjsrfqcuuxmpczmprhmuamfuqchosbqdujaxvxpujruczfdqqzzuavomjqohpvqpaufsmcsbmruxmgbhcexuxqwhxhfttvjhyzdevfoxujdmzqhxvamqrhvamxzuouopbusubsjzqcqfcrpmpgfcdxcrzxhfbpuhacramjqzqquzjouxmprugduqocpsfsmcvvbmxzhkzjdyvfmbfoipdmeosscqzpvhurumzarpzcvmcgjuxjdqabfpqoomqfmuubhxancnafsxzbubebvnfhlmpctfwmaubbqhpqquafzucpdupcoxzjgvvfxmqrzcoushrjmmsxhujmjpfvsgqopsucozardbzqmrucpbfmucuhqqzmxavcjvofacxfbsuxbqsqhpahuzgqmmrdpvjmcomuqzupuzrrpuusahcvvmhxjzufmfzacrbjqsummrxoqzgocqpdbupqdtsmozwsradrbfapoocvuugbzxczmhuufphmscujxzqvmpsmjqqqqjupfjbqhbupfqpsmamhzcavgoqomxudvszxruzmrccumbpzrhzfpajouqcgjozvrcpuvxqaduhcmmfuqbxmqsusqbqqcjupouvomhqudhucjpmzsragmfzzxrfsmcpbxvaulikzhvlmjpnouuropmsuqoxhfmjcqprfucmxuzavjzsqpbbqzaugumvhcdjoazruqqmufbsmbcapfzmczpduprxogsjmvxhvuchuqqqvrcfoujusmbzsurmhqxmdzfopqcauzubmqpjxcgphvadhzpxxkmnjlcajmxdouvoamscqxbpgmuvphqhrfzqucbsmujpczzqurfajiobhsbwktbccspqjuzvfmbvpmqmcxzhqquxzabamgroduphcfjrsouuhhsqpqmjszfcvdbugpcoauxczxbzqvuufraqujopmmmrlrnragnldauovgnxqudpjqcbpcqpzoghscrxujmomuzffxauasqhrmmvzqvubwlmhdrpgcozczmhruqaumxspfcfjqbqvuuozbasxjpvqumvhjuuhqzadbcmgcrfuqozcmbrsmoxuspjxmpufvzqapqqrjuspcppmuhqbodmszcvmjzfgqaamxubuqhzcvruxofamvudpbxhzozocqumuqjvsfpqrmfxgujphcmcrsauzbquahqpjsqzqsxczuvubzgucbfrxjoqocmvpummpmdarfhqrgrydabsbvgzosqasqurmmxqbpzuuhrofdujxucccpfjbmmzhpqavxuhaqmfmvxmmvdqpugrscqzbrjojshcqbuozpazfpuucxzvuzuqdhmbmxcjuogzbfspvcqqmfocpuasjpramuqrhkcusmgpqzbqprvuhazdmhjmsxcqfzjfcapuxorvqobmuuwwfkeumrxouslhxwjpvmsrozdvcbjgufpaumuxfrhhzmcmxpbcsazoqjqqquutzrwotonqzzoavsvrdfhsaczqpmghpjqujbmruxqpmcfoumbcuxusjvqoaufbcumcmhmjbzxrphzqrpuqxasufqpugdoczmvuzxhhsrjizszbaczjvcoxmdzjvhfcsmaqhxpfmsuqruuumbqoqgurppbfzdxjvvcpufmsmaacqzguoppouxqjbrhmrusqquczmhzgoubzmpjpuszvovdmcauhuqpxmfxqucrbqazghsfjqrmcnwhrszzugcqcmvdqcjzbhhqmfaupsxvoamfuxmuqpburjprocuzkmqazrqvrbmmospufacgzuuxcupjhqsqbxzphcjufvdomqhgmrucummzhzxupoqcopjavmfdxfusurqqbcjzspvabaovxvguxpmuhzqjzqumcqrafrudpubbpjsqhfmszmoccibsvcowzauxsuomzahprjccgduzzbqjqsomqvvbprmhcqmxfpuuffvymutvmbqqhpzjqqamdrxmprszuucgzxcmuhfpavvjsuobocufmdhzmsuupzjccraqqxbfufomuzjgpxbcasopqvrmvqhuodjujzpgfcrzmqxuumpqqcxupmhubasqzfcrvbovmshakdwvsocqjdufqgmqqhxpbrhupoufmuaxcrzmbzpavumzcjspsalpikolqzcggddlxmiuivnqhfzozgjuvfcmpcpxqsqhcxuhabpqmujrobzaqurmsmduvkzgenayzbwfesfsgfozpeynzsummepjcjpzafbuhqmmxuqczoxqgpqbmuscrauprodhzmfvusvoqptsofucbxrbqcqmhhupzzpsvfuusfqvcajzromampugdmqojxbxayipirvvxcmbjspquxmqcosuzzapucqrbmgouqhjmuhffavdrzprqsjbmvhacuuqhmxoqbcpjpfpurzgzuzvxsaocmmfudqrxbkzbixjubvsmsjvqxcqzhudurazmmpuqpzgjhqxmucopouraffbchmxfvgzzmuuuocabmauqqmphpjfdsqqjozcrrusvcbxpekbjzvvtkbihwrbdelhlisorpjgpxudmcuhcoojhpvafxmqvsmuamcsfrzzuzqqbuqbxpefwtihobmvmqncebqteznmmyccukhdoirtdmnvrdzrmaxpjqubhcbguurmumoxqjvcuvspfqoqzshfzcapmaxquzcjucomrfxvuuzzbpbqvhmjraugpsfpmhqoqdmcsmpozmmejthbuucsxqbpzrpmuqugodrfjhzcqhzxvpavsaubfummjmcoqjarxrvzqompqmjcpxfmcpvgusafsmquuohbubhqcuzzdmpuzaqqhcsavrgfzzjxbmrchupxdsfvumbmquoupjcqohhzxbsjdpqqourmqqvccpujaufmrmovmupczfgbasxuzuzzsbmruqaqpxumozpmarccvmhbqphufxojujgvfdqcshpkclrfgvaxpfchqpzxqofmbohszagmbuzvupscmmuqdjrjruucqbquqzqchfsuxuocpmzpjsrgmvxuavzqahdubjmpfcomrdqcumpgoauxbzmjrumspbsjarmfvuqvxupozqhfchzqcbxvcklxxmpxfqawkrrtqqkoucszphqmgdxmujobvmuzsbfpmchqpfjuxaaqrucqzvrtfmiruyfixucmzfcpdvhqambrjqvuguomuphscqqxoaupszmxfrbjzufzpjsquvocazhsbgorjcfrxmbaphupqmqudmumqvzxcoaqdjuzaoxqupbcxmqmvpujhqrczsgfuhzrbucmspvmfposjuzcdmquuumvpxfbcmzogqmaaujvfcqzsbxrphrhqsxvuujuudrqhfbpcvpozzsfrmzmouaqpahxgjqcqbmcmmqfgjquxpaofhmajbbzoucrzxsvmqpsprcquhuvzmduccfuqzzumcosoqpfdujqamjvbgruhpcsxmbmrhuqzxvpasbmbvhvozmqzjuqxcdphumucrqraqcfxmupozsfagpujbkquujtyzaqhxsrmmrczuxjazbmdvuofqqzmoupvaupbccughqjspftdnpsauiuzjbqhjrxquouacumcbsovahzrpdmppqsfgumfzmvcqxkibgehsrybspcxuuzsvfazomudqqcargoxhmqrjzupjfbmbqpumhcvdvgvsuxpphzxcuobumdmrohcrfqmufqpqbzamqcujajszbwuacpiqjburmqoxgqzmppruhocbcuzfvpqvudhsxaqmzscmafujqzftaqxvmpcrzuosqjcouzbhcupzjqhvuuqsrfpmxmdmbfgaseususaqfvfmmzgzpduouqrchazphjxbjrcumxqqbcpovmfvhsmbrmdjuuzqaccxupavmfgxzpmqsoqchupqzojurbwuwlassjxqmzouujmrsbzgjqhfbazcuvuscdupvommprqhpqafxcxrombmzpcupvgqofchzxuqapmhqsqufdzuusmjjvabcrcjuyqzuqbdmxvrbammschxmuofjrzavpchcpuopzqsfgjuqubyzdfqoxhqcuqjmacrufsaqhobuzpxsdmzvpzmbrmgcpvuujnviomrruagjuvpmcjpcfvqxafmrhxsmoquushzzupqczobbdqmoirpyaoxbcofmqrvzhzppjcmxfjguvaqqbosmqudruhuzcmuaspqojhsouzasmagxfcrmmzbpdxuqphcbfpjmurcvzvquuqaqqodhwegxaopmxpzzhmqkirocqqxbmhpsovzrzafqazjcgurbmjcuhsmpfxupomvqudukwusyqrnpgaghfstqorpfoscubopvmqujbquuqzfqarxhmcacszmzjhpgxmdvuxacgbcvosmzpdmuvfhfqbuoxrpqqpjzcrumjhmqusuazojqbummhuumgbmfxvopjarxzrqsccqzpfavuudscpzhqkllznuchafrcgvaquhvcfumqbmzpuusqzboxjrzqspmopdjmxpmcqcpuqrfojbhzpuaufvmzmzbjduraqmxhsxgouscvqubpqahbzxufcmmjovcrqzcuavzqrmpoxjphsudqmfsugvtnnywlqqjbnpchczomqvmvrzgmcaxujbduufurqsmqbqxhszfappuojcoxvbbjzjrhpmuhzsazfrqdvxfumgumcqsqpmcauoqupsuudqschpqhavoabqrzmczpbjuqoxjpmrffxvugummczobhyfcvdcxzvqbpujjgmfapocxocumvfhruqamhmzqspusqruzdbbtcobxqxqhougmzbpspmuvdcfqmupjufajcvuszarzmhrqvjshxazamvcpduvqfbphbcuuczoqqgosfrpzjruxmjumqmpxcormujmcqjqsmfodusbzguaazvhqpfhmurqcpvzxubwazhughkpoxupqpbgzxauarmmbrdzfcfvuvscqqmpjmuhzjcqohuslclexozhfqxhvouaruqcpdcqubuqzcspouapjmrvfjxmmbzmsgxjkygpaiuzqfxwxnolmrbsjqquujuupafzvmammvzqqxgsphuzdmorchcpxfcbosujqucpamovmuzomdgzpfchcfbvapqzxqxqmubhsrjurtchqgwnrrxcujauhfsopxmcmjzumoaqzqvhrmfrbuppqusgvdqzbxc";
		String pattern = "cujauhfsopxmcmjzumoaqzqvhrmfrbuppqusgvdqzbxc";
		Map<Character, Integer> frequency = new HashMap<>();
		char ch;
		int left = 0, right = 0, n = text.length(), k = pattern.length(), charCount, count;
		for (int i = 0; i < pattern.length(); i++) {
			ch = pattern.charAt(i);
			if (!frequency.containsKey(ch)) {
				frequency.put(ch, 0);
			}
			frequency.put(ch, frequency.get(ch) + 1);
		}
		charCount = frequency.keySet().size();
		// sliding until it hits the window
		char leftChar, rightChar;
		while (right < k) {
			rightChar = text.charAt(right);
			if (frequency.containsKey(rightChar)) {
				frequency.put(rightChar, frequency.get(rightChar) - 1);
				if (frequency.get(rightChar) == 0) {
					charCount--;
				}
			}
			right++;
		}
		count = charCount == 0 ? 1 : 0;
		while (right < n) {
			leftChar = text.charAt(left);
			rightChar = text.charAt(right);

			if (frequency.containsKey(leftChar)) {
				frequency.put(leftChar, frequency.get(leftChar) + 1);
				if (frequency.get(leftChar) > 0) {
					charCount++;
				}
			}
			if (frequency.containsKey(rightChar)) {
				frequency.put(rightChar, frequency.get(rightChar) - 1);
				if (frequency.get(rightChar) == 0) {
					charCount--;
				}
			}
			count = count + (charCount == 0 ? 1 : 0);
			left++;
			right++;
		}
		System.out.println(count);
	}

	// type 2 and type 3 are same
	// just that we are not taking any set
	// Asymtotically it should take more time but in reality it's taking less
	// as it's easy it work on array rather than customized data structure
	private static void type3() {
		String text = "mforxxorfxdofr";
		String pattern = "for";
		List<Integer> list = new ArrayList<>();
		if (null == text || null == pattern || text.length() < pattern.length())
			return;
		int[] patternArray = new int[26];
		int[] textArray = new int[26];
		int textSize = text.length();
		int patternSize = pattern.length();
		int i = 0;
		while (i < textSize) {
			if (i < patternSize) {
				patternArray[pattern.charAt(i) - 'a']++;
				textArray[text.charAt(i) - 'a']++;
			} else {
				if (equals(patternArray, textArray)) {
					list.add(i - patternSize);
				}
				textArray[text.charAt(i) - 'a']++;
				textArray[text.charAt(i - patternSize) - 'a']--;
			}
			i++;
		}
		if (equals(patternArray, textArray)) {
			list.add(i - patternSize);
		}
		System.out.println(list.size());
		System.out.println(list);
	}

	private static boolean equals(int[] patternArray, int[] textArray) {
		for (int i = 0; i < patternArray.length; i++) {
			if (patternArray[i] != textArray[i]) {
				return false;
			}
		}
		return true;
	}

	// Sliding window
	// if the text size is n and we are looping through 26 letters in every window
	// so time complexity is O(n*k)
	// space complexity is O(2*26+k) for 2 array
	// We can optimize this by using Map
	public static void type2() {
		String text = "mforxxorfxdofr";
		String pattern = "for";

		int n = text.length();
		int k = pattern.length();
		Set<Integer> allUniqueCharacters = new HashSet<>(26);
		int[] patternFrequency = new int[26];
		int[] windowFrequency = new int[26];
		int left = 0, right = 0, count = 0;
		while (right < k) {
			allUniqueCharacters.add(getIndex(pattern.charAt(right)));
			patternFrequency[getIndex(pattern.charAt(right))]++;
			windowFrequency[getIndex(text.charAt(right))]++;
			right++;
		}
		// calculating for the first window
		count = equals(patternFrequency, windowFrequency, allUniqueCharacters) ? 1 : 0;
		// at this point left=0 and right=k
		while (right < n) {
			// updating frequency for the current window
			// where left=1 and right=k
			windowFrequency[getIndex(text.charAt(left))]--;
			windowFrequency[getIndex(text.charAt(right))]++;
			// calculating for the current window
			if (equals(patternFrequency, windowFrequency, allUniqueCharacters)) {
				count++;
			}
			left++;
			right++;
		}
		System.out.println(count);
	}

	private static boolean equals(int[] patternArray, int[] textArray, Set<Integer> allUniqueCharacters) {
		for (int index : allUniqueCharacters) {
			if (patternArray[index] != textArray[index]) {
				return false;
			}
		}
		return true;
	}

	public static int getIndex(char ch) {
		return ch - 'a';
	}

	// Brute force
	private static void type1() {

	}

}
