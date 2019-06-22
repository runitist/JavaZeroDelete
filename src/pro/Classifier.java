package pro;

import java.io.File;
import java.io.IOException;

public class Classifier {

	public static void classify(String directoryPath) {
		String directPath = directoryPath;

		File dir = new File(directoryPath);
		File[] fileList = dir.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			if (file.isDirectory()) {
				System.out.println("디렉토리 이름 = " + file.getName());
				File[] fileSubList = file.listFiles();
				for (int j = 0; j < fileSubList.length; j++) {
					File subFile = fileSubList[j];
					if(subFile.isFile()) {
						if(subFile.length() == 0) {
							if(subFile.delete()) {
								System.out.println(subFile.getName()+" 사이즈 : "+subFile.length());
								System.out.println("zero파일 삭제");
							}else {
								System.out.println("파일삭제 에러");
							}
						}
					}
				}
				if(file.delete()) {
					System.out.println("빈폴더를 삭제했습니다.");
				}else {
					System.out.println("해당 폴더는 비어있지 않습니다.");
				}
				System.out.printf("%.1f%%\n",((i+1)/(fileList.length*1.0))*100);
			}
		}
	}

}
