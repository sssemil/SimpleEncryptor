/*
 * Copyright (c) 2017 Emil Suleymanov <suleymanovemil8@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class KeyEncryptor {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {

            out.print("Enter word: ");
            out.flush();

            String word = null;

            while (word == null) {
                word = in.nextLine().toLowerCase();
            }
            out.print("Enter key: ");
            out.flush();

            String key = null;

            while (key == null) {
                key = in.nextLine().toLowerCase();
            }

            int rows = (int) Math.ceil(word.length() / ((1.00) * key.length()));

            char arrs[][] = new char[rows][key.length()];

            for (int i = 0; i < key.length(); i++) {
                for (int j = 0; j < rows; j++) {
                    if (j * key.length() + i < word.length() && word.charAt(j * key.length() + i) != ' ') {
                        arrs[j][i] = word.charAt(j * key.length() + i);
                    } else {
                        arrs[j][i] = '-';
                    }
                }
            }

            out.println();
            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < key.length(); i++) {
                    out.print(arrs[j][i] + " ");
                }
                out.println();
            }

            for (int x = 0; x < key.length(); x++) {
                for (int i = 0; i < key.length(); i++) {
                    int n = key.charAt(i) - '0' - 1;
                    if (n == x) {
                        for (int j = 0; j < rows; j++) {
                            out.print(arrs[j][i]);
                        }
                    }
                }
            }
        }
    }
}