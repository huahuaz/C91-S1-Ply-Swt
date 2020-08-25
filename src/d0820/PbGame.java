package d0820;

import java.io.*;

public class PbGame {
	// 游戏地图
	protected char[][] map = new char[20][20];
	// 去掉箱子和人的空地图,用于判断游戏是否结束，以及移动小人后，恢复地图显示
	protected char[][] mapEmpty = new char[20][20];
	//保存的地图
	protected char[][] saveMap = new char[20][20];
	// 关数
	protected int level = 0;

	public PbGame() {
		// 第一次创建游戏时，加载地图
		next();
	}

	// 加载当前关卡的地图
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
				// 设置空地图
				mapEmpty[i] = line.toCharArray();
				for (int j = 0; j < mapEmpty.length; j++) {
					if (mapEmpty[i][j] == '3' || mapEmpty[i][j] == '5') {
						mapEmpty[i][j] = '2';
					} else if (mapEmpty[i][j] == '9') {
						mapEmpty[i][j] = '4';
					}
				}
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
				if (map[y][x] >= '5' && map[y][x] <= '8') {
					return new int[] { x, y };
				}
			}
		}
		return null;
	}

	public void moveTop() {
		move(0, -1, '8');
	}

	public void moveDown() {
		move(0, 1, '5');
	}

	public void moveLeft() {
		move(-1, 0, '6');
	}

	public void moveRight() {
		move(1, 0, '7');
	}

	public void move(int ox, int oy, char man) {
		int[] xy = findMan();
		int x = xy[0];
		int y = xy[1];

		// 判断是否可以推动
		if (map[y + oy][x + ox] == '1') {
			// 前面是房子，则退出
			return;
		} else if (map[y + oy][x + ox] == '3' || map[y + oy][x + ox] == '9') {
			// 箱子前面是房子1，箱子3，压在目的地上的箱子9那么不能推动
			if (map[y + oy + oy][x + ox + ox] == '1' || map[y + oy + oy][x + ox + ox] == '3'
					|| map[y + oy + oy][x + ox + ox] == '9') {
				return;
			}
			// 移动箱子
			if (mapEmpty[y + oy + oy][x + ox + ox] == '4') {
				// 箱子后面是目的地
				map[y + oy + oy][x + ox + ox] = '9';
			} else {
				// 箱子后面不是目的地
				map[y + oy + oy][x + ox + ox] = '3';
			}
		}
		// 移动小人
		map[y + oy][x + ox] = man;
		// 恢复空地
		map[y][x] = mapEmpty[y][x];
	}

	/**
	 * 判断是否胜利
	 * 
	 * @return
	 */
	/*
	 * public void decideWin() { int count = 0; for (int y = 0; y < map.length; y++)
	 * { for (int x = 0; x < map.length; x++) { if (map[y][x] == '4') { count =
	 * count + 1; } } } if (count == 0) { System.out.println("您已通过此关!"); level =
	 * level + 1; loadMap(); } }
	 */
	public boolean isYouWin() {
		for (int y = 0; y < mapEmpty.length; y++) {
			for (int x = 0; x < mapEmpty.length; x++) {
				if (mapEmpty[y][x] == '4' && map[y][x] != '9') {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 返回地图二维数组
	 */
	public char[][] getMap() {
		return map;
	}

	/**
	 * 下一关
	 */
	public void next() {
		level++;
		loadMap();
	}

	/**
	 * 重新开始
	 */
	public void restart() {
		loadMap();
	}
	
	/**
	 * 保存进度
	 */
	public void save() {
	}
}
