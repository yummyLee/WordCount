import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFile {
	static String basePath = "input";

	/**
	 * �����ļ��������з���csv���ļ�
	 *
	 * @param dir
	 *            Ҫ���ҵ��ļ��ж���
	 */

	public static void findFile(File dir) throws IOException {
		File[] dirFiles = dir.listFiles();
		for (File temp : dirFiles) {
			if (!temp.isFile()) {
				findFile(temp);
			}
			// ����ָ�����ļ�
			if (temp.isFile() && temp.getAbsolutePath().endsWith(".txt")) {
//				System.out.println(temp.isFile() + "  " + temp.getAbsolutePath());
				String str=readFileContent(temp);
			}
		}
	}

	/**
	 * @param file
	 *            Ҫ��ȡ���ļ����� @return �����ļ�������
	 */

	public static String readFileContent(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		while (br.ready()) {
			sb.append(br.readLine());
		}
//		System.out.println(sb.toString());
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

	public static void main(String[] args) {
		try {
			findFile(new File(basePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
