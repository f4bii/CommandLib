package de.f4bii.commandlib;

import de.f4bii.commandlib.annotation.Command;
import de.f4bii.commandlib.annotation.Sender;
import de.f4bii.commandlib.annotation.SubCommand;
import de.f4bii.commandlib.annotation.Variable;

@Command("perms")
public class TestPermissionCommand extends CustomCommand<TestPlayer, String> {

    @SubCommand("group")
    public void onGroup(
            @Sender TestPlayer executor
    ) {
        throw new SuccessfulCommand("onGroup");
    }

    @SubCommand("int {int}")
    public void onGroup(
            @Variable("int") int _int,
            @Sender TestPlayer executor
    ) {
        if (_int == 187)
            throw new NullPointerException();
        throw new SuccessfulCommand("onGroup");
    }

    @SubCommand("group {group}")
    public void onGroupGroup(
            @Sender TestPlayer executor
    ) {
        throw new SuccessfulCommand("onGroupGroup");
    }

    @SubCommand("group {group} addPermission {perm}")
    public void onGroupAddPerm(
            @Variable("group") String group,
            @Variable("perm") String perm,
            @Sender TestPlayer executor
    ) {
        throw new SuccessfulCommand("onGroupAddPerm");
    }

    @SubCommand("group {group} removePermission {perm}")
    public void onGroupRemovePerm(
            @Variable("group") String group,
            @Variable("perm") String perm,
            @Sender TestPlayer executor
    ) {
        throw new SuccessfulCommand("onGroupRemovePerm");
    }

    @SubCommand("user {user}")
    public void onUser(
            @Variable("user") String user,
            @Sender TestPlayer executor
    ) {
        throw new SuccessfulCommand("onUser");
    }

    @SubCommand("user {user} addPermission {perm}")
    public void onUserAddPerm(
            @Variable("user") String user,
            @Variable("perm") String perm,
            @Sender TestPlayer executor
    ) {
        throw new SuccessfulCommand("onUserAddPerm");
    }

    @SubCommand("user {user} removePermission {perm}")
    public void onUserRemovePerm(
            @Variable("user") String user,
            @Variable("perm") String perm,
            @Sender TestPlayer executor
    ) {
        throw new SuccessfulCommand("onUserRemovePerm");
    }

}
