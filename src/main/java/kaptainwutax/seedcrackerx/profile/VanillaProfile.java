package kaptainwutax.seedcrackerx.profile;

import kaptainwutax.seedcrackerx.finder.Finder;

public class VanillaProfile extends FinderProfile {

	public VanillaProfile() {
		super(true);
		this.author = "KaptainWutax";
		this.setTypeState(Finder.Type.DUNGEON, false);
	}

}
