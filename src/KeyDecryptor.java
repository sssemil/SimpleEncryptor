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

public class KeyDecryptor {

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

            out.println();
            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < key.length(); i++) {
                    out.printf("%c ", word.charAt(j + i * rows));
                }
                out.println();
            }

            out.println();
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < key.length(); k++) {
                    int n = key.charAt(k) - '0' - 1;
                    out.print(word.charAt(j + n * rows));
                }
            }
        }
    }
}