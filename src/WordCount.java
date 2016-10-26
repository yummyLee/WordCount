import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * ͳ�������г��ִ����������ĺ��ֻ�Ӣ�ĵ���
 * 
 * 	���ò���˵����
 * 		String str  ��Ҫͳ�Ƶ�����
 * 		int index  ��Ҫ���ص�����ǰ����
 *     return ����ֵΪһ���ַ������飬�������ַ���ʼ���־��Ǹú��ֻ򵥴ʳ��ֵĴ���
 * </pre>
 * 
 * @author kaifang
 * 
 */

public class WordCount {
	// ͳ�ƺ���
	public static TreeMap<String, Integer> countToZH(String str) {
		System.out.println("��ʼ��ȡ����Ϊ1�Ĵ���");
		// ȥ���м�����Ŀո����Ķ��š����ľ��
		str = str.replace(" ", "").replace("��", "").replace("#", "");
		// ���巵������

		// �ı�ת��Ϊ�ַ�����
		char[] chs = str.toCharArray();
//		System.out.println(chs.length);
		// ����ArrayList����洢����
		ArrayList<String> array = new ArrayList<>();
		for (char ch : chs) {
			Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
			Matcher matcher = pattern.matcher(String.valueOf(ch));
			while (matcher.find()) {
				array.add(matcher.group());
			}
		}
		// ����Map���ϴ洢���֣���Ϊ���ֲ��ظ���ֵΪͳ�Ƶ�����
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		// �����ַ����飬��ȡ��ÿһ���ַ�
		for (String tstr : array) {
			// ��ÿһ���ַ���Ϊ������TreeMap�в���
			Integer val = map.get(tstr);
			if (val == null) {
				// ����null���򲻴��ڣ��洢1
				map.put(tstr, 1);
			} else {
				// ���ط�null�����ֵ��1�����´洢
				val++;
				// if (val == 10) {
				// System.out.println(tstr+val);
				// }
				map.put(tstr, val);
			}
		}

		return map;
	}

	public static TreeMap<String, Integer> countToZH(String str, int index) {
		System.out.println("��ʼ��ȡ����Ϊ" + index + "�Ĵ���");
		// System.out.println("index");
		// ȥ���м�����Ŀո����Ķ��š����ľ��
		str = str.replace(" ", "").replace("��", "").replace("#", "");
		// ���巵������

		// �ı�ת��Ϊ�ַ�����
		char[] chs = str.toCharArray();
		// ����ArrayList����洢����
		ArrayList<String> array = new ArrayList<>();
		int count = 0;
		String goalStr = "";
//		System.out.println(chs.length);
//		System.out.println(chs.length);
		for (int i = 0; i < chs.length - index; i++) {
			
			Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
			Matcher matcher = pattern.matcher(String.valueOf(chs[i]));
			// System.out.println(i);
			while (count < index && matcher.find()) {
				// System.out.println(goalStr);

				String tempStr = matcher.group();
				goalStr = goalStr + tempStr;
				count++;
				matcher = pattern.matcher(String.valueOf(chs[i + count]));

			}
			// if (goalStr.equals("")) {
			// System.out.println(i);
			// break;
			// }
			if (goalStr.length() == index)
				array.add(goalStr);
			// System.out.println(count + "+" + goalStr);
			goalStr = "";
			count = 0;
		}

		// System.out.println("what");

		// ����Map���ϴ洢���֣���Ϊ���ֲ��ظ���ֵΪͳ�Ƶ�����
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		// �����ַ����飬��ȡ��ÿһ���ַ�
		for (String tstr : array) {
			// ��ÿһ���ַ���Ϊ������TreeMap�в���
			Integer val = map.get(tstr);
			if (val == null) {
				// ����null���򲻴��ڣ��洢1
				map.put(tstr, 1);
			} else {
				// ���ط�null�����ֵ��1�����´洢
				val++;
				// if (val == 10) {
				// System.out.println(tstr+val);
				// }
				map.put(tstr, val);
			}
		}

		return map;
	}

	public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(oriMap.entrySet());
		Collections.sort(entryList, new MapValueComparator());

		Iterator<Entry<String, Integer>> iter = entryList.iterator();
		Entry<String, Integer> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}

	public static boolean isChineseChar(String str) {
		boolean temp = false;
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			temp = true;
		}
		return temp;
	}

}

class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> me1, Entry<String, Integer> me2) {

		if (me1.getValue() > me2.getValue())
			return -1;
		else if (me1.getValue() == me2.getValue())
			return 0;
		else
			return 1;
	}
}

class MapKeyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer arg0, Integer arg1) {
		// TODO Auto-generated method stub
		if (arg0 > arg1)
			return 1;
		else if (arg0 == arg1)
			return 0;
		else
			return -1;
	}

}
