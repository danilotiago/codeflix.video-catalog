package app.projetaria.codeflixvideocatalog.enums;

import java.util.HashMap;
import java.util.Map;

public enum CastMemberPosition {

    ACTOR,
    DIRECTOR;

    private static final Map<String, CastMemberPosition> positions = new HashMap<String, CastMemberPosition>();
    static {
        for (CastMemberPosition position : CastMemberPosition.values()) {
            positions.put(position.toString(), position);
        }
    }

    public static CastMemberPosition getByString(String position) {
        return positions.get(position);
    }
}
