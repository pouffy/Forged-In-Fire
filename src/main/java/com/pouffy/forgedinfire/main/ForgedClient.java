package com.pouffy.forgedinfire.main;

import com.pouffy.forgedinfire.main.item.book.ForgedBook;

public class ForgedClient {
    public static void onForged() {
        ForgedBook.initBook();
    }
}
