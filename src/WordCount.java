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
 * 统计文章中出现次数最多的中文汉字或英文单词
 * 
 * 	调用参数说明：
 * 		String str  需要统计的文章
 * 		int index  需要返回的最多的前几个
 *     return 返回值为一个字符串数组，数组中字符起始数字就是该汉字或单词出现的次数
 * </pre>
 * 
 * @author kaifang
 * 
 */

public class WordCount {
	// 统计汉字
	public static TreeMap<String, Integer> countToZH(String str) {
		System.out.println("开始获取长度为1的词语");
		// 去掉中间包含的空格、中文逗号、中文句号
		str = str.replace(" ", "").replace("，", "").replace("#", "");
		// 定义返回数组

		// 文本转换为字符数组
		char[] chs = str.toCharArray();
//		System.out.println(chs.length);
		// 定义ArrayList对象存储汉字
		ArrayList<String> array = new ArrayList<>();
		for (char ch : chs) {
			Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
			Matcher matcher = pattern.matcher(String.valueOf(ch));
			while (matcher.find()) {
				array.add(matcher.group());
			}
		}
		// 定义Map集合存储汉字，键为汉字不重复，值为统计的数量
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		// 遍历字符数组，获取到每一个字符
		for (String tstr : array) {
			// 用每一个字符作为键，在TreeMap中查找
			Integer val = map.get(tstr);
			if (val == null) {
				// 返回null，则不存在，存储1
				map.put(tstr, 1);
			} else {
				// 返回非null，则把值加1，重新存储
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
		System.out.println("开始获取长度为" + index + "的词语");
		// System.out.println("index");
		// 去掉中间包含的空格、中文逗号、中文句号
		str = str.replace(" ", "").replace("，", "").replace("#", "");
		// 定义返回数组

		// 文本转换为字符数组
		char[] chs = str.toCharArray();
		// 定义ArrayList对象存储汉字
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

		// 定义Map集合存储汉字，键为汉字不重复，值为统计的数量
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		// 遍历字符数组，获取到每一个字符
		for (String tstr : array) {
			// 用每一个字符作为键，在TreeMap中查找
			Integer val = map.get(tstr);
			if (val == null) {
				// 返回null，则不存在，存储1
				map.put(tstr, 1);
			} else {
				// 返回非null，则把值加1，重新存储
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
