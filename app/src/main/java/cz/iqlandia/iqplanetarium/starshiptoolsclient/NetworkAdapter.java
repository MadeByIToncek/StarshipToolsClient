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
import java.util.concurrent.atomic.AtomicReference;

public class NetworkAdapter {

    public static String get(String address) {
        AtomicReference<String> s = new AtomicReference<>("");
        Thread t = new Thread(() -> {
            try (Scanner sc = new Scanner(new URL(address).openStream())) {
                StringBuilder sb = new StringBuilder();
                while (sc.hasNextLine()) {
                    sb.append(sc.nextLine()).append("\n");
                }
                s.set(sb.toString());
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
                s.set("[]");
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return s.get();
    }
}
