/*
 * Copyright (c) 2023 - IToncek
 *
 * All rights to modifying this source code are granted, except for changing licence.
 * Any and all products generated from this source code must be shared with a link
 * to the original creator with clear and well-defined mention of the original creator.
 * This applies to any lower level copies, that are doing approximately the same thing.
 * If you are not sure, if your usage is within these boundaries, please contact the
 * author on their public email address.
 */

package cz.iqlandia.iqplanetarium.starshiptoolsclient;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class NetworkAdapter {

    public static String get(String address) {
        try (Scanner sc = new Scanner(new URL(address).openStream())) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.next());
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
