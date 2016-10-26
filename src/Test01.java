import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test01 {
//	static String basePath = "D:\\JavaWorkSpace\\AnalogLoginTest\\ʾ��";
	 static String basePath = "input";
	
	static String str = "";

	/**
	 * �����ļ��������з���csv���ļ�
	 *
	 * @param dir
	 *            Ҫ���ҵ��ļ��ж���
	 */

	public static String findFile(File dir) throws IOException {
		str = "";
		File[] dirFiles = dir.listFiles();
		for (File temp : dirFiles) {
			if (!temp.isFile()) {
				continue;
			}
			// ����ָ�����ļ�
			if (temp.isFile() && temp.getAbsolutePath().endsWith(".txt")) {
				// System.out.println(temp.isFile() + " " +
				// temp.getAbsolutePath());
				str = str + readFileContent(temp);
			}
		}
		return str;
	}

	/**
	 * @param file
	 *            Ҫ��ȡ���ļ����� @return �����ļ�������
	 */

	public static String readFileContent(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		// int count=0;
		while (br.ready()) {
			String str = br.readLine();
			// System.out.println(count+"--"+str+"---"+str.length());
			// count++;
			// if(count>10)
			// break;
			if (str.length() > 6)
				sb.append(str);
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * @param file
	 *            Ҫд����ļ����� @param content Ҫд����ļ�����
	 */

	public static void writeFileContent(File file, String content) throws IOException {
		FileWriter fw = new FileWriter(file);
		fw.write(content);
		fw.flush();
		fw.close();
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

	public static void main(String[] args) {
		try {

			Map<String, Integer> resultMap = WordCount.countToZH(findFile(new File(basePath)));
			resultMap = sortMapByValue(resultMap);
			int count = 0;
			File file = new File("result1.txt");
			FileWriter fileWriter = new FileWriter(file.getName());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {

				// System.out.println(entry.getKey() + " " + entry.getValue());
				// count++;

				bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "#");
				bufferedWriter.newLine();

			}
			bufferedWriter.close();
			System.out.println("д�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			Map<String, Integer> resultMap = WordCount.countToZH(findFile(new File(basePath)), 2);
			resultMap = sortMapByValue(resultMap);
			int count = 0;
			File file = new File("result2.txt");
			FileWriter fileWriter = new FileWriter(file.getName());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {

				// System.out.println(entry.getKey() + " " + entry.getValue());
				// count++;

				bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "#");
				bufferedWriter.newLine();

			}
			bufferedWriter.close();
			System.out.println("д�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			Map<String, Integer> resultMap = WordCount.countToZH(findFile(new File(basePath)), 3);
			resultMap = sortMapByValue(resultMap);
			int count = 0;
			File file = new File("result3.txt");
			FileWriter fileWriter = new FileWriter(file.getName());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {

				// System.out.println(entry.getKey() + " " + entry.getValue());
				// count++;

				bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "#");
				bufferedWriter.newLine();

			}
			bufferedWriter.close();
			System.out.println("д�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
