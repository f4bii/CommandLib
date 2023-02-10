package de.f4bii.commandlib;

import de.f4bii.commandlib.exception.CommandNotFoundException;
import de.f4bii.commandlib.parser.DefaultParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.Ref;

class ServerTest {

    public static TestPlayer sender;

    @BeforeEach
    void setup() {
        DefaultParser.registerAll();
        sender = new TestPlayer();
    }

    private final TestPermissionCommand command = new TestPermissionCommand();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "group Admin removePermission lobby.test;onGroupRemovePerm",
            "group Admin addPermission lobby.test;onGroupAddPerm",
            "user FabiHBBBT addPermission lobby.test;onUserAddPerm",
            "user FabiHBBBT removePermission lobby.test;onUserRemovePerm",
            "group;onGroup",
            "group Admin;onGroupGroup",
            "user FabiHBBBT;onUser"
    })
    void testRightExecutedCommands(String cmd, String expected) {
        SuccessfulCommand thrown = Assertions.assertThrows(SuccessfulCommand.class, () -> {
            command.execute(sender, cmd.split(","));
        });
        Assertions.assertEquals(expected, thrown.getMessage());
    }

    @Test
    void testExceptionHandler() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            command.execute(sender, new String[]{"int", "187"});
        });
    }

    @Test
    void testNotFoundCommand() {
        Assertions.assertThrows(CommandNotFoundException.class, () -> {
            command.execute(sender, new String[]{"housdf", "adsf", "dgf"});
        });
    }

}
