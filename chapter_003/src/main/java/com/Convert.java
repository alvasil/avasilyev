package com;


import java.util.*;

public class Convert {

	//объявлен конструктор по умолчанию - это требуется в том случае, если мы еще объявили парамет.конструктор и нам
	// необходим еще и конструктор по умолчанию.
	// в данном случае конструктор по умолчанию можно не указывать явно.
	public Convert() {

	}

	//Converts array to list
	// не понятно для чего указан дефолтный модификатор доступа
	List<Integer> makeList(int[][] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) { //можно заменить на foreach
			for (int j = 0; j < array[i].length; j++)
				list.add(array[i][j]);
		}
		return list;
	}

	//Converts list to array
	public int[][] makeArray(List<Integer> list, int rws) {
		Iterator<Integer> iterator = list.iterator();
		int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);

		int[][] array = new int[rws][cls];
		for (int i = 0; i < rws; i++) {
			for (int j = 0; j < cls; j++) {
				// не хватает фигурных скобок у if else
				if (iterator.hasNext())
					array[i][j] = iterator.next();
				else
					array[i][j] = 0;
			}
		}
		return array;
	}
}