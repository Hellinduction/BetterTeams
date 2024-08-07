package com.booksaw.betterTeams.team;

import com.booksaw.betterTeams.Team;
import com.booksaw.betterTeams.team.storage.team.TeamStorage;
import org.bukkit.Location;

public class ChestClaimComponent extends LocationSetComponent {

	@Override
	public String getSectionHeading() {
		return "chests";
	}

	@Override
	public void load(TeamStorage section) {
		load(section.getClaimedChests());
	}

	@Override
	public void save(TeamStorage storage) {
		storage.setClaimedChests(getConvertedList());
	}

	@Override
	public void add(Team team, Location component) {
		super.add(team, component);
		Team.getTeamManager().addChestClaim(team, component);
	}

	@Override
	public void remove(Team team, Location component) {
		super.remove(team, component);
		Team.getTeamManager().removeChestclaim(component);
	}

	@Override
	public void clear() {
		for (Location location : set) {
			Team.getTeamManager().removeChestclaim(location);
		}

		super.clear();

	}

}
