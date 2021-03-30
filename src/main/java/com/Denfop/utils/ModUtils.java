package com.Denfop.utils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.StatCollector;

public class ModUtils {

	public static String getString(float number) {
		float g = number;
		float hhh = number;
		float gg = 0;
		int i = 0;
		for (; g >= 10; i++) {
			g = (float) (g / 10);

		}
		String maxstorage_2 = "0";
		if (i >= 0 && i < 3 && hhh <= 1000) {

			gg = (float) (hhh);
			maxstorage_2 = String.format("%.0f", gg);
		} else if (i >= 3 && i < 6 && hhh >= 1000 && hhh < 1000000) {
			gg = (float) (hhh / (1000));
			maxstorage_2 = String.format("%.2fK", gg);
		} else if (i >= 6 && i < 9 && hhh >= 1000000 && hhh < 1000000000) {
			gg = (float) (hhh / (1000000));
			maxstorage_2 = String.format("%.2fM", gg);
		} else if (i >= 9 && i < 12 && hhh >= 1000000000 && hhh < 2100000000) {
			gg = (float) (hhh / (1000000000));
			maxstorage_2 = String.format("%.2fG", gg);
		}
		return maxstorage_2;

	}

	public static String getString(double number) {
		double hhh = number;
		String maxstorage_2 = "0";
		if (hhh <= 1000) {

			maxstorage_2 = String.format("%.0f", hhh);
		} else if (hhh >= 10E2D && hhh < 10E5D) {

			maxstorage_2 = String.format("%.2fK", hhh/10E2D);
		} else if (hhh >= 10E5D && hhh < 10E8D) {

			maxstorage_2 = String.format("%.2fM", hhh/10E5D);
		}

		else if (hhh >= 10E8D && hhh < 10E11D) {

			maxstorage_2 = String.format("%.2fG", hhh/10E8D);
		} else if (hhh >= 10E11D && hhh < 10E14D) {

			maxstorage_2 = String.format("%.2fT", hhh/10E11D);
		} else if (hhh >= 10E14D && hhh < 10E17D) {

			maxstorage_2 = String.format("%.2fP", hhh/10E14D);
		} else if (hhh >= 10E17D && hhh < 10E20D) {

			maxstorage_2 = String.format("%.2fE", hhh/10E17D);
		} else if (hhh >= 10E20D && hhh < 10E23D) {

			maxstorage_2 = String.format("%.2fZ", hhh/10E20D);
		} else if (hhh >= 10E23D && hhh < 10E26D) {

			maxstorage_2 = String.format("%.2fY", hhh/10E23D);
		}
		return maxstorage_2;

	}

	public static String Boolean(boolean boolean1) {
		if (boolean1) {
			return StatCollector.translateToLocal("ssp.yes");
		} else {
			return StatCollector.translateToLocal("ssp.no");
		}

	}

	public static boolean Boolean(List<Boolean> boolean1) {

		for (int i = 0; i < boolean1.size(); i++) {
			if (boolean1.get(i))
				return true;
		}

		return false;
	}
	public static boolean getbooleanthree(List<Boolean> boolean1) {
List<Boolean> boolean2 = new ArrayList<Boolean>();
		for (int i = 0; i < boolean1.size(); i++) {
			if (boolean1.get(i))
				boolean2.add(boolean1.get(i));
		}

		return boolean2.size() >= 4 ?  true :  false;
	}
	public static double getsum(List<Double> sum) {
double sum_sum =0;
		for (int i = 0; i < sum.size(); i++) {
			sum_sum +=sum.get(i); 
		}
		return sum_sum;
	}
	
}
