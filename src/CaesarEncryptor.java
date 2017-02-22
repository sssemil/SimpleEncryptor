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
import java.util.Locale;
import java.util.Scanner;

public class CaesarEncryptor {

    private static String LETTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    private static int getCharNum(char c) {
        for (int i = 0; i < LETTERS.length(); i++) {
            if (c == LETTERS.charAt(i)) return i + 1;
        }
        return -1;
    }

    private static char getNumChar(int c) {
        return LETTERS.charAt((c) % LETTERS.length());
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            out.print("Enter word: ");
            out.flush();

            String word = null;

            while (word == null) {
                word = in.nextLine().toLowerCase();
            }

            out.printf(Locale.CANADA, "You entered: %s\n", word);
            out.flush();

            out.print("Enter key (int): ");
            out.flush();
            int key = in.nextInt();

            key = key % LETTERS.length();

            if (key < 0) {
                key = (key + (LETTERS.length()) * (key / LETTERS.length() + 1)) % LETTERS.length();
            }

            for (int i = 0; i <= key; i++) {
                StringBuilder result = new StringBuilder(word);
                for (int j = 0; j < result.length(); j++) {
                    if(getCharNum(result.charAt(j))!=-1) {
                        if (getCharNum(result.charAt(j)) + key > LETTERS.length() - 1) {
                            int num = (getCharNum(result.charAt(j)) + i) % LETTERS.length();
                            result.setCharAt(j,
                                    getNumChar(num)
                            );
                        } else if (getCharNum(result.charAt(j)) + key < 0) {
                            result.setCharAt(j,
                                    getNumChar((getCharNum(result.charAt(j)) + i + LETTERS.length()) % LETTERS.length())
                            );
                        } else {
                            result.setCharAt(j,
                                    getNumChar((getCharNum(result.charAt(j)) + i) % LETTERS.length())
                            );
                        }
                    }
                }
                out.printf(Locale.CANADA, "%s for %d\n", result.toString(), i+1);
                out.flush();
            }
        }
    }
}