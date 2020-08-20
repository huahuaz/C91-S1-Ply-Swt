package d0820;

import java.io.*;
import java.util.Arrays;

public class PbGame {
	// 游戏地图
	private char[][] map = new char[20][20];
	// 关数
	private int level = 1;

	public PbGame() {
		// 第一次创建游戏时，加载地图
		loadMap();
	}

	// 加载地图
	public void loadMap() {
		// 读取地图文件
		String path = "maps/" + level + ".map";
		// 使用类对象读入工程里面的文件
		InputStream in = PbGame.class.getResourceAsStream(path);
		// Stream :字节流Reader Writer:字符流
		// 字节流转字符流(处理流)
		InputStreamReader isr = new InputStreamReader(in);
		// 字符流转成缓冲字符流(处理流) ==> 以行的方式读入
		BufferedReader br = new BufferedReader(isr);
		try {
			for (int i = 0; i < map.length; i++) {
				String line;
				line = br.readLine();
				map[i] = line.toCharArray();
				// System.out.println(Arrays.toString(map[i]));
			}
		} catch (IOException e) {
			// 异常转型
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	// 查找小人坐标x,y
	private int[] findMan() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map.length; x++) {
				if (map[y][x] == '5') {
					return new int[] { x, y };
				}
			}
		}
		return null;
	}

	public void moveTop() {
		int[] xy = findMan();
		int x = xy[0];
		int y = xy[1];

		// 判断是否可以推动
		if (map[y - 1][x] == '1') {
			// 前面是房子，则退出
			return;
		} else if (map[y - 1][x] == '3' || map[y - 1][x] == '9') {
			// 箱子前面是房子1，箱子3，压在目的地上的箱子9那么不能推动
			if (map[y - 2][x] == '1' || map[y - 2][x] == '3' || map[y - 2][x] == '9') {
				return;
			}
			map[y - 2][x] = map[y - 1][x];
		}

		// 上移
		map[y - 1][x] = '5';
		// 恢复空地
		map[y][x] = '2';
	}

	public void moveDown() {
		int[] xy = findMan();
		int x = xy[0];
		int y = xy[1];

		// 判断是否可以推动
		if (map[y + 1][x] == '1') {
			// 前面是房子，则退出
			return;
		} else if (map[y + 1][x] == '3' || map[y + 1][x] == '9') {
			// 箱子前面是房子1，箱子3，压在目的地上的箱子9那么不能推动
			if (map[y + 2][x] == '1' || map[y + 2][x] == '3' || map[y + 2][x] == '9') {
				return;
			}
			map[y + 2][x] = map[y + 1][x];
		}

		// 上移
		map[y + 1][x] = '5';
		// 恢复空地
		map[y][x] = '2';
	}

	public void moveLeft() {
		int[] xy = findMan();
		int x = xy[0];
		int y = xy[1];

		// 判断是否可以推动
		if (map[y][x - 1] == '1') {
			// 前面是房子，则退出
			return;
		} else if (map[y][x - 1] == '3' || map[y][x - 1] == '9') {
			// 箱子前面是房子1，箱子3，压在目的地上的箱子9那么不能推动
			if (map[y][x - 2] == '1' || map[y][x - 2] == '3' || map[y][x - 2] == '9') {
				return;
			}
			map[y][x - 2] = map[y][x - 1];
		}
		// 上移
		map[y][x - 1] = '5';
		// 恢复空地
		map[y][x] = '2';
	}

	public void moveRight() {
		int[] xy = findMan();
		int x = xy[0];
		int y = xy[1];

		// 判断是否可以推动
		if (map[y][x + 1] == '1') {
			// 前面是房子，则退出
			return;
		} else if (map[y][x + 1] == '3' || map[y][x + 1] == '9') {
			// 箱子前面是房子1，箱子3，压在目的地上的箱子9那么不能推动
			if (map[y][x + 2] == '1' || map[y][x + 2] == '3' || map[y][x + 2] == '9') {
				return;
			}
			map[y][x + 2] = map[y][x + 1];
		}

		// 上移
		map[y][x + 1] = '5';
		// 恢复空地
		map[y][x] = '2';
	}

	public char[][] getMap() {
		return map;
	}

	public static void main(String[] arges) {
		PbGame pg = new PbGame();
		pg.loadMap();
	}
}
