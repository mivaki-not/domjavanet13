package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    public void testPriceTicketSortCity1() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                19,
                22
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                30_000,
                14,
                23
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Сочи",
                31_000,
                19,
                22
        );

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.search("Москва", "Санкт-Петербург");
        Ticket[] expected = {ticket3, ticket2};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testOneTicket2() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                19,
                22
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                14,
                23
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Сочи",
                31_000,
                19,
                22
        );

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.search("Москва", "Сочи");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void testNotTicket3() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                19,
                22
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                14,
                23
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Сочи",
                31_000,
                19,
                22
        );

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.search("Москва", "Минск");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortTicketComparator4() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                19,
                22
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                30_000,
                14,
                23
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Сочи",
                31_000,
                19,
                22
        );

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Москва", "Санкт-Петербург", timeComparator);
        Ticket[] expected = {ticket2, ticket3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortNotTicketComparator5() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                19,
                22
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                14,
                23
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Сочи",
                31_000,
                19,
                22
        );

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Москва", "Минск", timeComparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortNotTicketComparator6() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                35_000,
                15,
                18
        );
        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                19,
                22
        );
        Ticket ticket3 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                31_000,
                14,
                23
        );
        Ticket ticket4 = new Ticket(
                "Москва",
                "Сочи",
                31_000,
                19,
                22
        );

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Москва", "Сочи", timeComparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(actual, expected);
    }

}
