package test;

import java.util.ArrayList;

import tool.AccessTableLoader;

public class ATLtest {

	public static void main(String[] args) {
		ArrayList<Integer> integers = AccessTableLoader.loadAccessTableByPid(1);
		if (integers == null) {
			System.err.println("load access table error");
		} else {
			for (Integer integer : integers) {
				if (integer == null)
					continue;
				System.out.println(integer.toString());
			}
		}
	}

}
